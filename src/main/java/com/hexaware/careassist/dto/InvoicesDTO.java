package com.hexaware.careassist.dto;

import java.time.LocalDate;


public class InvoicesDTO {
	
	private long invoiceId;
	
	private LocalDate invoiceDate;
	
	private LocalDate invoiceDueDate;
	
	private String patientName; 
	
	private String patientAddress;
	
	private double invoiceTax;
	
	private double consultingFees;
	
	private double diagnosticTestFees;
	
	private double diagnosticScanFees;
	
	private double calculatedAmount;
	
	

	public InvoicesDTO() {
		super();
	}



	public InvoicesDTO(long invoiceId, LocalDate invoiceDate, LocalDate invoiceDueDate, String patientName,
			String patientAddress, double invoiceTax, double consultingFees, double diagnosticTestFees,
			double diagnosticScanFees, double calculatedAmount) {
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



	@Override
	public String toString() {
		return "Invoices [invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", InvoiceDueDate="
				+ invoiceDueDate +", patientName=" + patientName + ", patientAddress="
				+ patientAddress + ", invoiceTax=" + invoiceTax + ", consultingFees=" + consultingFees
				+ ", diagnosticTestFees=" + diagnosticTestFees + ", diagnosticScanFees=" + diagnosticScanFees
				+ ", calculatedAmount=" + calculatedAmount + "]";
	}

	
	
	
}
