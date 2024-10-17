package com.example.insurance.controller;

import com.example.insurance.service.KYCService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class KYCController {

    @Autowired
    private KYCService kycService;

    @GetMapping("/kyc")
    public String showKYCForm(Model model) {
        return "kyc";
    }

    @PostMapping("/kyc/upload")
    public String uploadKYC(
            @RequestParam("userId") String userId,
            @RequestParam("documentType") String documentType,
            @RequestParam("file") MultipartFile file,
            Model model) {
        try {
            kycService.uploadKYCFile(userId, documentType, file);
            model.addAttribute("successMessage", "Documents submitted successfully.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (IOException e) {
            model.addAttribute("errorMessage", "An error occurred while uploading the document.");
        }
        return "kyc";
    }

    @PostMapping("/kyc/verify")
    public String verifyKYC(
            @RequestParam("documentId") Long documentId,
            @RequestParam("isApproved") boolean isApproved,
            Model model) {
        String message = kycService.processKYC(documentId, isApproved);
        model.addAttribute("notification", message);
        return "kyc"; // Return to the KYC form with a notification
    }
}