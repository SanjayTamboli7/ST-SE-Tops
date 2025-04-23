//REPOSITORY - ScheduleRepository.java

package com.example.hms2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	@Query("SELECT s FROM Schedule s WHERE s.attendance LIKE %:search%")
    Page<Schedule> findByAttendanceContaining(String search, Pageable pageable);}
