package init_cycle.dao;

import init_cycle.dbservice.DataBaseService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

    private DataBaseService databaseService;

    public void setDatabaseService(DataBaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void showStudents() throws Exception {

        Connection conn = databaseService.getConnection();

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name"));
        }
    }
}