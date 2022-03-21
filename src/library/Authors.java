package library;

public class Authors extends People {
	private String[] writtenBooks;
	private String genre;

	public Authors() {
	};

	public Authors(String name, int age, int id, String[] writtenBooks, String genre) {
		super(name, age, id);
		setWrittenBooks(writtenBooks);
		setGenre(genre);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String[] getWrittenBooks() {
		return writtenBooks;
	}

	public void setWrittenBooks(String[] writtenBooks) {
		this.writtenBooks = writtenBooks;
	}

	static void printBooks(String[] arr, int size) {
		for (int i = 0; i < size; i++)
			System.out.format(arr[i] + "%n");

	}

	public static void main(String[] args) {
		String[] books = { "And Then There Were None", "Five Little Pigs" };
		Authors author1 = new Authors("Agatha Christie", 80, 2554689, books, "Crimes") {
		};

		String[] books2 = { "1984", "Animal Farm" };
		Authors author2 = new Authors("George Orwell", 95, 1234567, books2, "Science Fiction") {
		};

		String[] books3 = { "Beyond Good and Evil", "The Birth of Tragedy" };
		Authors author3 = new Authors("Friedrich Nietzsche", 85, 0123456, books3, "Philosophy") {
		};

		System.out.println(author1.getName());
		System.out.println(author1.getId());
		System.out.println(author1.getAge());
		printBooks(author1.getWrittenBooks(), 2);

		System.out.println(author2.getName());
		System.out.println(author2.getId());
		System.out.println(author2.getAge());
		printBooks(author2.getWrittenBooks(), 2);

		System.out.println(author3.getName());
		System.out.println(author3.getId());
		System.out.println(author3.getAge());
		printBooks(author3.getWrittenBooks(), 2);
	}
}