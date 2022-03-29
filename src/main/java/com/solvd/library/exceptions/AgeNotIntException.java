package com.solvd.library.exceptions;

public class AgeNotIntException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AgeNotIntException(String message) {
		super(message);
	}
}