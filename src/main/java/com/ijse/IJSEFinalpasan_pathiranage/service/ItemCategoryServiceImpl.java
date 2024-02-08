package com.ijse.IJSEFinalpasan_pathiranage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.IJSEFinalpasan_pathiranage.entity.ItemCategory;
import com.ijse.IJSEFinalpasan_pathiranage.repository.ItemCategoryRepository;


@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    
    @Autowired
    private ItemCategoryRepository ItemCategoryRepository; 

    @Override
    public List<ItemCategory> getAllCategories(){
        return ItemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory findItemCategoryById(Long id){
        return ItemCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ItemCategory creaItemCategory(ItemCategory ItemCategory){
        return ItemCategoryRepository.save(ItemCategory);
    }

    @Override
    public ItemCategory updateItemCategory(Long id, ItemCategory ItemCategory){

        ItemCategory existingItemCategory =  ItemCategoryRepository.findById(id).orElse(null);

        if(existingItemCategory != null){
            existingItemCategory.setName(ItemCategory.getName());
            return ItemCategoryRepository.save(existingItemCategory);
        }else{
            return null;
        }
    }

    
}
