package com.example.hms2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TxnPoDetailsService {

    @Autowired
    private TxnPoDetailsRepository txnPoDetailsRepository;
    
//    @Autowired
//    private TxnPoDetailsRepository txnPoDetailsRepository;

    @Transactional
    public List<TxnPoDetailsDTO> getPoDetailsByPoid(Integer poid) {
        // Fetch TxnPoDetails list from the repository based on POID
        List<TxnPoDetails> txnPoDetailsList = txnPoDetailsRepository.findByPoHeader_Poid(poid);

        // Map each TxnPoDetails entity to TxnPoDetailsDTO
        List<TxnPoDetailsDTO> txnPoDetailsDTOList = txnPoDetailsList.stream()
            .map(txnPoDetails -> {
                // Create a new TxnPoDetailsDTO and populate it with data from TxnPoDetails
                return new TxnPoDetailsDTO(
                    txnPoDetails.getPodetailid(),
                    txnPoDetails.getPoHeader().getPoid(), // Mapping POID from TxnPoHeader
                    txnPoDetails.getItem().getItemid(),   // Mapping ItemID from Item
                    txnPoDetails.getQty(),
                    txnPoDetails.getRate()
                );
            })
            .collect(Collectors.toList());

        // Return the list of TxnPoDetailsDTO
        return txnPoDetailsDTOList;
    }
}

