package org.example;

import org.postgresql.Driver;

import java.sql.*;
import java.util.Scanner;

import static java.text.DateFormat.DEFAULT;

public class ProjectManagement {
    static Driver driver;
    static Connection connection;
    static Statement statement;
    static Scanner sc ;
    public static void main(String[] args) throws SQLException {
        driver = new Driver();
        DriverManager.registerDriver(driver);

        String url = "jdbc:postgresql://localhost:5433/ProductManagement";
        String user = "postgres";
        String password = "ABCDEF";

        connection = DriverManager.getConnection(url, user, password);

        System.out.println("Connected Successfully!");

        //create statement
         statement = connection.createStatement();
         sc = new Scanner(System.in);
        while(true){
            System.out.println("Product Management System");
            System.out.println("1. Add products to the system.");


            System.out.println("enter choice");
            int choice = sc.nextInt();

            switch(choice){
                case 1 : addProduct();
                case 2 : viewProduct();
                case 3 : viewProductByID();

                default: addProduct();
            }
        }



    }

    static void addProduct() throws SQLException {
        System.out.println("enter id");
        int id = sc.nextInt();
        ResultSet rs = statement.executeQuery("select * from products where product_id = " + id);
        if (rs.next()) {
            System.out.println("already exist");
            return;
        }
        sc.nextLine();
        System.out.println("enter name");
        String name = sc.nextLine();

        System.out.println("Enter Category: ");
        String category = sc.nextLine();

        System.out.println("Enter Price: ");
        double price = sc.nextDouble();
        if (price <= 0) {
            System.out.println("Invalid Price!");
            return;
        }

        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();
        if (quantity < 0) {
            System.out.println("Invalid Quantity!");
            return;
        }

        System.out.println("Enter Rating (1-5): ");
        double rating = sc.nextDouble();
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid Rating!");
            return;
        }
        System.out.println("Enter Manufacturer: ");
        String manufacturer = sc.nextLine();

        int rowsInserted = statement.executeUpdate("INSERT INTO products VALUES(" + id + ",'" + name + "','" + category + "'," + price + "," + quantity + "," + rating + ",'" + manufacturer + "',DEFAULT )");
        if (rowsInserted > 0) {
            System.out.println(rowsInserted + " inserted successfully");
        } else {
            System.out.println("failed");
        }
    }

    static void viewProduct() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from products ");
        while(rs.next()){
            int id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            String category = rs.getString("category");
            int price = rs.getInt("price");
            double quantity = rs.getDouble("quantity");
            int rate = rs.getInt("rating");
            String manufacturer = rs.getString("manufacturer");

            System.out.println(id + "|" + name + "|" + category + "|" + price + "|" + quantity + "|" + rate + "|" + manufacturer);
        }
    }

    static void viewProductByID() throws SQLException {
        System.out.println("enter id");
        int id = sc.nextInt();
        ResultSet rs = statement.executeQuery("select * from products where product_id = " + id);
        while(rs.next()){
            String name = rs.getString("product_name");
            String category = rs.getString("category");
            int price = rs.getInt("price");
            double quantity = rs.getDouble("quantity");
            int rate = rs.getInt("rating");
            String manufacturer = rs.getString("manufacturer");

            System.out.println(  name + "|" + category + "|" + price + "|" + quantity + "|" + rate + "|" + manufacturer);
        }
    }
}
