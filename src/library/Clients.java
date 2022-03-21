package library;

public class Clients extends People implements IRead {
	private String[] bookTaste;
	private boolean libraryCard;

	public Clients() {
	}

	public Clients(String name, int age, int id, String[] bookTaste, boolean libraryCard) {
		setName(name);
		setAge(age);
		setId(id);
		setBookTaste(bookTaste);
		this.libraryCard = libraryCard;
	}

	public boolean isLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(boolean libraryCard) {
		this.libraryCard = libraryCard;
	}

	public String[] getBookTaste() {
		return bookTaste;
	}

	public void setBookTaste(String[] bookTaste) {
		this.bookTaste = bookTaste;
	};

	public static void main(String[] args) {
		String[] booksTaste = { "Crimes", "Romantic novels" };
		Clients client1 = new Clients("Carlos Sanchez", 22, 3830544, booksTaste, true);
		System.out.print("You should read Agatha Christie");
		boolean card = client1.isLibraryCard();
		System.out.print(card);
		client1.read();
	}

}