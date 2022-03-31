package com.solvd.library.Iaba;

import java.util.HashSet;

import com.solvd.library.util.IGreet;
import com.solvd.library.util.IHelp;
import com.solvd.library.util.IWork;

public class SecurityGuard extends Person implements IHelp, IWork, IGreet {
	private HashSet<String> clients = new HashSet<>();

	public SecurityGuard() {
	}

	public SecurityGuard(String name, int age, int id) {
		super(name, age, id);
	}

	public HashSet<String> getClients() {
		return clients;
	}

	public void setClients(HashSet<String> clients) {
		this.clients = clients;
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

	public boolean isClient(HashSet<String> clients, String client) {
		return clients.contains(client);
	}
}