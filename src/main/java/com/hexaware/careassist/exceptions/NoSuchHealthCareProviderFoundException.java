package com.hexaware.careassist.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSuchHealthCareProviderFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public NoSuchHealthCareProviderFoundException(String message) {
		
		super(message);
		
		logger.error(message);
		
	}
}