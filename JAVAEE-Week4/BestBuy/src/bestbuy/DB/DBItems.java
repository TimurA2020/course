package bestbuy.DB;

import bestbuy.essence.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
                    "SELECT * FROM items_table");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                float price = resultSet.getFloat("price");

                Items item = new Items();
                item.setId(id);
                item.setName(name);
                item.setDescription(description);
                item.setPrice(price);

                allItems.add(item);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return allItems;
    }
}
