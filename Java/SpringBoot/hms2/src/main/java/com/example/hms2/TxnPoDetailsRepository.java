package com.example.hms2;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TxnPoDetailsRepository extends JpaRepository<TxnPoDetails, Integer> {
    List<TxnPoDetails> findByPoHeader_Poid(Integer poid);
    
    void deleteByPoHeader_Poid(Integer poid);

}
