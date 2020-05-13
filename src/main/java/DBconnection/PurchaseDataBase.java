package DBconnection;



import Data.Purchase;

import java.sql.*;
import java.util.ArrayList;

public class PurchaseDataBase {
    private static String url = "jdbc:mysql://localhost:3306/shopdatabase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1999";

    public static ArrayList<Purchase> select() {
        ArrayList<Purchase> purchases = new ArrayList<Purchase>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM purchase");
                while(resultSet.next()){
                    int idPurchase = resultSet.getInt(1);
                    int idCustomer = resultSet.getInt(2);
                    Purchase country = new Purchase(idPurchase, idCustomer);
                    purchases.add(country);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return purchases;
    }

    public static Purchase selectOne(int id) {
        Purchase purchase= null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM purchase WHERE idPurchase = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idPurchase = resultSet.getInt(1);
                        int idCustomer = resultSet.getInt(2);
                        purchase = new Purchase(idPurchase, idCustomer);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return purchase;
    }

    public static Purchase selectOneonIdCust(int id) {
        Purchase purchase= null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT MAX(idPurchase) FROM purchase WHERE idCustomer = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idPurchase = resultSet.getInt(1);
                        /*int idCustomer = resultSet.getInt(2);*/
                        purchase = new Purchase(idPurchase, 0);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return purchase;
    }


    public static int insert(Purchase purchase) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO purchase ( idCustomer ) Values (?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, purchase.getIdCustomer());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Purchase purchase) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE purchase SET idCustomer = ?" +
                        " WHERE idPurchase = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, purchase.getIdPurchase());
                    preparedStatement.setInt(2, purchase.getIdCustomer());
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
                String sql = "DELETE FROM purchase WHERE idPurchase = ?";
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
