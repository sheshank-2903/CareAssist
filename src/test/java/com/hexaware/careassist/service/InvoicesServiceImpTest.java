package com.hexaware.careassist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.careassist.dto.InvoicesDTO;
import com.hexaware.careassist.entities.Invoices;

import jakarta.transaction.Transactional;

@SpringBootTest
class InvoicesServiceImpTest {

	@Autowired
	IInvoicesService service;

	@Test
//	@Disabled
	void testAddInvoice() {
		InvoicesDTO invoice=new InvoicesDTO(2,LocalDate.now(),LocalDate.now(),"Yash","abc abc", 0, 0, 0, 0, 0);
		
		Invoices inv=service.addInvoice(invoice, 1);
		
		assertEquals(2,inv.getInvoiceId());
	}

	@Test
//	@Disabled
	void testGetAllInvoices() {
		List<Invoices> list=service.getAllInvoices();
		
		assertTrue(list.size()==2);
	}

	@Test
//	@Disabled
	void testGetInvoiceById() {
		Invoices inv=service.getInvoiceById(1);
		
		assertEquals(1,inv.getInvoiceId());
	}

	@Test
//	@Disabled
	void testGetInvoicesByPatientId() {
		List<Invoices> list=service.getInvoicesByPatientId(1);
		//System.out.println(list);
		assertTrue(list.size()==2);
	}

}
