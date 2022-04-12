package com.solvd.library.entities;

import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Sex;
import com.solvd.library.util.ICheckCard;
import com.solvd.library.util.IHelp;
import com.solvd.library.util.IWork;

public class SecurityGuard extends Person implements IHelp, IWork, ICheckCard {
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

	@Override
	public boolean checkCard(Client client) {
		return client.getLibraryCard().isOwned();
	}

	public static void printClientsCardCheck(HashSet<Client> roster, ICheckCard tester) {
		for (Client c : roster) {
			if (tester.checkCard(c)) {
				LOGGER.info(c.getName() + " has a valid card");
			} else {
				LOGGER.info(c.getName() + " doesnt have a valid card");
			}
		}
	}
}