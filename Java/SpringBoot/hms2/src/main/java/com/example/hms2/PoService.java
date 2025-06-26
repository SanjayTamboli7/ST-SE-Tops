package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoService {

    @Autowired
    private TxngrnPoDetailsRepository txngrnPoDetailsRepository;

    public List<PoItemDTO> getItemsByPoId(Integer poid) {
        List<Object[]> rawItems = txngrnPoDetailsRepository.findRawPoItemsByPoid(poid);
        return rawItems.stream().map(row -> new PoItemDTO(
            (Integer) row[0],
            (Integer) row[1],
            row[2] != null ? ((Number) row[2]).doubleValue() : 0.0
        )).collect(Collectors.toList());
    }
}
