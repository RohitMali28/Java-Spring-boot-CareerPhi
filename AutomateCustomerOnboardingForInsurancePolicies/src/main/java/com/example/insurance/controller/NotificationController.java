package com.example.insurance.controller;

import com.example.insurance.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public String showNotifications(@RequestParam("userId") String userId, Model model) {
        model.addAttribute("notifications", notificationService.getUserNotifications(userId));
        return "notifications"; // Return a view that displays notifications
    }

    // This endpoint simulates sending notifications based on policy status
    public void notifyPolicyStatus(String userId, boolean isApproved) {
        if (isApproved) {
            notificationService.sendNotification(userId, "Your insurance policy has been successfully issued.");
        } else {
            notificationService.sendNotification(userId, "Your policy application has been rejected due to missing/incorrect documents.");
        }
    }
}