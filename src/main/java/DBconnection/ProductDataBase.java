package DBconnection;

import Data.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDataBase {
    private static String url = "jdbc:mysql://localhost:3306/shopdatabase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1999";

    public static ArrayList<Product> select() {
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
                while(resultSet.next()){
                    int idProduct = resultSet.getInt(1);
                    int idCategory = resultSet.getInt(2);
                    String name = resultSet.getString(3);
                    int price = resultSet.getInt(4);
                    int rating = resultSet.getInt(5);
                    Product product = new Product(idProduct, idCategory, name, price, rating);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }

    public static Product selectOne(int id) {
        Product product = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM product WHERE idProduct=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idProduct = resultSet.getInt(1);
                        int idCategory = resultSet.getInt(2);
                        String name = resultSet.getString(3);
                        int price = resultSet.getInt(4);
                        int rating = resultSet.getInt(5);
                        product = new Product(idProduct, idCategory, name, price, rating);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return product;
    }
    public static ArrayList<Product> selectMore(int id) {
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM product WHERE idCategory = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int idProduct = resultSet.getInt(1);
                        int idCategory = resultSet.getInt(2);
                        String name = resultSet.getString(3);
                        int price = resultSet.getInt(4);
                        int rating = resultSet.getInt(5);
                        Product product = new Product(idProduct, idCategory, name, price, rating);
                        products.add(product);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }

    public static ArrayList<Product> search (String nameProduct) {
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM product WHERE productName LIKE ? ";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, "%"+nameProduct+"%");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int idProduct = resultSet.getInt(1);
                        int idCategory = resultSet.getInt(2);
                        String name = resultSet.getString(3);
                        int price = resultSet.getInt(4);
                        int rating = resultSet.getInt(5);
                        Product product = new Product(idProduct, idCategory, name, price, rating);
                        products.add(product);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }


    public static int insert(Product product) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO product (idCategory, productName, price, rating ) Values (?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, product.getIdCategory());
                    preparedStatement.setString(2, product.getName());
                    preparedStatement.setInt(3, product.getPrice());
                    preparedStatement.setDouble(4,product.getRating());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Product product) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE product SET idCategory = ?, name = ?, price = ?, rating = ?" +
                        " WHERE idProduct = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, product.getIdProduct());
                    preparedStatement.setInt(2, product.getIdCategory());
                    preparedStatement.setString(3, product.getName());
                    preparedStatement.setInt(4, product.getPrice());
                    preparedStatement.setDouble(5,product.getRating());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }



    public static int updateRating(int id, double rating) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE product SET rating = ?" +
                        " WHERE idProduct = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setDouble(1, rating);
                    preparedStatement.setInt(2, id);
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
                String sql = "DELETE FROM product WHERE idProduct = ?";
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

    public static ArrayList<Product> sortByName() {
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM product ORDER BY productName");
                while(resultSet.next()){
                    int idProduct = resultSet.getInt(1);
                    int idCategory = resultSet.getInt(2);
                    String name = resultSet.getString(3);
                    int price = resultSet.getInt(4);
                    int rating = resultSet.getInt(5);
                    Product product = new Product(idProduct, idCategory, name, price, rating);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }


    public static ArrayList<Product> sortByPrice() {
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM product ORDER BY price");
                while(resultSet.next()){
                    int idProduct = resultSet.getInt(1);
                    int idCategory = resultSet.getInt(2);
                    String name = resultSet.getString(3);
                    int price = resultSet.getInt(4);
                    int rating = resultSet.getInt(5);
                    Product product = new Product(idProduct, idCategory, name, price, rating);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }

    public static ArrayList<Product> priceFilter (int min,int max) {
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM product WHERE price between ? and ? ";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, min);
                    preparedStatement.setInt(2, max);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int idProduct = resultSet.getInt(1);
                        int idCategory = resultSet.getInt(2);
                        String name = resultSet.getString(3);
                        int price = resultSet.getInt(4);
                        int rating = resultSet.getInt(5);
                        Product product = new Product(idProduct, idCategory, name, price, rating);
                        products.add(product);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }

    public static ArrayList<Product> findByCategory (String nameCategory) {
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM product where (Select idCategory from category where nameCategory=?) = product.idCategory";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, nameCategory);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int idProduct = resultSet.getInt(1);
                        int idCategory = resultSet.getInt(2);
                        String name = resultSet.getString(3);
                        int price = resultSet.getInt(4);
                        double rating = resultSet.getDouble(5);
                        Product product = new Product(idProduct, idCategory, name, price, rating);
                        products.add(product);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }




}
