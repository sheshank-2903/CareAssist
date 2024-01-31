package com.hexaware.careassist.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class InsuranceCompany {
	@Id
	private int insuranceCompanyId;
	private String insuranceCompanyDescription;
    private String companyName;
    private int companyContactNumber;
    private String email;
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="policyProviderId") //policyProviderId column will be created in PolicyList class table or we can say it is foreign key in department table
	private Set<PolicyList> policySet=new HashSet<PolicyList>(); // Collection should be initialised to avoid null pointer exception
	
    
    public InsuranceCompany() {
		super();
	}
	public InsuranceCompany(int insuranceCompanyId, String insuranceCompanyDescription, String companyName,
			int companyContactNumber, String email) {
		super();
		this.insuranceCompanyId = insuranceCompanyId;
		this.insuranceCompanyDescription = insuranceCompanyDescription;
		this.companyName = companyName;
		this.companyContactNumber = companyContactNumber;
		this.email = email;
	}
	public int getInsuranceCompanyId() {
		return insuranceCompanyId;
	}
	public void setInsuranceCompanyId(int insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}
	public String getInsuranceCompanyDescription() {
		return insuranceCompanyDescription;
	}
	public void setInsuranceCompanyDescription(String insuranceCompanyDescription) {
		this.insuranceCompanyDescription = insuranceCompanyDescription;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCompanyContactNumber() {
		return companyContactNumber;
	}
	public void setCompanyContactNumber(int companyContactNumber) {
		this.companyContactNumber = companyContactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "InsuranceCompany [insuranceCompanyId=" + insuranceCompanyId + ", insuranceCompanyDescription="
				+ insuranceCompanyDescription + ", companyName=" + companyName + ", companyContactNumber="
				+ companyContactNumber + ", email=" + email + "]";
	}
    
    
}
