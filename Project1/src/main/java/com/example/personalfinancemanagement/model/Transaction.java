package com.example.personalfinancemanagement.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  
public class Transaction {  
   @Id  
   @GeneratedValue(strategy = GenerationType.IDENTITY)  
   private Long id;  
   private double amount;  
   private String category;  
   private Date date;  
   // getters and setters  
}
