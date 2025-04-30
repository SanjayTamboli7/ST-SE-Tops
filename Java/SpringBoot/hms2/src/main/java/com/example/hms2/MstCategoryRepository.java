package com.example.hms2;

//package com.example.demo.repository;
//
//import com.example.demo.model.MstCategory;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MstCategoryRepository extends JpaRepository<MstCategory, Integer> {
	@Query("SELECT c FROM MstCategory c WHERE " +
		       "LOWER(c.categoryname) LIKE LOWER(CONCAT('%', :search, '%')) " +
		       "OR LOWER(c.description) LIKE LOWER(CONCAT('%', :search, '%'))")
		Page<MstCategory> searchCategories(@Param("search") String search, Pageable pageable);

}
