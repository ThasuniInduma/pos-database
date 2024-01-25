package com.ijse.posdatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.posdatabase.entity.ItemCategory;
import com.ijse.posdatabase.repository.ItemCategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllCategories(){
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory findCategoryById(Long id){
        return itemCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ItemCategory createCategory(ItemCategory itemCategory){
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategory updateCategory(Long id, ItemCategory itemCategory){

        ItemCategory existingCategory = itemCategoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(itemCategory.getName());
            return itemCategoryRepository.save(existingCategory);
        }else{
            return null;
        }

    }

    @Override
    public ItemCategory deleteCategory(Long id){
        ItemCategory existingCategory = itemCategoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            itemCategoryRepository.deleteById(id);
        }
        throw new EntityNotFoundException("There is no item category associated with the id"+id);
    }
    
}
