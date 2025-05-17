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

    @Transactional
    public List<TxnPoDetailsDTO> getPoDetailsByPoid(Integer poid) {
        // Fetch PO details by header ID
        List<TxnPoDetails> txnPoDetailsList = txnPoDetailsRepository.findByPoHeader_Poid(poid);

        // Convert to DTOs
        List<TxnPoDetailsDTO> txnPoDetailsDTOList = txnPoDetailsList.stream()
            .map(txnPoDetails -> {
                TxnPoDetailsDTO dto = new TxnPoDetailsDTO();
                dto.setPodetailid(txnPoDetails.getPodetailid());
                dto.setPoid(txnPoDetails.getPoHeader().getPoid());
                dto.setItemid(txnPoDetails.getItem().getItemid());
                dto.setItemname(txnPoDetails.getItem().getItemname());
                dto.setQty(txnPoDetails.getQty());
                dto.setRate(txnPoDetails.getRate());
                dto.setAmount(txnPoDetails.getQty() * txnPoDetails.getRate());
                dto.setLastaddeditby(txnPoDetails.getLastaddeditby());
                dto.setLasteditdatetime(txnPoDetails.getLasteditdatetime());
                return dto;
            })
            .collect(Collectors.toList());

        return txnPoDetailsDTOList;
    }
}
