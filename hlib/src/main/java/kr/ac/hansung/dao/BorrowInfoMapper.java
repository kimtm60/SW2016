package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.domain.BorrowInfo;

	public class BorrowInfoMapper implements RowMapper<BorrowInfo> {


		public BorrowInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			BorrowInfo borrowInfo = new BorrowInfo();
			borrowInfo.setBookId(rs.getInt("bookId"));
			borrowInfo.setMemberId(rs.getString("memberId"));
			borrowInfo.setBorrowDate(rs.getString("borrowDate"));
			borrowInfo.setBorrowTerm(rs.getString("borrowTerm"));
		
			return borrowInfo;
		
	}
	
}

