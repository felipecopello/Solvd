package com.solvd.library.entities;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.util.CustomLinkedList;

public class Library {
	private String name;
	private ArrayList<BookSection> bookSections = new ArrayList<>();
	private ArrayList<String> readingSections = new ArrayList<>();
	private static CustomLinkedList<Book> bookList = new CustomLinkedList<Book>();
	private int computers;
	private int printers;
	private static final Logger LOGGER = LogManager.getLogger(Library.class);

	public Library() {
	};

	public Library(String name, ArrayList<String> readingSections, CustomLinkedList<Book> booklist, int computers,
			int printers) {
		setName(name);
		setReadingSections(readingSections);
		setBooklist(booklist);
		setComputers(computers);
		setPrinters(printers);
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<BookSection> getBookSection() {
		return bookSections;
	}

	public void setBookSection(ArrayList<BookSection> bookSections) {
		this.bookSections = bookSections;
	}

	public void addBookSection(BookSection b) {
		bookSections.add(b);
	}

	public ArrayList<String> getReadingSections() {
		return readingSections;
	}

	public void setReadingSections(ArrayList<String> readingSections) {
		this.readingSections = readingSections;
	}

	public void addReadingSection(String readingSection) {
		readingSections.add(readingSection);
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

	public void addBookToList(Book b) {
		bookList.insert(b);
	}

}