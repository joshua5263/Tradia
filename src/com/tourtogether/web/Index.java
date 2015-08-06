package com.tourtogether.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Index
 */
@WebServlet("/main")
public class Index extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String id = null;
		String pw = null;
		
		
		if(request.getMethod().equals("POST"))
		{
			String _id = request.getParameter("id");
			String _pw = request.getParameter("pw");
			
			if(_id != null && _pw != null && !_id.equals("") && !_pw.equals(""))
			{
				id = (_id);
				pw = (_pw);
				
			}
		}
		
		
		
		out.write("<form action=\"main\" method=\"post\">");

		out.write("<ul>");
		out.write("<li><label for=\"id\">이메일  <br/> </label><input name=\"id\"/></li>");
		out.write("<li><label for=\"pw\">비밀번호 <br/> </label><input name=\"pw\"/></li>");
		out.write("</ul>");
		
		out.write("<p><input type=\"submit\" value=\"로그인\"/></p>");
		
		out.write("</ul>");

		out.write("</form>");
		
		String id1 = "pjh5263";
		String pw1 = "1234";
		
		if(id == null && pw == null){
			
		}
		
		else if(id != null && pw != null && id.equals(id1) && pw.equals(pw1))
			out.println("로그인되었습니다.");
		
		else
			out.println("다시입력해주세요");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
