package com.solvd.library.entities;

public class BookSection {
	private String name;
	private int bookCapacity;
	private int bookSelfs;
	private String genre;

	public BookSection() {
	};

	public BookSection(String name, int bookCapacity, int bookSelfs, String genre) {
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genra) {
		this.genre = genra;
	}

}