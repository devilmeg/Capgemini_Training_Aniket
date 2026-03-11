package org.example;

import java.sql.*;
import java.util.*;
import org.postgresql.Driver;

//import com..cj.jdbc.Driver;
public class JdbcSteps {
    public static void main(String[] args) throws SQLException {
        //Load & Register Driver
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        //create connection

        String url = "jdbc:postgresql://localhost:5433/BOOKS";
        String user = "postgres";
        String password = "ABCDEF";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("Connected Successfully!");

        //create statement
        Statement statement = connection.createStatement();

        //insert
//        int rowsInserted = statement.executeUpdate("Insert Into books VALUES (199,'ALL',6,8)");
//
//        if (rowsInserted>0){
//            System.out.println(rowsInserted+" inserted successfully");
//        }
//        else{
//            System.out.println("failed");
//        }

//        ResultSet rs = statement.executeQuery("SELECT * FROM books ");
//        while(rs.next()){
//            int id = rs.getInt("book_id");
//            String name = rs.getString("title");
//            int authorID = rs.getInt("author_id");
//            int genreID = rs.getInt("genre_id");
//
//            System.out.println(id+ "|" + name+ "|" + authorID + "|" + genreID);
//        }

        //update

//        int rowsUpdate = statement.executeUpdate("UPDATE loans SET  return_date = '2025-01-10'  WHERE book_id = 2");
//        if (rowsUpdate>0){
//            System.out.println(rowsUpdate+" inserted successfully");
//       }
//        else{
//            System.out.println("failed");
//       }

        //delete
        int rowsdelete = statement.executeUpdate("DELETE FROM books where book_id = 2");
        if (rowsdelete>0){
            System.out.println(rowsdelete+" deletion successfully");
       }
        else{
            System.out.println("failed");
       }

        //  bClose resources
        statement.close();
        connection.close();

        System.out.println("Connection Closed");

    }

}
