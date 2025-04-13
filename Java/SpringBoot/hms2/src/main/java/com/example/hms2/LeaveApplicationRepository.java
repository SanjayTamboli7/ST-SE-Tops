package com.example.hms2;

//package com.example.leaveapp.repository;
//
//import com.example.leaveapp.model.LeaveApplication;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Integer> {
    Page<LeaveApplication> findByLeaveapptypeContainingIgnoreCaseOrLeaveappstatusContainingIgnoreCase(
        String type, String status, Pageable pageable
    );
}
