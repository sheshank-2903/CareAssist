package com.hexaware.careassist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Claims {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long claimId;
	
	private double claimAmount;
	@NotBlank
	private String claimStatus;
	
	
	private int planId;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="planId")
	private Plans plans;
	
	
	
	public Claims() {
		super();
	}



	public Claims(long claimId, double claimAmount, @NotBlank String claimStatus, int planId, Patient patient,
			Plans plans) {
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.planId = planId;
		this.patient = patient;
		this.plans = plans;
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



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public Plans getPlans() {
		return plans;
	}



	public void setPlans(Plans plans) {
		this.plans = plans;
	}



	@Override
	public String toString() {
		return "Claims [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus
				+ ", planId=" + planId + ", patient=" + patient + ", plans=" + plans + "]";
	}

	
	
	
	
	
}
