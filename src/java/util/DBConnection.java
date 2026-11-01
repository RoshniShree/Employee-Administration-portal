package com.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = getSetting("EMS_DB_URL", "jdbc:mysql://localhost:3306/employee_db");
    private static final String USER = getSetting("EMS_DB_USER", "root");
    private static final String PASSWORD = getSetting("EMS_DB_PASSWORD", "your_mysql_password");

    private static String getSetting(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value == null || value.isBlank()) ? defaultValue : value;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
