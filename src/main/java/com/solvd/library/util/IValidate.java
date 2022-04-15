package com.solvd.library.util;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Genre;
import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NameNotCharException;
import com.solvd.library.exceptions.NoLibraryCardException;
import com.solvd.library.exceptions.NoStockException;

public interface IValidate {
	static final Logger LOGGER = LogManager.getLogger(IValidate.class);

	public static String validateName(char[] ch) throws NameNotCharException {
		String validatedName = new String();
		for (char a : ch) {
			if (Character.isLetter(a)) {
				validatedName = validatedName + a;
			} else {
				LOGGER.error(a + " is not a letter");
				throw new NameNotCharException("There can only be letters in Name field");
			}
		}
		return validatedName;
	}

	public static int validateAge(char[] age) throws AgeNotIntException {
		StringBuilder str = new StringBuilder();
		for (char i : age) {
			if (Character.isDigit(i)) {
				str.append(i);
			} else {
				throw new AgeNotIntException("Age field can only be ints");
			}
		}
		String vs = str.toString();
		int validatedAge = Integer.parseInt(vs);
		return validatedAge;
	}

	public static String validateId(String id) throws IdTooLongException {
		if (id.length() == 8) {
			LOGGER.info(id + " is a valid Id");
			return id;
		} else {
			throw new IdTooLongException("The Id should be 8 numbers");
		}
	}

	public static boolean validateBookTaste(ArrayList<Genre> clientBookTaste) throws NoStockException {
		boolean genreAvailable = false;
		for (Genre t : clientBookTaste) {
			try {
				if (clientBookTaste.contains(t)) {
					genreAvailable = true;
					LOGGER.info("We actually have " + t + " available");
				}
				;
			} catch (Exception e) {
				LOGGER.info("Sorry, we dont have any " + t + " books in the library");
			}
		}
		if (genreAvailable == false) {
			throw new NoStockException("None of the books you like are in stock");
		}
		return genreAvailable;
	}

	public static boolean validateLibraryCard(String card) {
		if (card.equalsIgnoreCase("yes")) {
			return true;
		} else {
			throw new NoLibraryCardException("Sorry, you do not have a valid Library Card");
		}
	}
}
