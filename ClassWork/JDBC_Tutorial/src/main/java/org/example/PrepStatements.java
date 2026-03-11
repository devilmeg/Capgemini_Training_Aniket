package org.example;

import java.sql.*;

public class PrepStatements {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/Student";
        String user = "postgres";
        String password = "Vishal@2020";
        // Establish connection
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to PostgreSQL successfully!");

        // Create statement
//        Statement statement = connection.createStatement();
        String querry = "select * from products where product_id = ?";
        PreparedStatement ps = connection.prepareStatement(querry);
        ps.setInt(1,1);
        ResultSet noOfRows = ps.executeQuery();
        while(noOfRows.next()){
            int product_id = noOfRows.getInt(1);
            String pName = noOfRows.getString(2);
            System.out.println(product_id + " | " + pName);
        }



    }
}
