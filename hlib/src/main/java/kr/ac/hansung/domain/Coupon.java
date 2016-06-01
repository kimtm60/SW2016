package kr.ac.hansung.domain;

public class Coupon {

	
	
	private String memberId;
	private int used;
	private String couponSerialNumber;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public String getCouponSerialNumber() {
		return couponSerialNumber;
	}
	public void setCouponSerialNumber(String couponSerialNumber) {
		this.couponSerialNumber = couponSerialNumber;
	}
	
	public Coupon() {

	}

	public Coupon(String memberId, String couponSerialNumber) {

		this.memberId = memberId;
		this.couponSerialNumber = couponSerialNumber;
	}
	
}
