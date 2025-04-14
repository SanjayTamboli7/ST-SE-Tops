package com.example.hms2;

//package com.yourpackage.controller;
//
//import com.yourpackage.dto.OUEmailRequest;
//import com.yourpackage.dto.OUUserStatusResponse;
//import com.yourpackage.service.OUUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ouuser")
@CrossOrigin(origins = "*")
public class OUUserStatusController {

	@Autowired
	private OUUserService ouUserService;

	@PostMapping("/status-by-email")
	public ResponseEntity<?> getUserStatusByEmail(@RequestBody OUEmailRequest emailRequest) {
		return ouUserService.getUserStatusByEmail(emailRequest.getEmail()).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/change-password")
	public ResponseEntity<String> changePassword(@RequestBody OUEmailPasswordRequest request) {
		try {
			ouUserService.changePassword(request.getEmail(), request.getPassword());
			return ResponseEntity.ok("Password updated successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update password.");
		}
	}

}
