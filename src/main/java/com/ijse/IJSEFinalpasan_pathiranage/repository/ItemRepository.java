package com.ijse.IJSEFinalpasan_pathiranage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ijse.IJSEFinalpasan_pathiranage.entity.Item;
import com.ijse.IJSEFinalpasan_pathiranage.entity.ItemCategory;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.category = :category")
    List<Item> findItemsByItemCategory(@Param("category") ItemCategory itemCategory);

    @Transactional
    @Modifying
    @Query("DELETE FROM Item i WHERE i.id = :id")
    void deleteItemById(@Param("id") Long id);

    void deleteById(Long id);

}
