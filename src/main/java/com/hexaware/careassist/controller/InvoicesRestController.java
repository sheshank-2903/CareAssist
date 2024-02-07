package com.hexaware.careassist.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(InvoicesRestController.class);
	
	@PostMapping("/add/{patientId}")
	public Invoices addInvoice(@RequestBody InvoicesDTO invoiceDto,@PathVariable long patientId) {
		logger.info("InvoicesRestController-- Invoice with invoiceId: {} generated successfully",invoiceDto.getInvoiceId());
		return service.addInvoice(invoiceDto, patientId);
	}

	
	@GetMapping("/getall")
	public List<Invoices> getAllInvoices() {
		logger.info("InvoicesRestController-- All invoice details fetched successfully");
		return service.getAllInvoices();
	}

	
	@GetMapping("/getbyid/{invoiceId}")
	public Invoices getInvoiceById(@PathVariable long invoiceId) {
		logger.info("InvoicesRestController-- Invoice with invoiceId: {} fetched successfully",invoiceId);
		return service.getInvoiceById(invoiceId);
	}

	
	@GetMapping("/getbypatientid/{patientId}")
	public List<Invoices> getInvoicesByPatientId(@PathVariable long patientId) {
		logger.info("InvoicesRestController-- Invoice with PatientId: {} fetched successfully",patientId);
		return service.getInvoicesByPatientId(patientId);
	}

}
