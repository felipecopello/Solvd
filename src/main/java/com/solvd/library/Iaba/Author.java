package com.solvd.library.Iaba;

import java.util.HashMap;
import java.util.Map;

public class Author extends People {
	private Map<String, String> writtenBooks = new HashMap<>();
	private String genre;

	public Author() {
	};

	public Author(String name, int age, int id, Map<String, String> writtenBooks, String genre) {
		super(name, age, id);
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
			System.out.format(arr[i] + "%n");
	}

	public Map<String, String> getWrittenBooks() {
		return writtenBooks;
	}

	public void setWrittenBooks(Map<String, String> writtenBooks) {
		this.writtenBooks = writtenBooks;
	}

}