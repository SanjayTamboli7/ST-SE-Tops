package com.example.hms2;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StockAdjustmentDTO {
    private Integer adjustmentId;
    
    @NotNull(message = "Item ID is mandatory")
    private Integer itemId;
    
    @NotNull(message = "Quantity is mandatory")
    @Min(value = 1, message = "Quantity must be positive")
    private Integer qty;
    
    @Size(max = 100, message = "Reason cannot exceed 100 characters")
    private String reason;
    
    private Integer adjustedBy;
    
    private String adjustedDate; // ISO format (yyyy-MM-dd'T'HH:mm:ss)
    
    @Size(max = 100, message = "Remark cannot exceed 100 characters")
    private String remark;
    
    @NotBlank(message = "Status is mandatory")
    @Size(max = 10, message = "Status cannot exceed 10 characters")
    private String status;
    
    @NotNull(message = "Last added/edited by is mandatory")
    private Integer lastAddEditBy;
    
    @NotNull(message = "Last edit datetime is mandatory")
    private String lastEditDateTime; // ISO format

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
    public String getAdjustedDate() { return adjustedDate; }
    public void setAdjustedDate(String adjustedDate) { this.adjustedDate = adjustedDate; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getLastAddEditBy() { return lastAddEditBy; }
    public void setLastAddEditBy(Integer lastAddEditBy) { this.lastAddEditBy = lastAddEditBy; }
    public String getLastEditDateTime() { return lastEditDateTime; }
    public void setLastEditDateTime(String lastEditDateTime) { this.lastEditDateTime = lastEditDateTime; }
}