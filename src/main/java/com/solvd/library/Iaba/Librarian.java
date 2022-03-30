package com.solvd.library.Iaba;

import java.util.Scanner;

import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NameNotCharException;
import com.solvd.library.exceptions.NoLibraryCardException;
import com.solvd.library.exceptions.NoStockException;
import com.solvd.library.util.GroupedInterface;
import com.solvd.library.util.IGreet;
import com.solvd.library.util.IValidate;

public class Librarian extends People implements GroupedInterface, IGreet, IValidate {
	private Scanner sc = new Scanner(System.in);

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
		System.out.format("%nEnter your name: ");
		String clientName = "";
		try {
			clientName = sc.nextLine();
			char[] ch = new char[clientName.length()];
			ch = clientName.toCharArray();
			clientName = IValidate.validateName(ch);
			return clientName;
		} catch (NameNotCharException ex) {
			System.out.println(ex.getMessage());
		}
		return clientName;
	}

	public int getClientAge() throws AgeNotIntException {
		System.out.print("Enter your age: ");
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
		System.out.print("Enter your Id: ");
		try {
			String validId = IValidate.validateId(sc.nextLine());
			int clientId = Integer.parseInt(validId);
			return clientId;
		} catch (IdTooLongException ex) {
			throw new IdTooLongException(ex.getMessage());
		}
	}

	public String[] getClientBookTaste() throws NoStockException {
		System.out.println("¿How many book genres do you like?");
		try {
			int length = sc.nextInt();
			String[] clientBookTaste = new String[length];
			System.out.println("¿What genres of books do you like?");
			for (int i = 0; i < length; i++) {
				String userInput = sc.next();
				clientBookTaste[i] = userInput;
			}
			System.out.println("I like those books too");
			IValidate.validateBookTaste(clientBookTaste);
			return clientBookTaste;
		} catch (NoStockException ex) {
			throw new NoStockException(ex.getMessage());
		}
	}

	public boolean getClientLibraryCard() {
		System.out.println("¿Do you have a library card? enter yes or no");
		try (Scanner sc = new Scanner(System.in)) {
			return IValidate.validateLibraryCard(sc.nextLine());
		} catch (NoLibraryCardException ex) {
			throw new NoLibraryCardException(ex.getMessage());
		}
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

	public void recieveNewClient() throws IdTooLongException, NoStockException, AgeNotIntException {
		String name = getClientName();
		int age = getClientAge();
		int id = getClientId();
		String[] bookTaste = getClientBookTaste();
		boolean card = getClientLibraryCard();
		Client client = new Client(name, age, id, bookTaste, card);
		recommendBook(client);
	}

	public static void main(String[] args) throws IdTooLongException, AgeNotIntException {
		Librarian librarian1 = new Librarian();
		librarian1.getClientAge();
	};
}