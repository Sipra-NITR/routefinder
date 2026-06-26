package Project;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/RouteFinder";

    private static final String USER = "root";
    private static final String PASSWORD = "Sipra_Singh@14";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD);
    }
}