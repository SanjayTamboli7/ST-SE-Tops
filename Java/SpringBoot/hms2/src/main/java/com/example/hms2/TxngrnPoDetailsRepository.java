package com.example.hms2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TxngrnPoDetailsRepository extends CrudRepository<TxnPoDetails, Integer> {

    @Query(value = "SELECT podetail.podetailid, podetail.itemid, podetail.qty " +
                   "FROM txnpodetails AS podetail " +
                   "WHERE podetail.poid = :poid AND podetail.grndetailid IS NULL",
           nativeQuery = true)
    List<Object[]> findRawPoItemsByPoid(Integer poid);
}
