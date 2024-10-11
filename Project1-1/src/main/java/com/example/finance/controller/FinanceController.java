package com.example.finance.controller;

import com.example.finance.entity.Transaction;
import com.example.finance.entity.User;
import com.example.finance.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestParam String name, @RequestParam double initialIncome, Model model) {
        User user = financeService.createUser(name, initialIncome);
        model.addAttribute("user", user);
        return "dashboard";
    }

    @PostMapping("/addTransaction")
    public String addTransaction(@RequestParam Long userId, @RequestParam String type, @RequestParam double amount, @RequestParam String category, Model model) {
        User user = financeService.getUserById(userId);
        financeService.addTransaction(user, type, amount, category);
        List<Transaction> transactions = financeService.getTransactions(user);
        model.addAttribute("transactions", transactions);
        return "transactions";
    }
}
