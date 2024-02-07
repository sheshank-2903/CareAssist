package com.hexaware.careassist.dto;

public class HealthCareProviderDTO {
	
	private long healthCareProviderId;
	
	private String healthcareProviderName;
	
    private String providerGender;
	
    private String address;
	
    private String email;
	
	private String password;

	public HealthCareProviderDTO() {
		super();
	}

	public HealthCareProviderDTO(long healthCareId, String healthcareProviderName,
			String providerGender, String address, String email, String password) {
		super();
		this.healthCareProviderId = healthCareId;
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
	
    
   
    
}
