package com.example.hms2;

//package com.example.demo.controller;
//
//import com.example.demo.entity.OUOtherUser;
//import com.example.demo.service.OUOtherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/ouuser")
@CrossOrigin(origins = "*")
public class OUOtherUserController {

	@Autowired
	private OUOtherUserService service;

	@PostMapping("/login")
	public Optional<OUOtherUser> login(@RequestBody Map<String, String> payload) {
		return service.login(payload.get("email"), payload.get("password"));
	}

	@PostMapping("/change-password-alt")
	public ResponseEntity<String> changePassword(@RequestBody OUChangePasswordRequest request) {
		boolean updated = service.changePassword(request.getEmail(), request.getNewPassword());
		if (updated) {
			return ResponseEntity.ok("Password changed successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

}
