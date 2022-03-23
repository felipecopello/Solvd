package com.solvd.Iaba;

import java.time.LocalDate;

public class LibraryCard {
	private String owner;
	private LocalDate issueDate;

	public LibraryCard() {
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate() {
		LocalDate myObj = LocalDate.now();
		myObj = this.issueDate;
	}

	public Object getOwner() {
		return owner;
	}

	public void setOwner(Object o) {
		String name = ((Clients) o).getName();
		name = this.owner;
	}

}