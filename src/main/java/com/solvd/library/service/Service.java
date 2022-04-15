package com.solvd.library.service;

import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.entities.Author;
import com.solvd.library.entities.Book;
import com.solvd.library.entities.BookSection;
import com.solvd.library.entities.Client;
import com.solvd.library.entities.Librarian;
import com.solvd.library.entities.Library;
import com.solvd.library.entities.LibraryCard;
import com.solvd.library.entities.Printer;
import com.solvd.library.entities.SecurityGuard;
import com.solvd.library.enums.Genre;
import com.solvd.library.enums.Sex;
import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NoStockException;
import com.solvd.library.util.ICalculate;
import com.solvd.library.util.IGreet;
import com.solvd.library.util.IPrintable;

public class Service {
	private static final Logger LOGGER = LogManager.getLogger(Service.class);

	public static void main(String[] args) throws IdTooLongException, NoStockException, AgeNotIntException {
		Library publicLibrary = new Library();
		publicLibrary.welcome();

		BookSection connanDoyleBookSections = new BookSection("Connan Doyle", 200, 20, Genre.CRIMES);
		publicLibrary.addBookSection(connanDoyleBookSections);

		Author agatha = new Author("Agatha Christie", 80, 12345678, Genre.CRIMES, Sex.FEMALE);

		Book book1 = new Book(agatha, "And Then There Were None", "Collins Crime Club", Genre.CRIMES);
		Book book2 = new Book(agatha, "Death on the Nile", "Collins Crime Club", Genre.CRIMES);

		agatha.addWrittenBook(book1);
		agatha.addWrittenBook(book2);

		publicLibrary.addBookToList(book1);
		publicLibrary.addBookToList(book2);

		LibraryCard libraryCardFelipe = new LibraryCard("Felipe Copello", true);
		LibraryCard libraryCardPepe = new LibraryCard("Pepe", false);

		Client clientPepe = new Client("Pepe", 60, 01222567, libraryCardPepe, Sex.MALE);
		Client clientFelipe = new Client(" Felipe Copello", 27, 01234567, libraryCardFelipe, Sex.MALE);
		clientFelipe.addToBookTaste(Genre.CRIMES);
		clientFelipe.addToBookTaste(Genre.NOVELS);
		clientFelipe.greet();
		clientFelipe.askBook();

		Librarian librarianSusan = new Librarian();
		IGreet lambdaGreeting = () -> LOGGER.info("Hello" + clientFelipe.getName());
		Librarian.greeting(lambdaGreeting);
		librarianSusan.recommendBook(clientFelipe);
		librarianSusan.showBookList(publicLibrary);

		SecurityGuard securityPedro = new SecurityGuard();
		securityPedro.addClient(clientFelipe);
		securityPedro.addClient(clientPepe);

		Consumer<HashSet<Client>> checkLibraryCard = (HashSet<Client> x) -> x.stream()
				.filter(client -> client.getLibraryCard().isOwned() == true)
				.forEach((client -> LOGGER.info(client.getName() + " has a valid library card")));
		securityPedro.clientsCardCheck(checkLibraryCard);

		securityPedro.whereIsBook(publicLibrary, "Death on the Nile");
		// Next 3 functions require console input
		// librarianSusan.recieveNewClient();
		// librarianSusan.recommendActivity();
		// recieveClientQueue(2);
		publicLibrary.setBooklist(clientFelipe.retrieveBook(publicLibrary, "Death on the Nile"));

		Printer lenovoPrinter = new Printer();
		lenovoPrinter.setToPrint(book1.getTitle() + " was written by " + book1.getAuthor());
		IPrintable<String> lambdaPrintable = x -> LOGGER.info(x);
		lenovoPrinter.printThing(lambdaPrintable);

		ICalculate avg = (a, b) -> (a.getAge() + b.getAge()) / 2;
		LOGGER.info("The average age of this clients is " + Client.operate(clientFelipe, clientPepe, avg));

		BiFunction<HashSet<Client>, Sex, List<Client>> filterBySex = (HashSet<Client> x, Sex s) -> x.stream()
				.filter(client -> client.getGender() == s).collect(Collectors.toList());

		BiFunction<HashSet<Client>, Sex, List<Client>> filterBySexAndPrint = (HashSet<Client> x, Sex s) -> {
			List<Client> list = x.stream().filter(client -> client.getGender() == s).collect(Collectors.toList());
			LOGGER.info("The male clients are: ");
			for (Client c : list) {
				LOGGER.info(c.getName());
			}
			return list;
		};

		BiFunction<HashSet<Client>, Sex, List<Client>> filterBySexAgeOver30 = (HashSet<Client> x, Sex s) -> {
			List<Client> list = x.stream().filter(client -> client.getGender() == s && client.getAge() > 30)
					.collect(Collectors.toList());
			return list;
		};

		securityPedro.filterClients(filterBySex, Sex.MALE);
		securityPedro.filterClients(filterBySexAndPrint, Sex.MALE);
		securityPedro.filterClients(filterBySexAgeOver30, Sex.MALE);
	}

}