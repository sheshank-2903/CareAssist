package com.hexaware.careassist.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSuchPatientFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public NoSuchPatientFoundException(String message) {
		
		super(message);
		
		logger.error(message);
		
	}
}