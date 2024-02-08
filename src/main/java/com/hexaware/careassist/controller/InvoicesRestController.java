package com.hexaware.careassist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/invoice")
public class InvoicesRestController {

	@Autowired
	IInvoicesService service;
	
	@PostMapping("/add/{patientId}")
	public Invoices addInvoice(@RequestBody InvoicesDTO invoiceDto,@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.addInvoice(invoiceDto, patientId);
	}

	
	@GetMapping("/getall")
	public List<Invoices> getAllInvoices() {
		return service.getAllInvoices();
	}

	
	@GetMapping("/getbyid/{invoiceId}")
	public Invoices getInvoiceById(@PathVariable long invoiceId) throws NoSuchInvoiceFoundException {
		return service.getInvoiceById(invoiceId);
	}

	
	@GetMapping("/getbypatientid/{patientId}")
	public List<Invoices> getInvoicesByPatientId(@PathVariable long patientId) throws NoSuchPatientFoundException {
		return service.getInvoicesByPatientId(patientId);
	}
	
	@DeleteMapping("/deletebyid/{invoiceId}")
	public String deleteInvoiceById(@PathVariable long invoiceId) throws NoSuchInvoiceFoundException {
		boolean isDeleted=service.deleteInvoiceById(invoiceId);
		return isDeleted?"Invoice Deleted" : "Deletion unsuccessful";
	}

}
