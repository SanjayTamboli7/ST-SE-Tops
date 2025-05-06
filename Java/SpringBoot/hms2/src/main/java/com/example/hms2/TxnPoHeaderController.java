package com.example.hms2;
//package com.example.hms2;
//
//import com.example.hms2.entity.TxnPoHeader;
//import com.example.hms2.dto.TxnPoHeaderDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/poheaders")
@CrossOrigin
public class TxnPoHeaderController {

    @Autowired
    private TxnPoHeaderService txnPoHeaderService;

    @PostMapping
    public TxnPoHeaderDTO createPo(@RequestBody TxnPoHeaderDTO dto) {
        return txnPoHeaderService.savePoHeaderWithDetails(dto);
    }

    @PutMapping("/{poid}")
    public TxnPoHeaderDTO updatePo(@PathVariable Integer poid, @RequestBody TxnPoHeaderDTO dto) {
        dto.setPoid(poid);
        return txnPoHeaderService.savePoHeaderWithDetails(dto);
    }

    @GetMapping
    public ResponseEntity<Page<TxnPoHeader>> getPagedPoHeaders(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "lasteditdatetime") String sortBy,
            @RequestParam(defaultValue = "false") boolean asc
    ) {
        Page<TxnPoHeader> headers = txnPoHeaderService.getPagedHeaders(search.trim(), page, size, sortBy, asc);
        return ResponseEntity.ok(headers);
    }

    @GetMapping("/{poid}")
    public TxnPoHeaderDTO getPo(@PathVariable Integer poid) {
        return txnPoHeaderService.getPoHeaderWithDetails(poid);
    }

    @DeleteMapping("/{poid}")
    public void deletePo(@PathVariable Integer poid) {
        txnPoHeaderService.deletePo(poid);
    }
}
