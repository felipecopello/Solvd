package com.solvd.library.Iaba;

import com.solvd.library.util.IGreet;
import com.solvd.library.util.IRead;

public class Client extends Person implements IRead, IGreet {
	private String[] bookTaste;
	private boolean libraryCard;

	public Client() {
	}

	public Client(String name, int age, int id, String[] bookTaste, boolean libraryCard) {
		setName(name);
		setAge(age);
		setId(id);
		setBookTaste(bookTaste);
		this.libraryCard = libraryCard;
	}

	public boolean getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(boolean libraryCard) {
		this.libraryCard = libraryCard;
	}

	public String[] getBookTaste() {
		return bookTaste;
	}

	public void setBookTaste(String[] bookTaste) {
		this.bookTaste = bookTaste;
	};

	public void askBook() {
		System.out.println("Hi! can you recommend me a book?");
	}

	public void printBookTaste(String[] myArray) {
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
	}
}