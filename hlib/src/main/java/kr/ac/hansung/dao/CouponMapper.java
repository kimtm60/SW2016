package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.domain.Coupon;


public class CouponMapper implements RowMapper<Coupon> {
	
	public Coupon mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Coupon coupon = new Coupon();
		coupon.setMemberId(rs.getString("memberId"));
		coupon.setUsed(rs.getInt("used"));
		coupon.setCouponSerialNumber(rs.getString("couponSerialNumber"));
	
		return coupon;
	
}
	
}
