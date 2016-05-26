package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.domain.Book;

public class BookMapper implements RowMapper<Book> {


		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			Book book = new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setBookName(rs.getString("bookName"));
			book.setBookCount(rs.getInt("bookCount"));
			book.setBookType(rs.getInt("bookType"));
		
			return book;
		
	}
	
}
