package com.ijse.IJSEFinalpasan_pathiranage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.IJSEFinalpasan_pathiranage.entity.ItemCategory;



@Service
public interface ItemCategoryService {
    
    List<ItemCategory> getAllCategories();
    ItemCategory findItemCategoryById(Long id);
    ItemCategory creaItemCategory(ItemCategory ItemCategory);
    ItemCategory updateItemCategory(Long id , ItemCategory ItemCategory);

    
}
