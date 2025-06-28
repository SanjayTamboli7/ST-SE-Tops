package com.example.hms2;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "txnstockadjustment")
public class StockAdjustment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adjustmentid")
    private Integer adjustmentId;

    @Column(name = "itemid", nullable = false)
    private Integer itemId;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @Column(name = "reason", length = 100)
    private String reason;

    @Column(name = "adjustedby")
    private Integer adjustedBy;

    @Column(name = "adjusteddate")
    private LocalDateTime adjustedDate;

    @Column(name = "remark", length = 100)
    private String remark;

    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "lastaddeditby", nullable = false)
    private Integer lastAddEditBy;

    @Column(name = "lasteditdatetime", nullable = false)
    private LocalDateTime lastEditDateTime;

    // Getters and Setters
    public Integer getAdjustmentId() { return adjustmentId; }
    public void setAdjustmentId(Integer adjustmentId) { this.adjustmentId = adjustmentId; }
    public Integer getItemId() { return itemId; }
    public void setItemId(Integer itemId) { this.itemId = itemId; }
    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public Integer getAdjustedBy() { return adjustedBy; }
    public void setAdjustedBy(Integer adjustedBy) { this.adjustedBy = adjustedBy; }
    public LocalDateTime getAdjustedDate() { return adjustedDate; }
    public void setAdjustedDate(LocalDateTime adjustedDate) { this.adjustedDate = adjustedDate; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getLastAddEditBy() { return lastAddEditBy; }
    public void setLastAddEditBy(Integer lastAddEditBy) { this.lastAddEditBy = lastAddEditBy; }
    public LocalDateTime getLastEditDateTime() { return lastEditDateTime; }
    public void setLastEditDateTime(LocalDateTime lastEditDateTime) { this.lastEditDateTime = lastEditDateTime; }
}