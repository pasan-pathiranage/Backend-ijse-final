package com.ijse.IJSEFinalpasan_pathiranage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.IJSEFinalpasan_pathiranage.entity.ItemCategory;
import com.ijse.IJSEFinalpasan_pathiranage.service.ItemCategoryService;




@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {
    
    @Autowired
    private ItemCategoryService itemCategoryService;
    
    @GetMapping("/categories")
    public List<ItemCategory> getAllCategories(){
        return itemCategoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public ItemCategory createItemCategory(@RequestBody ItemCategory itemCategory){
        return itemCategoryService.creaItemCategory(itemCategory);
    }

    @GetMapping("/categories/{id}")
    public ItemCategory getItemCategoryById(@PathVariable Long id){
        return itemCategoryService.findItemCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public ItemCategory updateItemCategory(@PathVariable Long id,@RequestBody ItemCategory ItemCategory){
        return itemCategoryService.updateItemCategory(id, ItemCategory);
    }


}
