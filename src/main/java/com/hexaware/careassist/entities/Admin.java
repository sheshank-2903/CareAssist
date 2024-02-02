package com.hexaware.careassist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Admin {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long adminId;
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	private String password;
	
	
	
	public Admin() {
		super();
	}
	
	public Admin(long adminId, String name) {
		super();
		this.adminId = adminId;
		this.name = name;
	}
	
	public long getId() {
		return adminId;
	}
	public void setId(long adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
