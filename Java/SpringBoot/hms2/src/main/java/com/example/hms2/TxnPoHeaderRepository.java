package com.example.hms2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TxnPoHeaderRepository extends JpaRepository<TxnPoHeader, Integer> {

    // For paginated list view (summary data only)
	@Query("SELECT new com.example.hms2.PoHeaderListDTO(h.poid, s.suppliername, h.podate, h.status, h.totalAmount) " +
		       "FROM TxnPoHeader h JOIN h.supplier s " +
		       "WHERE (LOWER(h.status) LIKE LOWER(CONCAT('%', :status, '%')) " +
		       "AND h.supplier.supplierid = s.supplierid) " +
		       "OR h.poid = :poid")
		Page<PoHeaderListDTO> findAllHeadersByFilter(@Param("status") String status,
		                                              @Param("poid") Integer poid,
		                                              Pageable pageable);
    // For full detail view/edit
	@Query("SELECT h FROM TxnPoHeader h " +
		       "LEFT JOIN FETCH h.supplier s " +
		       "LEFT JOIN FETCH h.details d " +
		       "LEFT JOIN FETCH d.item i " +
		       "WHERE h.poid = :id")
		TxnPoHeader findByIdWithDetails(@Param("id") Integer id);	
}
