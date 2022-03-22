package library;

import java.util.Scanner;

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
		return clientName;
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
		String Crimes = "Crimes";
		String Philosophy = "Philosophy";
		String scyFy = "Science Fiction";

		if (card == true) {
			for (String x : taste) {
				if (x == Crimes) {
					System.out.format("%nIf you like " + Crimes + " you should read Agatha Christie");
				} else if (x == Philosophy) {
					System.out.format("%nIf you like " + Philosophy + " you should read Friederich Nietzche");
				} else if (x == scyFy) {
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
		Clients client = new Clients(name, age, id, bookTaste, true);
		recommendBook(client);
	}

	public static void main(String[] args) {
		Librarian librarian1 = new Librarian();

		Clients client1 = new Clients();
		client1.setName(librarian1.getClientName());
		client1.setAge(librarian1.getClientAge());
		client1.setId(librarian1.getClientId());
		client1.setBookTaste(librarian1.getClientBookTaste());
		client1.setLibraryCard(librarian1.getClientLibraryCard());
		System.out.println(client1.getName() + client1.getAge() + client1.getId() + client1.getBookTaste()
				+ client1.getLibraryCard());
	};
}