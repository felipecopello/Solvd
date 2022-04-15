package com.solvd.library.entities;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Sex;
import com.solvd.library.util.CustomLinkedList;

public abstract class Person {

	private static final Logger LOGGER = LogManager.getLogger(Person.class);
	private String name;
	private int age;
	private int id;
	private Sex gender;

	public Person() {
	};

	public Person(String name, int age, int id, Sex gender) {
		setName(name);
		setAge(age);
		setId(id);
		setGender(gender);
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract void interact();

	public Book findBook(Library o, String title) {
		CustomLinkedList<Book> list = o.getBooklist();
		Book book = new Book();
		try {
			for (int i = 0; i < list.size(); i++) {
				String b = list.get(i).getData().getTitle();
				if (b.equals(title)) {
					book = list.get(i).getData();
					return book;
				}
			}
		} catch (RuntimeException e) {
			e.getMessage();
		}
		return book;
	}

	public void whereIsBook(Library o, String title) {
		Book book = findBook(o, title);
		if (book.getTitle().equals(title)) {
			ArrayList<BookSection> bookSections = o.getBookSection();
			for (BookSection b : bookSections) {
				if (b.getGenre().equals(book.getGenre())) {
					LOGGER.info("The book " + "-" + title + "-" + " is in Section: " + b.getName());
				}
			}
		}
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}
}