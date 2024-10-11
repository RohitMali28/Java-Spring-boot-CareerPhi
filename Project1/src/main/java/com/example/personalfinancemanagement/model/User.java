package com.example.personalfinancemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  
public class User {  
   @Id  
   @GeneratedValue(strategy = GenerationType.IDENTITY)  
   private Long id;  
   private String name;  
   private double income;  
   private double balance;  
   // getters and setters  
}
