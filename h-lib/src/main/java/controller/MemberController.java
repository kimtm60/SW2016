package controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MemberController {
	//Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value="/open.do")
	public ModelAndView openSampleList(Map<String,Object> commanMap) throws Exception{
		ModelAndView mv = new ModelAndView("main");
		//log.debug("인터셉터 테스트");
		return mv;
	}
	
	@RequestMapping(value="/login")
	 public String deleteorm(@PathVariable int id){
			return "/login";
		}

	 @RequestMapping(value="/loginCheck.do")
	 public String deleteForm(@PathVariable int id){
			return "index";
		}
	
	
}
