package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hansung.domain.Coupon;
import kr.ac.hansung.domain.Member;
import kr.ac.hansung.service.MemberService;

@Controller
public class MemberController {

	private MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping("logout")
	public ModelAndView doLogout(Model model,HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/login");
		session.removeAttribute("userLoginInfo");
		return mv;
	}
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	@RequestMapping("showCoupon")
	public String showCoupon(HttpServletRequest request, HttpSession session) {
		int value = memberService.showPoint((String)session.getAttribute("memberId"));
		request.setAttribute("value", value);
		return "coupon";
	}
	@RequestMapping("home")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("signUp")
	public String showSignUpPage() {
		return "signPage";
	}
	
	@RequestMapping("signUpProcess")
	public String signUpProcess(HttpServletRequest request){
		String mv;
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		if(memberId.equals("") || password.equals("")){
			mv="failInsert";
		}
		else {
		memberService.doSignUp(memberId,password);
		mv = "login";
		}
		return mv;
	}
	
	@RequestMapping("loginProcess")
	public String loginProcess( HttpSession session, HttpServletRequest request)  {
        String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String mv;
       Member loginMember = memberService.isMemberOk(memberId, password);
        if (loginMember != null) {
            session.setAttribute("userLoginInfo", loginMember);
            session.setAttribute("memberId", loginMember.getMemberId());
            mv="home";
        }
        else {
        	mv="failLogin";
        }
        return mv;
        
    } 
	
	@RequestMapping("requsetExchange")
	public String requestExchange(Model model, HttpSession session, HttpServletRequest request) {

		String memberId = (String)session.getAttribute("memberId");

		int couponNum = Integer.parseInt(request.getParameter("couponNum"));
		
		List <Coupon> coupon = memberService.doExchange(couponNum,memberId);
		
		
		List <Coupon> couponSet = new ArrayList<Coupon>();

		for(int i=0; i<coupon.size();i++){
			couponSet.add(coupon.get(i));
		}
		memberService.changeCouponStatus(couponSet,memberId);
		model.addAttribute("coupon",coupon);
		return "myCoupon";
	}
	
	@RequestMapping("showMyCouponList")
	public String showMyCouponList(Model model, HttpSession session ) {
		
		String memberId = (String)session.getAttribute("memberId");
		List <Coupon> coupon = memberService.requestCouponList(memberId);
		model.addAttribute("coupon", coupon);
		return "myCouponList";
	}
	
}
