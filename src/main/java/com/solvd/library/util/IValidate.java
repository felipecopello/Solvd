package com.solvd.library.util;

import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NameNotCharException;
import com.solvd.library.exceptions.NoLibraryCardException;
import com.solvd.library.exceptions.NoStockException;

public interface IValidate {

	public static String validateName(char[] ch) throws NameNotCharException {
		String validatedName = new String();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetter(ch[i])) {
				char a = ch[i];
				validatedName = validatedName + a;
			} else {
				System.out.println(ch[i] + " is not a letter");
				throw new NameNotCharException("There can only be letters in Name field");
			}
		}
		return validatedName;
	}

	public static int validateAge(char[] age) throws AgeNotIntException {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < age.length; i++) {
			if (Character.isDigit(age[i])) {
				str.append(age[i]);
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
			System.out.println(id + " is a valid Id");
			return id;
		} else {
			throw new IdTooLongException("The Id should be 8 numbers");
		}
	}

	public static boolean validateBookTaste(String[] taste) throws NoStockException {
		String[] availableGenres = { "Crimes", "Science Fiction", "Philosophy" };
		boolean genreAvailable = false;
		for (int i = 0; i < taste.length; i++) {
			for (int j = 0; j < availableGenres.length; j++) {
				if (taste[i].equalsIgnoreCase(availableGenres[j])) {
					genreAvailable = true;
					System.out.println("We actually have " + taste[i] + " available");
				}
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
