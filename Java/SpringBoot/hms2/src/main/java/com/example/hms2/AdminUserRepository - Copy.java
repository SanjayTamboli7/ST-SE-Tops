package com.example.hms2;
//package com.example.adminlogin.repository;
//
//import com.example.adminlogin.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {
    Optional<AdminUser> findByAuserEmailId(String email);
}

