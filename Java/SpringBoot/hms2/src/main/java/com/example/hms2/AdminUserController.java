package com.example.hms2;
//package com.example.hms2.controller;
//
//import com.example.hms2.model.AdminUser;
//import com.example.hms2.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.hms2.AdminUserController.adminUserRepository;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminUserController {

    public interface adminUserRepository {

		static Optional<AdminUser> findByAuserEmailId(String email) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Autowired
    private AdminUserService service;

    /**
     * Login API
     */
    @PostMapping("/login")
    public AdminUser login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || password == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email and password must be provided.");
        }        
        // return service.login(credentials.get("email"), credentials.get("password"));
        return service.login(email, password);
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

