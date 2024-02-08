package com.ijse.IJSEFinalpasan_pathiranage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ijse.IJSEFinalpasan_pathiranage.dto.ItemDto;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Item;
import com.ijse.IJSEFinalpasan_pathiranage.entity.ItemCategory;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Stock;
import com.ijse.IJSEFinalpasan_pathiranage.repository.ItemCategoryRepository;
import com.ijse.IJSEFinalpasan_pathiranage.repository.ItemRepository;
import com.ijse.IJSEFinalpasan_pathiranage.repository.StockRepository;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item createItem(ItemDto itemDto) {
        ItemCategory itemCategory = itemCategoryRepository.findById(itemDto.getCategoryId()).orElse(null);

        if (itemCategory != null) {
            Item item = new Item();
            item.setName(itemDto.getName());
            item.setPrice(itemDto.getPrice());
            item.setCategory(itemCategory);
            item.setImage(itemDto.getImage());

            Stock stock = new Stock();
            stock.setQty(itemDto.getStock_qty());
            item.setStock(stock);
            stockRepository.save(stock);
            return itemRepository.save(item);
        } else {
            return null;
        }
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(ItemDto itemDto, Long id) {

        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem != null) {

        existingItem.setName(itemDto.getName());
        existingItem.setPrice(itemDto.getPrice());
        existingItem.setImage(itemDto.getImage());
    
        ItemCategory itemCategory = itemCategoryRepository.findById(itemDto.getCategoryId()).orElse(null);
        if (itemCategory != null) {
            existingItem.setCategory(itemCategory);
        } else {
            return null;
        }

        Stock stock = stockRepository.findById(existingItem.getStock().getId()).orElse(null);
        if (stock != null) {
            stock.setQty(itemDto.getStock_qty());
        } else {
            return null; 
        }
    
        return itemRepository.save(existingItem);
        
        }else{
            return null; 
        }
    }
    

    @Override  
    public void deleteItem(Long id) {
        itemRepository.deleteItemById(id);
    }

    @Override
    public List<Item> getItemsByItemCategory(Long id) {
        ItemCategory itemCategory = itemCategoryRepository.findById(id).orElse(null);

        if (itemCategory != null) {
            return itemRepository.findItemsByItemCategory(itemCategory);
        } else {
            return null;
        }
    }
}
