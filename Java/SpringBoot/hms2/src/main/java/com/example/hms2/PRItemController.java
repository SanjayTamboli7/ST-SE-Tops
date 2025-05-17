package com.example.hms2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PRItemController {

    private final PRItemService prItemService;

    public PRItemController(PRItemService prItemService) {
        this.prItemService = prItemService;
    }

    @GetMapping("/pritems/{supplierid}")
    public ResponseEntity<List<PRItemDTO>> getPRItemsBySupplier(@PathVariable Integer supplierid) {
        List<PRItemDTO> items = prItemService.getItemsForSupplier(supplierid);
        return ResponseEntity.ok(items);
    }
}
