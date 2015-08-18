package com.fantastic.web.dao.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.vo.Member;

@Controller
@RequestMapping("/selectpreferlocation/*")
public class SelectPreferLocationController{
	
	private MemberDao memberDao;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping(value= "selectpreferlocation", method=RequestMethod.GET)
	public String selectPreferLocation(Principal principal){
		
		Member m = memberDao.getMember(principal.getName());		
		
		if(m.getPreferLocation() == null){
			return "/WEB-INF/view/selectpreferlocation/selectpreferlocation.jsp";
		}
		else{
			return "redirect:/main/travelMain";
		}

	}
	
	@RequestMapping(value= "selectpreferlocation", method=RequestMethod.POST)
	public String selectPreferLocation(Member m, Principal principal, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
			
		String preferLocation = request.getParameter("preferLocation");
		
		m = memberDao.getMember(principal.getName());
		m.setPreferLocation(preferLocation);
		
		memberDao.preferLocaMember(m);			
		
		return "redirect:/main/travelMain";		
				
	}
}
