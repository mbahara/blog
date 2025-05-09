package org.example.blog.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Article {

    private final Long id;

    private final String title;
    private final String lead;
    private final String text;

    private final List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments.stream().toList();
    }

    public void addComment(final @NotNull Comment comment) {
        this.comments.add(comment);
    }

    public void addComments(final @NotNull List<Comment> comments) {
        this.comments.addAll(comments);
    }
}
