package com.example.personalfinancemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personalfinancemanagement.service.UserService;

@RestController  
@RequestMapping("/users")  
public class UserController {  
   @Autowired  
   private UserService userService;  
    
   @PostMapping  
   public com.example.personalfinancemanagement.model.User saveUser(@RequestBody User user) {  
      return userService.saveUser(user);  
   }  
    
   @GetMapping("/{id}")  
   public User getUser(@PathVariable Long id) {  
      return userService.getUser(id);  
   }  
}
