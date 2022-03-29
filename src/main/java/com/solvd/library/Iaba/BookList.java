package com.solvd.library.Iaba;

import com.solvd.library.util.CustomLinkedList;
import com.solvd.library.util.Node;

public class BookList {
	private static CustomLinkedList<Book> books = new CustomLinkedList<Book>();

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book("Felipe", "mybook", "planeta");

		books.insertAtStart(book1);
		books.insertAtStart(book2);
		Node<Book> b = books.get(0);
		System.out.println(b.getData().getTitle());

	}
}