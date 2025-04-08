package com.example.hms2;

// package com.example.departmentapi.repository;

// import com.example.departmentapi.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Page<Department> findByDeptnameContainingIgnoreCase(String deptname, Pageable pageable);
}
