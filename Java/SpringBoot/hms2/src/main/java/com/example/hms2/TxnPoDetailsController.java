package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/txnpodetails")
//public class TxnPoDetailsController {
//
//    @Autowired
//    private TxnPoDetailsRepository detailsRepository;
//
//    // If using DTOs
//    @GetMapping("/{poid}")
//    public ResponseEntity<List<TxnPoDetailsDTO>> getDetailsByPoid(@PathVariable Integer poid) {
//        List<TxnPoDetails> details = detailsRepository.findByPoid(poid);
//        List<TxnPoDetailsDTO> dtos = TxnPoDetailsMapper.toDTOList(details);
//        return ResponseEntity.ok(dtos);
//    }
//
//    // If not using DTOs, return entities directly (less safe)
//    /*
//    @GetMapping("/{poid}")
//    public ResponseEntity<List<TxnPoDetails>> getDetailsByPoid(@PathVariable Integer poid) {
//        return ResponseEntity.ok(detailsRepository.findByPoid(poid));
//    }
//    */
//}

public class TxnPoDetailsController {

    @Autowired private TxnPoDetailsRepository detailRepo;
    @Autowired private TxnPoHeaderRepository headerRepo;

    @GetMapping("/{poid}")
    public List<TxnPoDetailsDTO> getByPoid(@PathVariable Integer poid) {
        List<TxnPoDetails> details = detailRepo.findByPoid(poid);
        return TxnPoDetailsMapper.toDTOList(details);
    }

    @PostMapping
    public TxnPoDetailsDTO addDetail(@RequestBody TxnPoDetailsDTO dto) {
        TxnPoDetails entity = TxnPoDetailsMapper.toEntity(dto);
        entity.setLasteditdatetime(LocalDateTime.now());
        TxnPoDetails saved = detailRepo.save(entity);
        updateTotalAmount(dto.getPoid());
        return TxnPoDetailsMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public TxnPoDetailsDTO updateDetail(@PathVariable Integer id, @RequestBody TxnPoDetailsDTO dto) {
        TxnPoDetails entity = detailRepo.findById(id).orElseThrow();
        entity.setItemid(dto.getItemid());
        entity.setQty(dto.getQty());
        entity.setRate(dto.getRate());
        entity.setAmount(dto.getAmount());
        entity.setLastaddeditby(dto.getLastaddeditby());
        entity.setLasteditdatetime(LocalDateTime.now());
        TxnPoDetails updated = detailRepo.save(entity);
        updateTotalAmount(dto.getPoid());
        return TxnPoDetailsMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetail(@PathVariable Integer id) {
        TxnPoDetails detail = detailRepo.findById(id).orElseThrow();
        Integer poid = detail.getPoid();
        detailRepo.deleteById(id);
        updateTotalAmount(poid);
        return ResponseEntity.ok().build();
    }

    private void updateTotalAmount(Integer poid) {
        BigDecimal total = detailRepo.findByPoid(poid).stream()
                .map(TxnPoDetails::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        headerRepo.updateTotalAmount(poid, total);
    }
}
