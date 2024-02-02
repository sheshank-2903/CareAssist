package com.hexaware.careassist.service;

import java.util.List;

import com.hexaware.careassist.dto.InvoicesDTO;
import com.hexaware.careassist.entities.Invoices;

public interface IInvoicesService {
	public boolean addInvoice(InvoicesDTO invoiceDto);
	public boolean updateInvoice(InvoicesDTO invoiceDto );
	public List<Invoices> getAllInvoices();
	public List<Invoices> getInvoiceById(long invoiceId);
	public List<Invoices> getInvoicesByPatientId(long patientId);
	public boolean deleteInvoiceById(long invoiceId);
	
}
