package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "txnpoheader")
public class TxnPoHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer poid;

    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier supplier; // ✅ Renamed to camelCase for consistency
    private LocalDate podate;
    private LocalDate deliverydate;
    private String status;
    @Column(name = "total_amount")
    private Float totalAmount; // ✅ Renamed to camelCase for consistency
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;

    @OneToMany(mappedBy = "poHeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TxnPoDetails> details;

    public Integer getPoid() {
        return poid;
    }
    
    public void setPoid(Integer poid) {
        this.poid = poid;
    }

    public LocalDate getPodate() {
        return podate;
    }

    public void setPodate(LocalDate podate) {
        this.podate = podate;
    }

    public LocalDate getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(LocalDate deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getLastaddeditby() {
        return lastaddeditby;
    }

    public void setLastaddeditby(Integer lastaddeditby) {
        this.lastaddeditby = lastaddeditby;
    }

    public LocalDateTime getLasteditdatetime() {
        return lasteditdatetime;
    }

    public void setLasteditdatetime(LocalDateTime lasteditdatetime) {
        this.lasteditdatetime = lasteditdatetime;
    }

    public List<TxnPoDetails> getDetails() {
        return details;
    }

    public void setDetails(List<TxnPoDetails> details) {
        this.details = details;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public TxnPoHeader(Integer poid) {
        this.poid = poid;
    }

	public TxnPoHeader() {
		// TODO Auto-generated constructor stub
	}
    
}
