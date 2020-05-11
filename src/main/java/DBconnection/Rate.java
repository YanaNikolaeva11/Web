package DBconnection;

import java.sql.*;

public class Rate {
    private static String url = "jdbc:mysql://localhost:3306/shopdatabase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1999";

    public static int insert(int id, double rating) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO rating (idProduct, rating ) Values (?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.setDouble(2, rating);
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static double getRate(int id) {
        double rate = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            ;
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT AVG (rating) FROM rating where idProduct=?");
                while (resultSet.next()) {
                    rate = resultSet.getDouble(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return rate;
    }


}
