package org.example.blog.model.dao;

import jakarta.validation.constraints.NotNull;
import org.example.blog.model.Article;
import org.example.blog.model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO extends DAO {
    public static Article findById(final long id) {
        try {
            final Connection conn = getConnection();
            final Statement stmt = conn.createStatement();
            final ResultSet rs = stmt.executeQuery("SELECT * FROM article " +
                    "WHERE id = " + id);

            // No results
            if (!rs.next()) return null;

            final Article article = retrieveArticle(rs);

            // More results -> not unique -> can't choose
            if (rs.next()) return null;

            rs.close();
            stmt.close();
            conn.close();

            return article;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get all Article objects from DB where the title contains a certain string
     */
    public static List<Article> findWhereTitleLike(@NotNull final String query) {
        final List<Article> articles = new ArrayList<>();

        try {
            final Connection conn = getConnection();
            final PreparedStatement stmt = conn.prepareStatement("SELECT * FROM article "
                    + "WHERE LCASE(title) LIKE "
                    + "'%" + query.toLowerCase() + "%'"
                    + "ORDER BY id DESC");
            final ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                articles.add(retrieveArticle(rs));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }

    /**
     * Get all Article objects from DB
     */
    public static List<Article> findAll() {

        final List<Article> articles = new ArrayList<>();

        try {
            final Connection conn = getConnection();
            final Statement stmt = conn.createStatement();
            final ResultSet rs = stmt.executeQuery("SELECT * FROM article ORDER BY id DESC");

            while (rs.next()) {
                articles.add(retrieveArticle(rs));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }

    /**
     * Create single Article object from current result set
     */
    private static Article retrieveArticle(final ResultSet rs) throws SQLException {
        final long id = rs.getLong("id");
        final String title = rs.getString("title");
        final String lead = rs.getString("lead");
        final String text = rs.getString("text");

        final Article article = new Article(id, title, lead, text);
        List<Comment> comments = CommentDAO.findByArticleId(id);
        article.addComments(comments);
        return article;
    }
}
