package com.hexaware.careassist.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Invoices {
	@Id
	private int invoiceId;
	private LocalDate invoiceDate;
	private LocalDate InvoiceDueDate;
	private int patientId;
	private String patientName;
	private String patientAddress;
	private double invoiceTax;
	private double consultingFees;
	private double diagnosticTestFees;
	private double diagnosticScanFees;
	private double calculatedAmount;
	public Invoices() {
		super();
	}
	public Invoices(int invoiceId, LocalDate invoiceDate, LocalDate invoiceDueDate, int patientId, String patientName,
			String patientAddress, double invoiceTax, double consultingFees, double diagnosticTestFees,
			double diagnosticScanFees, double calculatedAmount) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		InvoiceDueDate = invoiceDueDate;
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.invoiceTax = invoiceTax;
		this.consultingFees = consultingFees;
		this.diagnosticTestFees = diagnosticTestFees;
		this.diagnosticScanFees = diagnosticScanFees;
		this.calculatedAmount = calculatedAmount;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public LocalDate getInvoiceDueDate() {
		return InvoiceDueDate;
	}
	public void setInvoiceDueDate(LocalDate invoiceDueDate) {
		InvoiceDueDate = invoiceDueDate;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
				+ InvoiceDueDate + ", patientId=" + patientId + ", patientName=" + patientName + ", patientAddress="
				+ patientAddress + ", invoiceTax=" + invoiceTax + ", consultingFees=" + consultingFees
				+ ", diagnosticTestFees=" + diagnosticTestFees + ", diagnosticScanFees=" + diagnosticScanFees
				+ ", calculatedAmount=" + calculatedAmount + "]";
	}
	
	
}
