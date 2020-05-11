package DBconnection;

import Data.City;

import java.sql.*;
import java.util.ArrayList;

public class CityDataBase {
    private static String url = "jdbc:mysql://localhost:3306/shopdatabase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1999";

    public static ArrayList<City> select() {
        ArrayList<City> Cities = new ArrayList<City>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
                while(resultSet.next()){
                    int idCity = resultSet.getInt(1);
                    String nameCity = resultSet.getString(2);
                    int idCountry = resultSet.getInt(3);
                    City city = new City(idCity, nameCity, idCountry);
                    Cities.add(city);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return Cities;
    }

    public static City selectOne(int id) {
        City city = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM city WHERE idCity=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idCity = resultSet.getInt(1);
                        String nameCity = resultSet.getString(2);
                        int idCountry = resultSet.getInt(3);
                        city = new City(idCity, nameCity, idCountry);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return city;
    }
    public static int insert(City city) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO city ( nameCity, idCountry  ) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, city.getNameCity());
                    preparedStatement.setInt(2, city.getIdCountry());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(City city) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE city SET nameCity = ?, idCountry = ?" +
                        " WHERE idCity = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, city.getIdCity());
                    preparedStatement.setString(2, city.getNameCity());
                    preparedStatement.setInt(3, city.getIdCountry());
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
                String sql = "DELETE FROM city WHERE idCity = ?";
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
