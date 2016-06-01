package kr.ac.hansung.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.dao.MemberDAO;
import kr.ac.hansung.domain.Coupon;
import kr.ac.hansung.domain.Member;

@Service("MemberService")
public class MemberService {

	private MemberDAO memberDAO;

	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public Member isMemberOk(String memberId, String password){
		
		Member member = new Member();
		member = memberDAO.getMember(memberId);
		if(member!=null && password.equals(member.getPassword())){
			return member;
		}
		else{
		return null;
		}
		}

	public void doSignUp(String memberId, String password) {
		
		memberDAO.addMember(memberId,password);
	}

	public int showPoint(String memberId) {
		Member member = memberDAO.getMember(memberId);
		try{
		int value = (member.getCoffeePoint()/100);
		return value;
		}catch(ArithmeticException e){
			System.out.println("정수를 0으로 나눌수 없습니다.");
			return 0;
			
		}
		}
	@Transactional
	public List<Coupon> doExchange(int couponNum, String memberId) {
		//memberDAO.subtractPoint(couponNum,memberId);
		return memberDAO.getCoupon(couponNum);
	}

	public void changeCouponStatus(List<Coupon> couponSet, String memberId) {
		
		memberDAO.insertCouponMemberId(couponSet,memberId);
	}

	public List<Coupon> requestCouponList(String memberId) {
		
		return memberDAO.getCouponList(memberId);
	}

}

