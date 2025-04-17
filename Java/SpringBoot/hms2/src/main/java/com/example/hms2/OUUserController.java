package com.example.hms2;

//package com.example.demo.controller;
//
//import com.example.demo.dto.OUChangePasswordRequest;
//import com.example.demo.dto.OULoginRequest;
//import com.example.demo.entity.OUUser;
//import com.example.demo.service.OUUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ouuser")
@CrossOrigin(origins = "*")
public class OUUserController {

    @Autowired
    private OUUserService service;

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody OULoginRequest req) {
//        Optional<OUUser> user = service.login(req.getEmail(), req.getPassword());
//        return user.map(ResponseEntity::ok)
//                   .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"));
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody OULoginRequest req) {
        Optional<OUUser> user = service.login(req.getEmail(), req.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody OUChangePasswordRequest request) {
        boolean result = service.changePassword(request.getEmail(), request.getPassword());
        return result ?
                ResponseEntity.ok("Password changed successfully.") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

//    @PostMapping("/forgot-password")
//    public ResponseEntity<String> forgotPassword(@RequestBody OULoginRequest req) {
//        // Simulate sending reset email / OTP
//        return service.login(req.getEmail(), req.getPassword()).isPresent() ?
//                ResponseEntity.ok("Reset instructions sent to " + req.getEmail()) :
//                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not registered");
//    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody OULoginRequest req) {
        Optional<OUUser> userOpt = service.findByEmail(req.getEmail());
        return userOpt.isPresent()
                ? ResponseEntity.ok("Reset instructions sent to " + req.getEmail())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not registered");
    }    
}
