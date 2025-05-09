package com.example.RestApi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Menu1Repository extends JpaRepository<MenuItem, Long> {
    // Find all menu items ordered by position
    List<MenuItem> findAllByOrderByPositionAsc();
    
    // Find all active menu items
    List<MenuItem> findByIsActiveTrue();
    
    // Find all root menu items (items without parent)
    List<MenuItem> findByParentIdIsNullOrderByPositionAsc();
    
    // Find children of a specific menu item
    List<MenuItem> findByParentIdOrderByPositionAsc(Long parentId);
}
