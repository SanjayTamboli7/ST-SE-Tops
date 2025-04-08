package com.example.hms2;

import java.util.Optional; // Handling optional results

// package com.example.departmentapi.controller;

//import com.example.departmentapi.entity.Department;
//import com.example.departmentapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest; // Page request creation
//import org.springframework.data.domain.Pageable; // Pageable parameter support
//import org.springframework.data.domain.Sort; // Sorting support
import org.springframework.http.ResponseEntity;
// Required for @RestController, @RequestMapping, @GetMapping, etc.
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

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public ResponseEntity<Page<Department>> getAllDepartments(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(departmentService.getAllDepartments(search, page, size));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.saveOrUpdateDepartment(department));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department department) {
        if (!departmentService.getDepartmentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        department.setDeptid(id);
        return ResponseEntity.ok(departmentService.saveOrUpdateDepartment(department));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
        if (!departmentService.getDepartmentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}

