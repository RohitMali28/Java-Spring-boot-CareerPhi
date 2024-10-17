package com.example.insurance.service;

import com.example.insurance.model.AdditionalDocument;
import com.example.insurance.repository.AdditionalDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class DocumentService {

    @Autowired
    private AdditionalDocumentRepository additionalDocumentRepository;

    private static final String UPLOAD_DIR = "uploads/additional/";

    public void uploadAdditionalDocument(String userId, String documentType, MultipartFile file) throws IOException {
        // Check file format and size
        if (!file.getContentType().matches("image/.*|application/pdf|application/msword|application/vnd.openxmlformats-officedocument.wordprocessingml.document") || file.getSize() > 5242880) {
            throw new IllegalArgumentException("Please upload valid documents in the correct format and size.");
        }

        // Save file to local storage
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File destFile = new File(uploadDir, userId + "_" + documentType + "_" + file.getOriginalFilename());
        file.transferTo(destFile);

        // Save additional document details
        AdditionalDocument additionalDocument = new AdditionalDocument();
        additionalDocument.setUserId(userId);
        additionalDocument.setDocumentType(documentType);
        additionalDocument.setFilePath(destFile.getPath());
        additionalDocument.setStatus("SUBMITTED"); // or "PENDING"
        additionalDocumentRepository.save(additionalDocument);
    }
}