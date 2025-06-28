package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/api/itemissues")
@CrossOrigin("*")
public class TxnIssueRequestController {

    @Autowired
    private TxnIssueRequestService service;

    @GetMapping
    public Page<TxnIssueRequestDTO> getAll(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "issueid") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                                                    : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return service.getAll(pageable, search);
    }

    @GetMapping("/{id}")
    public TxnIssueRequestDTO getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public TxnIssueRequestDTO create(@RequestBody TxnIssueRequestDTO dto) {
        return service.createOrUpdate(dto);
    }

    @PutMapping("/{id}")
    public TxnIssueRequestDTO update(@PathVariable Integer id, @RequestBody TxnIssueRequestDTO dto) {
        dto.setIssueid(id);
        return service.createOrUpdate(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
