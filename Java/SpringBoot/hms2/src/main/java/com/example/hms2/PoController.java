package com.example.hms2;

//package com.example.demo.controller;
//
//import com.example.demo.dto.PoItemDTO;
//import com.example.demo.service.PoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poitems")
@CrossOrigin(origins = "*") // Optional: Enable if frontend is on different domain
public class PoController {

    @Autowired
    private PoService poService;

    @GetMapping("/{poid}")
    public List<PoItemDTO> getPoItems(@PathVariable Integer poid) {
        return poService.getItemsByPoId(poid);
    }
}
