package kr.ac.hansung.domain;

public class Book {

	private int bookId;
	private String bookName;
	private int bookCount;
	private int bookType;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public int getBookType() {
		return bookType;
	}

	public void setBookType(int bookType) {
		this.bookType = bookType;
	}

	public Book() {

	}

	public Book(int bookId, String bookName, int bookCount, int bookType) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookCount = bookCount;
		this.bookType = bookType;
	}
}
