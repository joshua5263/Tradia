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

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.mybatis.MybatisMemberDao;
import com.fantastic.web.vo.Member;

/*@WebServlet("/join/join")*/
public class SpringJoinController extends HttpServlet{
	
	@Override
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
		
	}

}
