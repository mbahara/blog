package org.example.blog.controller;

import org.example.blog.model.Article;
import org.example.blog.model.Comment;
import org.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping
    public List<Article> getAll() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<?> addComment(@PathVariable Long id, @RequestBody Comment comment) {
        articleService.addComment(id, comment);
        return ResponseEntity.ok().build();
    }
}
