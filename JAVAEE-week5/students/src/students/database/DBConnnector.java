package students.database;

import students.student.City;
import students.student.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DBConnnector {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/Students", "postgres", "falcon");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



        public static ArrayList<Student> getAllStudents(){

        ArrayList<Student> students = new ArrayList<>();

            try{
                PreparedStatement statement = connection.prepareStatement("" +
                        "SELECT st.id, st.firstname, st.surname, st.birthdate, st.city, c.city_code, c.city_name " +
                        "FROM studentlist st " +
                        "INNER JOIN cities c ON c.id = st.city ORDER BY id ASC");

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("firstname");
                    String surname = resultSet.getString("surname");
                    String birthdate = resultSet.getString("birthdate");

                    City city = new City();
                    city.setId((resultSet.getLong("city")));
                    city.setName(resultSet.getString("city_name"));
                    city.setCode(resultSet.getString("city_code"));

                    Student student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setSurname(surname);
                    student.setBirthdate(birthdate);

                    student.setCity(city);

                    students.add(student);
                }

                statement.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            return students;
        }

        public static void addStudent(Student student){
            try{
                PreparedStatement statement = connection.prepareStatement
                        ("INSERT INTO studentlist(firstname, surname, birthdate, city)" +
                                "VALUES(?, ?, ?, ?)");
                statement.setString(1, student.getName());
                statement.setString(2, student.getSurname());
                statement.setString(3, student.getBirthdate());
                statement.setLong(4, student.getCity().getId());

                statement.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    public static void addCity(City city){
        try{
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO cities(city_name, city_code)" +
                            "VALUES(?, ?)");
            statement.setString(1, city.getName());
            statement.setString(2, city.getCode());

            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static Student getStudent(Long id){
            Student studentToReturn = getAllStudents().stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
            return studentToReturn;
        }

        public static void saveStudent(Student student){

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE studentlist SET firstname = ?, surname = ?, birthdate = ?, city = ?"+
                    "WHERE id = ?");

            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getBirthdate());
            statement.setLong(4, student.getCity().getId());
            statement.setLong(5, student.getId());

            statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        }

    public static void deleteStudent(Student student){

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM studentlist WHERE id = ?");

            statement.setLong(1, student.getId());

            statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<City> getAllCities(){

        ArrayList<City> cities = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM cities ORDER BY id ASC");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("city_name");
                String code = resultSet.getString("city_code");

                City city = new City();
                city.setId(id);
                city.setName(name);
                city.setCode(code);

                cities.add(city);
            }

            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return cities;
    }

    public static  City getCity(Long id){
        City city = null ;
         try{
             PreparedStatement statement = connection.prepareStatement("" +
                     "SELECT * FROM cities WHERE id = ?");
             statement.setLong(1, id);

             ResultSet resultSet = statement.executeQuery();

             if (resultSet.next()){
                 city = new City();
                 city.setId(resultSet.getLong("id"));
                 city.setName(resultSet.getString("city_name"));
                 city.setCode(resultSet.getString("city_code"));
             }
             statement.close();
         }catch (Exception e){
             e.printStackTrace();
         }
         return city;
    }
    }
