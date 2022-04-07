package com.solvd.library.entities;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.util.CustomLinkedList;
import com.solvd.library.util.IGreet;
import com.solvd.library.util.IRead;

public class Client extends Person implements IRead, IGreet {
	private ArrayList<String> bookTaste = new ArrayList<>();
	private LibraryCard libraryCard;
	private static final Logger LOGGER = LogManager.getLogger(Client.class);

	public Client() {
	}

	public Client(String name, int age, int id, ArrayList<String> bookTaste, LibraryCard libraryCard) {
		setName(name);
		setAge(age);
		setId(id);
		setBookTaste(bookTaste);
		this.libraryCard = libraryCard;
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

	public ArrayList<String> getBookTaste() {
		return bookTaste;
	}

	public void setBookTaste(ArrayList<String> bookTaste) {
		this.bookTaste = bookTaste;
	};

	public void askBook() {
		LOGGER.info("Can you recommend me a book?");
	}

	@Override
	public void interact() {
		LOGGER.info("Beautiful morning, isnt it?");
	}

	public void printBookTaste(ArrayList<String> myArray) {
		for (int i = 0; i < myArray.size(); i++) {
			LOGGER.info(myArray.get(i) + " ");
		}
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
}