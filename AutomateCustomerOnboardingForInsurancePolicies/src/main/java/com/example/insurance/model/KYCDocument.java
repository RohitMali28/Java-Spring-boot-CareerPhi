package com.example.insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class KYCDocument {
    public KYCDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userId; // Assume you have a way to associate documents with users

    @NotNull
    private String documentType;

    private String filePath; // Path to the stored file

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void save(KYCDocument kycDocument) {
		// TODO Auto-generated method stub
		
	}

	public Object findById(Long documentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getResultMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setResultMessage(String string) {
		// TODO Auto-generated method stub
		
	}
    
   
}