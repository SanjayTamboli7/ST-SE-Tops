package com.example.hms2;

//package com.example.leaveapp.service;
//
//import com.example.leaveapp.model.LeaveApplication;
//import com.example.leaveapp.repository.LeaveApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaveApplicationService {

    @Autowired
    private LeaveApplicationRepository repo;

    public Page<LeaveApplication> getAll(String keyword, int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findByLeaveapptypeContainingIgnoreCaseOrLeaveappstatusContainingIgnoreCase(keyword, keyword, pageable);
    }

    public LeaveApplication save(LeaveApplication app) {
        return repo.save(app);
    }

    public Optional<LeaveApplication> getById(int id) {
        return repo.findById(id);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
}

