package com.example.hms2;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {
    @Query("SELECT d FROM Designation d WHERE LOWER(d.designationname) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Designation> searchByName(@Param("search") String search, Pageable pageable);
}
