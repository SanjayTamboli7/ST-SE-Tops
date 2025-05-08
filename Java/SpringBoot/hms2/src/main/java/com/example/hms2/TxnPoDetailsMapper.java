package com.example.hms2;

import java.util.List;
import java.util.stream.Collectors;
public class TxnPoDetailsMapper {

    public static TxnPoDetailsDTO toDTO(TxnPoDetails e) {
        TxnPoDetailsDTO d = new TxnPoDetailsDTO();
        d.setPodetailid(e.getPodetailid());
        d.setPoid(e.getPoid());
        d.setItemid(e.getItemid());
        d.setQty(e.getQty());
        d.setRate(e.getRate());
        d.setAmount(e.getAmount());
        d.setPrid(e.getPrid());
        d.setLastaddeditby(e.getLastaddeditby());
        d.setLasteditdatetime(e.getLasteditdatetime());
        return d;
    }

    public static TxnPoDetails toEntity(TxnPoDetailsDTO dto) {
        TxnPoDetails entity = new TxnPoDetails();
        entity.setPodetailid(dto.getPodetailid());
        entity.setPoid(dto.getPoid());
        entity.setItemid(dto.getItemid());
        entity.setQty(dto.getQty());
        entity.setRate(dto.getRate());
        entity.setAmount(dto.getAmount());
        entity.setPrid(dto.getPrid());
        entity.setLastaddeditby(dto.getLastaddeditby());
        entity.setLasteditdatetime(dto.getLasteditdatetime());
        return entity;
    }

    public static List<TxnPoDetailsDTO> toDTOList(List<TxnPoDetails> list) {
        return list.stream().map(TxnPoDetailsMapper::toDTO).collect(Collectors.toList());
    }
}
