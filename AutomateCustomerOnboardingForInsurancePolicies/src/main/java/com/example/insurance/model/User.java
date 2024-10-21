package com.example.insurance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    @NotBlank(message = "Name is required")
    private String name;
     
    @Column(name = "email")
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @Column(name = "phone")
    @NotBlank(message = "Phone is required")
    private String phone;
    
    @Column(name = "password")
    @NotBlank(message = "Password is required")
    private String password;

	public User(Long id, @NotBlank(message = "Name is required") String name,
			@Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Phone is required") String phone,
			@NotBlank(message = "Password is required") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
     
   
}