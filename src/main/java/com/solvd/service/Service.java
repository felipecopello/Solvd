package com.solvd.service;

import com.solvd.Iaba.ClientQueue;
import com.solvd.Iaba.SecurityGuard;

public abstract class Service extends ClientQueue<Object> {
	public static void main(String[] args) {

		SecurityGuard securityGuard = new SecurityGuard();
		// Librarian librarian1 = new Librarian();
		// librarian1.recieveNewClient();
		// recieveClientQueue(2);
		securityGuard.listFurniture();
	}
}