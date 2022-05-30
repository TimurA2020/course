package bestbuy.DB;

import bestbuy.essence.Users;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBUsers {
    private static Connection connection;

    static{
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/Items", "postgres", "falcon");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Users> getAllUsers(){
        ArrayList<Users> allUsers = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users_table");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullname(resultSet.getString("fullname"));

                allUsers.add(user);

            }

            statement.close();
            }catch (Exception e){
            e.printStackTrace();
        }

        return allUsers;
    }
}
