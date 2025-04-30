package com.example.hms2;

//package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/uoms")
@CrossOrigin(origins = "*")
public class MstUomController {

    @Autowired
    private MstUomService service;

    @GetMapping
    public Page<MstUom> getAllUoms(
        @RequestParam(defaultValue = "") String search,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "uomname") String sortField,
        @RequestParam(defaultValue = "asc") String sortDir
    ) {
        return service.getAllUoms(search, page, size, sortField, sortDir);
    }

    @GetMapping("/{id}")
    public Optional<MstUom> getUomById(@PathVariable Integer id) {
        return service.getUomById(id);
    }

    @PostMapping
    public MstUom createUom(@RequestBody MstUom uom, @RequestParam Integer userId) {
        return service.saveUom(uom, userId);
    }

    @PutMapping("/{id}")
    public MstUom updateUom(@PathVariable Integer id, @RequestBody MstUom uom, @RequestParam Integer userId) {
        uom.setUomid(id);
        return service.saveUom(uom, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUom(@PathVariable Integer id) {
        service.deleteUom(id);
    }
}
