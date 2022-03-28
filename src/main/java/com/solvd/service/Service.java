package com.solvd.service;

import com.solvd.Iaba.ClientQueue;

public abstract class Service extends ClientQueue<Object> {
	public static void main(String[] args) {

		// Librarian librarian1 = new Librarian();
		// librarian1.recieveNewClient();
		recieveClientQueue(2);
	}
}