package com.example.insurance.repository;

import com.example.insurance.model.KYCDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KYCDocumentRepository extends JpaRepository<KYCDocument, Long> {
    
}