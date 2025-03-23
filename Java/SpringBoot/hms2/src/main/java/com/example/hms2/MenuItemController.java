package com.example.hms2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/menuitem")
    public ResponseEntity<List<com.example.hms2.MenuItem>> getAllMenus() {
        try {
            // Fetch all menu items from the database - use fully qualified name
            List<com.example.hms2.MenuItem> flatMenuItems = menuItemRepository.findAllByOrderByPositionAsc();
            
            // Convert flat menu items to hierarchical structure
            List<com.example.hms2.MenuItem> hierarchicalMenu = buildHierarchicalMenu(flatMenuItems);
            
            return ResponseEntity.ok(hierarchicalMenu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * Converts a flat list of menu items into a hierarchical structure
     */
    private List<com.example.hms2.MenuItem> buildHierarchicalMenu(
            List<com.example.hms2.MenuItem> flatItems) {
            
        List<com.example.hms2.MenuItem> rootItems = new ArrayList<>();
        Map<Long, com.example.hms2.MenuItem> menuMap = new HashMap<>();
        
        // First pass: Create a map of all items by ID
        for (com.example.hms2.MenuItem item : flatItems) {
            menuMap.put(item.getId(), item);
        }
        
        // Second pass: Build the hierarchy
        for (com.example.hms2.MenuItem item : flatItems) {
            if (item.getParentId() == null) {
                // This is a root item
                rootItems.add(item);
            } else {
                // This is a child item
                com.example.hms2.MenuItem parent = menuMap.get(item.getParentId());
                if (parent != null) {
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(item);
                }
            }
        }
        
        return rootItems;
    }
	
}
