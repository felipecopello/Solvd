package com.solvd.library.entities;

import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Sex;
import com.solvd.library.util.IHelp;
import com.solvd.library.util.IWork;

public class SecurityGuard extends Person implements IHelp, IWork {
	private HashSet<Client> clients = new HashSet<>();
	private static final Logger LOGGER = LogManager.getLogger(SecurityGuard.class);

	public SecurityGuard() {
	}

	public SecurityGuard(String name, int age, int id, Sex gender) {
		super(name, age, id, gender);
	}

	public HashSet<Client> getClients() {
		return clients;
	}

	public void setClients(HashSet<Client> clients) {
		this.clients = clients;
	}

	public void addClient(Client c) {
		clients.add(c);
	}

	@Override
	public void helpClient() {
		LOGGER.info("The section you are looking for is that way");
	}

	@Override
	public void work() {
		LOGGER.info("Watching the library");
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

	public List<Client> filterClients(BiFunction<HashSet<Client>, Sex, List<Client>> clientsFilter, Sex sex) {
		return clientsFilter.apply(clients, sex);
	}

	public void clientsCardCheck(Consumer<HashSet<Client>> tester) {
		tester.accept(clients);
	}

}
