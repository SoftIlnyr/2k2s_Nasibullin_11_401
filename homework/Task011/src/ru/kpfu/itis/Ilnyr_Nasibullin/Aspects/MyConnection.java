package ru.kpfu.itis.Ilnyr_Nasibullin.Aspects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ilnyr on 14.10.2015.
 */
public class MyConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/book_track",
                "postgres", "soft160896"

        );
        return conn;
    }
}
