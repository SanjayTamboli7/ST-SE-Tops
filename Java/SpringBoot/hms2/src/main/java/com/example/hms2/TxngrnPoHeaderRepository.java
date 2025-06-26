package com.example.hms2;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TxngrnPoHeaderRepository extends CrudRepository<TxnPoHeader, Integer> {

    @Query(value = "SELECT pohdr.poid AS poid, pohdr.podate AS podate, s.suppliername AS suppliername " +
                   "FROM txnpoheader pohdr " +
                   "JOIN mstsupplier s ON pohdr.supplierid = s.supplierid " +
                   "WHERE pohdr.status = 'Approve' " +
                   "ORDER BY pohdr.podate, pohdr.poid", nativeQuery = true)
    List<PoDropdownProjection> findApprovedPoDropdown();
}
