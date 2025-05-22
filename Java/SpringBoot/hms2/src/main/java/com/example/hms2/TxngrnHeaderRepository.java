package com.example.hms2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TxngrnHeaderRepository extends JpaRepository<TxngrnHeader, Integer> {
    Page<TxngrnHeader> findAll(Pageable pageable);

    @Query("SELECT h FROM TxngrnHeader h WHERE " +
    	       "CAST(h.grnid AS string) LIKE %:keyword% OR " +
    	       "CAST(h.status AS string) LIKE %:keyword%")
    	Page<TxngrnHeader> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
    
}
