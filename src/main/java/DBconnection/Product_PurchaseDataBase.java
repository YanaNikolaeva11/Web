package DBconnection;



import Data.Product_Purchase;

import java.sql.*;
import java.util.ArrayList;

public class Product_PurchaseDataBase {
    private static String url = "jdbc:mysql://localhost:3306/shopdatabase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1999";

    public static ArrayList<Product_Purchase> select() {
        ArrayList<Product_Purchase> Product_Purchase = new ArrayList<Product_Purchase>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM product-purchase");
                while(resultSet.next()){
                    int idRecord = resultSet.getInt(1);
                    int idProduct = resultSet.getInt(2);
                    int idPurchase = resultSet.getInt(3);
                    Product_Purchase product_purchase = new Product_Purchase(idRecord, idProduct, idPurchase);
                    Product_Purchase.add(product_purchase);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return Product_Purchase;
    }

    public static Product_Purchase selectOne(int id) {
        Product_Purchase product_purchase = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM product-purchase WHERE idRecord=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idRecord = resultSet.getInt(1);
                        int idProduct = resultSet.getInt(2);
                        int idPurchase = resultSet.getInt(3);
                        product_purchase = new Product_Purchase(idRecord, idProduct, idPurchase);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return product_purchase;
    }
    public static int insert(Product_Purchase product_purchase) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO productpurchase ( idProduct, idPurchase  ) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, product_purchase.getIdProduct());
                    preparedStatement.setInt(2, product_purchase.getIdPurchase());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Product_Purchase product_purchase) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE product-purchase SET idProduct = ?, idPurchase = ?" +
                        " WHERE idRecord = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, product_purchase.getIdRecord());
                    preparedStatement.setInt(2, product_purchase.getIdProduct());
                    preparedStatement.setInt(3, product_purchase.getIdPurchase());
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
                String sql = "DELETE FROM product-purchase WHERE idRecord = ?";
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
