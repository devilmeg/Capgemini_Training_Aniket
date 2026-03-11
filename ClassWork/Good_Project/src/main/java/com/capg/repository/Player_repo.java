package com.capg.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Player_repo {
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/Student",
                "postgres",
            "Vishal@2020"
        );
    }
}
