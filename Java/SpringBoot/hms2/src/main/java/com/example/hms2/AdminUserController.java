package com.example.hms2;
//package com.example.hms2.controller;
//
//import com.example.hms2.model.AdminUser;
//import com.example.hms2.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminUserController {

    @Autowired
    private AdminUserService service;

    /**
     * Login API
     */
    @PostMapping("/login")
    public AdminUser login(@RequestBody Map<String, String> credentials) {
        return service.login(credentials.get("email"), credentials.get("password"));
    }

    /**
     * Reset Password API
     */
    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody Map<String, String> request) {
        // ✅ Validate request parameters
        String email = request.get("email");
        String newPassword = request.get("newPassword");

        if (email == null || newPassword == null) {
            return "Invalid request: Email or newPassword missing.";
        }

        boolean success = service.resetPassword(email, newPassword);
        return success ? "Password reset successful" : "User not found";
    }
}
