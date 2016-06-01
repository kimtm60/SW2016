package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.dao.BookDAO;
import kr.ac.hansung.dao.BorrowInfoDAO;
import kr.ac.hansung.dao.MemberDAO;
import kr.ac.hansung.domain.Book;
import kr.ac.hansung.domain.BorrowInfo;

@Service("BookService")
public class BookService {

	
	private BookDAO bookDAO;
	private BorrowInfoDAO borrowInfoDAO;
	private MemberDAO memberDAO;

	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Autowired
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	@Autowired
	public void setBorrowInfoDAO(BorrowInfoDAO borrowInfoDAO) {
		this.borrowInfoDAO = borrowInfoDAO;
	}

	public List<Book> selectBookList() {
		return bookDAO.getBooks();
	}

	@Transactional
	public String doBorrow(String memberId, int bookId) {
		Book book = bookDAO.getBook(bookId);
		if(book.getBookCount()!=0){
			book.setBookCount(book.getBookCount()-1);
			bookDAO.update(book);
			BorrowInfo borrowInfo = new BorrowInfo(memberId,bookId);
			borrowInfoDAO.insertBorrowInfo(borrowInfo);
			memberDAO.incrementCoffeePoint(memberId);
		return "redirect:/home";	
		}
			else{
				return "failBorrow";
			}
			
			
			
		
	}

	public List<BorrowInfo> selectBorrowList(String memberId) {
		return borrowInfoDAO.getBorrowInfos(memberId);
	}
}
