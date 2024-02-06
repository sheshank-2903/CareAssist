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
import jakarta.validation.constraints.Pattern;

@Entity
public class InsuranceCompany {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long insuranceCompanyId;
	@NotBlank
	private String insuranceCompanyDescription;
	@NotBlank
    private String companyName;
    @Pattern(regexp="\\d{10}",message="Please enter 10 digit number")
    private String companyContactNumber;
    @Email
    private String email;
    
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="insuranceCompany") 
	private Set<Plans> planSet=new HashSet<>();


	public InsuranceCompany() {
		super();
	}


	public InsuranceCompany(long insuranceCompanyId, @NotBlank String insuranceCompanyDescription,
			@NotBlank String companyName,
			@Pattern(regexp = "[0-9]{10}", message = "Please enter 10 digit number") String companyContactNumber,
			@Email String email, Set<Plans> planSet) {
		super();
		this.insuranceCompanyId = insuranceCompanyId;
		this.insuranceCompanyDescription = insuranceCompanyDescription;
		this.companyName = companyName;
		this.companyContactNumber = companyContactNumber;
		this.email = email;
		this.planSet = planSet;
	}


	public long getInsuranceCompanyId() {
		return insuranceCompanyId;
	}


	public void setInsuranceCompanyId(long insuranceCompanyId) {
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


	public String getCompanyContactNumber() {
		return companyContactNumber;
	}


	public void setCompanyContactNumber(String companyContactNumber) {
		this.companyContactNumber = companyContactNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set<Plans> getPlanSet() {
		return planSet;
	}


	public void setPlanSet(Set<Plans> planSet) {
		this.planSet = planSet;
	}


	@Override
	public String toString() {
		return "InsuranceCompany [insuranceCompanyId=" + insuranceCompanyId + ", insuranceCompanyDescription="
				+ insuranceCompanyDescription + ", companyName=" + companyName + ", companyContactNumber="
				+ companyContactNumber + ", email=" + email + ", planSet=" + planSet + "]";
	} 
    
    
}
