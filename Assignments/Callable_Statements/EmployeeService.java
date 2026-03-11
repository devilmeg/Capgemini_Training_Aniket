package Callable_Statements;

import java.sql.CallableStatement;
import java.sql.Connection;

public class EmployeeService {
    public void insertEmployee(int id ,String name , String job)throws Exception{
        String sql = "CALL InsertEmp(? ,? , ?)";
        Connection conn = DatabaseUtil.getConnection();
        CallableStatement stmt = conn.prepareCall(sql);

        stmt.setInt(1 , 1);
        stmt.setString(2 , "Vishal");
        stmt.setString(3 , "SDE");
        stmt.execute();
        System.out.println("Employee inserted successfully");
    }


}
