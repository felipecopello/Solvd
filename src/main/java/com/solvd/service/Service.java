package com.solvd.service;

import com.solvd.Iaba.Librarian;
import com.solvd.exceptions.NameNotCharException;

public class Service {
	public static void main(String[] args) throws NameNotCharException {

		Librarian librarian1 = new Librarian();
		librarian1.recieveNewClient();

	}
}