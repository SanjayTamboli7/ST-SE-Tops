//CONTROLLER - ScheduleController.java

package com.example.hms2;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/api/schedules")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000")

public class ScheduleController {

 @Autowired
 private ScheduleService scheduleService;

 @GetMapping
 public Page<ScheduleDTO> getAllSchedules(
         @RequestParam(defaultValue = "") String search,
         @RequestParam(defaultValue = "0") int page,
         @RequestParam(defaultValue = "10") int size,
         @RequestParam(defaultValue = "scheduledate") String sortBy,
         @RequestParam(defaultValue = "asc") String sortDir) {
     return scheduleService.getAllSchedules(search, page, size, sortBy, sortDir);
 }

 @PostMapping
 public ResponseEntity<String> createSchedule(@RequestBody ScheduleDTO dto) {
     scheduleService.saveSchedule(dto);
     return ResponseEntity.ok("Schedule created successfully");
 }

 @PutMapping("/{id}")
 public ResponseEntity<String> updateSchedule(@PathVariable("id") Long id, @RequestBody ScheduleDTO dto) {
     scheduleService.updateSchedule(id, dto);
     return ResponseEntity.ok("Schedule updated successfully");
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteSchedule(@PathVariable("id") Long id) {
     scheduleService.deleteSchedule(id);
     return ResponseEntity.ok("Schedule deleted successfully");
 }

 @GetMapping("/{id}")
 public ResponseEntity<ScheduleDTO> getSchedule(@PathVariable("id") Long id) {
     return ResponseEntity.ok(scheduleService.getScheduleById(id));
 }

 @GetMapping("/search-v2")
 public ResponseEntity<Map<String, Object>> searchSchedules(
     @RequestParam(defaultValue = "") String keyword,
     @RequestParam(defaultValue = "0") int page,
     @RequestParam(defaultValue = "10") int size
 ) {
     Map<String, Object> result = scheduleService.searchSchedulesByNameOrDesignation(keyword, page, size);
     return ResponseEntity.ok(result);
 }

 @PostMapping("/create")
 public String createSchedule(@RequestParam int lastaddeditby) {
     scheduleService.callScheduleShift(lastaddeditby);
     return "Schedule created successfully!";
 } 
}
