package com.hexaware.careassist.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class HealthCareProvider {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long healthCareId;
	@NotBlank
	private String healthcareProviderName;
	@NotBlank
    private String providerGender;
	@NotBlank
    private String address;
	@Email
    private String email;
	
	private int password;

	public HealthCareProvider() {
		super();
	}

	public HealthCareProvider(long healthCareId, @NotBlank String healthcareProviderName,
			@NotBlank String providerGender, @NotBlank String address, @Email String email, int password) {
		super();
		this.healthCareId = healthCareId;
		this.healthcareProviderName = healthcareProviderName;
		this.providerGender = providerGender;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	public long getHealthCareId() {
		return healthCareId;
	}

	public void setHealthCareId(long healthCareId) {
		this.healthCareId = healthCareId;
	}

	public String getHealthcareProviderName() {
		return healthcareProviderName;
	}

	public void setHealthcareProviderName(String healthcareProviderName) {
		this.healthcareProviderName = healthcareProviderName;
	}

	public String getProviderGender() {
		return providerGender;
	}

	public void setProviderGender(String providerGender) {
		this.providerGender = providerGender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "HealthCareProvider [healthCareId=" + healthCareId + ", healthcareProviderName=" + healthcareProviderName
				+ ", providerGender=" + providerGender + ", address=" + address + ", email=" + email + ", password="
				+ password + "]";
	} 
	
    
   
    
}
