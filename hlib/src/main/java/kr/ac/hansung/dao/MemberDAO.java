package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.ac.hansung.domain.Coupon;
import kr.ac.hansung.domain.Member;

@Component("memberDAO")
public class MemberDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Member getMember(String memberId){
		try{
		String sqlStatement = "select * from member where memberId=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {memberId}, new MemberMapper());
		}catch (Exception e){
			
			System.out.println("DAO 예외 처리 발생 확인 메세지");
			e.printStackTrace();
			return null;
		
		}
	}

	public void incrementCoffeePoint(String memberId) {
		String sqlStatement = "update member set coffeePoint=coffeePoint+50 where memberId=?";
		jdbcTemplateObject.update(sqlStatement, new Object[] {memberId});
		
	}

	public void addMember(String memberId, String password) {
		String sqlStatement = "insert into member(memberId,password) values(?,?)";
		jdbcTemplateObject.update(sqlStatement, new Object[] {memberId,password});
		
	}

	public void subtractPoint(int couponNum, String memberId) {
		String sqlStatement = "update member set coffeePoint=coffeePoint-"+ 100*couponNum + " where memberId=?";
		jdbcTemplateObject.update(sqlStatement, new Object[] {memberId});
		
	}

	public List<Coupon> getCoupon(int couponNum) {
		
		String sqlStatement = "select * from coupon where used = '0' order by rand() limit " + couponNum;
		return jdbcTemplateObject.query(sqlStatement, new CouponMapper());
	}
/*
	public void insertCouponMemberId(String memberId) {
		String sqlStatement = "update coupon set memberId="+memberId+"where ";
		jdbcTemplateObject.update(sqlStatement, new Object[] {memberId});
	}
	*/

	public void insertCouponMemberId(List<Coupon> couponSet, String memberId) {
		for(int i=0;i<couponSet.size();i++){
			String sqlStatement = "update coupon set memberId='"+memberId+"' where couponSerialNumber=?";
			jdbcTemplateObject.update(sqlStatement, new Object[] {couponSet.get(i).getCouponSerialNumber()});
		}
	}

	public List<Coupon> getCouponList(String memberId) {
		String sqlStatement = "select * from coupon where memberId = ?";
		return jdbcTemplateObject.query(sqlStatement, new Object[] {memberId},new CouponMapper());
		
	}
	
}
