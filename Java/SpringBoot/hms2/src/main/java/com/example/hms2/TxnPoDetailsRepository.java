// TxnPoDetailsRepository
package com.example.hms2;

//package com.example.repository;
//
//import com.example.entity.TxnPoDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TxnPoDetailsRepository extends JpaRepository<TxnPoDetails, Integer> {
//public interface TxnPoDetailRepository extends JpaRepository<TxnPoDetail, Integer> {	

    List<TxnPoDetails> findByPoid(Integer poid);
 // List<TxnPoDetails> findByPoid(Integer poid);
    void deleteByPoid(Integer poid);
}
