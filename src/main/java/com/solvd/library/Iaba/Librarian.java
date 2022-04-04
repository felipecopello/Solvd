package com.solvd.library.Iaba;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NameNotCharException;
import com.solvd.library.exceptions.NoLibraryCardException;
import com.solvd.library.exceptions.NoStockException;
import com.solvd.library.util.GroupedInterface;
import com.solvd.library.util.IGreet;
import com.solvd.library.util.IValidate;

public class Librarian extends Person implements GroupedInterface, IGreet, IValidate {
	private static final Logger LOGGER = LogManager.getLogger(Librarian.class);
	private Scanner sc = new Scanner(System.in);
	private String crimes = "Crimes";
	private String philosophy = "Philosophy";
	private String scyFy = "Science Fiction";

	public Librarian() {
	}

	public Librarian(String name, int age, int id) {
		super(name, age, id);
	}

	@Override
	public void helpClient() {
		LOGGER.info("%nThe book you are looking for is over there");
	}

	@Override
	public void work() {
		LOGGER.info("%nOrganizing books");
	}

	public String getClientName() {
		LOGGER.info("%nEnter your name: ");
		String clientName = "";
		try {
			clientName = sc.nextLine();
			char[] ch = new char[clientName.length()];
			ch = clientName.toCharArray();
			clientName = IValidate.validateName(ch);
			return clientName;
		} catch (NameNotCharException ex) {
			LOGGER.error(ex.getMessage());
		}
		return clientName;
	}

	public int getClientAge() throws AgeNotIntException {
		LOGGER.info("Enter your age: ");
		try {
			String age = sc.nextLine();
			char[] ch = new char[age.length()];
			ch = age.toCharArray();
			int validatedAge = IValidate.validateAge(ch);
			return validatedAge;
		} catch (AgeNotIntException ex) {
			throw new AgeNotIntException(ex.getMessage());
		}
	}

	public int getClientId() throws IdTooLongException {
		LOGGER.info("Enter your Id: ");
		try {
			String validId = IValidate.validateId(sc.nextLine());
			int clientId = Integer.parseInt(validId);
			return clientId;
		} catch (IdTooLongException ex) {
			throw new IdTooLongException(ex.getMessage());
		}
	}

	public ArrayList<String> getClientBookTaste() throws NoStockException {
		LOGGER.info("How many book genres do you like?");
		try {
			int length = sc.nextInt();
			ArrayList<String> clientBookTaste = new ArrayList<>();
			LOGGER.info("What genres of books do you like?");
			for (int i = 0; i < length; i++) {
				String userInput = sc.next();
				clientBookTaste.add(userInput);
			}
			LOGGER.info("I like those books too");
			IValidate.validateBookTaste(clientBookTaste);
			return clientBookTaste;
		} catch (NoStockException ex) {
			throw new NoStockException(ex.getMessage());
		}
	}

	public boolean getClientLibraryCard() {
		LOGGER.info("Do you have a library card? enter yes or no");
		try (Scanner sc = new Scanner(System.in)) {
			return IValidate.validateLibraryCard(sc.nextLine());
		} catch (NoLibraryCardException ex) {
			throw new NoLibraryCardException(ex.getMessage());
		}
	}

	public void recommendBook(Object client) {
		ArrayList<String> taste = ((Client) client).getBookTaste();
		boolean card = ((Client) client).getLibraryCard();

		if (card == true) {
			for (String x : taste) {
				if (x.equalsIgnoreCase(crimes)) {
					LOGGER.info("%nIf you like " + crimes + " you should read Agatha Christie");
				} else if (x.equalsIgnoreCase(philosophy)) {
					LOGGER.info("%nIf you like " + philosophy + " you should read Friederich Nietzche");
				} else if (x.equalsIgnoreCase(scyFy)) {
					LOGGER.info("%nYou should read George Orwell");
				}
			}
		} else {
			LOGGER.error("%nSorry you do not have a valid Library Card");
		}
	};

	public void recieveNewClient() throws IdTooLongException, NoStockException, AgeNotIntException {
		String name = getClientName();
		int age = getClientAge();
		int id = getClientId();
		ArrayList<String> bookTaste = getClientBookTaste();
		boolean card = getClientLibraryCard();
		Client client = new Client(name, age, id, bookTaste, card);
		recommendBook(client);
	}

	public void showBookList(Library o) {
		LOGGER.info("Currently we have in the library");
		int f = o.getBooklist().size();
		for (int i = 0; i < f; i++) {
			String book = o.getBooklist().get(i).getData().getTitle();
			LOGGER.info(book);
		}
	}

	public static void main(String[] args) throws IdTooLongException, AgeNotIntException {
	};
}