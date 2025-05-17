package com.example.hms2;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/api/poheaders")
public class TxnPoHeaderController {

    @Autowired
    private TxnPoHeaderService service;

    @Autowired
    private TxnPoDetailsService txnPoDetailsService;

    // Paginated list
    @GetMapping
    public ResponseEntity<Page<PoHeaderListDTO>> getHeaders(
        @RequestParam(defaultValue = "") String status,
        @RequestParam(defaultValue = "0") Integer poid,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "podate") String sortBy,
        @RequestParam(defaultValue = "DESC") String direction) {

        Page<PoHeaderListDTO> pageResult = service.getAllHeaders(status, poid, page, size, sortBy, direction);
        return ResponseEntity.ok(pageResult);
    }

    // Get full DTO for view/edit
    @GetMapping("/{id}")
    public ResponseEntity<PoHeaderDTO> getById(@PathVariable Integer id) {
        PoHeaderDTO dto = service.getPoHeaderById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/details/{poid}")
    public ResponseEntity<List<TxnPoDetailsDTO>> getPoDetails(@PathVariable Integer poid) {
        List<TxnPoDetailsDTO> poDetailDTOs = txnPoDetailsService.getPoDetailsByPoid(poid);
        return ResponseEntity.ok(poDetailDTOs);
    }

 // POST - Create PO
    @PostMapping
    public ResponseEntity<PoHeaderDTO> createPo(@RequestBody PoHeaderDTO dto) {
        PoHeaderDTO created = service.createPo(dto);
        return ResponseEntity.ok(created);
    }
    
 // PUT - Update PO
    @PutMapping("/{id}")
    public ResponseEntity<PoHeaderDTO> updatePo(@PathVariable Integer id, @RequestBody PoHeaderDTO dto) {
        PoHeaderDTO updated = service.updatePo(id, dto);
        return ResponseEntity.ok(updated);
    }

    // DELETE - Delete PO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePo(@PathVariable Integer id) {
        service.deletePo(id);
        return ResponseEntity.noContent().build();
    }
    
    // @GetMapping("/poheaders/maxdate")
    @GetMapping("/maxdate")
    public ResponseEntity<LocalDate> getMaxPoDate() {
        return ResponseEntity.ok(service.getMaxPoDate());
    }   
    
}
