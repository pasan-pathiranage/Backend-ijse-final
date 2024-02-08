package com.ijse.IJSEFinalpasan_pathiranage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.IJSEFinalpasan_pathiranage.dto.ItemDto;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Item;
import com.ijse.IJSEFinalpasan_pathiranage.service.ItemService;


@RestController
@CrossOrigin(origins = "*") 
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.status(200).body(items);
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@RequestBody ItemDto itemDto) {
        try {
            Item createdItem = itemService.createItem(itemDto);
            return ResponseEntity.status(201).body(createdItem);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to Create the Item");
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.status(200).body(item);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item updatedItem = itemService.updateItem(itemDto, id);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        if(item != null){
            itemService.deleteItem(id);
            return ResponseEntity.ok().body("DELETED SUCCESSFULLY");
        }else{{
            return ResponseEntity.status(404).body("Invalied Item");
        }}
        
    }

    @GetMapping("/categories/{id}/items")
    public ResponseEntity<List<Item>> getItemsByCategory(@PathVariable Long id) {
        List<Item> items = itemService.getItemsByItemCategory(id);
        return ResponseEntity.ok(items);
    }
}
