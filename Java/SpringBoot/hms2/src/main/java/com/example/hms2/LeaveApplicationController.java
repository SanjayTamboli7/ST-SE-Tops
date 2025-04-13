package com.example.hms2;

//package com.example.leaveapp.controller;
//
//import com.example.leaveapp.model.LeaveApplication;
//import com.example.leaveapp.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;

import java.util.*;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin(origins = "*")
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationService service;

    @GetMapping
    public Page<LeaveApplication> getAll(
        @RequestParam(defaultValue = "") String keyword,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "leaveappid") String sortBy,
        @RequestParam(defaultValue = "asc") String direction
    ) {
        return service.getAll(keyword, page, size, sortBy, direction);
    }

    @PostMapping
    public LeaveApplication create(@RequestBody LeaveApplication app) {
        return service.save(app);
    }

    @PutMapping("/{id}")
    public LeaveApplication update(@PathVariable int id, @RequestBody LeaveApplication app) {
        app.setLeaveappid(id);
        return service.save(app);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<LeaveApplication> getById(@PathVariable int id) {
        return service.getById(id);
    }
    
    @PatchMapping("/{id}/status")
    public LeaveApplication updateStatus(@PathVariable int id, @RequestParam String status) {
        Optional<LeaveApplication> optional = service.getById(id);
        if (optional.isPresent()) {
            LeaveApplication leave = optional.get();
            leave.setLeaveappstatus(status);
            return service.save(leave);
        } else {
            throw new RuntimeException("Leave application not found");
        }
    }
    
}
