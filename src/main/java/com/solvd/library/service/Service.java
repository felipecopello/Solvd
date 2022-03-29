package com.solvd.library.service;

import com.solvd.library.Iaba.ClientQueue;
import com.solvd.library.Iaba.Librarian;
import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NoStockException;

public class Service extends ClientQueue {
	public static void main(String[] args) throws IdTooLongException, NoStockException, AgeNotIntException {

		Librarian librarian1 = new Librarian();
		librarian1.recieveNewClient();
		// recieveClientQueue(1);
	}
}