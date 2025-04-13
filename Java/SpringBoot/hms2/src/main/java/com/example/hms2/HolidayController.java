package com.example.hms2;

//package com.example.holidaymanagement.controller;
//
//import com.example.holidaymanagement.entity.Holiday;
//import com.example.holidaymanagement.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/holidays")
@CrossOrigin(origins = "*")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @GetMapping
    public Page<Holiday> list(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "holidaydate") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        return holidayService.list(search, page, size, sortField, sortDir);
    }

    @PostMapping
    public Holiday save(@RequestBody Holiday holiday) {
        return holidayService.save(holiday);
    }

    @DeleteMapping("/{date}")
    public void delete(@PathVariable Date date) {
        holidayService.delete(date);
    }

    @GetMapping("/{date}")
    public Holiday get(@PathVariable Date date) {
        return holidayService.get(date);
    }

    @PutMapping("/{date}")
    public Holiday update(@PathVariable Date date, @RequestBody Holiday updatedHoliday) {
        Holiday existing = holidayService.get(date);
        if (existing == null) {
            throw new RuntimeException("Holiday not found for date: " + date);
        }

        // Update fields
        existing.setHolidayname(updatedHoliday.getHolidayname());
        existing.setHolidaytype(updatedHoliday.getHolidaytype());
        existing.setHolidaydescription(updatedHoliday.getHolidaydescription());
        existing.setLastaddeditby(updatedHoliday.getLastaddeditby());
        existing.setLasteditdatetime(LocalDateTime.now());

        return holidayService.save(existing);
    }    
}

