package library;

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
		name = owner;
	}

	public static void main(String[] args) {
		String[] booksTaste1 = { "Crimes", "Romantic novels" };
		Clients client1 = new Clients("Carlos Sanchez", 22, 3830544, booksTaste1, true);
		LibraryCard librarycard1 = new LibraryCard();
		librarycard1.setOwner(client1);
		librarycard1.setIssueDate();
	}
}