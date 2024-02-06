package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.PatientDTO;
import com.hexaware.careassist.entities.Patient;

public interface IPatientService {
	public Patient addPatient(PatientDTO patientDto);
	public PatientDTO getPatientById(long patientId);
	public Patient updatePatient(PatientDTO patientDto);
	public boolean deletePatientById(long patientId);
	public List<Patient> getAllPatient();
	public List<Patient> getPatientByName(String patientName);
}
