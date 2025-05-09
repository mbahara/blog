package org.example.blog.model.dao;

import jakarta.validation.constraints.NotNull;
import org.example.blog.model.Comment;
import org.example.blog.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends DAO {

    /**
     * Add Comment object to DB
     */
    public static void addComment(@NotNull final Comment comment, final long articleId) {
        try {
            final Connection conn = getConnection();
            final Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO comment (text, article_id, user_id) "
                    + "VALUES ('" + comment.getText() + "', " + articleId +
                    ", " + comment.getUser().getId() + ")");

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all Comment objects from DB for a specific article
     */
    public static List<Comment> findByArticleId(final long articleId) {
        final List<Comment> comments = new ArrayList<>();

        try {
            final Connection conn = getConnection();
            final Statement stmt = conn.createStatement();
            final ResultSet rs = stmt.executeQuery("SELECT * FROM comment "
                    + "WHERE article_id = " + articleId +
                    " ORDER BY id");

            while (rs.next()) {
                comments.add(retrieveComment(rs));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    /**
     * Create single Comment object from current result set
     */
    private static Comment retrieveComment(final ResultSet rs) throws SQLException {
        final String text = rs.getString("text");
        final User user = UserDAO.findById(rs.getLong("user_id"));

        return new Comment(text, user);
    }
}
