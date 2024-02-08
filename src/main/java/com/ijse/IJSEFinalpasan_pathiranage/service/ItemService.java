package com.ijse.IJSEFinalpasan_pathiranage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.IJSEFinalpasan_pathiranage.dto.ItemDto;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Item;



@Service
public interface ItemService {

    List<Item> getAllItems();
    Item createItem(ItemDto itemDto);
    Item getItemById(Long id);
    Item updateItem(ItemDto itemDto, Long id);
    void deleteItem(Long id);
    List<Item> getItemsByItemCategory(Long id);

}