package com.solvd.library.java;

import java.util.ArrayList;

public class BookSection {
	private int bookCapacity;
	private int bookSelfs;
	private static ArrayList<String> genrasIncluded = new ArrayList<>();

	BookSection() {
	};

	BookSection(int bookCapacity, int bookSelfs, ArrayList<String> genrasIncluded) {
		setBookCapacity(bookCapacity);
		setBookSelfs(bookSelfs);
		setGenrasIncluded(genrasIncluded);
	};

	public int getBookCapacity() {
		return bookCapacity;
	}

	public void setBookCapacity(int bookCapacity) {
		this.bookCapacity = bookCapacity;
	}

	public int getBookSelfs() {
		return bookSelfs;
	}

	public void setBookSelfs(int bookSelfs) {
		this.bookSelfs = bookSelfs;
	}

	public static ArrayList<String> getGenrasIncluded() {
		return genrasIncluded;
	}

	public static void setGenrasIncluded(ArrayList<String> genrasIncluded) {
		BookSection.genrasIncluded = genrasIncluded;
	}

}