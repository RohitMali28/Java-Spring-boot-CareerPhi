package com.example.finance.service;

import com.example.finance.entity.Transaction;
import com.example.finance.entity.User;
import com.example.finance.repository.TransactionRepository;
import com.example.finance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FinanceService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public User createUser(String name, double initialIncome) {
        User user = new User();
        user.setName(name);
        user.setInitialIncome(initialIncome);
        return userRepository.save(user);
    }

    public Transaction addTransaction(User user, String type, double amount, String category) {
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setCategory(category);
        transaction.setDate(new Date());
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions(User user) {
        return transactionRepository.findAll();
    }

	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
}