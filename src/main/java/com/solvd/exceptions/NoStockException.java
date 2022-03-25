package com.solvd.exceptions;

public class NoStockException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoStockException(String message) {
		super(message);
	}
}
