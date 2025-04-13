package com.example.hms2;

//package com.example.holidaymanagement.service;

//import com.example.holidaymanagement.entity.Holiday;
//import com.example.holidaymanagement.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepo;

    public Page<Holiday> list(String search, int page, int size, String sortField, String sortDir) {
        Pageable pageable = PageRequest.of(page, size,
                sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        return holidayRepo.search(search, pageable);
    }

    public Holiday save(Holiday holiday) {
        holiday.setLasteditdatetime(LocalDateTime.now());
        return holidayRepo.save(holiday);
    }

    public void delete(Date date) {
        holidayRepo.deleteById(date);
    }

    public Holiday get(Date date) {
        return holidayRepo.findById(date).orElse(null);
    }
}

