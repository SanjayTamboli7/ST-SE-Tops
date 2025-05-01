package com.example.hms2;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TxnPurchaseRequestService {

    @Autowired
    private TxnPurchaseRequestRepository repo;

    public Page<TxnPurchaseRequest> getAll(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("prid").descending());

        Specification<TxnPurchaseRequest> spec = (root, query, cb) -> {
            if (keyword != null && !keyword.trim().isEmpty()) {
                String likeKeyword = "%" + keyword.toLowerCase() + "%";
                return cb.or(
                    cb.like(cb.lower(root.get("status")), likeKeyword),
                    cb.like(cb.lower(root.get("qty").as(String.class)), likeKeyword)
                );
            }
            return null;
        };

        return repo.findAll(spec, pageable);
    }

    public TxnPurchaseRequest save(TxnPurchaseRequest request) {
        request.setLasteditdatetime(LocalDateTime.now());
        return repo.save(request);
    }

    public Optional<TxnPurchaseRequest> getById(Integer id) {
        return repo.findById(id);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
