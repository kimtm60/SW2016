package kr.ac.hansung.domain;

public class BorrowInfo {

	
	private String memberId;
	private int bookId;
	private String borrowDate;
	private String borrowTerm;
	
	
public BorrowInfo() {
		
	}
	public BorrowInfo(String memberId, int bookId) {
	this.memberId = memberId;
	this.bookId = bookId;
}
	public BorrowInfo(String memberId, int bookId, String borrowDate, String borrowTerm) {
		super();
		this.memberId = memberId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.borrowTerm = borrowTerm;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public String getBorrowTerm() {
		return borrowTerm;
	}
	public void setBorrowTerm(String borrowTerm) {
		this.borrowTerm = borrowTerm;
	}
}
