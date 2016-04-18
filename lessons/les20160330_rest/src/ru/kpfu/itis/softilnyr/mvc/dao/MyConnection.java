package ru.kpfu.itis.softilnyr.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by softi on 01.04.2016.
 */
public class MyConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/virtual_schools",
                "postgres", "soft160896"

        );
        return conn;
    }
}
