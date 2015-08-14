package com.fantastic.web.dao.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.mybatis.MybatisMemberDao;
import com.fantastic.web.vo.Member;

/*@WebServlet("/join/join")*/
@Controller
@RequestMapping("/join/*")
public class JoinController extends HttpServlet{
	
	MemberDao memberDao;
	
	
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping(value= "join", method=RequestMethod.GET)
	public String join(){
		
		return "/WEB-INF/view/join/Join.jsp";
	}
	
	@RequestMapping(value= "join", method=RequestMethod.POST)
	public String join(Member m, HttpServletRequest request, String joinId){
		
		
		//String joinId = request.getParameter("join-id");
		String pw = request.getParameter("pw");
		String pwCheck = request.getParameter("pw-check");
		
	
		if(memberDao.getMember(joinId) == null){
			if(pw.equals(pwCheck)){
				Member member = new Member();				
				
				member.setId(joinId);
				member.setPassword(pw);
				
				MemberDao memberDao = new MybatisMemberDao();
				memberDao.addMember(member);
				
				return "redirect:../intro/intro";
			}
			else{
				return "redirect:../join/join";
			}
		}
		else{
			return "redirect:../join/join";
		}
	}
	
	
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getMethod().equals("POST"))
		{
			String nickName = request.getParameter("nick-name");
			String joinId = request.getParameter("join-id");
			String pw = request.getParameter("pw");
			String pwCheck = request.getParameter("pw-check");
			
			if(pw.equals(pwCheck)){
				Member member = new Member();
				
				
				member.setId(joinId);
				member.setPassword(pw);
				
				MemberDao memberDao = new MybatisMemberDao();
				memberDao.addMember(member);
				
				response.sendRedirect("../intro/intro");
			}
						
		}
		
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/join/Join.jsp");
			dispatcher.forward(request, response);
		}
		
	}*/

}
