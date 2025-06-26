package com.example.hms2;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public Page<Item> getAllItems(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "") String search
    ) {
        return itemService.getItems(page, size, search);
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item item) {
        item.setItemid(id);
        return itemService.saveItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemService.deleteItem(id);
    }
    
}
