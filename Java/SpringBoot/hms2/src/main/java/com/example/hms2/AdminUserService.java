package com.example.hms2;
//package com.example.hms2.service;
//
//import com.example.hms2.model.AdminUser;
//import com.example.hms2.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserRepository repository;

    /**
     * Login function: Checks if the user exists and the password matches
     */
    public AdminUser login(String email, String password) {
        Optional<AdminUser> user = repository.findByAuserEmailId(email);

        if (user.isPresent()) {
            AdminUser admin = user.get();

            // ✅ Simple password comparison (not recommended for production)
            if (admin.getAuserpassword().equals(password)) {
                return admin; // ✅ Login Successful
            }
        }
        return null; // ❌ Login Failed
    }

    /**
     * Reset password function: Finds user by email and updates password
     */
    public boolean resetPassword(String email, String newPassword) {
        Optional<AdminUser> user = repository.findByAuserEmailId(email);

        if (user.isPresent()) {
            AdminUser admin = user.get();
            
            // ✅ Directly updating password without hashing (for simple comparison)
            admin.setAuserpassword(newPassword);
            repository.save(admin);

            return true; // ✅ Password reset successful
        }

        return false; // ❌ User not found
    }
}
