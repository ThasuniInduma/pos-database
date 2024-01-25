package com.ijse.posdatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.posdatabase.dto.ItemDto;
import com.ijse.posdatabase.entity.Item;
import com.ijse.posdatabase.entity.ItemCategory;
import com.ijse.posdatabase.repository.ItemCategoryRepository;
import com.ijse.posdatabase.repository.ItemRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @Override
    public Item createItem(ItemDto itemDto){
        ItemCategory itemCategory = itemCategoryRepository.findById(itemDto.getCategoryId()).orElse(null);
        if (itemCategory != null) {
            Item item = new Item();
            item.setName(itemDto.getName());
            item.setPrice(itemDto.getPrice());
            item.setItemCategory(itemCategory);
            return itemRepository.save(item);
        } else {
            return null;
        }
    }

    @Override
    public Item getItemById(Long id){
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(Long id, Item item){
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.setName(item.getName());
            existingItem.setItemCategory(item.getItemCategory());
            existingItem.setPrice(item.getPrice());
            return itemRepository.save(existingItem);
        } else {
            return null;
        }
    }

    @Override
    public Item deleteItem(Long id){
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            itemRepository.deleteById(id);
        }
        throw new EntityNotFoundException("There is no item associated with the id"+id);
    
    }

    @Override
    public List<Item> getItemsByCategory(Long id){
        ItemCategory itemCategory = itemCategoryRepository.findById(id).orElse(null);
        if(itemCategory != null){
            return itemRepository.findItemByItemCategory(itemCategory);
        } else {
            return null;
        }
    }
    
}
