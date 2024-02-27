package com.hexaware.careassist.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.Patient;


/*
@Author :  Yash Dubey
Modified Date : 02-02-2024
Description : PatientRepository extending JpaRepository
*/

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query(value = "SELECT * FROM Patient WHERE patient_Name LIKE %?1%", nativeQuery = true)
	public List<Patient> findByPatientName(String patientName);

	public Optional<Patient> findByEmail(String email);
	
}
