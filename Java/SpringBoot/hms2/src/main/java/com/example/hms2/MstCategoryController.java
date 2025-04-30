package com.example.hms2;

//package com.example.demo.controller;
//
//import com.example.demo.model.MstCategory;
//import com.example.demo.repository.MstCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class MstCategoryController {

    @Autowired
    private MstCategoryRepository repo;

    @GetMapping
    public Page<MstCategory> getAll(@RequestParam(defaultValue = "") String search,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "categoryid") String sortBy,
                                    @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageRequest.of(page, size,
                sortDir.equals("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());

//        return repo.findByCategorynameContainingIgnoreCase(search, pageable);
        return repo.searchCategories(search, pageable);

    }

    @GetMapping("/{id}")
    public Optional<MstCategory> getById(@PathVariable Integer id) {
        return repo.findById(id);
    }

    @PostMapping
    public MstCategory create(@RequestBody MstCategory category) {
        category.setLasteditdatetime(LocalDateTime.now());
        return repo.save(category);
    }

    @PutMapping("/{id}")
    public MstCategory update(@PathVariable Integer id, @RequestBody MstCategory category) {
        category.setCategoryid(id);
        category.setLasteditdatetime(LocalDateTime.now());
        return repo.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
    
}
