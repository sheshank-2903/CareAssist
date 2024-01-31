package com.hexaware.careassist.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;



@Entity
public class Patient {
	@Id
	int patientId; 
	private LocalDate date;
    private int contact;
    private String address;
    private String patientName;
    private String patientGender;
    private String descriptionOfTreatment;
    private String email;
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="patientId") // patientId column will be created in Claims class table or we can say it is foreign key in department table
	private Set<Claims> claimSet=new HashSet<Claims>(); // Collection should be initialised to avoid null pointer exception
    @ManyToMany(mappedBy="patientList",fetch=FetchType.LAZY)
	private Set<PolicyList> policyList=new HashSet<PolicyList>();
	public Patient() {
		super();
	}
	public Patient(int patientId, LocalDate date, int contact, String address, String patientName, String patientGender,
			String descriptionOfTreatment, String email) {
		super();
		this.patientId = patientId;
		this.date = date;
		this.contact = contact;
		this.address = address;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.descriptionOfTreatment = descriptionOfTreatment;
		this.email = email;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getDescriptionOfTreatment() {
		return descriptionOfTreatment;
	}
	public void setDescriptionOfTreatment(String descriptionOfTreatment) {
		this.descriptionOfTreatment = descriptionOfTreatment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", date=" + date + ", contact=" + contact + ", address=" + address
				+ ", patientName=" + patientName + ", patientGender=" + patientGender + ", descriptionOfTreatment="
				+ descriptionOfTreatment + ", email=" + email + "]";
	}
    
    
}
