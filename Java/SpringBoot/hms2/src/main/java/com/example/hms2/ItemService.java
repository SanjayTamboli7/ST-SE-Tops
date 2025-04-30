package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Page<Item> getItems(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("itemname").ascending());
        if (search == null || search.isEmpty()) {
            return itemRepository.findAll(pageable);
        } else {
            return itemRepository.findByItemnameContainingIgnoreCaseOrItemcodeContainingIgnoreCase(search, search, pageable);
        }
    }

    public Item saveItem(Item item) {
        item.setLasteditdatetime(LocalDateTime.now());
        return itemRepository.save(item);
    }

    public Optional<Item> getItemById(Integer id) {
        return itemRepository.findById(id);
    }

    public void deleteItem(Integer id) {
        itemRepository.deleteById(id);
    }
    
    public Item updateItem(Integer id, Item updatedItem) {
        return itemRepository.findById(id).map(item -> {
            item.setItemname(updatedItem.getItemname());
            item.setItemcode(updatedItem.getItemcode());
            item.setCategoryid(updatedItem.getCategoryid());
            item.setUomid(updatedItem.getUomid());
            item.setReorderlevel(updatedItem.getReorderlevel());
            item.setMaxstock(updatedItem.getMaxstock());
            item.setLastaddeditby(updatedItem.getLastaddeditby());
            item.setLasteditdatetime(LocalDateTime.now());
            return itemRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item not found with id " + id));
    }

}
