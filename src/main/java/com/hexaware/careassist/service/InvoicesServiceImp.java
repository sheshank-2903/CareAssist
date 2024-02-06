package com.hexaware.careassist.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.careassist.dto.InvoicesDTO;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.entities.Patient;
import com.hexaware.careassist.exceptions.NoSuchInvoiceGeneratedException;
import com.hexaware.careassist.repository.InvoicesRepository;
import com.hexaware.careassist.repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InvoicesServiceImp implements IInvoicesService {

	Logger logger = LoggerFactory.getLogger(InvoicesServiceImp.class);
	
	@Autowired
	InvoicesRepository invoiceRepo;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Override
	public Invoices addInvoice(InvoicesDTO invoiceDto,long patientId) {
		
		Patient patient=patientRepo.findById(patientId).orElse(null);
		
		Invoices invoice=new Invoices();
		invoice.setInvoiceId(invoiceDto.getInvoiceId());
		invoice.setInvoiceDate(invoiceDto.getInvoiceDate());
		invoice.setInvoiceDueDate(invoiceDto.getInvoiceDueDate());
		invoice.setPatientName(invoiceDto.getPatientName());
		invoice.setPatientAddress(invoiceDto.getPatientAddress());
		invoice.setInvoiceTax(invoiceDto.getInvoiceTax());
		invoice.setConsultingFees(invoiceDto.getConsultingFees());
		invoice.setDiagnosticTestFees(invoiceDto.getDiagnosticTestFees());
		invoice.setDiagnosticScanFees(invoiceDto.getDiagnosticScanFees());
		invoice.setCalculatedAmount(invoiceDto.getCalculatedAmount());
		invoice.setPatient(patient);
		
		logger.info("InvoicesServiceImp-- Invoice with invoiceId: {} generated successfully",invoice.getInvoiceId());
		
		patient.getInvoiceSet().add(invoice);
		patientRepo.save(patient);
		
		return invoiceRepo.save(invoice);
		
	}

	

	@Override
	public List<Invoices> getAllInvoices() {
		logger.info("InvoicesServiceImp-- All invoice details fetched successfully");
		return invoiceRepo.findAll();
	}

	@Override
	public Invoices getInvoiceById(long invoiceId) {

		logger.info("InvoicesServiceImp-- Invoice with invoiceId: {} fetched successfully",invoiceId);
		return invoiceRepo.findById(invoiceId).orElseThrow(() -> new NoSuchInvoiceGeneratedException(HttpStatus.NO_CONTENT,
				"No such Invoice with Id :" + invoiceId + " Found"));
	}
	

	@Override
	public List<Invoices> getInvoicesByPatientId(long patientId) {
		logger.info("InvoicesServiceImp-- Invoice with PatientId: {} fetched successfully",patientId);
		return invoiceRepo.findByByPatientId(patientId);
	}

	

}
