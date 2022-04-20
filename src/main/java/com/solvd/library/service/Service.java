package com.solvd.library.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
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

		Book bookNone = new Book(agatha, "And Then There Were None", "Collins Crime Club", Genre.CRIMES);
		Book bookNile = new Book(agatha, "Death on the Nile", "Collins Crime Club", Genre.CRIMES);

		agatha.addWrittenBook(bookNone);
		agatha.addWrittenBook(bookNile);

		publicLibrary.addBookToList(bookNone);
		publicLibrary.addBookToList(bookNile);

		LibraryCard libraryCardFelipe = new LibraryCard("Felipe Copello", true);
		LibraryCard libraryCardPepe = new LibraryCard("Pepe", false);
		LibraryCard libraryCardMariana = new LibraryCard("Mariana", true);

		Client clientPepe = new Client("Pepe", 60, 01222567, libraryCardPepe, Sex.MALE);
		Client clientFelipe = new Client(" Felipe Copello", 27, 01234567, libraryCardFelipe, Sex.MALE);
		Client clientMariana = new Client("Mariana", 40, 11122233, libraryCardMariana, Sex.FEMALE);
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
		securityPedro.addClient(clientMariana);

		Consumer<HashSet<Client>> checkLibraryCard = (HashSet<Client> x) -> x.stream()
				.filter(client -> client.getLibraryCard().isOwned() == true)
				.forEach((client -> LOGGER.info(client.getName() + " has a valid library card")));
		securityPedro.clientsCardCheck(checkLibraryCard);

		securityPedro.whereIsBook(publicLibrary, "Death on the Nile");
		// Next 3 functions require console input
		// librarianSusan.recommendActivity();
		// librarianSusan.recieveNewClient();
		// recieveClientQueue(2);
		publicLibrary.setBooklist(clientFelipe.retrieveBook(publicLibrary, "Death on the Nile"));

		Printer lenovoPrinter = new Printer();
		lenovoPrinter.setToPrint(bookNone.getTitle() + " was written by " + bookNone.getAuthor().getName());
		IPrintable<String> lambdaPrintable = x -> LOGGER.info(x);
		lenovoPrinter.printThing(lambdaPrintable);

		ICalculate avg = (a, b) -> (a.getAge() + b.getAge()) / 2;
		LOGGER.info("The average age of this clients is " + Client.operate(clientFelipe, clientPepe, avg));

		BiFunction<HashSet<Client>, Sex, HashSet<Client>> filterBySex = (HashSet<Client> x, Sex s) -> {
			x.stream().filter(client -> client.getGender() == s).collect(Collectors.toList());
			return x;
		};

		BiFunction<HashSet<Client>, Sex, HashSet<Client>> filterBySexAndPrint = (HashSet<Client> x, Sex s) -> {
			x.stream().filter(client -> client.getGender() == s).collect(Collectors.toList())
					.forEach(client -> LOGGER.info(client.getName()));
			return x;
		};

		BiFunction<HashSet<Client>, Sex, HashSet<Client>> filterBySexAndWrite = (HashSet<Client> x, Sex s) -> {
			x.stream().filter(client -> client.getGender() == s).collect(Collectors.toList());
			try {
				StringBuffer sb = new StringBuffer();
				BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("serviceOutput.txt")));
				x.forEach(e -> {
					sb.append(String.format(e.getName() + "\n"));
				});
				bwr.write(sb.toString());
				bwr.flush();
				bwr.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
			return x;
		};

		securityPedro.filterClients(filterBySex, Sex.MALE);
		securityPedro.filterClients(filterBySexAndPrint, Sex.MALE);
		securityPedro.filterClients(filterBySexAndWrite, Sex.MALE);
	}

}