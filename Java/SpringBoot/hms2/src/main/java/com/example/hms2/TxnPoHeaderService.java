package com.example.hms2;

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
public class TxnPoHeaderService {

    @Autowired
    private TxnPoHeaderRepository repository;

    @Autowired
    private TxnPoDetailsRepository txnPoDetailsRepository;

    public TxnPoHeaderService(TxnPoHeaderRepository repository) {
        this.repository = repository;
        if (this.repository == null) {
            System.out.println("Repository is null!");
        } else {
            System.out.println("Repository successfully injected.");
        }
    }
    
    // For paginated list view (without details)
    public Page<PoHeaderListDTO> getAllHeaders(String status, Integer poid, int page, int size, String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return repository.findAllHeadersByFilter(status, poid, pageable);
    }

    // For fetching PO header by ID with details
    @Transactional
    public PoHeaderDTO getPoHeaderById(Integer id) {
        // Fetch the PO header with details
        TxnPoHeader header = repository.findByIdWithDetails(id);
        if (header == null) throw new RuntimeException("PO Header not found with id: " + id);

        PoHeaderDTO dto = new PoHeaderDTO();
        dto.setPoid(header.getPoid());

        // Handling the supplier object correctly
        if (header.getSupplier() != null) {
            dto.setSupplierid(header.getSupplier().getSupplierid());
            dto.setSuppliername(header.getSupplier().getSuppliername());
        }

        // Set other fields
        dto.setPodate(header.getPodate());
        dto.setDeliverydate(header.getDeliverydate());
        dto.setStatus(header.getStatus());
        dto.setTotalAmount(header.getTotalAmount());
        dto.setLastaddeditby(header.getLastaddeditby());
        dto.setLasteditdatetime(header.getLasteditdatetime());

        // Mapping PO details
        List<PoDetailDTO> detailDTOs = header.getDetails().stream().map(detail -> {
            PoDetailDTO d = new PoDetailDTO();

            // Handle null item reference safely
            if (detail.getItem() != null) {
                d.setItemid(detail.getItem().getItemid());    // Call getId() method on item
                d.setItemname(detail.getItem().getItemname());  // Call getName() method on item
            }

            // Set other PO detail fields
            d.setQty(detail.getQty());         // Call setQty() for qty
            d.setRate(detail.getRate()); 	
            return d;
        }).toList();

        // Set the details to the DTO
        dto.setDetails(detailDTOs);
        return dto;
    }
    
    @Transactional
    public List<TxnPoDetailsDTO> getPoDetailsByPoid(Integer poid) {
        List<TxnPoDetails> txnPoDetailsList = txnPoDetailsRepository.findByPoHeader_Poid(poid);

        List<TxnPoDetailsDTO> txnPoDetailsDTOList = txnPoDetailsList.stream()
            .map(txnPoDetails -> new TxnPoDetailsDTO(
                txnPoDetails.getPodetailid(),
                txnPoDetails.getPoHeader().getPoid(), // Mapping poid from poHeader
                txnPoDetails.getItem().getItemid(),   // Mapping itemid from item
                txnPoDetails.getQty(),
                txnPoDetails.getRate()
            ))
            .collect(Collectors.toList());

        return txnPoDetailsDTOList;
    }

    @Transactional
    public PoHeaderDTO createPo(PoHeaderDTO dto) {
        TxnPoHeader header = new TxnPoHeader();

        // Set header fields
        header.setPodate(dto.getPodate());
        header.setDeliverydate(dto.getDeliverydate());
        header.setStatus(dto.getStatus());
        header.setTotalAmount(dto.getTotalAmount());
        header.setLastaddeditby(dto.getLastaddeditby());
        header.setLasteditdatetime(dto.getLasteditdatetime());

        // Set supplier
        Supplier supplier = new Supplier();
        supplier.setSupplierid(dto.getSupplierid());
        header.setSupplier(supplier);

        // Set details
        List<TxnPoDetails> details = dto.getDetails().stream().map(d -> {
            TxnPoDetails detail = new TxnPoDetails();
            detail.setQty(d.getQty());
            detail.setRate(d.getRate());	            
            POItem item = new POItem();
            item.setItemid(d.getItemid());
            detail.setItem(item);
            detail.setPoHeader(header); // set back-reference
            detail.setLastaddeditby(d.getLastaddeditby());
            detail.setLasteditdatetime(d.getLasteditdatetime());
            return detail;
        }).toList();

        header.setDetails(details);

        TxnPoHeader saved = repository.save(header);

        return getPoHeaderById(saved.getPoid());
    }

    @Transactional
    public PoHeaderDTO updatePo(Integer id, PoHeaderDTO dto) {
        TxnPoHeader existing = repository.findByIdWithDetails(id);
        if (existing == null) {
            throw new RuntimeException("PO Header not found with id: " + id);
        }

        // Update fields
        existing.setPodate(dto.getPodate());
        existing.setDeliverydate(dto.getDeliverydate());
        existing.setStatus(dto.getStatus());
        existing.setTotalAmount(dto.getTotalAmount());
        existing.setLastaddeditby(dto.getLastaddeditby());
        existing.setLasteditdatetime(dto.getLasteditdatetime());

        // Update supplier
        Supplier supplier = new Supplier();
        supplier.setSupplierid(dto.getSupplierid());
        existing.setSupplier(supplier);

        // Clear existing details and set new ones
        existing.getDetails().clear();
        List<TxnPoDetails> newDetails = dto.getDetails().stream().map(d -> {
            TxnPoDetails detail = new TxnPoDetails();
            detail.setQty(d.getQty());
            detail.setRate(d.getRate());
            POItem item = new POItem();
            item.setItemid(d.getItemid());
            detail.setItem(item);
            detail.setPoHeader(existing); // set back-reference
            detail.setLastaddeditby(d.getLastaddeditby());
            detail.setLasteditdatetime(d.getLasteditdatetime());
            return detail;
        }).toList();

        existing.getDetails().addAll(newDetails);

        repository.save(existing);
        return getPoHeaderById(existing.getPoid());
    }

    @Transactional
    public void deletePo(Integer id) {
        repository.deleteById(id);
    }
    
}
