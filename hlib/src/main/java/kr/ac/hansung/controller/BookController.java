package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.domain.Book;
import kr.ac.hansung.domain.BorrowInfo;
import kr.ac.hansung.service.BookService;

@Controller
public class BookController {

	private BookService bookService;
	
	@Autowired
	public void setMemberervice(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("borrowList")
	public String showBorrowList(Model model, HttpSession session) {
		List<BorrowInfo> borrowInfo  = bookService.selectBorrowList((String)session.getAttribute("memberId"));
		model.addAttribute("borrowInfo", borrowInfo);
		return "borrowList";

	}
	
	@RequestMapping("bookList")
	public String showBookList(Model model) {
		
		List<Book> books = bookService.selectBookList();
		model.addAttribute("books", books);
		return "bookList";

	}
	
	
	
	@RequestMapping("borrow/{bookId}")
	public String requestBorrow(@PathVariable("bookId") int bookId, HttpSession session) {
		
		String mv;
		String memberId=(String) session.getAttribute("memberId");
		mv = bookService.doBorrow(memberId,bookId);
		System.out.println(mv);
		return mv;

	}
	
}
