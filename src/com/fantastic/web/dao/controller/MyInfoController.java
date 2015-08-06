package com.fantastic.web.dao.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.vo.Member;


@Controller
@RequestMapping("/mypage/*")
public class MyInfoController{
	
	private MemberDao memberDao;
	
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping(value= "myinfo", method=RequestMethod.GET)
	public String myinfo(Member m, Model model, Principal principal, HttpServletRequest request){
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		return "/WEB-INF/view/mypage/myinfo.jsp";
	}
	
	@RequestMapping(value= "myinfo", method=RequestMethod.POST)
	public String myinfo(Model model,String password, String password2, Member m, Principal principal, HttpServletRequest request){
		
		/*String password = request.getParameter("password");
		String password2 = request.getParameter("password2");*/
		
		/*if (password != "" && password2 != "" && password.equals(password2))
		{
			m = memberDao.getMember(principal.getName());
			m.setPassword(password);
			memberDao.modMember(m);
			//member.setGender(gender);
		}
		*/
		return "/WEB-INF/view/mypage/myinfo.jsp";
	}
	
	@RequestMapping(value= "mypage", method=RequestMethod.GET)
	public String mypage(){
		
		return "/WEB-INF/view/mypage/mypage.jsp";
	}

	@RequestMapping(value= "scrapinfo", method=RequestMethod.GET)
	public String scrapinfo(){
		
		return "/WEB-INF/view/mypage/scrapinfo.jsp";
	}
	
	
	
}
