package com.example.hms2;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminUserCRUDRepository extends JpaRepository<AdminUserCRUD, Integer> {
    Optional<AdminUserCRUD> findByAuseremailid(String email);
    
    // Search by username, email, or contact number
    @Query("SELECT u FROM AdminUserCRUD u WHERE " +
            "LOWER(u.ausername) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.auseremailid) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.ausercontactno) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            "OR u.auserstatus = :keyword")
     Page<AdminUserCRUD> searchUsers(@Param("keyword") String keyword, Pageable pageable);
        
}

