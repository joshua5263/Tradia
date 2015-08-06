package com.fantastic.web.dao.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.mybatis.MybatisMemberDao;
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
	public String selectPreferLocation(){
		
		/*HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberId = (String)session.getAttribute("mid");
		Member m = memberDao.getMember(memberId);
		request.setAttribute("m", m);*/
		
		return "/WEB-INF/view/selectpreferlocation/selectpreferlocation.jsp";
	}
	
	@RequestMapping(value= "selectpreferlocation", method=RequestMethod.POST)
	public String selectPreferLocation(Member m, Principal principal, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
			/*HttpSession session = request.getSession();
			MemberDao memberDao = new MybatisMemberDao();
			String memberId = (String)session.getAttribute("mid");
			Member m = memberDao.getMember(memberId);
			request.setAttribute("m", m);*/
			
	
			int preferLocation = Integer.parseInt(request.getParameter("preferLocation"));
			/*response.getWriter().println(preferLocation);*/
			
			/*Member member = new Member();*/
			m = memberDao.getMember(principal.getName());
			m.setPreferLocation(preferLocation);
			
			memberDao.preferLocaMember(m);		
		
			/*String preferLocation = request.getParameter("select-prefer-location");
			response.getWriter().println(preferLocation);
			
			MemberDao memberDao = new MybatisMemberDao();
			Member member = memberDao.getMember(id);	*/	
			return "redirect:/main/travelMain";
			
				
	}
}
