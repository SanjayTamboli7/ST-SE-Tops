package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/api/grns")
@CrossOrigin(origins = "*") // Optional: Enable if frontend is on different domain
public class TxngrnController {

    @Autowired
    private TxngrnService grnService;

    // POST or PUT: Save GRN
    @PostMapping
    public ResponseEntity<TxngrnHeaderDTO> saveGrn(@RequestBody TxngrnHeaderDTO dto) {
        TxngrnHeaderDTO savedDto = grnService.saveGrn(dto);
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping("/{grnid}")
    public ResponseEntity<TxngrnHeaderDTO> getGrnById(@PathVariable Integer grnid) {
        System.out.println("Called getGrnById: " + grnid);
        return ResponseEntity.ok(grnService.getGrnById(grnid));
    }    
    // GET: Search with keyword, pagination, sorting
    @GetMapping
    public ResponseEntity<Page<TxngrnHeaderDTO>> searchGrns(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "grnid") String sortField,
            @RequestParam(defaultValue = "DESC") String sortDir) {
        Page<TxngrnHeaderDTO> results = grnService.searchGrns(keyword, page, size, sortField, sortDir);
        return ResponseEntity.ok(results);
    }

    // DELETE: Delete GRN by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrn(@PathVariable Integer id) {
        grnService.deleteGrn(id);
        return ResponseEntity.noContent().build();
    }

 // PUT: Edit existing GRN (header + details)
    @PutMapping("/{id}")
    public ResponseEntity<TxngrnHeaderDTO> updateGrn(@PathVariable Integer id, @RequestBody TxngrnHeaderDTO dto) {
        dto.setGrnid(id); // ensure path ID overrides body ID if needed
        TxngrnHeaderDTO updatedDto = grnService.saveGrn(dto);
        return ResponseEntity.ok(updatedDto);
    }
    
    @GetMapping("/test")
    public String test() {
        return "GRN endpoint working!";
    }    
}
