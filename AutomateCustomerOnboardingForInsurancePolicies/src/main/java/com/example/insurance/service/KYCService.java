package com.example.insurance.service;

import com.example.insurance.model.KYCDocument;
import com.example.insurance.repository.KYCDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class KYCService {

    @Autowired
    private KYCDocumentRepository kycDocumentRepository;

    private static final String UPLOAD_DIR = "uploads/";

    public void uploadKYCFile(String userId, String documentType, MultipartFile file) throws IOException {
        // Check file format and size
        if (!file.getContentType().matches("image/.*|application/pdf") || file.getSize() > 5242880) {
            throw new IllegalArgumentException("Please upload valid documents in the correct format and size.");
        }

        // Save file to local storage
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File destFile = new File(uploadDir, userId + "_" + documentType + "_" + file.getOriginalFilename());
        file.transferTo(destFile);

        // Save KYC document details
        KYCDocument kycDocument = new KYCDocument();
        kycDocument.setUserId(userId);
        kycDocument.setDocumentType(documentType);
        kycDocument.setFilePath(destFile.getPath());
        kycDocument.setStatus("PENDING");
        kycDocumentRepository.save(kycDocument);
    }

    public String processKYC(Long documentId, boolean isApproved) {
        KYCDocument kycDocument = kycDocumentRepository.findById(documentId).orElse(null);
        if (kycDocument != null) {
            if (isApproved) {
                kycDocument.setStatus("APPROVED");
                kycDocument.setResultMessage("Your KYC has been approved.");
            } else {
                kycDocument.setStatus("REJECTED");
                kycDocument.setResultMessage("KYC verification failed. Please upload valid documents.");
            }
            kycDocumentRepository.save(kycDocument);
            return kycDocument.getResultMessage();
        }
        return "Document not found.";
    }
}