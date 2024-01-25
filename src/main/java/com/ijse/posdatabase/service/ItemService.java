package com.ijse.posdatabase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.posdatabase.dto.ItemDto;
import com.ijse.posdatabase.entity.Item;

@Service
public interface ItemService {

    List<Item> getAllItems();
    Item createItem(ItemDto itemDto);
    Item getItemById(Long id);
    Item updateItem(Long id, Item item);
    Item deleteItem(Long id);
    List<Item> getItemsByCategory(Long id);

}
