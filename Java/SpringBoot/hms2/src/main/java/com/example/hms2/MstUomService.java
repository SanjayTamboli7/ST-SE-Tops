package com.example.hms2;

//package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MstUomService {

    @Autowired
    private MstUomRepository repository;

    public Page<MstUom> getAllUoms(String search, int page, int size, String sortField, String sortDir) {
        Pageable pageable = PageRequest.of(page, size,
            sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());

        if (search == null || search.isEmpty()) {
            return repository.findAll(pageable);
        } else {
            return repository.findByUomnameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(search, search, pageable);
        }
    }

    public Optional<MstUom> getUomById(Integer id) {
        return repository.findById(id);
    }

    public MstUom saveUom(MstUom uom, Integer userId) {
        uom.setLastaddeditby(userId);
        uom.setLasteditdatetime(LocalDateTime.now());
        return repository.save(uom);
    }

    public void deleteUom(Integer id) {
        repository.deleteById(id);
    }
}
