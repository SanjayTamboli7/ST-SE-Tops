package com.example.hms2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
//    @Query("SELECT d FROM Department d WHERE d.deptname LIKE %:search%")
//    Page<Department> searchDepartments(String search, Pageable pageable);
	@Query("SELECT d FROM Department d WHERE LOWER(d.deptname) LIKE LOWER(CONCAT('%', :search, '%'))")
	Page<Department> searchDepartments(@Param("search") String search, Pageable pageable);
	
}
