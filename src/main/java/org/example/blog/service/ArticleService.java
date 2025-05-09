package org.example.blog.service;

import lombok.AllArgsConstructor;
import org.example.blog.model.Article;
import org.example.blog.model.Comment;
import org.example.blog.model.dao.ArticleDAO;
import org.example.blog.model.dao.CommentDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ArticleService {

    public List<Article> getAllArticles() {
        return ArticleDAO.findAll();
    }

    public Article getArticle(Long id) {
        return ArticleDAO.findById(id);
    }

    public void addComment(Long id, Comment comment) {
        CommentDAO.addComment(comment, id);
    }
}
