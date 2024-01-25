package com.ijse.posdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.posdatabase.entity.ItemCategory;
import com.ijse.posdatabase.service.ItemCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/categories")
    public List<ItemCategory> getAllCategories() {
        return itemCategoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public ItemCategory createCategory(@RequestBody ItemCategory itemCategory) {
        return itemCategoryService.createCategory(itemCategory);
    }
    
    @GetMapping("/categories/{id}")
    public ItemCategory getCategoryById(@PathVariable Long id) {
        return itemCategoryService.findCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public ItemCategory updateCategory(@PathVariable Long id, @RequestBody ItemCategory itemCategory){
        return itemCategoryService.updateCategory(id, itemCategory);
    }
    
    
}
