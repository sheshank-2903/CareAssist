package com.hexaware.careassist.dto;

public class HealthCareProviderDTO {
	
	private long healthCareId;
	
	private String healthcareProviderName;
	
    private String providerGender;
	
    private String address;
	
    private String email;
	
	private int password;

	public HealthCareProviderDTO() {
		super();
	}

	public HealthCareProviderDTO(long healthCareId, String healthcareProviderName,
			String providerGender, String address, String email, int password) {
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
