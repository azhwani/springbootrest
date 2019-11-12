package com.project.az.springbootrest.exceptions;

public class ResouceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResouceNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public ResouceNotFoundException(int id) {
		super("Resource ID not found : " + id);
		// TODO Auto-generated constructor stub
	}

	public ResouceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ResouceNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ResouceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ResouceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
