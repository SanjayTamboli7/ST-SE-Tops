package com.example.hms2;

//package com.example.hms2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MstUomRepository extends JpaRepository<MstUom, Integer> {

    Page<MstUom> findByUomnameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String uomname, String description, Pageable pageable);
}
