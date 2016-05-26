package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.hansung.domain.Member;

@Component("memberDAO")
public class MemberDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Member getMember(String memberId){
		String sqlStatement = "select * from member where memberId=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {memberId}, new MemberMapper());
	}

	public void incrementCoffeePoint(String memberId) {
		String sqlStatement = "update member set coffeePoint=coffeePoint+50 where memberId=?";
		jdbcTemplateObject.update(sqlStatement, new Object[] {memberId});
		
	}

	public void addMember(String memberId, String password) {
		String sqlStatement = "insert into member(memberId,password) values(?,?)";
		jdbcTemplateObject.update(sqlStatement, new Object[] {memberId,password});
		
	}
	
	
}
