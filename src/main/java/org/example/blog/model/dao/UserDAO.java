package org.example.blog.model.dao;

import jakarta.validation.constraints.NotNull;
import org.example.blog.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends DAO {
    public static User findById(final long id) {
        try {
            final Connection conn = getConnection();
            final Statement stmt = conn.createStatement();
            final ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id = " + id);

            if (!rs.next()) return null;

            final User user = retrieveUser(rs);

            if (rs.next()) return null;

            rs.close();
            stmt.close();
            conn.close();

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User findByLogin(@NotNull String login) {
        // minimale Filterung
        login = login.replaceAll(" -- ", "");

        try {
            final Connection conn = getConnection();
            final Statement stmt = conn.createStatement();
            final ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE login = '" + login + "'");

            if (!rs.next()) return null;

            final User user = retrieveUser(rs);

            if (rs.next()) return null;

            rs.close();
            stmt.close();
            conn.close();

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static User retrieveUser(final ResultSet rs) throws SQLException {
        final Long id = rs.getLong("id");
        final String login = rs.getString("login");
        final String password = rs.getString("password");
        final String name = rs.getString("name");

        return new User(id, login, password, name);
    }
}
