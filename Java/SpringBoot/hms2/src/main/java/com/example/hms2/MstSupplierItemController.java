package com.example.hms2;

//package com.example.hms2.controller;
//
//import com.example.hms2.dto.MstSupplierItemDTO;
//import com.example.hms2.entity.*;
//import com.example.hms2.repository.MstSupplierItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
//import java.util.*;
//import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/supplieritems")
@CrossOrigin(origins = "http://localhost:3000") // ✅ avoid "*", use specific origin
public class MstSupplierItemController {

    @Autowired
    private MstSupplierItemRepository repository;

    // 🔹 Add or Update
    @PostMapping
    public MstSupplierItemDTO save(@RequestBody MstSupplierItemDTO dto) {
        MstSupplierItem item = new MstSupplierItem();
        item.setSupplierid(dto.getSupplierid());
        item.setItemid(dto.getItemid());
        item.setLeadtimedays(dto.getLeadtimedays());
        item.setLastaddeditby(dto.getLastaddeditby());
        item.setLasteditdatetime(LocalDateTime.now());

        MstSupplierItem saved = repository.save(item);
        return convertToDTO(saved);
    }

    // 🔹 Get with Pagination + Search
    @GetMapping
    public Page<MstSupplierItemDTO> getAll(
        @RequestParam(defaultValue = "") String search,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("supplierid").ascending());

        Page<MstSupplierItem> pageData = search != null && !search.isBlank()
                ? repository.search(search.trim(), pageable)
                : repository.findAll(pageable);

        return pageData.map(this::convertToDTO);
    }

    // 🔹 Get One
    @GetMapping("/{supplierid}/{itemid}")
    public MstSupplierItemDTO getOne(@PathVariable Integer supplierid, @PathVariable Integer itemid) {
        MstSupplierItemKey key = new MstSupplierItemKey(supplierid, itemid);
        return repository.findById(key)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // 🔹 Delete
    @DeleteMapping("/{supplierid}/{itemid}")
    public void delete(@PathVariable Integer supplierid, @PathVariable Integer itemid) {
        MstSupplierItemKey key = new MstSupplierItemKey(supplierid, itemid);
        repository.deleteById(key);
    }

    // 🔹 Entity to DTO Conversion
    private MstSupplierItemDTO convertToDTO(MstSupplierItem item) {
        MstSupplierItemDTO dto = new MstSupplierItemDTO();
        dto.setSupplierid(item.getSupplierid());
        dto.setItemid(item.getItemid());
        dto.setLeadtimedays(item.getLeadtimedays());
        dto.setLastaddeditby(item.getLastaddeditby());
        dto.setLasteditdatetime(item.getLasteditdatetime());

        if (item.getSupplier() != null) {
            dto.setSuppliername(item.getSupplier().getSuppliername());
        }
        if (item.getItem() != null) {
            dto.setItemname(item.getItem().getItemname());
        }

        return dto;
    }
}
