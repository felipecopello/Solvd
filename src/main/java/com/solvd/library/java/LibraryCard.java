package com.solvd.library.java;

import java.time.LocalDate;

public class LibraryCard {
	private String owner;
	private LocalDate issueDate;
	private boolean owned;

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

	public boolean isOwned() {
		return owned;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}

}