package org.example.blog.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.blog.model.User;
import org.example.blog.model.dao.UserDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        User user = UserDAO.findByLogin(request.getLogin());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @Setter
    @Getter
    public static class LoginRequest {
        private String login;
        private String password;
    }
}
