package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.domain.Member;

public class MemberMapper implements RowMapper<Member> {


		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			Member offer = new Member();
			offer.setMemberId(rs.getString("memberId"));
			offer.setPassword(rs.getString("password"));
			offer.setCoffeePoint(rs.getString("coffeePoint"));
		
			return offer;
		
	}
	
}
