package DBconnection;



import Data.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDataBase {
    private static String url = "jdbc:mysql://localhost:3306/shopdatabase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1999";

    public static ArrayList<Customer> select() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();;
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
                while(resultSet.next()){
                    int idCustomer = resultSet.getInt(1);
                    int idCountry = resultSet.getInt(2);
                    String password = resultSet.getString(3);
                    String name = resultSet.getString(4);
                    String surname = resultSet.getString(5);
                    String patronymic = resultSet.getString(6);
                    String gender = resultSet.getString(7);
                    String role = resultSet.getString(8);
                    Customer customer = new Customer(idCustomer, idCountry, password, name,surname,patronymic,gender, role);
                    customers.add(customer);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return customers;
    }

    public static Customer selectOne(int id) {
        Customer customer = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM customer WHERE idCustomer=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idCustomer = resultSet.getInt(1);
                        int idCountry = resultSet.getInt(2);
                        String password = resultSet.getString(3);
                        String name = resultSet.getString(4);
                        String surname = resultSet.getString(5);
                        String patronymic = resultSet.getString(6);
                        String gender = resultSet.getString(7);
                        String role = resultSet.getString(8);
                        customer = new Customer(idCustomer, idCountry, password, name,surname,patronymic,gender, role);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return customer;
    }

    /*public static boolean selectone(Customer customer, String password1){
        Customer customerres = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM customer WHERE password = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, password1);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idCustomer = resultSet.getInt(1);
                        int idCountry = resultSet.getInt(2);
                        String passwordres = resultSet.getString(3);
                        String name = resultSet.getString(4);
                        String surname = resultSet.getString(5);
                        String patronymic = resultSet.getString(6);
                        String gender = resultSet.getString(7);
                        String role = resultSet.getString(8);
                        customerres = new Customer( idCountry, passwordres, name,surname,patronymic,gender, role);
                    }

                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        assert customerres != null;
        if(customer.getIdCountry()==customerres.getIdCountry() && customer.getPassword().equals(customerres.getPassword()) && customer.getName().equals(customerres.getName()) && customer.getSurname().equals(customerres.getSurname()) && customer.getPatronymic().equals(customer.getPatronymic()) && customer.getGender().equals(customerres.getGender()) && customer.getRole().equals(customerres.getRole())){
            return true;
        }
        return false;
    }*/


    public static boolean selectone(Customer customer, String uname){
        Customer customerres = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM customer WHERE name = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, uname);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idCustomer = resultSet.getInt(1);
                        int idCountry = resultSet.getInt(2);
                        String passwordres = resultSet.getString(3);
                        String name = resultSet.getString(4);
                        String surname = resultSet.getString(5);
                        String patronymic = resultSet.getString(6);
                        String gender = resultSet.getString(7);
                        String role = resultSet.getString(8);
                        customerres = new Customer( idCustomer, idCountry, passwordres, name,surname,patronymic,gender, role);

                        assert customerres != null;
                        if(customer.getPassword().equals(customerres.getPassword()) && customer.getName().equals(customerres.getName()) ){
                            return true;
                        }
                    }

                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return false;
    }

    public static String selectoneRole(Customer customer, String uname){
        Customer customerres = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM customer WHERE name = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, uname);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idCustomer = resultSet.getInt(1);
                        int idCountry = resultSet.getInt(2);
                        String passwordres = resultSet.getString(3);
                        String name = resultSet.getString(4);
                        String surname = resultSet.getString(5);
                        String patronymic = resultSet.getString(6);
                        String gender = resultSet.getString(7);
                        String role = resultSet.getString(8);
                        customerres = new Customer( idCustomer, idCountry, passwordres, name,surname,patronymic,gender, role);

                        assert customerres != null;
                        if(customer.getPassword().equals(customerres.getPassword()) && customer.getName().equals(customerres.getName()) ){
                            return customerres.getRole();
                        }
                    }

                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    public static int selectoneID(Customer customer, String uname){
        Customer customerres = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM customer WHERE name = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, uname);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int idCustomer = resultSet.getInt(1);
                        int idCountry = resultSet.getInt(2);
                        String passwordres = resultSet.getString(3);
                        String name = resultSet.getString(4);
                        String surname = resultSet.getString(5);
                        String patronymic = resultSet.getString(6);
                        String gender = resultSet.getString(7);
                        String role = resultSet.getString(8);
                        customerres = new Customer( idCustomer, idCountry, passwordres, name,surname,patronymic,gender, role);

                        assert customerres != null;
                        if(customer.getPassword().equals(customerres.getPassword()) && customer.getName().equals(customerres.getName()) ){
                            return customerres.getIdCustomer();
                        }
                    }

                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int insert(Customer customer) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO customer (idCountry, password, name, surname, patronymic, gender, role ) Values ( ?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, customer.getIdCountry());
                    preparedStatement.setString(2, customer.getPassword());
                    preparedStatement.setString(3, customer.getName());
                    preparedStatement.setString(4, customer.getSurname());
                    preparedStatement.setString(5, customer.getPatronymic());
                    preparedStatement.setString(6, customer.getGender());
                    preparedStatement.setString(7, customer.getRole());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Customer customer) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE customer SET idCountry = ?, password = ?, name = ?, surname = ?, patronymic = ?, gender = ?, role = ?" +
                        " WHERE idCustomer = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(8, customer.getIdCustomer());
                    preparedStatement.setInt(1, customer.getIdCountry());
                    preparedStatement.setString(2, customer.getPassword());
                    preparedStatement.setString(3, customer.getName());
                    preparedStatement.setString(4, customer.getSurname());
                    preparedStatement.setString(5, customer.getPatronymic());
                    preparedStatement.setString(6, customer.getGender());
                    preparedStatement.setString(7, customer.getRole());

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
                String sql = "DELETE FROM customer WHERE idCustomer = ?";
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
