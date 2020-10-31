import java.sql.*;

public class DevelopersJdbcDemo {
    /**
     * JDBC Driver and database url
     */
   // static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lab8?serverTimezone=UTC&amp;useUnicode=true&amp;characterEncoding=UTF-8";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "H@r4e#k0";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM car";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nDevelopers:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String brend = resultSet.getString("brend");
            String types = resultSet.getString("types");
            String color = resultSet.getString("color");
            int capacity = resultSet.getInt("capacity");
            int price = resultSet.getInt("price");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Brend: " + brend);
            System.out.println("Types: " + types);
            System.out.println("Color: " + color);
            System.out.println("Capacity: " + capacity);
            System.out.println("Price: $" + price);
        }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}