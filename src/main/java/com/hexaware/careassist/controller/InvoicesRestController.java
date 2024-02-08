package com.hexaware.careassist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.careassist.dto.InvoicesDTO;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.service.IInvoicesService;

@RestController
@RequestMapping("/api/invoice")
public class InvoicesRestController {

	@Autowired
	IInvoicesService service;
	
	@PostMapping("/add/{patientId}")
	public Invoices addInvoice(@RequestBody InvoicesDTO invoiceDto,@PathVariable long patientId) {
		return service.addInvoice(invoiceDto, patientId);
	}

	
	@GetMapping("/getall")
	public List<Invoices> getAllInvoices() {
		return service.getAllInvoices();
	}

	
	@GetMapping("/getbyid/{invoiceId}")
	public Invoices getInvoiceById(@PathVariable long invoiceId) {
		return service.getInvoiceById(invoiceId);
	}

	
	@GetMapping("/getbypatientid/{patientId}")
	public List<Invoices> getInvoicesByPatientId(@PathVariable long patientId) {
		return service.getInvoicesByPatientId(patientId);
	}

}
