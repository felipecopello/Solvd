package com.solvd.service;

import com.solvd.Iaba.Clients;
import com.solvd.Iaba.Librarian;

public class Service {
	public static void main(String[] args) {
		String[] booksTaste = { "Crimes", "Romantic novels" };
		Clients client1 = new Clients("Carlos Sanchez", 22, 3830544, booksTaste, true);

		Librarian librarian1 = new Librarian();
		librarian1.recommendBook(client1);

		librarian1.recieveNewClient();

	}
}