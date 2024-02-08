package com.hexaware.careassist.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.careassist.dto.PatientDTO;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;
import com.hexaware.careassist.repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImp implements IPatientService {

	Logger logger = LoggerFactory.getLogger(PatientServiceImp.class);
	
	@Autowired
	PatientRepository repo;
	
	@Override
	public PatientDTO getPatientById(long patientId) throws NoSuchPatientFoundException {
		
		Patient patient=repo.findById(patientId)
				.orElseThrow(()->new NoSuchPatientFoundException("No such patient exists in the database")); 
		
		PatientDTO patientdto=new PatientDTO();
		patientdto.setPatientId(patient.getPatientId());  
		patientdto.setPatientName(patient.getPatientName());
		patientdto.setAddress(patient.getAddress());
		patientdto.setContact(patient.getContact());
		patientdto.setDob(patient.getDob());
		patientdto.setDescriptionOfTreatment(patient.getDescriptionOfTreatment());
		patientdto.setEmail(patient.getEmail());
		patientdto.setPassword(patient.getPassword());
		patientdto.setPatientGender(patient.getPatientGender());
		
		logger.info("PatientServiceImp-- Patient with id {} has been fetched successfully",patientId);
		
		return patientdto;
	}

	@Override
	public Patient updatePatient(PatientDTO patientDto) throws NoSuchPatientFoundException {

		repo.findById(patientDto.getPatientId())
		.orElseThrow(()->new NoSuchPatientFoundException("No such patient exists in the database")); 

		Patient patient=new Patient();
		patient.setPatientId(patientDto.getPatientId());
		patient.setPatientName(patientDto.getPatientName());
		patient.setAddress(patientDto.getAddress());
		patient.setContact(patientDto.getContact());
		patient.setDob(patientDto.getDob());
		patient.setDescriptionOfTreatment(patientDto.getDescriptionOfTreatment());
		patient.setEmail(patientDto.getEmail());
		patient.setPassword(patientDto.getPassword());
		patient.setPatientGender(patientDto.getPatientGender());
		
		logger.warn("PatientServiceImp-- Patient with id: {} is updated!!!!",patient.getPatientId());
		
		return repo.save(patient);
	}

	@Override
	public boolean deletePatientById(long patientId) throws NoSuchPatientFoundException {
		
		repo.findById(patientId)
		.orElseThrow(()->new NoSuchPatientFoundException("No such patient exists in the database")); 

		repo.deleteById(patientId);
		
		Patient patient=repo.findById(patientId).orElse(null); 

		
		boolean bool=false;
		if(patient==null) {
			bool=true;
			logger.warn("PatientServiceImp-- Patient with id: {} has been deleted!",patientId);
		}
		
		return bool;
	
	}

	@Override
	public List<Patient> getAllPatient() {
		logger.info("PatientServiceImp-- All the Patients Data is received!!!");
		return repo.findAll();
	}

	@Override
	public List<Patient> getPatientByName(String patientName) {
		
		logger.info("PatientServiceImp-- Patients with name: {}  are fetched!!!",patientName);
		
		return repo.findByPatientName(patientName);
	}

	@Override
	public Patient addPatient(PatientDTO patientDto) {
		//already exists in db...
		Patient patient=new Patient();
		patient.setPatientId(patientDto.getPatientId());
		patient.setPatientName(patientDto.getPatientName());
		patient.setAddress(patientDto.getAddress());
		patient.setContact(patientDto.getContact());
		patient.setDob(patientDto.getDob());
		patient.setDescriptionOfTreatment(patientDto.getDescriptionOfTreatment());
		patient.setEmail(patientDto.getEmail());
		patient.setPassword(patientDto.getPassword());
		patient.setPatientGender(patientDto.getPatientGender());
		
		logger.info("PatientServiceImp-- Patient with id: {} is added successfully!!!!",patient.getPatientId());
		
		return repo.save(patient);
	}


}
