package com.example.hms2;
//package com.example.stockadjustment.service;
//
//import com.example.stockadjustment.dto.StockAdjustmentDTO;
//import com.example.stockadjustment.model.StockAdjustment;
//import com.example.stockadjustment.repository.StockAdjustmentRepository;
//import com.example.stockadjustment.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class StockAdjustmentService {
    @Autowired
    private StockAdjustmentRepository repository;

    public Page<StockAdjustmentDTO> getAllStockAdjustments(String search, Pageable pageable) {
        Page<StockAdjustment> page = repository.findBySearch(search, pageable);
        return page.map(this::convertToDTO);
    }

    public StockAdjustmentDTO getStockAdjustmentById(Long id) {
        StockAdjustment adjustment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock Adjustment not found with id: " + id));
        return convertToDTO(adjustment);
    }

    public StockAdjustmentDTO createStockAdjustment(StockAdjustmentDTO dto) {
        StockAdjustment adjustment = convertToEntity(dto);
        adjustment = repository.save(adjustment);
        return convertToDTO(adjustment);
    }

    public StockAdjustmentDTO updateStockAdjustment(Long id, StockAdjustmentDTO dto) {
        StockAdjustment adjustment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock Adjustment not found with id: " + id));
        updateEntityFromDTO(adjustment, dto);
        adjustment = repository.save(adjustment);
        return convertToDTO(adjustment);
    }

    public void deleteStockAdjustment(Long id) {
        StockAdjustment adjustment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock Adjustment not found with id: " + id));
        if (!"Pending".equals(adjustment.getStatus())) {
            throw new IllegalStateException("Cannot delete Stock Adjustment with status: " + adjustment.getStatus());
        }
        repository.deleteById(id);
    }

    private StockAdjustmentDTO convertToDTO(StockAdjustment adjustment) {
        StockAdjustmentDTO dto = new StockAdjustmentDTO();
        dto.setAdjustmentId(adjustment.getAdjustmentId());
        dto.setItemId(adjustment.getItemId());
        dto.setQty(adjustment.getQty());
        dto.setReason(adjustment.getReason());
        dto.setAdjustedBy(adjustment.getAdjustedBy());
        dto.setAdjustedDate(adjustment.getAdjustedDate() != null ?
                adjustment.getAdjustedDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null);
        dto.setRemark(adjustment.getRemark());
        dto.setStatus(adjustment.getStatus());
        dto.setLastAddEditBy(adjustment.getLastAddEditBy());
        dto.setLastEditDateTime(adjustment.getLastEditDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return dto;
    }

    private StockAdjustment convertToEntity(StockAdjustmentDTO dto) {
        StockAdjustment adjustment = new StockAdjustment();
        adjustment.setItemId(dto.getItemId());
        adjustment.setQty(dto.getQty());
        adjustment.setReason(dto.getReason());
        adjustment.setAdjustedBy(dto.getAdjustedBy());
        try {
            adjustment.setAdjustedDate(dto.getAdjustedDate() != null ?
                    LocalDateTime.parse(dto.getAdjustedDate(), DateTimeFormatter.ISO_DATE_TIME) : null);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid adjustedDate format: " + dto.getAdjustedDate(), e);
        }
        adjustment.setRemark(dto.getRemark());
        adjustment.setStatus(dto.getStatus());
        adjustment.setLastAddEditBy(dto.getLastAddEditBy());
        try {
            adjustment.setLastEditDateTime(dto.getLastEditDateTime() != null ?
                    LocalDateTime.parse(dto.getLastEditDateTime(), DateTimeFormatter.ISO_DATE_TIME) : null);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid lastEditDateTime format: " + dto.getLastEditDateTime(), e);
        }
        return adjustment;
    }

    private void updateEntityFromDTO(StockAdjustment adjustment, StockAdjustmentDTO dto) {
        adjustment.setItemId(dto.getItemId());
        adjustment.setQty(dto.getQty());
        adjustment.setReason(dto.getReason());
        adjustment.setAdjustedBy(dto.getAdjustedBy());
        try {
            adjustment.setAdjustedDate(dto.getAdjustedDate() != null ?
                    LocalDateTime.parse(dto.getAdjustedDate(), DateTimeFormatter.ISO_DATE_TIME) : null);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid adjustedDate format: " + dto.getAdjustedDate(), e);
        }
        adjustment.setRemark(dto.getRemark());
        adjustment.setStatus(dto.getStatus());
        adjustment.setLastAddEditBy(dto.getLastAddEditBy());
        try {
            adjustment.setLastEditDateTime(dto.getLastEditDateTime() != null ?
                    LocalDateTime.parse(dto.getLastEditDateTime(), DateTimeFormatter.ISO_DATE_TIME) : null);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid lastEditDateTime format: " + dto.getLastEditDateTime(), e);
        }
    }
}
