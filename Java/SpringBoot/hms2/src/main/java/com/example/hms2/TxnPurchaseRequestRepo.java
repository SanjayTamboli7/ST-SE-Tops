package com.example.hms2;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface TxnPurchaseRequestRepo extends CrudRepository<TxnPurchaseRequest, Integer> {

	@Query(value = """
		    SELECT txnpr.itemid AS itemid, txnpr.qty AS qty, txnpr.prid AS prid 
		    FROM txnpurchaserequest txnpr 
		    WHERE txnpr.podetailid IS NULL 
		      AND txnpr.itemid IN (
		          SELECT mstsi.itemid 
		          FROM mstsupplieritems mstsi 
		          WHERE mstsi.supplierid = :supplierid
		      ) 
		    ORDER BY txnpr.itemid
		    """, nativeQuery = true)
		List<PRItemDTO> findEligiblePRItemsBySupplier(@Param("supplierid") Integer supplierid);
	
}
