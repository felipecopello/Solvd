package com.solvd.Iaba;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.exceptions.NameNotCharException;
import com.solvd.loggerExample.Main;
import com.solvd.util.GroupedInterface;
import com.solvd.util.IGreet;
import com.solvd.util.IValidate;

public class Librarian extends People implements GroupedInterface, IGreet, IValidate {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public Librarian() {
	}

	public Librarian(String name, int age, int id) {
		super(name, age, id);
	}

	@Override
	public void helpClient() {
		System.out.format("%nThe book you are looking for is over there");
	}

	@Override
	public void work() {
		System.out.format("%nOrganizing books");
	}

	public String getClientName() {
		Scanner sc = new Scanner(System.in);
		System.out.format("%nEnter your name: ");
		String clientName = sc.nextLine();

		try {
			char[] ch = new char[clientName.length()];
			ch = clientName.toCharArray();
			clientName = IValidate.validateName(ch);
			return clientName;
		}

		catch (NameNotCharException ex) {
			System.out.println(ex.getMessage());
		}
		return clientName;

	}

	public int getClientAge() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your age: ");
		try {
			int clientAge = sc.nextInt();
			return clientAge;
		} catch (RuntimeException ex) {
			throw new RuntimeException("There can only be ints in Age field");
		}
	}

	public int getClientId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Id: ");
		try {
			String validId = IValidate.validateId(sc.nextLine());
			int clientId = Integer.parseInt(validId);
			return clientId;
		} catch (NumberFormatException ex) {
			throw new NumberFormatException("There shoud only be ints in Id field");
		}
	}

	public String[] getClientBookTaste() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�How many book genres do you like?");
		int length = sc.nextInt();
		String[] clientBookTaste = new String[length];

		System.out.println("�What genres of books do you like?");

		for (int i = 0; i < length; i++) {
			String userInput = sc.next();
			clientBookTaste[i] = userInput;
		}
		System.out.println("I like those books too");
		IValidate.validateBookTaste(clientBookTaste);
		return clientBookTaste;
	}

	public boolean getClientLibraryCard() {
		String y = "yes";
		Scanner sc = new Scanner(System.in);
		System.out.println("�Do you have a library card? enter yes or no");
		String userInput = sc.nextLine();
		if (userInput == y) {
			System.out.println("ok great");
		} else {
		}
		return true;

	}

	public void recommendBook(Object client) {

		String[] taste = ((Client) client).getBookTaste();
		boolean card = ((Client) client).getLibraryCard();
		String crimes = "Crimes";
		String philosophy = "Philosophy";
		String scyFy = "Science Fiction";

		if (card == true) {
			for (String x : taste) {
				if (x.equalsIgnoreCase(crimes)) {
					System.out.format("%nIf you like " + crimes + " you should read Agatha Christie");
				} else if (x.equalsIgnoreCase(philosophy)) {
					System.out.format("%nIf you like " + philosophy + " you should read Friederich Nietzche");
				} else if (x.equalsIgnoreCase(scyFy)) {
					System.out.format("%nYou should read George Orwell");
				}
			}
		} else {
			System.out.format("%nSorry you do not have a valid Library Card");
		}
	};

	public void recieveNewClient() {
		String name = getClientName();
		int age = getClientAge();
		int id = getClientId();
		String[] bookTaste = getClientBookTaste();
		boolean card = getClientLibraryCard();
		Client client = new Client(name, age, id, bookTaste, card);
		recommendBook(client);
	}

	public static void main(String[] args) {
	};
}