package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.hansung.domain.Book;


@Component("bookDAO")
public class BookDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<Book> getBooks() {
		
		String sqlStatement = "select * from book";
		return jdbcTemplateObject.query(sqlStatement, new BookMapper());
		
	}
	
	public Book getBook(int bookId) {
		String sqlStatement = "select * from book where bookId=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { bookId }, new BookMapper());
	}

	public void update(Book book) {
		String sqlStatement = "update book set bookCount=? where bookId=?";
		jdbcTemplateObject.update(sqlStatement, new Object[] { book.getBookCount(), book.getBookId() });
		
	}
	
	


	
	
}
