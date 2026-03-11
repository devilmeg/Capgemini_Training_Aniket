package PreparedStatement;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Basics {
    public static void main(String[] args) throws SQLException {

        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        //create connection

        String url = "jdbc:postgresql://localhost:5433/BOOKS";
        String user = "postgres";
        String password = "ABCDEF";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("Connected Successfully!");


//        String insertQuery = "INSERT INTO books (?,?,?)";
//        PreparedStatement ps = connection.prepareStatement(insertQuery);
//
//        ps.setInt(1,3);
//        ps.setString(2,"aus");
//
//        int rowsInserted = ps.executeUpdate();

        String updateQuery = "UPDATE books SET book_name = ? WHERE book_id = 3";
        PreparedStatement ps = connection.prepareStatement(updateQuery);





    }
}
