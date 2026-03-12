package init_cycle.dbservice;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseService {

    private Connection connection;

    public void init() throws Exception {

        System.out.println("Initializing DB connection");

        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/springdb",
                "postgres",
                "Aniket620@"
        );

        System.out.println("DB Connected");
    }

    public Connection getConnection() {
        return connection;
    }

    public void destroy() throws Exception {

        System.out.println("Closing DB connection");

        if (connection != null) {
            connection.close();
        }
    }
}