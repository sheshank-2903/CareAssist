package com.hexaware.careassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.careassist.entities.Invoices;

public interface InvoicesRepository extends JpaRepository<Invoices, Long>{

}
