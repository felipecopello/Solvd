package com.solvd.library.enums;

public enum Genre {
	CRIMES("Crimes"), PHILOSOPHY("Philosophy"), SCIENCE_FICTION("Science Fiction");

	private String genre;

	Genre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}
}
