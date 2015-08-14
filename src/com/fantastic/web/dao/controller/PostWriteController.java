package com.fantastic.web.dao.controller;

import java.security.Principal;
import java.util.List;

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
	public String postCourseWrite(Course course, Principal principal){
		/*로그인한 멤버의 id를 얻어옴*/
		String memberID = principal.getName();
		
		/*해당 멤버가 가장 마지막으로 쓴 tarvelDiary의 코드를 얻어옴*/
		String lastCode = dao.getLastCode(memberID);
		/*얻어온 DiaryCode를 추가*/
		course.setTravelCode(lastCode);
		
		courseDao.addCourse(course);
		
		return "redirect:postCourseWrite";
	}
	
	@RequestMapping(value = "addPost", method = RequestMethod.POST)
	public String addPost(Course course, Principal principal){
		/*로그인한 멤버의 id를 얻어옴*/
		String memberID = principal.getName();
		
		/*해당 멤버가 가장 마지막으로 쓴 tarvelDiary의 코드를 얻어옴*/
		String lastCode = dao.getLastCode(memberID);
		/*얻어온 DiaryCode를 추가*/
		course.setTravelCode(lastCode);
		
		courseDao.addCourse(course);
		
		return "redirect:postCourseWrite";
	}
	
	@RequestMapping(value = "writeAfterword", method = RequestMethod.POST)
	public String writeAfterword(Course course, Principal principal){
		/*로그인한 멤버의 id를 얻어옴*/
		String memberID = principal.getName();
		
		/*해당 멤버가 가장 마지막으로 쓴 tarvelDiary의 코드를 얻어옴*/
		String lastCode = dao.getLastCode(memberID);
		/*얻어온 DiaryCode를 추가*/
		course.setTravelCode(lastCode);
		
		courseDao.addCourse(course);
		
		return "redirect:/main/travelMain";
	}
	
	
	
}
