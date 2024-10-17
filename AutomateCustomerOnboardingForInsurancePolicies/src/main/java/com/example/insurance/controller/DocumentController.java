package com.example.insurance.controller;

import com.example.insurance.service.DocumentService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public String showDocumentUploadForm(Model model) {
        // Ensure KYC is approved before showing this form
        // You can implement session/user validation here.
        return "documents";
    }

    @PostMapping("/documents/upload")
    public String uploadAdditionalDocuments(
            @RequestParam("userId") String userId, // This would typically come from the authenticated session
            @RequestParam("documentType") String documentType,
            @RequestParam("file") MultipartFile file,
            Model model) {
        try {
            documentService.uploadAdditionalDocument(userId, documentType, file);
            model.addAttribute("successMessage", "Documents submitted successfully.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (IOException e) {
            model.addAttribute("errorMessage", "An error occurred while uploading the document.");
        }
        return "documents";
    }
}