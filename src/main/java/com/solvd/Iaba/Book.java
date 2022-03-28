package com.solvd.Iaba;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
	private String author;
	private String title;
	private String editorial;
	private LocalDate publishedIn;

	Book() {
	};

	Book(String author, String title, String editorial) {
		setAuthor(author);
		setTitle(title);
		setEditorial(editorial);
		setPublishedIn(LocalDate.now());
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getPublishedIn() {
		return publishedIn;
	}

	public void setPublishedIn(LocalDate publishedIn) {
		this.publishedIn = publishedIn;
	}

	public static void listBooks() {
		Book book1 = new Book("John Katzenbach", "El psicoanalista", "Planeta");
		Book book2 = new Book("Joe Hill", "Fantasmas", "Suma");
		Book book3 = new Book("Jorge Fernandez", "El puñal", "ABC");
		ArrayList<Object> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);

		for (int i = 0; i < books.size(); i++) {
			System.out.println(((Book) books.get(i)).getTitle());
		}
	}
}