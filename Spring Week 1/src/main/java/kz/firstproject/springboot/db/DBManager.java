package kz.firstproject.springboot.db;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Brand> brands = new ArrayList<>();

    private static Long id = 5L;

    static {
        brands.add(new Brand(1L, "Apple", "USA"));
        brands.add(new Brand(2L, "Nintendo", "Japan"));
        brands.add(new Brand(3L, "Microsoft", "USA"));
    }

    static {
        items.add(new Item(1L, "MacBook Air 2020", "M1 8/256", 999.99, brands.get(0)));
        items.add(new Item(2L, "Nintendo Switch", "OLED SSBU BUNDLE", 399.99, brands.get(1)));
        items.add(new Item(3L, "Nintendo 2DS XL", "SSB4 Bundle", 199.99, brands.get(1)));
        items.add(new Item(4L, "XBOX Series X", "HALO 5 Bundle", 499.99, brands.get(2)));
        items.add(new Item(5L, "XBOX 360", "HALO 3 Bundle", 199.99, brands.get(2)));
        items.add(new Item(6L, "iPhone 5", "Retro Edition", 99.99, brands.get(0)));
    }

    public static ArrayList<Item> getAllItems(){
        return items;
    }

    public static void addItem(Item item){
        item.setId(id);
        items.add(item);
        id++;
    }
}
