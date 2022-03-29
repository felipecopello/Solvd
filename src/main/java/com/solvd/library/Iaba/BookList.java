package com.solvd.library.Iaba;

import java.util.ArrayList;

public class BookList {
	private static ArrayList<Object> books = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < books.size(); i++) {
			System.out.println(((Book) books.get(i)).getTitle());
		}
	}
}
