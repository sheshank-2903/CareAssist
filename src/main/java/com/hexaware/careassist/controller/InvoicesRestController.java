package com.hexaware.careassist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.careassist.dto.InvoicesDTO;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.exceptions.NoSuchInvoiceFoundException;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;
import com.hexaware.careassist.service.IInvoicesService;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoicesRestController {

	@Autowired
	IInvoicesService service;
	
	
	
	@PostMapping("/add/{patientId}")
	@PreAuthorize("hasAuthority('HEALTH_CARE_PROVIDER')")
	public Invoices addInvoice(@RequestBody InvoicesDTO invoiceDto,@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.addInvoice(invoiceDto, patientId);
	}

	
	@GetMapping("/getall")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Invoices> getAllInvoices() {
		return service.getAllInvoices();
	}

	
	@GetMapping("/getbyid/{invoiceId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Invoices getInvoiceById(@PathVariable long invoiceId) throws NoSuchInvoiceFoundException {
		return service.getInvoiceById(invoiceId);
	}

	
	@GetMapping("/getbypatientid/{patientId}")
	@PreAuthorize("hasAuthority('PATIENT')")
	public List<Invoices> getInvoicesByPatientId(@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.getInvoicesByPatientId(patientId);
	}
	
	@DeleteMapping("/deletebyid/{invoiceId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteInvoiceById(@PathVariable long invoiceId) throws NoSuchInvoiceFoundException {
		boolean isDeleted=service.deleteInvoiceById(invoiceId);
		return isDeleted?"Invoice Deleted" : "Deletion unsuccessful";
	}
	
	

}
