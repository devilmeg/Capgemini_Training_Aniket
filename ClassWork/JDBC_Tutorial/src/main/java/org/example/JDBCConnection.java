package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/Student";
        String user = "postgres";
        String password = "Vishal@2020";

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL successfully!");

            // Create statement
            Statement statement = connection.createStatement();

            // Example query
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS demo(id INT PRIMARY KEY, name VARCHAR(50));");
//
//            System.out.println("Table created!");

            //Retreive Data
            // Execute Querry will return result_set Interface.
//            ResultSet rs = statement.executeQuery("select * from emp");
//
//            while(rs.next()){
//                int id =rs.getInt("empno");
//                String name = rs.getString("ename");
//                String job = rs.getString("Job");
//                System.out.println(id + "|" + name + "|"+ job);
//            }
            // Update
//            int rowsUpdate = statement.executeUpdate("update emp set ename = 'Vishal' where empno = 7499 ");
//            if(rowsUpdate >0){
//                System.out.println("No. of updated rows : "+ rowsUpdate);
//            }else{
//                System.out.println("Update Failed");
//            }

            //delete
            int rowDeleted = statement.executeUpdate("delete from emp where empno = 7499");
            if(rowDeleted > 0){
                System.out.println("rows Deleted "+ rowDeleted);
            }
            else{
                System.out.println("Deleted failed"
                );
            }

            // Close connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}