package com.solvd.library.entities;

import com.solvd.library.enums.Genre;

public class BookSection {
	private String name;
	private int bookCapacity;
	private int bookSelfs;
	private Genre genre;

	public BookSection() {
	};

	public BookSection(String name, int bookCapacity, int bookSelfs, Genre genre) {
		setBookCapacity(bookCapacity);
		setBookSelfs(bookSelfs);
		setGenre(genre);
		setName(name);
	};

	public int getBookCapacity() {
		return bookCapacity;
	}

	public void setBookCapacity(int bookCapacity) {
		this.bookCapacity = bookCapacity;
	}

	public int getBookSelfs() {
		return bookSelfs;
	}

	public void setBookSelfs(int bookSelfs) {
		this.bookSelfs = bookSelfs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genra) {
		this.genre = genra;
	}

}