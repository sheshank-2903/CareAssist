package com.hexaware.careassist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hexaware.careassist.entities.Invoices;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Long>{
	
	@Query("select inv from Invoices inv where inv.patient.patientId=?1")
	List<Invoices> findByByPatientId(long patientId);

}
