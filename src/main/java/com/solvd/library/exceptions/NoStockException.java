package com.solvd.library.exceptions;

public class NoStockException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoStockException(String message) {
		super(message);
	}
}
