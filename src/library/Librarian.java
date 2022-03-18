package library;

public class Librarian extends People {
	public Librarian() {
	}

	public Librarian(String name, int age, int id) {
	}

	public static void recommendBook(Object o) {
		String[] taste = ((Clients) o).getBookTaste();
		boolean card = ((Clients) o).isLibraryCard();
		String Crimes = "Crimes";
		String Philosophy = "Philosophy";
		String scyFy = "Science Fiction";

		if (card == true) {
			for (String x : taste) {
				if (x == Crimes) {
					System.out.format("%nIf you like " + Crimes + " you should read Agatha Christie");
				} else if (x == Philosophy) {
					System.out.format("%nIf you like " + Philosophy + " you should read Friederich Nietzche");
				} else if (x == scyFy) {
					System.out.format("%nYou should read George Orwell");
				}
			}
		} else {
			System.out.format("%nSorry you do not have a valid Library Card");
		}
	};

	public static void main(String[] args) {
		String[] booksTaste1 = { "Crimes", "Romantic novels" };
		Clients client1 = new Clients("Carlos Sanchez", 22, 3830544, booksTaste1, true);

		String[] booksTaste2 = { "Philosophy", "Romantic novels" };
		Clients client2 = new Clients("Pepe Gutierrez", 66, 8870533, booksTaste2, true);

		String[] booksTaste3 = { "Philosophy", "Romantic novels" };
		Clients client3 = new Clients("Pepe Gutierrez", 66, 8870533, booksTaste3, false);
		recommendBook(client1);
		recommendBook(client2);
		recommendBook(client3);
	}
}