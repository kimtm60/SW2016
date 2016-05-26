package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.hansung.domain.Book;
import kr.ac.hansung.domain.BorrowInfo;

@Component("borrowInfoDAO")
public class BorrowInfoDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insertBorrowInfo(BorrowInfo borrowInfo) {
		String memberId = borrowInfo.getMemberId();
		int bookId = borrowInfo.getBookId();

		String sqlStatement = "insert into borrowInfo (memberId, bookId, borrowDate, borrowTerm) "
				+ "values (?, ?, now(), date_add(now(),interval 15 day))";

		jdbcTemplateObject.update(sqlStatement, new Object[] { memberId, bookId });

	}

	public List<BorrowInfo> getBorrowInfos(String memberId) {

		String sqlStatement = "select * from borrowInfo where memberId= ?";
		return jdbcTemplateObject.query(sqlStatement,new Object[] {memberId}, new BorrowInfoMapper());

	}

}
