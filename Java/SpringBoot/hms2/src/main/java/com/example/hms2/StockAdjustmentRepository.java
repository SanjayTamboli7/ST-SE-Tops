package com.example.hms2;

//package com.example.stockadjustment.repository;

//import com.example.stockadjustment.model.StockAdjustment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockAdjustmentRepository extends JpaRepository<StockAdjustment, Long> {
    @Query("SELECT sa FROM StockAdjustment sa WHERE " +
           "(:search IS NULL OR sa.reason LIKE %:search% OR sa.remark LIKE %:search% OR sa.status LIKE %:search%)")
    Page<StockAdjustment> findBySearch(@Param("search") String search, Pageable pageable);
}