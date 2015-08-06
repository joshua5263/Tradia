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
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.mybatis.MybatisCourseDao;
import com.fantastic.web.dao.mybatis.MybatisMemberDao;
import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.Member;

@Controller
@RequestMapping("/post/*")
public class PostController{
	

	@RequestMapping(value= "postcourse", method=RequestMethod.GET)
	public String selectPreferLocation(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberId = (String)session.getAttribute("mid");
		Member m = memberDao.getMember(memberId);
		request.setAttribute("m", m);
		
		return "/WEB-INF/view/post/postcourse.jsp";
	}
	
	@RequestMapping(value= "postcourse", method=RequestMethod.POST)
	public String selectPreferLocation(Course c, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
			HttpSession session = request.getSession();
			MemberDao memberDao = new MybatisMemberDao();
			String memberId = (String)session.getAttribute("mid");
			Member m = memberDao.getMember(memberId);
			request.setAttribute("m", m);
			
			c = new Course();
			
			c.setAreasCode("1");
			c.setTravelCode("1");
			
			CourseDao courseDao = new MybatisCourseDao();
			courseDao.addCourse(c);
			
			/*int preferLocation = Integer.parseInt(request.getParameter("preferLocation"));
			
			m.setPreferLocation(preferLocation);
			
			MemberDao mymemberDao = new MybatisMemberDao();
			mymemberDao.preferLocaMember(m);*/
		
			return "redirect:../mypage/myinfo";
			
				
	}
}
