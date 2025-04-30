package com.example.hms2;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/suppliers")
public class MstSupplierController {
    @Autowired private MstSupplierRepository repo;

    @GetMapping
    public Page<MstSupplier> list(
        @RequestParam(defaultValue = "") String search,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "suppliername") String sortField,
        @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortField));
        Specification<MstSupplier> spec = (root, query, cb) -> {
            if (search == null || search.isEmpty()) return cb.conjunction();
            String like = "%" + search.toLowerCase() + "%";
            return cb.or(
                cb.like(cb.lower(root.get("suppliername")), like),
                cb.like(cb.lower(root.get("contactperson")), like)
            );
        };
        return repo.findAll(spec, pageable);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MstSupplier> getById(@PathVariable Integer id) {
        return repo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MstSupplier add(@RequestBody MstSupplier supplier) {
        supplier.setLasteditdatetime(LocalDateTime.now());
        return repo.save(supplier);
    }

    @PutMapping("/{id}")
    public MstSupplier update(@PathVariable Integer id, @RequestBody MstSupplier supplier) {
        supplier.setSupplierid(id);
        supplier.setLasteditdatetime(LocalDateTime.now());
        return repo.save(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
