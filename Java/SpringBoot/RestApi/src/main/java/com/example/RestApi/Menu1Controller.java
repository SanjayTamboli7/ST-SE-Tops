package com.example.RestApi;

import com.example.RestApi.MenuItem;
import com.example.RestApi.Menu1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
//@CrossOrigin(origins = "*") // For development; restrict in production
public class Menu1Controller {

    @Autowired
    private Menu1Repository menu1Repository;

    @GetMapping("/menus1")
    public ResponseEntity<List<com.example.RestApi.MenuItem>> getAllMenus() {
        try {
            // Fetch all menu items from the database - use fully qualified name
            List<com.example.RestApi.MenuItem> flatMenuItems = menu1Repository.findAllByOrderByPositionAsc();
            
            // Convert flat menu items to hierarchical structure
            List<com.example.RestApi.MenuItem> hierarchicalMenu = buildHierarchicalMenu(flatMenuItems);
            
            return ResponseEntity.ok(hierarchicalMenu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * Converts a flat list of menu items into a hierarchical structure
     */
    private List<com.example.RestApi.MenuItem> buildHierarchicalMenu(
            List<com.example.RestApi.MenuItem> flatItems) {
            
        List<com.example.RestApi.MenuItem> rootItems = new ArrayList<>();
        Map<Long, com.example.RestApi.MenuItem> menuMap = new HashMap<>();
        
        // First pass: Create a map of all items by ID
        for (com.example.RestApi.MenuItem item : flatItems) {
            menuMap.put(item.getId(), item);
        }
        
        // Second pass: Build the hierarchy
        for (com.example.RestApi.MenuItem item : flatItems) {
            if (item.getParentId() == null) {
                // This is a root item
                rootItems.add(item);
            } else {
                // This is a child item
                com.example.RestApi.MenuItem parent = menuMap.get(item.getParentId());
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
