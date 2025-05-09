package org.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private final Long id;
    private final String login;
    private final String password;
    private final String name;
}
