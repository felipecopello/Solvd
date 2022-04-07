package com.solvd.library.java;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.util.CustomLinkedList;

public class Library {
	private String name;
	private ArrayList<String> bookSections = new ArrayList<>();
	private ArrayList<String> readingSections = new ArrayList<>();
	private static CustomLinkedList<Book> bookList = new CustomLinkedList<Book>();
	private int computers;
	private int printers;
	private static final Logger LOGGER = LogManager.getLogger(Library.class);

	public Library() {
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Library(String name, String[] bookSections, String[] readingSections, CustomLinkedList<Book> booklist,
			int computers, int printers) {
	};

	public ArrayList<String> getBookSections() {
		return bookSections;
	}

	public void setBookSections(ArrayList<String> bookSections) {
		this.bookSections = bookSections;
	}

	public ArrayList<String> getReadingSections() {
		return readingSections;
	}

	public void setReadingSections(ArrayList<String> readingSections) {
		this.readingSections = readingSections;
	}

	public int getComputers() {
		return computers;
	}

	public void setComputers(int computers) {
		this.computers = computers;
	}

	public int getPrinters() {
		return printers;
	}

	public void setPrinters(int printers) {
		this.printers = printers;
	}

	public void welcome() {
		LOGGER.info("Welcome");
	}

	public CustomLinkedList<Book> getBooklist() {
		return bookList;
	}

	public void setBooklist(CustomLinkedList<Book> booklist) {
		Library.bookList = booklist;
	}

}