package com.hexaware.careassist.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class PolicyList {
	@Id
	private int policyId;
	private int patientId;
    private LocalDate dateOfIssue;
    private double coverage_amount;
    private int insuranceCompanyId;
    @ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="patient_policy_table",
	joinColumns = {@JoinColumn(name="policy_id")},
					inverseJoinColumns= {@JoinColumn(name="patient_id")}	)
	private Set<Patient> patientList=new HashSet<Patient>();
	public PolicyList() {
		super();
	}
	public PolicyList(int policyId, int patientId, LocalDate dateOfIssue, double coverage_amount,
			int insuranceCompanyId, Set<Patient> patientList) {
		super();
		this.policyId = policyId;
		this.patientId = patientId;
		this.dateOfIssue = dateOfIssue;
		this.coverage_amount = coverage_amount;
		this.insuranceCompanyId = insuranceCompanyId;
		this.patientList = patientList;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public double getCoverage_amount() {
		return coverage_amount;
	}
	public void setCoverage_amount(double coverage_amount) {
		this.coverage_amount = coverage_amount;
	}
	public int getInsuranceCompanyId() {
		return insuranceCompanyId;
	}
	public void setInsuranceCompanyId(int insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}
	public Set<Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}
	@Override
	public String toString() {
		return "PolicyList [policyId=" + policyId + ", patientId=" + patientId + ", dateOfIssue=" + dateOfIssue
				+ ", coverage_amount=" + coverage_amount + ", insuranceCompanyId=" + insuranceCompanyId
				+ ", patientList=" + patientList + "]";
	}
    
    
}
