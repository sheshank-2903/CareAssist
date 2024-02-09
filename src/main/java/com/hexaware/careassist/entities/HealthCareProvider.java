package com.hexaware.careassist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class HealthCareProvider {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long healthCareProviderId;
	
	@Pattern(regexp="^[a-zA-Z]{1,20}$",message="Invalid name provided should have only alphabet with max length 20")
	private String healthcareProviderName;
	
	@Pattern(regexp = "MALE|FEMALE" , message="Gender Provided can only be MALE|FEMALE")
    private String providerGender;
	
	@NotBlank
    private String address;
	@Email
    private String email;
	
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
			,message="password must have at least 1 upper case, 1 lower case,1 special character, 1 digit and must be of minimum leangth 8")
	private String password;
	
	private static final String ROLE="HEALTH_CARE_PROVIDER";

	public HealthCareProvider() {
		super();
	}

	

	public HealthCareProvider(long healthCareProviderId,
			@Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "Invalid name provided should have only alphabet with max length 20") String healthcareProviderName,
			@Pattern(regexp = "MALE|FEMALE", message = "Gender Provided can only be MALE|FEMALE") String providerGender,
			@NotBlank String address, @Email String email,
			@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "password must have at least 1 upper case, 1 lower case,1 special character, 1 digit and must be of minimum leangth 8") String password) {
		super();
		this.healthCareProviderId = healthCareProviderId;
		this.healthcareProviderName = healthcareProviderName;
		this.providerGender = providerGender;
		this.address = address;
		this.email = email;
		this.password = password;
	}



	public long getHealthCareProviderId() {
		return healthCareProviderId;
	}

	public void setHealthCareProviderId(long healthCareProviderId) {
		this.healthCareProviderId = healthCareProviderId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "HealthCareProvider [healthCareProviderId=" + healthCareProviderId + ", healthcareProviderName=" + healthcareProviderName
				+ ", providerGender=" + providerGender + ", address=" + address + ", email=" + email + ", password="
				+ password + "]";
	} 
	
	public static String getRole() {
		return ROLE;
	}
   
    
}
