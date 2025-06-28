package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TxnIssueRequestService {

    @Autowired
    private TxnIssueRequestRepository repository;

    // 🔍 Fetch all with search and pagination
    public Page<TxnIssueRequestDTO> getAll(Pageable pageable, String search) {
        Specification<TxnIssueRequest> spec = (root, query, cb) -> {
            if (search != null && !search.isEmpty()) {
                return cb.or(
                        cb.like(cb.lower(root.get("remark")), "%" + search.toLowerCase() + "%"),
                        cb.like(cb.lower(root.get("status")), "%" + search.toLowerCase() + "%")
                );
            }
            return null;
        };

        return repository.findAll(spec, pageable)
                .map(this::toDTO);
    }

    // 🔍 Get by ID
    public TxnIssueRequestDTO getById(Integer id) {
        Optional<TxnIssueRequest> entity = repository.findById(id);
        return entity.map(this::toDTO).orElseThrow(() -> new RuntimeException("Item issue not found"));
    }

    // ➕ Save (Insert or Update)
    public TxnIssueRequestDTO createOrUpdate(TxnIssueRequestDTO dto) {
        TxnIssueRequest entity = toEntity(dto);

        // Set audit fields
        entity.setLasteditdatetime(LocalDateTime.now());

        // Save to DB
        TxnIssueRequest saved = repository.save(entity);
        return toDTO(saved);
    }

    // ❌ Delete
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    // 🔁 Mapper: Entity to DTO
    private TxnIssueRequestDTO toDTO(TxnIssueRequest entity) {
        TxnIssueRequestDTO dto = new TxnIssueRequestDTO();
        dto.setIssueid(entity.getIssueid());
        dto.setRequestedby(entity.getRequestedby());
        dto.setDepartmentid(entity.getDepartmentid());
        dto.setItemid(entity.getItemid());
        dto.setQty(entity.getQty());
        dto.setRequestdate(entity.getRequestdate());
        dto.setRemark(entity.getRemark());
        dto.setStatus(entity.getStatus());
        dto.setLastaddeditby(entity.getLastaddeditby());
        dto.setLasteditdatetime(entity.getLasteditdatetime());
        return dto;
    }

    // 🔁 Mapper: DTO to Entity
    private TxnIssueRequest toEntity(TxnIssueRequestDTO dto) {
        TxnIssueRequest entity = new TxnIssueRequest();
        entity.setIssueid(dto.getIssueid());
        entity.setRequestedby(dto.getRequestedby());
        entity.setDepartmentid(dto.getDepartmentid());
        entity.setItemid(dto.getItemid());
        entity.setQty(dto.getQty());
        entity.setRequestdate(dto.getRequestdate());
        entity.setRemark(dto.getRemark());
        entity.setStatus(dto.getStatus());
        entity.setLastaddeditby(dto.getLastaddeditby());
        entity.setLasteditdatetime(dto.getLasteditdatetime());
        return entity;
    }
    
}
