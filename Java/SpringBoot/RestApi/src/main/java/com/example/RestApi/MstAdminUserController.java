package com.example.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class MstAdminUserController {

    @Autowired
    private MstAdminUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Validated @RequestBody MstAdminUser user) {
        user.setLast_edit_date_time(java.time.LocalDateTime.now().toString());
        @SuppressWarnings("unused")
		MstAdminUser savedUser = userService.saveUser(user);
        return ResponseEntity.ok("User created successfully");
    }
}
