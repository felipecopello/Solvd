package com.solvd.exceptions;

public class IdTooLongException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdTooLongException(String message) {
		super(message);
	}
}
