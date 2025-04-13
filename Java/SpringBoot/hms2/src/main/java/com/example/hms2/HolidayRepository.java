package com.example.hms2;

//package com.example.holidaymanagement.repository;

//import com.example.holidaymanagement.entity.Holiday;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, java.sql.Date> {
    @Query("SELECT h FROM Holiday h WHERE " +
           "LOWER(h.holidayname) LIKE LOWER(CONCAT('%', :search, '%')) " +
           "OR LOWER(h.holidaytype) LIKE LOWER(CONCAT('%', :search, '%')) " +
           "OR LOWER(h.holidaydescription) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Holiday> search(String search, Pageable pageable);
}
