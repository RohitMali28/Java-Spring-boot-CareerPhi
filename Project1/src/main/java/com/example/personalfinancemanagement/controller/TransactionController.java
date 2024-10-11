package com.example.personalfinancemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personalfinancemanagement.service.TransactionService;

import jakarta.transaction.Transaction;

@RestController  
@RequestMapping("/transactions")  
public class TransactionController {  
   @Autowired  
   private TransactionService transactionService;  
    
   @PostMapping  
   public Transaction saveTransaction(@RequestBody Transaction transaction) {  
      return transactionService.saveTransaction(transaction);  
   }  
    
   @GetMapping  
   public List<Transaction> getTransactions() {  
      return transactionService.getTransactions();  
   }  
}