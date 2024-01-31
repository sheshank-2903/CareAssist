package com.hexaware.careassist.service;

import java.util.Set;

import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.entities.Patient;


public class AdminServiceImp implements IAdminService {

	@Override
	public boolean getAdminInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfo(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Patient> getAllPatientList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Invoices> getAllInvoicesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<HealthCareProvider> getAllHealthCareProviderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<InsuranceCompany> getAllInsuranceCompannyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePatientById(int patientId) {
		// TODO Auto-generated method stub
		return false;
	}

}
