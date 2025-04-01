package com.example.hms2;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adminuserdetails")
@CrossOrigin("*")
public class AdminUserDetailsController {
    @Autowired
    private AdminUserDetailsService service;
    
    @GetMapping("/fetchUserDetails")
    public ResponseEntity<?> getUserDetailsByEmail(@RequestParam String email) {
        Optional<AdminUserDetails> userDetails = service.getUserDetailsByEmail(email);
        if (userDetails.isPresent()) {
            return ResponseEntity.ok(userDetails.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}