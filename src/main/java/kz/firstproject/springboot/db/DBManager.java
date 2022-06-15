package kz.firstproject.springboot.db;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DBManager {

    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Brand> brands = new ArrayList<>();

    private static Long id = 7L;


    static {
        items.add(new Item(1L, "MacBook Air 2020", "M1 8/256", 999.99));
        items.add(new Item(2L, "Nintendo Switch", "OLED SSBU BUNDLE", 399.99));
        items.add(new Item(3L, "Nintendo 2DS XL", "SSB4 Bundle", 199.99));
        items.add(new Item(4L, "XBOX Series X", "HALO 5 Bundle", 499.99));
        items.add(new Item(5L, "XBOX 360", "HALO 3 Bundle", 199.99));
        items.add(new Item(6L, "iPhone 5", "Retro Edition", 99.99));
    }

    public static ArrayList<Item> getAllItems(){
        return items;
    }

    public static void addItem(Item item){
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Item getItem(Long id){
        Item itemToReturn = getAllItems().stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
        return itemToReturn;
    }
}
