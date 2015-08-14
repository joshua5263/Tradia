package com.fantastic.web.dao.controller;

import java.security.Principal;
import java.util.List;

import javafx.scene.control.Alert;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String postBeforeWrite(TravelDiary d, Principal principal, String option){
		String mid=principal.getName();
		
		//VO를 DAO를 통해서 DB로 전송
		d.setMemberID(mid);
		dao.addBeforeTravelDiary(d);
		
		
		/*누르는 버튼에 따라 페이지 다르게 이동*/
		/*코스추가를 선택할 경우*/
		if(option.equals("course"))
			/*코스 추가 페이지로 이동*/
			return "redirect:postCourseWrite";
			
			/*후기 작성 페이지로 이동*/
			/*return "redirect:postAfterwordWrite";*/
		
		/*임시 저장을 선택할 경우*/
		else 
			/*메인으로 이동*/
			return "redirect:/main/travelMain";
	}
	
	@RequestMapping(value = "postCourseWrite", method = RequestMethod.GET)
	public String postCourseWrite(){
		
		return "/WEB-INF/view/post/postCourseWrite.jsp";
	}
	
	@RequestMapping(value = "postCourseWrite", method = RequestMethod.POST)
	public String postCourseWrite(Course course, Principal principal,String option){
		/*로그인한 멤버의 id를 얻어옴*/
		String memberID = principal.getName();
		
		/*해당 멤버가 가장 마지막으로 쓴 tarvelDiary의 코드를 얻어옴*/
		String lastCode = dao.getLastCode(memberID);
		/*얻어온 DiaryCode를 추가*/
		course.setTravelCode(lastCode);
		courseDao.addCourse(course);
		
		if(option.equals("course")){
			return "redirect:postCourseWrite";
		}
		else if (option.equals("afterword")) {
			return "redirect:postAfterwordWrite";
		} else {
			return "redirect:/main/travelMain";
		}
		
		
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

	@RequestMapping(value = "postAfterwordWrite", method = RequestMethod.GET)
	public String postAfterwordWrite() {
		return "/WEB-INF/view/post/postAfterwordWrite.jsp";
	}

	
	/*----------------작성중인 부분입니다. 현재 오류 발생----------------*/
	@RequestMapping(value = "postAfterwordWrite", method = RequestMethod.POST)
	public String postAfterwordWrite(String a, Principal principal, HttpServletRequest req) {
		String travelCode = dao.getLastCode(principal.getName());
		String totalCost = "1";
		dao.addAfterword(travelCode, a, totalCost);
		return "redirect:/main/travelMain";
	}
	
}
