package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TxnPoHeaderServiceImpl implements TxnPoHeaderService {

    @Autowired
    private TxnPoHeaderRepository headerRepository;

    @Autowired
    private TxnPoDetailsRepository detailRepository;

    @Override
    public Page<TxnPoHeader> getPagedHeaders(String search, int page, int size, String sortBy, boolean asc) {
        Pageable pageable = PageRequest.of(page, size, asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
        return headerRepository.searchByPoidOrSupplierName(search, pageable);
    }

    @Override
    @Transactional
    public TxnPoHeaderDTO savePoHeaderWithDetails(TxnPoHeaderDTO dto) {
        TxnPoHeader header = new TxnPoHeader();
        if (dto.getPoid() != null) {
            header = headerRepository.findById(dto.getPoid()).orElse(new TxnPoHeader());
        }

        header.setSupplierid(dto.getSupplierid());
        header.setStatus(dto.getStatus());
        header.setLasteditdatetime(LocalDateTime.now());
        header.setLastaddeditby(dto.getLastaddeditby());
        header.setPodate(dto.getPodate());
        header.setDeliverydate(dto.getDeliverydate());

        TxnPoHeader savedHeader = headerRepository.save(header);

        detailRepository.deleteByPoid(savedHeader.getPoid());

        if (dto.getDetails() != null && !dto.getDetails().isEmpty()) {
            List<TxnPoDetails> details = dto.getDetails().stream()
                .filter(d -> d.getItemid() != null && d.getQty() != null)
                .map(d -> {
                    TxnPoDetails detail = new TxnPoDetails();
                    detail.setPoid(savedHeader.getPoid());
                    detail.setItemid(d.getItemid());
                    detail.setQty(d.getQty());
                    detail.setRate(d.getRate());
                    detail.setAmount(d.getAmount());
                    detail.setPrid(d.getPrid());
                    detail.setLastaddeditby(dto.getLastaddeditby());
                    detail.setLasteditdatetime(LocalDateTime.now());
                    return detail;
                }).collect(Collectors.toList());

            detailRepository.saveAll(details);
        }

        dto.setPoid(savedHeader.getPoid());
        return dto;
    }

    @Override
    public TxnPoHeaderDTO getPoHeaderWithDetails(Integer poid) {
        TxnPoHeader header = headerRepository.findById(poid)
            .orElseThrow(() -> new RuntimeException("PO not found"));

        TxnPoHeaderDTO dto = new TxnPoHeaderDTO();
        dto.setPoid(header.getPoid());
        dto.setSupplierid(header.getSupplierid());
        dto.setStatus(header.getStatus());
        dto.setLasteditdatetime(header.getLasteditdatetime());
        dto.setLastaddeditby(header.getLastaddeditby());

        List<TxnPoDetails> details = detailRepository.findByPoid(poid);
        if (details != null) {
            dto.setDetails(details.stream().map(d -> {
                TxnPoDetailsDTO detailDto = new TxnPoDetailsDTO();
                detailDto.setItemid(d.getItemid());
                detailDto.setQty(d.getQty());
                detailDto.setRate(d.getRate());
                detailDto.setAmount(d.getAmount());
                detailDto.setPrid(d.getPrid());
                detailDto.setPodetailid(d.getPodetailid());
                detailDto.setLastaddeditby(d.getLastaddeditby());
                detailDto.setLasteditdatetime(d.getLasteditdatetime());
                return detailDto;
            }).collect(Collectors.toList()));
        } else {
            dto.setDetails(Collections.emptyList());
        }

        return dto;
    }

    @Override
    @Transactional
    public void deletePo(Integer poid) {
        detailRepository.deleteByPoid(poid);
        headerRepository.deleteById(poid);
    }
}
