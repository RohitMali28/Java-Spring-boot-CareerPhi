package com.example.personalfinancemanagement.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personalfinancemanagement.service.CategoryService;

@RestController  
@RequestMapping("/categories")  
public class CategoryController {  
   @Autowired  
   private CategoryService categoryService;  
    
   @PostMapping  
   public Category saveCategory(@RequestBody Category category) {  
      return categoryService.saveCategory(category);  
   }  
    
   @GetMapping  
   public List<Category> getCategories() {  
      return categoryService.getCategories();  
   }  
}
