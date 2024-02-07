package com.hexaware.careassist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchPatientFoundException.class)

	public ResponseEntity<String> handleNoSuchPatientFoundException(NoSuchPatientFoundException ex) {

		return new ResponseEntity<String>("No such Patient exists in database", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoSuchAdminFoundException.class)

	public ResponseEntity<String> handleNoSuchAdminFoundException(NoSuchAdminFoundException ex) {

		return new ResponseEntity<String>("Invalid admin ID ", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoSuchClaimFoundException.class)
	public ResponseEntity<String> handleNoSuchClaimFoundException(NoSuchClaimFoundException ex) {

		return new ResponseEntity<String>("No such claim exists in database", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoSuchHealthCareProviderFoundException.class)
	public ResponseEntity<String> handleNoSuchHealthCareProviderFoundException(NoSuchHealthCareProviderFoundException ex) {

		return new ResponseEntity<String>("No such health care provider exists in database", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoSuchInvoiceFoundException.class)

	public ResponseEntity<String> handleNoSuchInvoiceFoundException(NoSuchInvoiceFoundException ex) {

		return new ResponseEntity<String>("No such invoice exists in database", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoSuchPlanFoundException.class)

	public ResponseEntity<String> handleNoSuchPlanFoundException(NoSuchPlanFoundException ex) {

		return new ResponseEntity<String>("No such plan exists in database", HttpStatus.NOT_FOUND);

	}
}
