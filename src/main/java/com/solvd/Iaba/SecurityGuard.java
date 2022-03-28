package com.solvd.Iaba;

import java.util.HashSet;

import com.solvd.util.IGreet;
import com.solvd.util.IHelp;
import com.solvd.util.IWork;

public class SecurityGuard extends People implements IHelp, IWork, IGreet {
	public SecurityGuard() {
	}

	public SecurityGuard(String name, int age, int id) {
		super(name, age, id);
	}

	@Override
	public void helpClient() {
		System.out.format("%nThe section you are looking for is that way");
	}

	@Override
	public void work() {
		System.out.format("%nWatching the library");
	}

	public void beQuiet() {
		System.out.println("Please be quiet in the library");
	}

	public HashSet<String> listClientsNames() {
		HashSet<String> clients = new HashSet<>();
		clients.add("Pedro Sanchez");
		clients.add("Esteban Gonzalez");
		clients.add("Juan Benitez");
		clients.add("Mariano Martinez");
		return clients;
	}

	public boolean isClient(HashSet<String> clients, String client) {
		return clients.contains(client);
	}
}