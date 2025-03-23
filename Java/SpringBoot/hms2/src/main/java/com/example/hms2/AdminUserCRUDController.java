package com.example.hms2;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/adminusers")
@CrossOrigin(origins = "http://localhost:3000") // Enable CORS for React Frontend

public class AdminUserCRUDController {

    private final AdminUserCRUDRepository adminUserCRUDRepository;

    public AdminUserCRUDController(AdminUserCRUDRepository adminUserCRUDRepository) {
        this.adminUserCRUDRepository = adminUserCRUDRepository;
    }

    // GET: Fetch all users
    @GetMapping
    public List<AdminUserCRUD> getAllUsers() {
        return adminUserCRUDRepository.findAll();
    }

    // GET: Fetch user by ID
    @GetMapping("/{id}")
    public ResponseEntity<AdminUserCRUD> getUserById(@PathVariable int id) {
        Optional<AdminUserCRUD> user = adminUserCRUDRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Add a new user
    @PostMapping
    public AdminUserCRUD createUser(@RequestBody AdminUserCRUD adminUserCURD) {
        return adminUserCRUDRepository.save(adminUserCURD);
    }

    // PUT: Update user by ID
    @PutMapping("/{id}")
    public ResponseEntity<AdminUserCRUD> updateUser(@PathVariable int id, @RequestBody AdminUserCRUD updatedUser) {

//    	if (!updatedUser.getAuserstatus().equalsIgnoreCase("Active") &&
//    		    !updatedUser.getAuserstatus().equalsIgnoreCase("Inactive")) {
//    		    return ResponseEntity.badRequest().body(null);
//    		}
    	
    	return adminUserCRUDRepository.findById(id).map(user -> {
            user.setAusername(updatedUser.getAusername());
            user.setAuseremailid(updatedUser.getAuseremailid());
            user.setAusercontactno(updatedUser.getAusercontactno());
            user.setAuserstatus(updatedUser.getAuserstatus());
            user.setLasteditdatetime(updatedUser.getLasteditdatetime());
            return ResponseEntity.ok(adminUserCRUDRepository.save(user));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Remove user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        if (adminUserCRUDRepository.existsById(id)) {
        	adminUserCRUDRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/search")
    public Page<AdminUserCRUD> searchUsers(@RequestParam String keyword, Pageable pageable) {
        return adminUserCRUDRepository.searchUsers(keyword, pageable);
    }    

}

