package com.ijse.IJSEFinalpasan_pathiranage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.IJSEFinalpasan_pathiranage.entity.ItemCategory;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long>{
    
}