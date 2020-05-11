package DBconnection;

import Data.Product;
import Data.Specifications;

import java.sql.*;
import java.util.ArrayList;

public class SpecificationsDataBase {
    private static String url = "jdbc:mysql://localhost:3306/shopdatabase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1999";

    public static ArrayList<Specifications> select() {
        ArrayList<Specifications> specifications = new ArrayList<Specifications>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM specifications");
                while(resultSet.next()){
                    int idProduct = resultSet.getInt(1);
                    String property = resultSet.getString(2);
                    String propertyValue = resultSet.getString(3);
                    Specifications specification = new Specifications(idProduct, property, propertyValue);
                    specifications.add(specification);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return specifications;
    }
    public static ArrayList<Specifications> selectMore(int id) {
        ArrayList<Specifications> specifications = new ArrayList<Specifications>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM specifications WHERE idProduct = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int idProduct = resultSet.getInt(1);
                        String property = resultSet.getString(2);
                        String propertyValue = resultSet.getString(3);
                        Specifications specification = new Specifications(idProduct, property, propertyValue);
                        specifications.add(specification);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return specifications;
    }
    public static Specifications selectOne(int id) {
        Specifications specification = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM specifications WHERE idProduct=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idProduct = resultSet.getInt(1);
                        String property = resultSet.getString(2);
                        String propertyValue = resultSet.getString(3);
                        specification = new Specifications(idProduct, property, propertyValue);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return specification;
    }
    public static int insert(Specifications specification) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO specifications ( idProduct, property, propertyValue  ) Values (?,?,?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, specification.getIdProduct());
                    preparedStatement.setString(2, specification.getProperty());
                    preparedStatement.setString(3, specification.getPropertyValue());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Specifications specification) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE specifications SET property = ?, propertyValue = ?" +
                        " WHERE idProduct = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(3, specification.getIdProduct());
                    preparedStatement.setString(1, specification.getProperty());
                    preparedStatement.setString(2, specification.getPropertyValue());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "DELETE FROM specifications WHERE idProduct = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
