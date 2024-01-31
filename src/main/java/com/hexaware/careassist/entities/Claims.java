package com.hexaware.careassist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Claims {
	@Id
	private int claimId;
	private double claimAmount;
	private String claimStatus;
	private String claimName;
	private String claimDescription;
	private int InsuranceCompanyId;
	private int policyId;
	
	public Claims() {
		super();
	}
	public Claims(int claimId, double claimAmount, String claimStatus, String claimName, String claimDesciption,int InsuranceCompanyId,int policyId) {
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.claimName = claimName;
		this.claimDescription = claimDesciption;
		this.InsuranceCompanyId=InsuranceCompanyId;
		this.policyId=policyId;
	}
	public String getClaimDescription() {
		return claimDescription;
	}
	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getInsuranceCompanyId() {
		return InsuranceCompanyId;
	}
	public void setInsuranceCompanyId(int insauraceCompanyId) {
		InsuranceCompanyId = insauraceCompanyId;
	}
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getClaimName() {
		return claimName;
	}
	public void setClaimName(String claimName) {
		this.claimName = claimName;
	}
	public String getClaimDesciption() {
		return claimDescription;
	}
	public void setClaimDesciption(String claimDesciption) {
		this.claimDescription = claimDesciption;
	}
	@Override
	public String toString() {
		return "Claims [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus
				+ ", claimName=" + claimName + ", claimDesciption=" + claimDescription + ", InsuranceCompanyId="
				+ InsuranceCompanyId + "]";
	}
	
	
}
