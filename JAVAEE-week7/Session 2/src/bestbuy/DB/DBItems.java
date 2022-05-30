package bestbuy.DB;

import bestbuy.essence.Brands;
import bestbuy.essence.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DBItems {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/Items", "postgres", "falcon");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Items> getAllItems(){

        ArrayList<Items> allItems = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT it.id, it.item, it.description, it.price, it.brand_id, b.brand, b.country " +
                    "FROM items_table it " +
                    "INNER JOIN brands_table b ON b.id = it.brand_id ORDER BY id ASC");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Long id = resultSet.getLong("id");
                String name = resultSet.getString("item");
                String description = resultSet.getString("description");
                float price = resultSet.getFloat("price");

                Brands brand = new Brands();
                brand.setId(resultSet.getLong("brand_id"));
                brand.setName(resultSet.getString("brand"));
                brand.setCountry(resultSet.getString("country"));

                Items item = new Items();
                item.setId(id);
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);
                item.setBrand(brand);

                allItems.add(item);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return allItems;
    }

    public static void addItem(Items item){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items_table(item, description, price, brand_id)" +
                    "VALUES (?, ?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setFloat(3, item.getPrice());
            statement.setLong(4, item.getBrand().getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addBrand(Brands item){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO brands_table(brand, country)" +
                    "VALUES (?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getCountry());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Brands> getAllBrands(){
        ArrayList<Brands> brands = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM brands_table");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Brands brand = new Brands();
                brand.setId(resultSet.getLong("id"));
                brand.setName(resultSet.getString("brand"));
                brand.setCountry(resultSet.getString("country"));
                brands.add(brand);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return brands;
    }

    public static Brands getBrand(Long id){
        Brands brand = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM brands_table WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                brand = new Brands();
                brand.setId(resultSet.getLong("id"));
                brand.setName(resultSet.getString("brand"));
                brand.setCountry(resultSet.getString("country"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return brand;
    }

    public static Items getItem(Long id){
        Items itemToReturn = getAllItems().stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
        return itemToReturn;
    }
}
