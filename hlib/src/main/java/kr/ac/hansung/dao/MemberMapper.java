package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.domain.Member;

public class MemberMapper implements RowMapper<Member> {


		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			Member member = new Member();
			member.setMemberId(rs.getString("memberId"));
			member.setPassword(rs.getString("password"));
			member.setCoffeePoint(rs.getInt("coffeePoint"));
		
			return member;
		
	}
	
}
