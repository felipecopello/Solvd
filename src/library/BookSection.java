package library;

public class BookSection {
	private int bookCapacity;
	private int bookSelfs;
	private String[] genrasIncluded;

	BookSection() {
	};

	BookSection(int bookCapacity, int bookSelfs, String[] genrasIncluded) {
		setBookCapacity(bookCapacity);
		setBookSelfs(bookSelfs);
		setGenrasIncluded(genrasIncluded);
	};

	public int getBookCapacity() {
		return bookCapacity;
	}

	public void setBookCapacity(int bookCapacity) {
		this.bookCapacity = bookCapacity;
	}

	public int getBookSelfs() {
		return bookSelfs;
	}

	public void setBookSelfs(int bookSelfs) {
		this.bookSelfs = bookSelfs;
	}

	public String[] getGenrasIncluded() {
		return genrasIncluded;
	}

	public void setGenrasIncluded(String[] genrasIncluded) {
		this.genrasIncluded = genrasIncluded;
	}

	public static void main(String[] args) {
		String[] genras = { "Crimes", "Philosophy" };
		BookSection sector1 = new BookSection(300, 15, genras);
		System.out.println(sector1.getBookCapacity());
	}
}