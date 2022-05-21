package students.database;

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
                        "SELECT * FROM studentlist");

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("firstname");
                    String surname = resultSet.getString("surname");
                    String birthdate = resultSet.getString("birthdate");
                    String city = resultSet.getString("city");

                    Student student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setCity(city);
                    student.setSurname(surname);
                    student.setBirthdate(birthdate);

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
                statement.setString(4, student.getCity());

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
            statement.setString(4, student.getCity());
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
    }
