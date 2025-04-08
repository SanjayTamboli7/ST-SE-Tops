package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository repository;

    public Page<Designation> getAll(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("designationname"));
        return repository.searchByName(search, pageable);
    }

    public Page<Designation> getAll(String search, int page, int size, String sortField, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        return repository.searchByName(search, pageable);
    }
    
    
    public Optional<Designation> getById(int id) {
        return repository.findById(id);
    }

    public Designation save(Designation designation) {
        designation.setLasteditdatetime(LocalDateTime.now());
        return repository.save(designation);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

