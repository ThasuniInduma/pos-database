package com.ijse.posdatabase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.posdatabase.entity.ItemCategory;

@Service
public interface ItemCategoryService {

    List<ItemCategory> getAllCategories();
    ItemCategory findCategoryById(Long id);
    ItemCategory createCategory(ItemCategory itemCategory);
    ItemCategory updateCategory(Long id, ItemCategory itemCategory);
    ItemCategory deleteCategory(Long id);
    
}
