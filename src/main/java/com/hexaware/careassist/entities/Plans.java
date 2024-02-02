package com.hexaware.careassist.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Plans {  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long planId;
	@NotBlank
	private String planName;
	@NotBlank
	private String description; 
	
	@NotNull
    private LocalDate dateOfIssue;
    @NotNull
    @Min(50000)
    private double coverageAmount;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="plans")
    private Set<Claims> claimSet=new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name="insuranceCompanyId")
    private InsuranceCompany insuranceCompany;

	public Plans() {
		super();
	}

	public Plans(long planId, @NotBlank String planName, @NotBlank String description, @NotNull LocalDate dateOfIssue,
			@NotNull @Min(50000) double coverageAmount, Set<Claims> claimSet, InsuranceCompany insuranceCompany) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.description = description;
		this.dateOfIssue = dateOfIssue;
		this.coverageAmount = coverageAmount;
		this.claimSet = claimSet;
		this.insuranceCompany = insuranceCompany;
	}

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Set<Claims> getClaimSet() {
		return claimSet;
	}

	public void setClaimSet(Set<Claims> claimSet) {
		this.claimSet = claimSet;
	}

	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	@Override
	public String toString() {
		return "Plans [planId=" + planId + ", planName=" + planName + ", Description=" + description + ", dateOfIssue="
				+ dateOfIssue + ", coverage_amount=" + coverageAmount + ", claimSet=" + claimSet
				+ ", insuranceCompany=" + insuranceCompany + "]";
	}
   
}
