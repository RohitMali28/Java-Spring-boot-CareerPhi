package com.example.personalfinancemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.personalfinancemanagement.repository.UserRepository;

@Service  
public class UserService<userRepository> {  
   @Autowired  
   private UserRepository userRepository;  
    
   public com.example.personalfinancemanagement.model.User saveUser(User user) {  
      return userRepository.save(user);  
   }  
    
   public User getUser(Long id) {  
      return (User) userRepository.findById(id);  
   }  
}