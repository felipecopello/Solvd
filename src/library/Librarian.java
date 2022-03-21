package library;

public class Librarian extends People implements GroupedInterface {
	public Librarian() {
	}

	public Librarian(String name, int age, int id) {
		super(name, age, id);
	}

	public void helpClient() {
		System.out.format("%nThe book you are looking for is over there");
	}

	public void work() {
		System.out.format("%nOrganizing books");
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

		IHelp l = new Librarian();
		l.helpClient();
		Librarian librarian1 = new Librarian();
		librarian1.read();
		librarian1.work();
	}
}