package com.fantastic.web.dao.controller;

import java.io.IOException;

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
/*
@WebServlet("/mypage/myinfo")*/
public class SpringMyInfoController extends HttpServlet {

	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberId = (String)session.getAttribute("mid");
		Member m = memberDao.getMember(memberId);
		request.setAttribute("m", m);
		
		 if ("gender" == 0)
		{
			int gender = 0;
			m.setGender(gender);
		} 
		//int preferlocation = m.getPreferLocation();

		
		if (request.getMethod().equals("POST"))
		{
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			//int gender = Integer.parseInt(request.getParameter("gender"));
			//Date birthday = getParameter("birthday");//

			
			member.setId("starbucks@coffee.com");
			
			if (password != "" && password2 != "" && password.equals(password2))
			{
				m.setPassword(password);
				memberDao.modMember(m);
				//member.setGender(gender);
			}
			//member.setBirthday(birthday);

			String code = request.getParameter("/mypage/myinfo");
			//request.setAttribute("m", m);
			response.sendRedirect("../mypage/myinfo");
		}
		
		else 
		{			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/mypage/myinfo.jsp");
			dispatcher.forward(request, response);
		}
	}*/
}
