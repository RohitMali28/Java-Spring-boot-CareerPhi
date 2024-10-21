package com.example.insurance.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InsurancePlatformController {

    private final InsurancePlatformController insurancePlatformService;

    // Constructor injection of the service
    public InsurancePlatformController(InsurancePlatformController insurancePlatformService) {
        this.insurancePlatformService = insurancePlatformService;
    }

    @PostMapping("/insurance_platform")
    public ResponseEntity<InsurancePlatformController> createInsurancePlatform(@RequestBody InsurancePlatformController platform) {
        // Save the platform using the service
        InsurancePlatformController savedPlatform = InsurancePlatformController.save(platform);
        
        // Return a response with the saved entity and HTTP status 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlatform);
    }

	private static InsurancePlatformController save(InsurancePlatformController platform) {
		// TODO Auto-generated method stub
		return null;
	}
}