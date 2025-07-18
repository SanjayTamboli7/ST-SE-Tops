package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TxngrnService {

    @Autowired
    private TxngrnHeaderRepository grnHeaderRepo;

    @Autowired
    private TxngrnDetailsRepository grnDetailRepo;

    @Autowired
    private OtherUserRepository otherUserRepository;

//    @Autowired
//    private TxnPoHeaderRepository poHeaderRepository;

    @SuppressWarnings("unused")
    @Autowired
    private ItemRepository itemRepo;

    @Transactional
    public TxngrnHeaderDTO saveGrn(TxngrnHeaderDTO dto) {
        TxngrnHeader header;

        if (dto.getReceivedBy() == null) {
            throw new IllegalArgumentException("ReceivedBy (User) is mandatory");
        }

        OtherUser user = otherUserRepository.findById(dto.getReceivedBy())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getReceivedBy()));

        if (dto.getGrnid() != null) {
            header = grnHeaderRepo.findById(dto.getGrnid())
                    .orElseThrow(() -> new RuntimeException("GRN not found with ID: " + dto.getGrnid()));
            grnDetailRepo.deleteByGrnHeader_Grnid(dto.getGrnid());
        } else {
            header = new TxngrnHeader();
        }

        header.setPo(new TxnPoHeader(dto.getPoid()));
        header.setReceivedDate(dto.getReceivedDate() != null ? dto.getReceivedDate() : LocalDate.now());
        header.setReceivedBy(user);
        header.setStatus(dto.getStatus());
        header.setLastAddEditBy(dto.getLastAddEditBy());
        header.setLastEditDateTime(LocalDateTime.now());

        TxngrnHeader savedHeader = grnHeaderRepo.save(header);

        List<TxngrnDetails> details = dto.getDetails().stream().map(detailDto -> {
            TxngrnDetails detail = new TxngrnDetails();
            detail.setGrnHeader(savedHeader);
            detail.setItem(new Item(detailDto.getItemid()));
            detail.setOrderedQty(detailDto.getOrderedQty() != null ? detailDto.getOrderedQty() : 0);
            detail.setReceivedQty(detailDto.getReceivedQty() != null ? detailDto.getReceivedQty() : 0);
            detail.setAcceptedQty(detailDto.getAcceptedQty() != null ? detailDto.getAcceptedQty() : 0);
            detail.setRejectedQty(detailDto.getRejectedQty() != null ? detailDto.getRejectedQty() : 0);
            detail.setBatchNo(detailDto.getBatchNo());
            detail.setExpiryDate(detailDto.getExpiryDate());

            if (detailDto.getPoDetailId() != null) {
                detail.setPoDetail(new TxnPoDetails(detailDto.getPoDetailId()));
            }

            detail.setLastAddEditBy(dto.getLastAddEditBy());
            detail.setLastEditDateTime(LocalDateTime.now());
            return detail;
        }).collect(Collectors.toList());

        grnDetailRepo.saveAll(details);

        return getGrnById(savedHeader.getGrnid());
    }

    @Transactional
    public TxngrnHeaderDTO updateGrn(Integer grnId, TxngrnHeaderDTO dto) {
        TxngrnHeader header = grnHeaderRepo.findByGrnid(grnId)
                .orElseThrow(() -> new RuntimeException("GRN not found with ID: " + grnId));

        if (dto.getReceivedBy() == null) {
            throw new IllegalArgumentException("ReceivedBy (User) is mandatory");
        }

        OtherUser user = otherUserRepository.findById(dto.getReceivedBy())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getReceivedBy()));

        header.setPo(new TxnPoHeader(dto.getPoid()));
        header.setReceivedDate(dto.getReceivedDate() != null ? dto.getReceivedDate() : LocalDate.now());
        header.setReceivedBy(user);
        header.setStatus(dto.getStatus());
        header.setLastAddEditBy(dto.getLastAddEditBy());
        header.setLastEditDateTime(LocalDateTime.now());

        TxngrnHeader savedHeader = grnHeaderRepo.save(header);

        grnDetailRepo.deleteByGrnHeader_Grnid(grnId);

        List<TxngrnDetails> details = dto.getDetails().stream().map(detailDto -> {
            TxngrnDetails detail = new TxngrnDetails();
            detail.setGrnHeader(savedHeader);
            detail.setItem(new Item(detailDto.getItemid()));
            detail.setOrderedQty(detailDto.getOrderedQty() != null ? detailDto.getOrderedQty() : 0);
            detail.setReceivedQty(detailDto.getReceivedQty() != null ? detailDto.getReceivedQty() : 0);
            detail.setAcceptedQty(detailDto.getAcceptedQty() != null ? detailDto.getAcceptedQty() : 0);
            detail.setRejectedQty(detailDto.getRejectedQty() != null ? detailDto.getRejectedQty() : 0);
            detail.setBatchNo(detailDto.getBatchNo());
            detail.setExpiryDate(detailDto.getExpiryDate());

            if (detailDto.getPoDetailId() != null) {
                detail.setPoDetail(new TxnPoDetails(detailDto.getPoDetailId()));
            }

            detail.setLastAddEditBy(dto.getLastAddEditBy());
            detail.setLastEditDateTime(LocalDateTime.now());
            return detail;
        }).collect(Collectors.toList());

        grnDetailRepo.saveAll(details);

        return getGrnById(savedHeader.getGrnid());
    }

    public TxngrnHeaderDTO getGrnById(Integer grnid) {
        TxngrnHeader header = grnHeaderRepo.findByGrnid(grnid)
                .orElseThrow(() -> new RuntimeException("GRN not found with ID " + grnid));

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
            d.setItemid(detail.getItem().getItemid());
            d.setOrderedQty(detail.getOrderedQty());
            d.setReceivedQty(detail.getReceivedQty());
            d.setAcceptedQty(detail.getAcceptedQty());
            d.setRejectedQty(detail.getRejectedQty());
            d.setBatchNo(detail.getBatchNo());
            d.setExpiryDate(detail.getExpiryDate());
            d.setPoDetailId(detail.getPoDetail() != null ? detail.getPoDetail().getPodetailid() : null);
            d.setLastAddEditBy(detail.getLastAddEditBy());
            d.setLastEditDateTime(detail.getLastEditDateTime());
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
        grnDetailRepo.deleteByGrnHeader_Grnid(grnid);
        grnHeaderRepo.deleteById(grnid);
    }
}
