package hlib.library.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/library/openMain.do")
    public ModelAndView openMain(Map<String,Object> commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/main");
    	log.debug("메인 화면");
    	
    	return mv;
    }
	@RequestMapping(value="/library/openLogin.do")
    public ModelAndView openLogin(Map<String,Object> commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/login");
    	log.debug("로그인 화면");
    	
    	return mv;
	}
}
