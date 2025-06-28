package com.example.hms2;

import org.springframework.beans.BeanUtils;

public class TxnIssueRequestMapper {

    public static TxnIssueRequest toEntity(TxnIssueRequestDTO dto) {
        TxnIssueRequest entity = new TxnIssueRequest();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public static TxnIssueRequestDTO toDTO(TxnIssueRequest entity) {
        TxnIssueRequestDTO dto = new TxnIssueRequestDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
