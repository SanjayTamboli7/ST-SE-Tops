package com.example.hms2;

/**
 * Interface-based projection for eligible PR items.
 * Spring Data JPA will use this to bind native query results.
 */
public interface PRItemDTO {
    Integer getItemid();
    Integer getQty();
    Integer getPrid();
}
