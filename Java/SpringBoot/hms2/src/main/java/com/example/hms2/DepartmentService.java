package com.example.hms2;

//package com.example.departmentapi.service;
//
//import com.example.departmentapi.entity.Department;
//import com.example.departmentapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    public Page<Department> getAllDepartments(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        System.out.println("Search Parameter: " + search); // Debugging output
        if (search == null || search.isEmpty()) {
            return departmentRepository.findAll(pageable);
        } else {
            return departmentRepository.findByDeptnameContainingIgnoreCase(search, pageable);
        }
    }
    
    public Optional<Department> getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }
    
    public Department saveOrUpdateDepartment(Department department) {
        department.setLasteditdatetime(LocalDateTime.now());
        return departmentRepository.save(department);
    }
    
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
