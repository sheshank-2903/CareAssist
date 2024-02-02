package com.hexaware.careassist.dto;




public class ClaimsDTO {
	
	private long claimId;
	
	private double claimAmount;
	
	private String claimStatus;
	
	private int planId;
	
	
	
	public ClaimsDTO() {
		super();
	}

	public ClaimsDTO(long claimId, double claimAmount, String claimStatus,int planId) {
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.planId = planId;
	}

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
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

	

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "Claims [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus
				+  ", planId=" + planId + "]";
	}
	
	
}
