package org.example.blog.controller;

import org.example.blog.model.User;
import org.example.blog.model.dao.UserDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = UserDAO.findByLogin(request.getLogin());
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Ungültiger Benutzername oder Passwort");
        }
        return ResponseEntity.ok(user);
    }

    public static class LoginRequest {
        private String login;
        private String password;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
