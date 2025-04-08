package com.example.hms2;

import java.time.LocalDateTime;

//import com.example.departmentapi.entity.Department;
//import com.example.departmentapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest; // Page request creation
//import org.springframework.data.domain.Pageable; // Pageable parameter support
//import org.springframework.data.domain.Sort; // Sorting support
import org.springframework.http.ResponseEntity;
//Required for @RestController, @RequestMapping, @GetMapping, etc.
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
@RequestMapping("/api/designations")
@CrossOrigin(origins = "http://localhost:3000")
public class DesignationController {

    @Autowired
    private DesignationService service;

//    @GetMapping
//    public Page<Designation> getAll(
//            @RequestParam(defaultValue = "") String search,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size) {
//        return service.getAll(search, page, size);
//    }
//
//    @GetMapping
//    public Page<Designation> getAll(
//            @RequestParam(defaultValue = "") String search,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size,
//            @RequestParam(defaultValue = "designationname") String sortField,
//            @RequestParam(defaultValue = "asc") String sortDir) {
//        return service.getAll(search, page, size, sortField, sortDir);
//    }

    @GetMapping
    public Page<Designation> getAll(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return service.getAll(search, page, size);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Designation> getById(@PathVariable int id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Designation add(@RequestBody Designation designation) {
        return service.save(designation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Designation> update(@PathVariable int id, @RequestBody Designation updated) {
        return service.getById(id).map(existing -> {
            existing.setDesignationname(updated.getDesignationname());
            existing.setLastaddeditby(updated.getLastaddeditby());
            existing.setLasteditdatetime(LocalDateTime.now());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
