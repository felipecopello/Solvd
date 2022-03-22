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

}