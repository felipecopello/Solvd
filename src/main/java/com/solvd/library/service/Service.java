package com.solvd.library.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.entities.Author;
import com.solvd.library.entities.Book;
import com.solvd.library.entities.BookSection;
import com.solvd.library.entities.Client;
import com.solvd.library.entities.ClientQueue;
import com.solvd.library.entities.Librarian;
import com.solvd.library.entities.Library;
import com.solvd.library.entities.LibraryCard;
import com.solvd.library.entities.Printer;
import com.solvd.library.entities.SecurityGuard;
import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NoStockException;
import com.solvd.library.util.CustomLinkedList;
import com.solvd.library.util.IPrintable;

public class Service extends ClientQueue {
	private static final Logger LOGGER = LogManager.getLogger(Service.class);

	public static void main(String[] args) throws IdTooLongException, NoStockException, AgeNotIntException {
		Library library = new Library();
		library.welcome();

		BookSection bookSection1 = new BookSection("Connan Doyle", 200, 20, "Crimes");
		ArrayList<BookSection> bookSections = new ArrayList<>();
		bookSections.add(bookSection1);
		library.setBookSection(bookSections);

		ArrayList<Book> writtenBooks = new ArrayList<Book>();
		Author agatha = new Author("Agatha Christie", 80, 12345678, writtenBooks, "Crimes");

		Book book1 = new Book(agatha, "And Then There Were None", "Collins Crime Club", "Crimes");
		Book book2 = new Book(agatha, "Death on the Nile", "Collins Crime Club", "Crimes");
		CustomLinkedList<Book> bookList = new CustomLinkedList<Book>();
		bookList.insert(book1);
		bookList.insert(book2);
		library.setBooklist(bookList);

		ArrayList<String> bookTaste = new ArrayList<>();
		bookTaste.add("Crimes");
		bookTaste.add("Novels");

		LibraryCard librarycard = new LibraryCard("Felipe Copello", true);

		Client client1 = new Client(" Felipe Copello", 27, 01234567, bookTaste, librarycard);
		client1.greet();
		client1.askBook();

		Librarian librarian1 = new Librarian();
		librarian1.greet(client1.getName());
		librarian1.recommendBook(client1);
		librarian1.showBookList(library);
		// Next 3 functions require console input
		// librarian1.recieveNewClient();
		// librarian1.recommendActivity();
		// recieveClientQueue(2);
		library.setBooklist(client1.retrieveBook(library, "Death on the Nile"));
		librarian1.showBookList(library);

		SecurityGuard securityGuard1 = new SecurityGuard();
		securityGuard1.whereIsBook(library, "And Then There Were None");

		IPrintable lambdaPrintable = () -> LOGGER.info("Printing..");
		Printer.printThing(lambdaPrintable);
	}
}