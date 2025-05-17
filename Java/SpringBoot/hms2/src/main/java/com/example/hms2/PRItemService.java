package com.example.hms2;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PRItemService {

    private final TxnPurchaseRequestRepo repository;

    public PRItemService(TxnPurchaseRequestRepo repository) {
        this.repository = repository;
    }

    public List<PRItemDTO> getItemsForSupplier(Integer supplierid) {
        return repository.findEligiblePRItemsBySupplier(supplierid);
    }
}
