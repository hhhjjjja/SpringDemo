package info.thecodinglive.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import info.thecodinglive.model.LoginVO;
import info.thecodinglive.model.MemberVO;
import info.thecodinglive.service.MemberService;

//@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/loginSvs", method = RequestMethod.GET)
	public String login(LoginVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		HttpSession session = req.getSession();
		
		MemberVO loginVO = service.login(vo);
		
		if(loginVO == null) {
//			session.setAttribute("member", null);
			rttr.addFlashAttribute("member", false);
		} else {
			session.setAttribute("member", loginVO);
			session.setAttribute("userName", loginVO.getName());
			System.out.println(session.getAttribute("member") + ", "+session.getAttribute("userName"));
		}
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/home";
	}
	
	
//	// 회원가입 get
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public void getRegister() throws Exception {
//		logger.info("get register");
//	}
//	
//	// 회원가입 post
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String postRegister(MemberVO vo) throws Exception {
//		logger.info("post register");
//		
//		service.register(vo);
//		
//		return null;
//	}
}