package library;

public class Library {
	private String name;

	private String[] bookSections;
	private String[] readingSections;
	private String[] bookList;
	private int computers;
	private int printers;

	public Library() {
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Library(String name, String[] bookSections, String[] readingSections, String[] bookList, int computers,
			int printers) {
	};

	public String[] getBookSections() {
		return bookSections;
	}

	public void setBookSections(String[] bookSections) {
		this.bookSections = bookSections;
	}

	public String[] getReadingSections() {
		return readingSections;
	}

	public void setReadingSections(String[] readingSections) {
		this.readingSections = readingSections;
	}

	public String[] getBookList() {
		return bookList;
	}

	public void setBookList(String[] bookList) {
		this.bookList = bookList;
	}

	public int getComputers() {
		return computers;
	}

	public void setComputers(int computers) {
		this.computers = computers;
	}

	public int getPrinters() {
		return printers;
	}

	public void setPrinters(int printers) {
		this.printers = printers;
	}

	public void welcome() {
		System.out.println("Welcome");
	}

}