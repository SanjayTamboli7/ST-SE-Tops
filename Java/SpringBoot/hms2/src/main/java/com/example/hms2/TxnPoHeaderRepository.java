package com.example.hms2;

import java.math.BigDecimal;

//package com.example.hms2.repository;
//
//import com.example.hms2.entity.TxnPoHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface TxnPoHeaderRepository extends JpaRepository<TxnPoHeader, Integer> {
	@Query(
		    value = "SELECT txnpoheader.* FROM txnpoheader, mstsupplier " +
		            "WHERE (txnpoheader.supplierid = mstsupplier.supplierid) and (:search IS NULL OR CAST(poid AS CHAR) LIKE CONCAT('%', :search, '%') " +
		            "OR mstsupplier.suppliername LIKE CONCAT('%', :search, '%'))",
		    countQuery = "SELECT COUNT(*) FROM txnpoheader, mstsupplier " +
		                 "WHERE (txnpoheader.supplierid = mstsupplier.supplierid) and (:search IS NULL OR CAST(poid AS CHAR) LIKE CONCAT('%', :search, '%') " +
		                 "OR mstsupplier.suppliername LIKE CONCAT('%', :search, '%'))",
		    nativeQuery = true
		)
		Page<TxnPoHeader> searchByPoidOrSupplierName(@Param("search") String search, Pageable pageable);

	@Modifying
	@Query("UPDATE TxnPoHeader h SET h.totalAmount = :totalAmount WHERE h.poid = :poid")
	void updateTotalAmount(@Param("poid") Integer poid, @Param("totalAmount") BigDecimal totalAmount);

//    @Modifying
//    @Transactional
//    @Query("UPDATE TxnPoHeader h SET h.totalAmount = :totalAmount WHERE h.poid = :poid")
//    void updateTotalAmount(@Param("poid") Integer poid, @Param("totalAmount") BigDecimal totalAmount);
	
}
