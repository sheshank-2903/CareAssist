package com.hexaware.careassist.dto;




public class InsuranceCompanyDTO {
	
	private long insuranceCompanyId;
	
	private String insuranceCompanyDescription;
	
    private String companyName;
    
    private int companyContactNumber;
    
    private String email;
    

	public InsuranceCompanyDTO() {
		super();
	}


	public InsuranceCompanyDTO(long insuranceCompanyId, String insuranceCompanyDescription, String companyName,
			int companyContactNumber, String email) {
		super();
		this.insuranceCompanyId = insuranceCompanyId;
		this.insuranceCompanyDescription = insuranceCompanyDescription;
		this.companyName = companyName;
		this.companyContactNumber = companyContactNumber;
		this.email = email;
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
