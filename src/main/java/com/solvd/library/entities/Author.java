package com.solvd.library.entities;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Sex;

public class Author extends Person {
	private ArrayList<Book> writtenBooks = new ArrayList<>();
	private String genre;
	private static final Logger LOGGER = LogManager.getLogger(Author.class);

	public Author() {
	};

	public Author(String name, int age, int id, ArrayList<Book> writtenBooks, String genre, Sex gender) {
		super(name, age, id, gender);
		setWrittenBooks(writtenBooks);
		setGenre(genre);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	static void printBooks(String[] arr, int size) {
		for (int i = 0; i < size; i++)
			LOGGER.info(arr[i] + "%n");
	}

	public ArrayList<Book> getWrittenBooks() {
		return writtenBooks;
	}

	public void setWrittenBooks(ArrayList<Book> writtenBooks) {
		this.writtenBooks = writtenBooks;
	}

	@Override
	public void interact() {
		LOGGER.info("Im here to give a talk about my book.");
	}

}