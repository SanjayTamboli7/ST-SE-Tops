package com.example.hms2;

//package com.example.hms2;

import org.springframework.data.domain.Page;

public interface TxnPoHeaderService {
    Page<TxnPoHeader> getPagedHeaders(String search, int page, int size, String sortBy, boolean asc);

    TxnPoHeaderDTO savePoHeaderWithDetails(TxnPoHeaderDTO dto);

    TxnPoHeaderDTO getPoHeaderWithDetails(Integer poid);

    void deletePo(Integer poid);
}
