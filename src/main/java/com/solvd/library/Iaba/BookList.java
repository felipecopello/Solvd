package com.solvd.library.Iaba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.util.CustomLinkedList;
import com.solvd.library.util.Node;

public class BookList {
	private static CustomLinkedList<Book> books = new CustomLinkedList<Book>();
	private static final Logger LOGGER = LogManager.getLogger(BookList.class);

	public static void main(String[] args) {
		Book book1 = new Book();

		books.insertAtStart(book1);
		Node<Book> b = books.get(0);
		LOGGER.info(b.getData().getTitle());

	}
}