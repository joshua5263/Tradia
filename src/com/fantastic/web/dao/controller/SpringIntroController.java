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

/*@WebServlet("/intro/intro")*/
public class SpringIntroController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getMethod().equals("POST"))
		{
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			MemberDao memberDao = new MybatisMemberDao();
			Member member = memberDao.getMember(id);			
					
				if(member ==  null)
				{				
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/intro/Intro.jsp");
					dispatcher.forward(request, response);
				}
				
				else if(!member.getPassword().equals(pw))
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/intro/Intro.jsp");
					dispatcher.forward(request, response);
				}
				
				else{
					if(member.getLevels().equals("1"))
					{
						HttpSession session = request.getSession();
						session.setAttribute("mid", id);				
						session.setMaxInactiveInterval(60*60);
						
						/*response.getWriter().println("success");*/				
						response.sendRedirect("../selectpreferlocation/selectpreferlocation");
					}
					else if(member.getLevels().equals("2"))
					{
						//휴면 계정 로그인
						response.getWriter().println("babo");
					}
					else
					{
						//관리자 로그인
						response.getWriter().println("success");
					}
				}	
			}			
		
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/intro/Intro.jsp");
			dispatcher.forward(request, response);
		}		
	}
}
