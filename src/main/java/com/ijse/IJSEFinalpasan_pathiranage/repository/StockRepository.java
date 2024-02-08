package com.ijse.IJSEFinalpasan_pathiranage.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.IJSEFinalpasan_pathiranage.entity.Item;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Long>{
    // Optional<Stock> findByItem(Item item);
}
