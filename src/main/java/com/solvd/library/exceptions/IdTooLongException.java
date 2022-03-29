package com.solvd.library.exceptions;

public class IdTooLongException extends Exception {

	private static final long serialVersionUID = 1L;

	public IdTooLongException(String message) {
		super(message);
	}
}
