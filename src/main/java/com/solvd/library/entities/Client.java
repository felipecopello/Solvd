package com.solvd.library.entities;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Genre;
import com.solvd.library.enums.Sex;
import com.solvd.library.util.CustomLinkedList;
import com.solvd.library.util.ICalculate;
import com.solvd.library.util.IGreet;
import com.solvd.library.util.IRead;

public class Client extends Person implements IRead, IGreet {
	private ArrayList<Genre> bookTaste = new ArrayList<>();
	private LibraryCard libraryCard;
	private static final Logger LOGGER = LogManager.getLogger(Client.class);

	public Client() {
	}

	public Client(String name, int age, int id, ArrayList<Genre> bookTaste, LibraryCard libraryCard, Sex gender) {
		setName(name);
		setAge(age);
		setId(id);
		setBookTaste(bookTaste);
		this.libraryCard = libraryCard;
		setGender(gender);
	}

	public Client(String name, int age, int id, LibraryCard libraryCard, Sex gender) {
		setName(name);
		setAge(age);
		setId(id);
		this.libraryCard = libraryCard;
		setGender(gender);
	}

	public void greet() {
		LOGGER.info("Hi! my name is" + getName());
	}

	public LibraryCard getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(LibraryCard libraryCard) {
		this.libraryCard = libraryCard;
	}

	public ArrayList<Genre> getBookTaste() {
		return bookTaste;
	}

	public void setBookTaste(ArrayList<Genre> bookTaste) {
		this.bookTaste = bookTaste;
	};

	public void addToBookTaste(Genre t) {
		bookTaste.add(t);
	}

	public void askBook() {
		LOGGER.info("Can you recommend me a book?");
	}

	@Override
	public void interact() {
		LOGGER.info("Beautiful morning, isnt it?");
	}

	public void printBookTaste(ArrayList<Genre> myArray) {
		myArray.stream().forEach(taste -> LOGGER.info(taste));
	}

	public CustomLinkedList<Book> retrieveBook(Library o, String title) {
		LOGGER.info("I would like to take " + title);
		CustomLinkedList<Book> list = o.getBooklist();
		for (int i = 0; i < list.size(); i++) {
			String b = list.get(i).getData().getTitle();
			if (b.equals(title)) {
				list.deleteAt(i);
			}
		}
		return list;
	}

	public static int operate(Client a, Client b, ICalculate c) {
		return c.operation(a, b);
	}

}