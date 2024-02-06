package com.hexaware.careassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.Invoices;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Long>{

}
