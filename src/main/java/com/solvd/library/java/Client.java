package com.solvd.library.java;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.util.IGreet;
import com.solvd.library.util.IRead;

public class Client extends Person implements IRead, IGreet {
	private ArrayList<String> bookTaste = new ArrayList<>();
	private boolean libraryCard;
	private static final Logger LOGGER = LogManager.getLogger(Client.class);

	public Client() {
	}

	public Client(String name, int age, int id, ArrayList<String> bookTaste, boolean libraryCard) {
		setName(name);
		setAge(age);
		setId(id);
		setBookTaste(bookTaste);
		this.libraryCard = libraryCard;
	}

	public void greet() {
		LOGGER.info("Hi! my name is" + getName());
	}

	public boolean getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(boolean libraryCard) {
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

	public void printBookTaste(ArrayList<String> myArray) {
		for (int i = 0; i < myArray.size(); i++) {
			LOGGER.info(myArray.get(i) + " ");
		}
	}
}