package com.solvd.library.entities;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Genre;
import com.solvd.library.enums.Sex;

public class Author extends Person {
	private ArrayList<Book> writtenBooks = new ArrayList<>();
	private Genre genre;
	private static final Logger LOGGER = LogManager.getLogger(Author.class);

	public Author() {
	};

	public Author(String name, int age, int id, Genre genre, Sex gender) {
		super(name, age, id, gender);
		setGenre(genre);
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	static void printBooks(ArrayList<Book> arr) {
		arr.stream().forEach(book -> LOGGER.info(book.getTitle()));
	}

	public ArrayList<Book> getWrittenBooks() {
		return writtenBooks;
	}

	public void setWrittenBooks(ArrayList<Book> writtenBooks) {
		this.writtenBooks = writtenBooks;
	}

	public void addWrittenBook(Book b) {
		writtenBooks.add(b);
	}

	@Override
	public void interact() {
		LOGGER.info("Im here to give a talk about my book.");
	}

}