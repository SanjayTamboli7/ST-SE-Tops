
//PoDropdownProjection.java
package com.example.hms2;

public interface PoDropdownProjection {
 Integer getPoid();
 String getPodate();         // or use LocalDate if mapped as DATE in DB
 String getSuppliername();
}
