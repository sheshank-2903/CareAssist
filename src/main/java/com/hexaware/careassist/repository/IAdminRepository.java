package com.hexaware.careassist.repository;

import java.util.Set;

import com.hexaware.careassist.entities.Admin;
import com.hexaware.careassist.entities.HealthCareProvider;
import com.hexaware.careassist.entities.InsuranceCompany;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.entities.Patient;


public interface IAdminRepository {
	boolean getAdminInfo(int id);
	boolean updateInfo(Admin admin);
	boolean addAdmin(Admin admin);
	Set<Patient> getAllPatientList();
	Set<Invoices> getAllInvoicesList();
	Set<HealthCareProvider> getAllHealthCareProviderList();
	Set<InsuranceCompany> getAllInsuranceCompannyList();
	boolean deletePatientById(int patientId);
}
