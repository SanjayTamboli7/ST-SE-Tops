package com.example.hms2;

//package com.example.stockadjustment.controller;
//
//import com.example.stockadjustment.dto.StockAdjustmentDTO;
//import com.example.stockadjustment.service.StockAdjustmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stockadjustments")
@CrossOrigin("*")
public class StockAdjustmentController {
    @Autowired
    private StockAdjustmentService service;

    @GetMapping
    public ResponseEntity<Page<StockAdjustmentDTO>> getAllStockAdjustments(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "adjustmentId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        Page<StockAdjustmentDTO> adjustments = service.getAllStockAdjustments(search, pageable);
        return ResponseEntity.ok(adjustments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockAdjustmentDTO> getStockAdjustmentById(@PathVariable Long id) {
        StockAdjustmentDTO adjustment = service.getStockAdjustmentById(id);
        return ResponseEntity.ok(adjustment);
    }

    @PostMapping
    public ResponseEntity<StockAdjustmentDTO> createStockAdjustment(@Valid @RequestBody StockAdjustmentDTO dto) {
        StockAdjustmentDTO created = service.createStockAdjustment(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockAdjustmentDTO> updateStockAdjustment(@PathVariable Long id, @Valid @RequestBody StockAdjustmentDTO dto) {
        StockAdjustmentDTO updated = service.updateStockAdjustment(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockAdjustment(@PathVariable Long id) {
        service.deleteStockAdjustment(id);
        return ResponseEntity.noContent().build();
    }
}