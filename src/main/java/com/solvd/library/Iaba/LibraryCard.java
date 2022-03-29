package com.solvd.library.Iaba;

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
		this.issueDate = LocalDate.now();

	}

	public Object getOwner() {
		return owner;
	}

	public void setOwner(Object o) {
		this.owner = ((Client) o).getName();
	}

}