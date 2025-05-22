package com.example.hms2;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TxngrnService {

    @Autowired
    private TxngrnHeaderRepository grnHeaderRepo;

    @Autowired
    private TxngrnDetailsRepository grnDetailRepo;

    @SuppressWarnings("unused")
	@Autowired
//    private MstItemRepository itemRepo;
    private ItemRepository itemRepo;

    @Transactional
    public TxngrnHeaderDTO saveGrn(TxngrnHeaderDTO dto) {
        TxngrnHeader header = new TxngrnHeader();

        if (dto.getGrnid() != null) {
            header = grnHeaderRepo.findById(dto.getGrnid()).orElse(new TxngrnHeader());
        }

        header.setGrnid(dto.getGrnid());
        header.setPo(new TxnPoHeader(dto.getPoid())); // assumes a constructor TxnPoHeader(Long id)
        header.setReceivedDate(dto.getReceivedDate() != null ? dto.getReceivedDate() : LocalDate.now());
        header.setReceivedBy(new OtherUser(dto.getReceivedBy())); // assumes OtherUser(Long id)
        header.setStatus(dto.getStatus());
        header.setLastAddEditBy(dto.getLastAddEditBy());
        header.setLastEditDateTime(LocalDateTime.now());

        TxngrnHeader savedHeader = grnHeaderRepo.save(header);

        // Save details
        List<TxngrnDetails> savedDetails = dto.getDetails().stream().map(detailDto -> {
            TxngrnDetails detail = new TxngrnDetails();
            detail.setGrnDetailId(detailDto.getGrnDetailId());
            detail.setGrnHeader(savedHeader);
            detail.setItem(new Item(detailDto.getItemid())); // assumes MstItem(Long id)
            detail.setOrderedQty(detailDto.getOrderedQty());
            detail.setReceivedQty(detailDto.getReceivedQty());
            detail.setAcceptedQty(detailDto.getAcceptedQty());
            detail.setRejectedQty(detailDto.getRejectedQty());
            detail.setBatchNo(detailDto.getBatchNo());
            detail.setExpiryDate(detailDto.getExpiryDate());
            detail.setPoDetail(detailDto.getPoDetailId() != null ? new TxnPoDetails(detailDto.getPoDetailId()) : null); // nullable
            detail.setLastAddEditBy(dto.getLastAddEditBy());
            detail.setLastEditDateTime(LocalDateTime.now());
            return detail;
        }).collect(Collectors.toList());

        grnDetailRepo.saveAll(savedDetails);

        return getGrnById(savedHeader.getGrnid());
    }

    public TxngrnHeaderDTO getGrnById(Integer grnid) {
        TxngrnHeader header = grnHeaderRepo.findById(grnid).orElseThrow();

        TxngrnHeaderDTO dto = new TxngrnHeaderDTO();
        dto.setGrnid(header.getGrnid());
        dto.setPoid(header.getPo().getPoid());
        dto.setReceivedDate(header.getReceivedDate());
        dto.setReceivedBy(header.getReceivedBy().getOuserid());
        dto.setStatus(header.getStatus());
        dto.setLastAddEditBy(header.getLastAddEditBy());
        dto.setLastEditDateTime(header.getLastEditDateTime());

        List<TxngrnDetailsDTO> details = header.getDetails().stream().map(detail -> {
            TxngrnDetailsDTO d = new TxngrnDetailsDTO();
            d.setGrnDetailId(detail.getGrnDetailId());
            // d.setItemid(detail.getItem().getItemId());
            d.setItemid(detail.getItem().getItemid());
            d.setOrderedQty(detail.getOrderedQty());
            d.setReceivedQty(detail.getReceivedQty());
            d.setAcceptedQty(detail.getAcceptedQty());
            d.setReceivedQty(detail.getRejectedQty());
            d.setBatchNo(detail.getBatchNo());
            d.setExpiryDate(detail.getExpiryDate());
            d.setPoDetailId(detail.getPoDetail() != null ? detail.getPoDetail().getPodetailid() : null);
            return d;
        }).collect(Collectors.toList());

        dto.setDetails(details);

        return dto;
    }

    public Page<TxngrnHeaderDTO> searchGrns(String keyword, int page, int size, String sortField, String sortDir) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortField);
        Page<TxngrnHeader> grnPage = grnHeaderRepo.searchByKeyword(keyword, pageable);
        return grnPage.map(header -> {
            TxngrnHeaderDTO dto = new TxngrnHeaderDTO();
            dto.setGrnid(header.getGrnid());
            dto.setPoid(header.getPo().getPoid());
            dto.setReceivedDate(header.getReceivedDate());
            dto.setReceivedBy(header.getReceivedBy().getOuserid());
            dto.setStatus(header.getStatus());
            dto.setLastAddEditBy(header.getLastAddEditBy());
            dto.setLastEditDateTime(header.getLastEditDateTime());
            return dto;
        });
    }

    @Transactional
    public void deleteGrn(Integer grnid) {
        if (!grnHeaderRepo.existsById(grnid)) {
            throw new RuntimeException("GRN not found: " + grnid);
        }
        grnDetailRepo.deleteByGrnid(grnid);
        grnHeaderRepo.deleteById(grnid);
    }
}
