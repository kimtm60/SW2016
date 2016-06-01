package kr.ac.hansung.domain;

public class Member {

	private String memberId;
	private String password;
	private int coffeePoint;
	
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCoffeePoint() {
		return coffeePoint;
	}
	public void setCoffeePoint(int coffeePoint) {
		this.coffeePoint = coffeePoint;
	}
	
	public Member(String memberID, String password) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.coffeePoint = coffeePoint;
	}
	public Member() {
	
	}
}
