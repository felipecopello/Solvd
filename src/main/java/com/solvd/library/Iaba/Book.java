package com.solvd.library.Iaba;

import java.time.LocalDate;

public class Book {
	private Author author;
	private String title;
	private String editorial;
	private LocalDate publishedIn;

	Book() {
	};

	public Book(Author author, String title, String editorial) {
		setAuthor(author);
		setTitle(title);
		setEditorial(editorial);
		setPublishedIn(LocalDate.now());
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
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

}