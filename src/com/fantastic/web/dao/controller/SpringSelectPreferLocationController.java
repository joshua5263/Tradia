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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.mybatis.MybatisMemberDao;
import com.fantastic.web.vo.Member;

/*@WebServlet("/selecpreferlocation/selectpreferlocation")*/
public class SpringSelectPreferLocationController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberId = (String)session.getAttribute("mid");
		Member m = memberDao.getMember(memberId);
		request.setAttribute("m", m);
		
		
		if(request.getMethod().equals("POST"))
		{
			int preferLocation = Integer.parseInt(request.getParameter("preferLocation"));
			/*response.getWriter().println(preferLocation);*/
			
			/*Member member = new Member();*/
			/*m.setPreferLocation(preferLocation);*/
			
			MemberDao mymemberDao = new MybatisMemberDao();
			mymemberDao.preferLocaMember(m);
			
			response.sendRedirect("../mypage/myinfo");				
					
				
		}			
		
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/selectpreferlocation/selectpreferlocation.jsp");
			dispatcher.forward(request, response);
		}		
	}
}
