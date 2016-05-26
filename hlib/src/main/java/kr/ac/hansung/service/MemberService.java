package kr.ac.hansung.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.MemberDAO;
import kr.ac.hansung.domain.Member;

@Service("MemberService")
public class MemberService {

	private MemberDAO memberDAO;

	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public Member isMemberOk(String memberId, String password) throws Exception {
		
		Member member = new Member();
		member = memberDAO.getMember(memberId);
		if(member!=null && password.equals(member.getPassword())){
			return member;
		}
		else
		return null;
	}

	public void doSignUp(String memberId, String password) {
		
		memberDAO.addMember(memberId,password);
	}

}

