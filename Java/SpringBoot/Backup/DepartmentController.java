package com.example.hms2;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin("*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    @GetMapping
//    public Page<Department> getAllDepartments(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size,
//            @RequestParam(defaultValue = "") String search) {
//        return departmentService.getDepartments(search, PageRequest.of(page, size));
//    }

    @GetMapping
    public ResponseEntity<Page<Department>> getAllDepartments(
        @RequestParam(defaultValue = "") String search,
        @PageableDefault(size = 5, sort = "deptname") Pageable pageable) {
    	System.out.println("Current Page: " + pageable.getPageNumber());
    	System.out.println("Page Size: " + pageable.getPageSize());

        Page<Department> departments = departmentService.getDepartments(search, pageable);
        return ResponseEntity.ok(departments);
    }
    
    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

//    @PostMapping
//    public Department addDepartment(@RequestBody Department department) {
//        return departmentService.saveDepartment(department);
//    }

    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody Department department) {
        try {
            Department savedDepartment = departmentService.saveDepartment(department);
            return ResponseEntity.ok(savedDepartment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable int id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
    }
}
