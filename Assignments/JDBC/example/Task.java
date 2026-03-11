package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import static java.time.LocalDateTime.now;

public class Task {
    static Scanner sc;
    static String url = "jdbc:postgresql://localhost:5432/Student";
    static String user = "postgres";
    static String password = "Vishal@2020";

    static Connection connection;
    static Statement statement;



    public static void main(String[] args) throws Exception{
        sc = new Scanner(System.in);
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        boolean isExit= true;
        int choice;
        while(isExit){
            System.out.println("Enter the choice number you want");
            System.out.println("1. Add Product");
            System.out.println("2. View All Product");
            System.out.println("3. View Product By ID");
            System.out.println("4. Update Product Price");
            System.out.println("5. Update Product Stock");
            System.out.println("6. Delete Product");
            System.out.println("7. Search By Name");
            System.out.println("8. Search By Category");
            System.out.println("9. Low Stock Alert");
            System.out.println("10. Top Rated Products");
            System.out.println("11. sort Products");
            System.out.println("12. Calculate Stock Value");
            System.out.println("13. Count Products");
            System.out.println("14. Category Wise Products");
            System.out.println("15. Pagination View");
            System.out.println("16. Exit Application");
            System.out.println("Enter your Choice");
            choice = sc.nextInt();
            switch(choice){
                default: addProduct();
                case 1 : addProduct();
                case 2 :

                    viewAllProduct();

                case 3 :
                    System.out.println("Enter the id: ");
                    int id = sc.nextInt();
                    viewProductById(id);

                case 4: updateProductPrice();

//
//                case 3: viewProductById();
//                case 4 : updateProductPrice();
//                case 5: updaeProductStock();
                case 16 : isExit = false;
            }


        }
    }


    static void addProduct() throws Exception{
        System.out.println("Enter Product_id");
        int Product_id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Product name");
        String pName = sc.nextLine();
        System.out.println("Enter Category");
        String category = sc.nextLine();
        System.out.println("Enter price");
        Double price = sc.nextDouble();
        System.out.println("Enter Quantity");
        int quantity = sc.nextInt();
        System.out.println("Enter Rating");
        Double rating = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Manufacturer name");
        String manu = sc.nextLine();
        LocalDateTime created_time = now();

        int noOfrows = statement.executeUpdate("Insert into products values("+Product_id+",'"+ pName+ "','"+ category + "'," + price + "," + quantity + "," + rating + ",'" + manu +"','" + created_time + "')");
        if(noOfrows >0){
            System.out.println("Inserted Successfully");
        }else{
            System.out.println("Insertion Failed");
        }
    }

    static void viewAllProduct()throws Exception{
        ResultSet rs = statement.executeQuery("select * from products");
        while(rs.next()){
            int Product_id = rs.getInt(1);
            String pName = rs.getString(2);
            String category = rs.getString(3);
            Double price = rs.getDouble(4);
            int quantity = rs.getInt(5);
            Double rating = rs.getDouble(6);
            String manu = rs.getString(7);
            Date date = rs.getDate(8);

            System.out.println(Product_id  + " | " + pName  + " | " +  category  + price +  " | "  +  quantity  + "|" +rating + " | " +  manu + " | " + date);


        }
    }
    static void viewProductById(int id)throws Exception{
        ResultSet rs = statement.executeQuery("select * from products where id = " + id);
        if(rs.wasNull()){
            System.out.println("product not found");
        }
        while(rs.next()){
            int Product_id = rs.getInt(1);
            String pName = rs.getString(2);
            String category = rs.getString(3);
            Double price = rs.getDouble(4);
            int quantity = rs.getInt(5);
            Double rating = rs.getDouble(6);
            String manu = rs.getString(7);
            Date date = rs.getDate(8);

            System.out.println(Product_id  + " | " + pName  + " | " +  category  + price +  " | "  +  quantity  + "|" +rating + " | " +  manu + " | " + date);


        }
    }
    static void updateProductPrice() throws Exception{
        System.out.println("Enter the product_id of the product whose price you want to update");
        int pId = sc.nextInt();
        System.out.println("Enter the updated Price");
        double updatedPrice = sc.nextInt();
        int noOfRows = statement.executeUpdate("Update products set price = " + updatedPrice + "  where product_id = "+ pId );
        System.out.println("No. of rows affected : " + noOfRows);


    }
}
