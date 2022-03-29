package com.solvd.library.exceptions;

public class NoLibraryCardException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoLibraryCardException(String message) {
		super(message);
	}
}
