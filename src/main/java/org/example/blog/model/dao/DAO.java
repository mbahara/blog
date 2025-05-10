package org.example.blog.model.dao;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String JDBC_URL = "jdbc:h2:mem:testdb";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "";

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
