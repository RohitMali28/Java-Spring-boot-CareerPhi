package com.example.personalfinancemanagement.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personalfinancemanagement.repository.CategoryRepository;

@Service  
public class CategoryService {  
   @Autowired  
   private CategoryRepository categoryRepository;  
    
   public Category saveCategory(Category category) {  
      return categoryRepository.save(category);  
   }  
    
   public List<Category> getCategories() {  
      return categoryRepository.findAll();  
   }  
}