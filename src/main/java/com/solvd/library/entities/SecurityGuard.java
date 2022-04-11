package com.solvd.library.entities;

import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.util.IGreet;
import com.solvd.library.util.IHelp;
import com.solvd.library.util.IWork;

public class SecurityGuard extends Person implements IHelp, IWork, IGreet {
	private HashSet<String> clients = new HashSet<>();
	private static final Logger LOGGER = LogManager.getLogger(SecurityGuard.class);

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
		LOGGER.info("%nThe section you are looking for is that way");
	}

	@Override
	public void work() {
		LOGGER.info("%nWatching the library");
	}

	public void beQuiet() {
		LOGGER.info("Please be quiet in the library");
	}

	public boolean isClient(HashSet<String> clients, String client) {
		return clients.contains(client);
	}

	@Override
	public void interact() {
		LOGGER.info("What can i do for you today?");
	}

}