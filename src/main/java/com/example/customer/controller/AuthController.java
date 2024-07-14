package com.example.customer.controller;

import com.example.customer.security.JwtUtil;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        // Implement user validation here, for demo assume valid user
        String username = credentials.get("login_id");
        String password = credentials.get("password");

        // Validate credentials...

        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok(token);
    }
}
