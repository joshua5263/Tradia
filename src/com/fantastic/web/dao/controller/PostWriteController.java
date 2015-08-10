package com.fantastic.web.dao.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.dao.mybatis.MybatisCourseDao;
import com.fantastic.web.dao.mybatis.MybatisTravelDiaryDao;
import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.TravelDiary;

@Controller
@RequestMapping("/post/*")
public class PostWriteController{
	private TravelDiaryDao dao;
	private CourseDao courseDao;

	@Autowired
	public void setDao(TravelDiaryDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}



	//	GET 요청을 받을 경우
	@RequestMapping(value = "postBeforeWrite", method = RequestMethod.GET)
	public String postBeforeWrite() {

		return "/WEB-INF/view/post/postBeforeWrite.jsp";
	}
	
	
	//POST 요청을 받을 경우
	@RequestMapping(value = "postBeforeWrite", method = RequestMethod.POST)
	public String postBeforeWrite(TravelDiary d, Principal principal){
		
		String mid=principal.getName();
		
		//VO를 DAO를 통해서 DB로 전송
		d.setMemberID(mid);
		dao.addBeforeTravelDiary(d);

		 return "redirect:postCourseWrite";
	}
	
	@RequestMapping(value = "postCourseWrite", method = RequestMethod.GET)
	public String postCourseWrite(){
		
		return "/WEB-INF/view/post/postCourseWrite.jsp";
	}
	
	@RequestMapping(value = "postCourseWrite", method = RequestMethod.POST)
	public String postCourseWrite(Course course, HttpServletRequest req){
		/*course.setTravelCode((String) req.getAttribute("travelCode"));*/
		course.setCsDate("2015-06-06");
		course.setFeeling("good");
		courseDao.addCourse(course);
		
		return "redirect:";
	}
	
	
	
}
