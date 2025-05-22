package com.example.hms2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TxngrnDetailsRepository extends JpaRepository<TxngrnDetails, Integer> {
    List<TxngrnDetails> findByGrnHeader_Grnid(Integer grnid);
    
    @Modifying
    @Query("DELETE FROM TxngrnDetails d WHERE d.grnHeader.grnid = :grnid")
    void deleteByGrnHeader_Grnid(@Param("grnid") Integer grnid);

}
