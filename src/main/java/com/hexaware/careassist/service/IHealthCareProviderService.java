package com.hexaware.careassist.service;

import java.util.Set;

import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.entities.Patient;


public interface IHealthCareProviderService {
	public HealthCareProvider getHealthCareProviderInfo(int hId);
	public boolean updateHealthCareProviderInfo(HealthCareProvider healthCareProvider);
	public boolean deleteHealthCareProviderInfo(int hId);
	public Set<Invoices> getAllInvoice(int healthCareId);
	public boolean generateInvoice(String patientName,double invoiceTax,double consultingFees,double diagnosticTestFees,double diagnosticScanFees );
	public Set<Patient> getAllPatientDetails();
	

//	auto - invoiceDate;
//	private String patientName;
//	private String patientAddress;
//	private double invoiceTax;
//	private double consultingFees;
//	private double diagnosticTestFees;
//	private double diagnosticScanFees;
//	private double calculatedAmount;
}
