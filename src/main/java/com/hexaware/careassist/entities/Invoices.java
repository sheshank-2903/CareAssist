package com.hexaware.careassist.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
@Author :  Yash Dubey
Modified Date : 26-10-2023
Description : Entity class for Admin containing various properties
*/


@Entity
public class Invoices {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long invoiceId;
	@NotNull
	private LocalDate invoiceDate;
	@NotNull
	private LocalDate invoiceDueDate;
	@NotBlank
	private String patientName; 
	@NotBlank
	private String patientAddress;
	
	@NotNull
	@Min(0)
	private double invoiceTax;
	
	@NotNull
	@Min(0)
	private double consultingFees;
	
	@NotNull
	@Min(0)
	private double diagnosticTestFees;
	
	@NotNull
	@Min(0)
	private double diagnosticScanFees;
	
	@NotNull
	@Min(0)
	private double calculatedAmount;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	@JsonBackReference
	private Patient patient;

	public Invoices() {
		super();
	}

	public Invoices(long invoiceId, @NotNull LocalDate invoiceDate, @NotNull LocalDate invoiceDueDate,
			 @NotBlank String patientName, @NotBlank String patientAddress,
			@NotNull double invoiceTax, @NotNull double consultingFees, @NotNull double diagnosticTestFees,
			@NotNull double diagnosticScanFees, @NotNull double calculatedAmount, Patient patient) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.invoiceDueDate = invoiceDueDate;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.invoiceTax = invoiceTax;
		this.consultingFees = consultingFees;
		this.diagnosticTestFees = diagnosticTestFees;
		this.diagnosticScanFees = diagnosticScanFees;
		this.calculatedAmount = calculatedAmount;
		this.patient = patient;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public LocalDate getInvoiceDueDate() {
		return invoiceDueDate;
	}

	public void setInvoiceDueDate(LocalDate invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}


	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public double getInvoiceTax() {
		return invoiceTax;
	}

	public void setInvoiceTax(double invoiceTax) {
		this.invoiceTax = invoiceTax;
	}

	public double getConsultingFees() {
		return consultingFees;
	}

	public void setConsultingFees(double consultingFees) {
		this.consultingFees = consultingFees;
	}

	public double getDiagnosticTestFees() {
		return diagnosticTestFees;
	}

	public void setDiagnosticTestFees(double diagnosticTestFees) {
		this.diagnosticTestFees = diagnosticTestFees;
	}

	public double getDiagnosticScanFees() {
		return diagnosticScanFees;
	}

	public void setDiagnosticScanFees(double diagnosticScanFees) {
		this.diagnosticScanFees = diagnosticScanFees;
	}

	public double getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(double calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Invoices [invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", InvoiceDueDate="
				+ invoiceDueDate + ", patientName=" + patientName + ", patientAddress="
				+ patientAddress + ", invoiceTax=" + invoiceTax + ", consultingFees=" + consultingFees
				+ ", diagnosticTestFees=" + diagnosticTestFees + ", diagnosticScanFees=" + diagnosticScanFees
				+ ", calculatedAmount=" + calculatedAmount + ", patient=" + patient + "]";
	}
	
	
	
}
