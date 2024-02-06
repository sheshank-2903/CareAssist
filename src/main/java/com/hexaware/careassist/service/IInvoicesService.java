package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.InvoicesDTO;
import com.hexaware.careassist.entities.Invoices;

public interface IInvoicesService {
	public Invoices addInvoice(InvoicesDTO invoiceDto,long patientId);
	
	public List<Invoices> getAllInvoices();
	public Invoices getInvoiceById(long invoiceId);
	public List<Invoices> getInvoicesByPatientId(long patientId);
	
	
}
