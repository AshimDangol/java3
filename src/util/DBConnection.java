package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String BASE_URL = "jdbc:postgresql://localhost:5432/";
    private static final String DB_NAME = "studentdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    static {
        initDatabase();
    }

    private static void initDatabase() {
        try (Connection conn = DriverManager.getConnection(BASE_URL + "postgres", USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT 1 FROM pg_database WHERE datname = '" + DB_NAME + "'");
            if (!rs.next()) {
                stmt.executeUpdate("CREATE DATABASE " + DB_NAME);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database: " + e.getMessage());
        }
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS students (" +
                "student_id INT PRIMARY KEY, " +
                "student_name VARCHAR(100), " +
                "email VARCHAR(100), " +
                "course VARCHAR(50), " +
                "marks DOUBLE PRECISION)"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(BASE_URL + DB_NAME, USER, PASSWORD);
    }
}
