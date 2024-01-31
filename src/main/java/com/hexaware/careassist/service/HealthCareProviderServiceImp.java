package com.hexaware.careassist.service;

import java.util.Set;

import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.entities.Patient;


public class HealthCareProviderServiceImp implements IHealthCareProviderService {

	@Override
	public HealthCareProvider getHealthCareProviderInfo(int hId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateHealthCareProviderInfo(HealthCareProvider healthCareProvider) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHealthCareProviderInfo(int hId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Invoices> getAllInvoice(int healthCareId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean generateInvoice(String patientName, double invoiceTax, double consultingFees,
			double diagnosticTestFees, double diagnosticScanFees) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Patient> getAllPatientDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
