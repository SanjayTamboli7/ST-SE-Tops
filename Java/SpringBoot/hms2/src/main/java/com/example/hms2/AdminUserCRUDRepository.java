package com.example.hms2;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminUserCRUDRepository extends JpaRepository<AdminUserCRUD, Integer> {
    Optional<AdminUserCRUD> findByAuseremailid(String email);

    // ✅ Enable Pagination for fetching users
    Page<AdminUserCRUD> findAll(Pageable pageable);

    // ✅ Enable Pagination for Search
    @Query("SELECT u FROM AdminUserCRUD u WHERE " +
            "LOWER(u.ausername) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.auseremailid) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.ausercontactno) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR u.auserstatus = :keyword")
    Page<AdminUserCRUD> searchUsers(@Param("keyword") String keyword, Pageable pageable);

}

