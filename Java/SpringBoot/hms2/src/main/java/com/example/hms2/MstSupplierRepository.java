package com.example.hms2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MstSupplierRepository extends JpaRepository<MstSupplier, Integer>, JpaSpecificationExecutor<MstSupplier> {
	
}
