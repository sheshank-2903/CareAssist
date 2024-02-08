package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.InvoicesDTO;
import com.hexaware.careassist.entities.Invoices;
import com.hexaware.careassist.exceptions.NoSuchInvoiceFoundException;
import com.hexaware.careassist.exceptions.NoSuchPatientFoundException;

public interface IInvoicesService {
	public Invoices addInvoice(InvoicesDTO invoiceDto,long patientId) throws NoSuchPatientFoundException;
	
	public List<Invoices> getAllInvoices();
	public Invoices getInvoiceById(long invoiceId) throws NoSuchInvoiceFoundException;
	public List<Invoices> getInvoicesByPatientId(long patientId) throws NoSuchPatientFoundException;
	public boolean deleteInvoiceById(long invoiceId) throws NoSuchInvoiceFoundException;
	
}
