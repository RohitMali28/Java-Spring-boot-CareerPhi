package com.example.personalfinancemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personalfinancemanagement.repository.TransactionRepository;

import jakarta.transaction.Transaction;

@Service  
public class TransactionService {  
   @Autowired  
   private TransactionRepository transactionRepository;  
    
   public Transaction saveTransaction(Transaction transaction) {  
      return transactionRepository.save(transaction);  
   }  
    
   public List<Transaction> getTransactions() {  
      return transactionRepository.findAll();  
   }  
}