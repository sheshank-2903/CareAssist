package com.hexaware.careassist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	public List<Patient> findByPatientName(String patientName);
	
}
