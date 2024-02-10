package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.PatientDTO;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.exceptions.EmailAlreadyPresentException;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;

public interface IPatientService {
	public Patient addPatient(PatientDTO patientDto) throws EmailAlreadyPresentException;
	public PatientDTO getPatientById(long patientId) throws NoSuchPatientFoundException;
	public Patient updatePatient(PatientDTO patientDto) throws NoSuchPatientFoundException;
	public boolean deletePatientById(long patientId) throws NoSuchPatientFoundException;
	public List<Patient> getAllPatient();
	public List<Patient> getPatientByName(String patientName);
}
