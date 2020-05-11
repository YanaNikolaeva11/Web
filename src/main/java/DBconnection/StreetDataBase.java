package DBconnection;


import Data.Street;

import java.sql.*;
import java.util.ArrayList;

public class StreetDataBase {
    private static String url = "jdbc:mysql://localhost:3306/shopdatabase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1999";

    public static ArrayList<Street> select() {
        ArrayList<Street> streets = new ArrayList<Street>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM street");
                while(resultSet.next()){
                    int idStreet = resultSet.getInt(1);
                    String nameStreet = resultSet.getString(2);
                    int idCity = resultSet.getInt(3);
                    Street street = new Street(idStreet, nameStreet, idCity);
                    streets.add(street);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return streets;
    }

    public static Street selectOne(int id) {
        Street street = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM street WHERE idStreet=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idStreet = resultSet.getInt(1);
                        String nameStreet = resultSet.getString(2);
                        int idCity = resultSet.getInt(3);
                        street = new Street(idStreet, nameStreet, idCity);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return street;
    }
    public static int insert(Street street) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO street ( nametreet, idCity  ) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, street.getNameStreet());
                    preparedStatement.setInt(2, street.getIdCity());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Street street) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE street SET nameStreet = ?, idCity = ?" +
                        " WHERE idStreet = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, street.getIdStreet());
                    preparedStatement.setString(2, street.getNameStreet());
                    preparedStatement.setInt(3, street.getIdCity());
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
                String sql = "DELETE FROM street WHERE idStreet = ?";
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
