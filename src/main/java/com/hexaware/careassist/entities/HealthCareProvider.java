package com.hexaware.careassist.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class HealthCareProvider {
	@Id
	private int healthCareId;
	private String healthcareProviderName;
    private String providerGender;
    private String address;
    private String email;
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="providerInvoiceId") // providerInvoiceId column will be created in Invoices class table or we can say it is foreign key in department table
	private Set<Invoices> hospitalInvoiceSet=new HashSet<Invoices>(); // Collection should be initialised to avoid null pointer exception
	public HealthCareProvider() {
		super();
	}
	public HealthCareProvider(int healthCareId, String healthcareProviderName, String providerGender, String address,
			String email) {
		super();
		this.healthCareId = healthCareId;
		this.healthcareProviderName = healthcareProviderName;
		this.providerGender = providerGender;
		this.address = address;
		this.email = email;
	}
	public int getHealthCareId() {
		return healthCareId;
	}
	public void setHealthCareId(int healthCareId) {
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
	@Override
	public String toString() {
		return "HealthCareProvider [healthCareId=" + healthCareId + ", healthcareProviderName=" + healthcareProviderName
				+ ", providerGender=" + providerGender + ", address=" + address + ", email=" + email + "]";
	}
    
    
}
