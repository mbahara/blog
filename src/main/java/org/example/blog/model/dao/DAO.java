package org.example.blog.model.dao;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String JDBC_URL = System.getenv().getOrDefault("JDBC_URL", "jdbc:h2:mem:testdb");
    private static final String JDBC_USER = System.getenv().getOrDefault("JDBC_USER", "db-user");
    private static final String JDBC_PASSWORD = System.getenv().getOrDefault("JDBC_PASSWORD", "password+1");

    @Getter
    private static final Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Fehler beim Aufbau der Datenbankverbindung", e);
        }
    }
}
