package com.hexaware.careassist.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchInvoiceGeneratedException extends ResponseStatusException {

	public NoSuchInvoiceGeneratedException(HttpStatusCode status,String reason) {
		super(status,reason);
		
	}
	
	

}
