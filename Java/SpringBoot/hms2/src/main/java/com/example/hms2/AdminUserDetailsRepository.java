package com.example.hms2;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminUserDetailsRepository extends JpaRepository<AdminUser, Integer> {

    @Query("SELECT new com.example.hms2.AdminUserDetails(a.auserid, a.auserstatus) FROM AdminUser a WHERE a.auserEmailId = :email")
    Optional<AdminUserDetails> findUserDetailsByEmail(String email);
}
