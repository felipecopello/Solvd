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
		Library publicLibrary = new Library();
		publicLibrary.welcome();

		BookSection connanDoyleBookSections = new BookSection("Connan Doyle", 200, 20, "Crimes");
		ArrayList<BookSection> bookSections = new ArrayList<>();
		bookSections.add(connanDoyleBookSections);
		publicLibrary.setBookSection(bookSections);

		ArrayList<Book> writtenBooks = new ArrayList<Book>();
		Author agatha = new Author("Agatha Christie", 80, 12345678, writtenBooks, "Crimes");

		Book book1 = new Book(agatha, "And Then There Were None", "Collins Crime Club", "Crimes");
		Book book2 = new Book(agatha, "Death on the Nile", "Collins Crime Club", "Crimes");
		CustomLinkedList<Book> bookList = new CustomLinkedList<Book>();
		bookList.insert(book1);
		bookList.insert(book2);
		publicLibrary.setBooklist(bookList);

		ArrayList<String> bookTaste = new ArrayList<>();
		bookTaste.add("Crimes");
		bookTaste.add("Novels");

		LibraryCard libraryCardFelipe = new LibraryCard("Felipe Copello", true);

		Client clientFelipe = new Client(" Felipe Copello", 27, 01234567, bookTaste, libraryCardFelipe);
		clientFelipe.greet();
		clientFelipe.askBook();

		Librarian librarianSusan = new Librarian();
		librarianSusan.greet(clientFelipe.getName());
		librarianSusan.recommendBook(clientFelipe);
		librarianSusan.showBookList(publicLibrary);
		// Next 3 functions require console input
		// librarian1.recieveNewClient();
		librarianSusan.recommendActivity();
		// recieveClientQueue(2);
		publicLibrary.setBooklist(clientFelipe.retrieveBook(publicLibrary, "Death on the Nile"));
		librarianSusan.showBookList(publicLibrary);

		SecurityGuard securityPedro = new SecurityGuard();
		securityPedro.whereIsBook(publicLibrary, "And Then There Were None");

		IPrintable lambdaPrintable = () -> LOGGER.info("Printing..");
		Printer.printThing(lambdaPrintable);
	}
}