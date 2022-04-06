package com.solvd.library.service;

import java.util.ArrayList;

import com.solvd.library.Iaba.Author;
import com.solvd.library.Iaba.Book;
import com.solvd.library.Iaba.Client;
import com.solvd.library.Iaba.ClientQueue;
import com.solvd.library.Iaba.Librarian;
import com.solvd.library.Iaba.Library;
import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NoStockException;
import com.solvd.library.util.CustomLinkedList;

public class Service extends ClientQueue {
	public static void main(String[] args) throws IdTooLongException, NoStockException, AgeNotIntException {
		Library library = new Library();
		library.welcome();

		ArrayList<Book> writtenBooks = new ArrayList<Book>();
		Author agatha = new Author("Agatha Christie", 80, 12345678, writtenBooks, "Crimes");

		Book book1 = new Book(agatha, "And Then There Were None", "Collins Crime Club");
		Book book2 = new Book(agatha, "Death on the Nile", "Collins Crime Club");
		CustomLinkedList<Book> bookList = new CustomLinkedList<Book>();
		bookList.insert(book1);
		bookList.insert(book2);
		library.setBooklist(bookList);

		ArrayList<String> bookTaste = new ArrayList<>();
		bookTaste.add("Crimes");
		bookTaste.add("Novels");

		Client client1 = new Client(" Felipe Copello", 27, 01234567, bookTaste, true);
		client1.greet();
		client1.askBook();

		Librarian librarian1 = new Librarian();
		librarian1.greet(client1.getName());
		librarian1.recommendBook(client1);
		librarian1.showBookList(library);
		// librarian1.recieveNewClient();
		librarian1.recommendActivity();
	}
}