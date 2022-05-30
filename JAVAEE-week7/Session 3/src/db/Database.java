package db;

import model.User;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Database {
    private static ArrayList<User> users = new ArrayList<>();

    static{
        users.add(new User("user@user.com", "user", "User", "Userov", 23));
        users.add(new User("hello@world.com", "hello", "Hello", "World", 450000000));
    }

    public static ArrayList<User> getUsers(){
        return users;
    }

    public static User getUser(String email){
        User itemToReturn = getUsers().stream().filter(a -> a.getUser().equals(email)).collect(Collectors.toList()).get(0);
        return itemToReturn;
    }
}
