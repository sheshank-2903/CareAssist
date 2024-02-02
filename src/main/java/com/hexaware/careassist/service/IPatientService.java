package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.PatientDTO;
import com.hexaware.careassist.entities.Patient;

public interface IPatientService {
	public PatientDTO getPatientById(int patientId);
	public boolean updatePatient(PatientDTO patientDto);
	public boolean deletePatientById(int patientId);
	public List<Patient> getAllPatient();
	public List<Patient> getPatientByName(String patientName);
}
