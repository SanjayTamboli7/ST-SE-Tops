package com.example.hms2;

//package com.example.hms2;
//
//import com.example.hms2.entity.MstSupplierItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MstSupplierItemRepository extends JpaRepository<MstSupplierItem, MstSupplierItemKey>  {

    @Query("SELECT m FROM MstSupplierItem m " +
           "WHERE LOWER(m.supplier.suppliername) LIKE LOWER(CONCAT('%', :search, '%')) " +
           "OR LOWER(m.item.itemname) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<MstSupplierItem> search(@Param("search") String search, Pageable pageable);
}
