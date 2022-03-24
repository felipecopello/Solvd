package com.solvd.Iaba;

import java.util.Scanner;

import com.solvd.exceptions.NameNotCharException;
import com.solvd.util.GroupedInterface;
import com.solvd.util.IGreet;

public class Librarian extends People implements GroupedInterface, IGreet {
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
			clientName = validateName(ch);
			return clientName;
		}

		catch (NameNotCharException ex) {
			System.out.println(ex.getMessage());
		}
		return clientName;

	}

	public String validateName(char[] ch) throws NameNotCharException {
		String validatedName = new String();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetter(ch[i])) {
				char a = ch[i];
				validatedName = validatedName + a;
			} else {
				System.out.println(ch[i] + " is not a letter");
				throw new NameNotCharException("There can only be letters in Name field");
			}
		}
		return validatedName;
	}

	public int getClientAge() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int clientAge = sc.nextInt();
		return clientAge;
	}

	public int getClientId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Id: ");
		int clientId = sc.nextInt();
		return clientId;
	}

	public String[] getClientBookTaste() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿How many book genres do you like?");
		int length = sc.nextInt();
		String[] clientBookTaste = new String[length];

		System.out.println("¿What genres of books do you like?");

		for (int i = 0; i < length; i++) {
			String userInput = sc.next();
			clientBookTaste[i] = userInput;
		}

		System.out.println("I like those books too");
		return clientBookTaste;
	}

	public boolean getClientLibraryCard() {
		String y = "yes";
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Do you have a library card? enter yes or no");
		String userInput = sc.nextLine();
		if (userInput == y) {
			System.out.println("ok great");
		} else {
		}
		return true;
	}

	public void recommendBook(Object client) {

		String[] taste = ((Clients) client).getBookTaste();
		boolean card = ((Clients) client).getLibraryCard();
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

	public void recieveNewClient() throws NameNotCharException {
		String name = getClientName();
		int age = getClientAge();
		int id = getClientId();
		String[] bookTaste = getClientBookTaste();
		Clients client = new Clients(name, age, id, bookTaste, true);
		System.out.println(client.getName());
		recommendBook(client);
	}

	public static void main(String[] args) throws NameNotCharException {
		Librarian librarian1 = new Librarian();
		librarian1.getClientName();
	};
}