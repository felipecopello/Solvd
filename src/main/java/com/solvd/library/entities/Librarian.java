package com.solvd.library.entities;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Course;
import com.solvd.library.enums.Day;
import com.solvd.library.enums.Genre;
import com.solvd.library.enums.Sex;
import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NameNotCharException;
import com.solvd.library.exceptions.NoLibraryCardException;
import com.solvd.library.exceptions.NoStockException;
import com.solvd.library.util.GroupedInterface;
import com.solvd.library.util.IGreet;
import com.solvd.library.util.IValidate;

public class Librarian extends Person implements GroupedInterface {
	private static final Logger LOGGER = LogManager.getLogger(Librarian.class);
	private static Scanner sc = new Scanner(System.in);

	public Librarian() {
	}

	public Librarian(String name, int age, int id, Sex gender) {
		super(name, age, id, gender);
	}

	@Override
	public void helpClient() {
		LOGGER.info("The book you are looking for is over there");
	}

	@Override
	public void work() {
		LOGGER.info("Organizing books");
	}

	@Override
	public void interact() {
		LOGGER.info("What can i do for you today?");
	}

	@Override
	public void greet() {
	}

	public static void greeting(IGreet thing) {
		thing.greet();
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

	public void recommendActivity() {
		LOGGER.info("Which day of the week are you interested in doing activities");
		String option = sc.nextLine();
		Day d = Day.valueOf(option.toUpperCase());
		switch (d) {
		case TUESDAY:
			Course.READING_FOR_BEGGINERS.info();
			break;
		case THURSDAY:
			Course.READING_FOR_BEGGINERS.info();
			break;
		case MONDAY:
			Course.NOVELS_CLUB.info();
			break;
		case FRIDAY:
			Course.NOVELS_CLUB.info();
			break;
		case WEDNESDAY:
			Course.WRITING.info();
			break;
		case SATURDAY:
			Course.WRITING.info();
			break;
		default:
			LOGGER.info("You should choose an option between Monday and Saturday");
			break;
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
		boolean card = ((Client) client).getLibraryCard().isOwned();

		if (card == true) {
			for (String x : taste) {
				try {
					Genre g = Genre.valueOf(x.toUpperCase());
					switch (g) {
					case CRIMES:
						LOGGER.info("If you like crimes you should read Agatha Christie");
						break;
					case PHILOSOPHY:
						LOGGER.info("If you like philosophy you should read Friederich Nietzche");
						break;
					case SCIENCE_FICTION:
						LOGGER.info("If you like you should read George Orwell");
						break;
					default:
						LOGGER.info("At the moment we dont have any genre you like");
						break;
					}
				} catch (Exception e) {
					LOGGER.info("Sorry, we dont have any " + x + " books in the library");
				}
			}
		} else {
			LOGGER.error("Sorry you do not have a valid Library Card");
		}
	};

	public void recieveNewClient() throws IdTooLongException, NoStockException, AgeNotIntException {
		String name = getClientName();
		int age = getClientAge();
		int id = getClientId();
		ArrayList<String> bookTaste = getClientBookTaste();
		boolean hasCard = getClientLibraryCard();
		LibraryCard card = new LibraryCard(name, hasCard);
		Client client = new Client(name, age, id, bookTaste, card, Sex.UNDEFINED);
		recommendBook(client);
	}

	public void showBookList(Library o) {
		LOGGER.info("Currently we have in the library");
		for (int i = 0; i < o.getBooklist().size(); i++) {
			LOGGER.info(o.getBooklist().get(i).getData().getTitle());
		}
	}
}