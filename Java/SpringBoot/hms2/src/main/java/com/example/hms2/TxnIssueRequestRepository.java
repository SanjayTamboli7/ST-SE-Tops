package com.example.hms2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TxnIssueRequestRepository extends 
        JpaRepository<TxnIssueRequest, Integer>, 
        JpaSpecificationExecutor<TxnIssueRequest> {
}
