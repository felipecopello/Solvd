package library;

public class EntryPoint {
	public static void main(String[] args) {
		String[] booksTaste = { "Crimes", "Romantic novels" };
		Clients client1 = new Clients("Carlos Sanchez", 22, 3830544, booksTaste, true);
		client1.askBook();

		Librarian.recommendBook(client1);
	}
}