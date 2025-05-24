package com.example.hms2;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;

@NamedEntityGraph(
	    name = "TxngrnHeader.withRelated",
	    attributeNodes = {
	        @NamedAttributeNode("po"),
	        @NamedAttributeNode("receivedBy"),
	        @NamedAttributeNode("details")
	    }
	)

public interface TxngrnHeaderRepository extends JpaRepository<TxngrnHeader, Integer> {
    Page<TxngrnHeader> findAll(Pageable pageable);

    @Query("SELECT h FROM TxngrnHeader h WHERE " +
    	       "CAST(h.grnid AS string) LIKE %:keyword% OR " +
    	       "CAST(h.status AS string) LIKE %:keyword%")
    	Page<TxngrnHeader> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
    
//    @EntityGraph(attributePaths = {"po", "receivedBy", "details"})
//    @EntityGraph(value = "TxngrnHeader.withRelated", type = EntityGraph.EntityGraphType.LOAD)
//    Optional<TxngrnHeader> findByGrnid(Integer grnid);
    @EntityGraph(value = "TxngrnHeader.withAllRelations", type = EntityGraph.EntityGraphType.LOAD)
    Optional<TxngrnHeader> findByGrnid(Integer grnid);

}
