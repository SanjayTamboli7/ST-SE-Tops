package com.example.hms2;

//package com.example.hms2.repository;
//
//import com.example.hms2.entity.TxnPoHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TxnPoHeaderRepository extends JpaRepository<TxnPoHeader, Integer> {
    // Page<TxnPoHeader> findByPoidContainingIgnoreCaseOrSuppliernameContainingIgnoreCase(String poid, String suppliername, Pageable pageable);
	@Query(
//		    value = "SELECT * FROM txnpoheader " +
//		            "WHERE (:search IS NULL OR CAST(poid AS CHAR) LIKE CONCAT('%', :search, '%') " +
//		            "OR suppliername LIKE CONCAT('%', :search, '%'))",
//		    countQuery = "SELECT COUNT(*) FROM txnpoheader " +
//		                 "WHERE (:search IS NULL OR CAST(poid AS CHAR) LIKE CONCAT('%', :search, '%') " +
//		                 "OR suppliername LIKE CONCAT('%', :search, '%'))",
//		    nativeQuery = true
		    value = "SELECT txnpoheader.* FROM txnpoheader, mstsupplier " +
		            "WHERE (txnpoheader.supplierid = mstsupplier.supplierid) and (:search IS NULL OR CAST(poid AS CHAR) LIKE CONCAT('%', :search, '%') " +
		            "OR mstsupplier.suppliername LIKE CONCAT('%', :search, '%'))",
		    countQuery = "SELECT COUNT(*) FROM txnpoheader, mstsupplier " +
		                 "WHERE (txnpoheader.supplierid = mstsupplier.supplierid) and (:search IS NULL OR CAST(poid AS CHAR) LIKE CONCAT('%', :search, '%') " +
		                 "OR mstsupplier.suppliername LIKE CONCAT('%', :search, '%'))",
		    nativeQuery = true
		)
		Page<TxnPoHeader> searchByPoidOrSupplierName(@Param("search") String search, Pageable pageable);

}
