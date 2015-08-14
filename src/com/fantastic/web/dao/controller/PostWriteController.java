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



	//	GET ��û�� ���� ���
	@RequestMapping(value = "postBeforeWrite", method = RequestMethod.GET)
	public String postBeforeWrite() {
		return "/WEB-INF/view/post/postBeforeWrite.jsp";
	}
	
	//POST ��û�� ���� ���
	@RequestMapping(value = "postBeforeWrite", method = RequestMethod.POST)
	public String postBeforeWrite(TravelDiary d, Principal principal, String option){
		String mid=principal.getName();
		
		//VO�� DAO�� ���ؼ� DB�� ����
		d.setMemberID(mid);
		dao.addBeforeTravelDiary(d);
		
		
		/*������ ��ư�� ���� ������ �ٸ��� �̵�*/
		/*�ڽ��߰��� ������ ���*/
		if(option.equals("course"))
			/*�ڽ� �߰� �������� �̵�*/
			return "redirect:postCourseWrite";
			
			/*�ı� �ۼ� �������� �̵�*/
			/*return "redirect:postAfterwordWrite";*/
		
		/*�ӽ� ������ ������ ���*/
		else 
			/*�������� �̵�*/
			return "redirect:/main/travelMain";
	}
	
	@RequestMapping(value = "postCourseWrite", method = RequestMethod.GET)
	public String postCourseWrite(){
		
		return "/WEB-INF/view/post/postCourseWrite.jsp";
	}
	
	@RequestMapping(value = "postCourseWrite", method = RequestMethod.POST)
	public String postCourseWrite(Course course, Principal principal,String option){
		/*�α����� ����� id�� ����*/
		String memberID = principal.getName();
		
		/*�ش� ����� ���� ���������� �� tarvelDiary�� �ڵ带 ����*/
		String lastCode = dao.getLastCode(memberID);
		/*���� DiaryCode�� �߰�*/
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
		/*�α����� ����� id�� ����*/
		String memberID = principal.getName();
		
		/*�ش� ����� ���� ���������� �� tarvelDiary�� �ڵ带 ����*/
		String lastCode = dao.getLastCode(memberID);
		/*���� DiaryCode�� �߰�*/
		course.setTravelCode(lastCode);
		
		courseDao.addCourse(course);
		
		return "redirect:postCourseWrite";
	}
	
	@RequestMapping(value = "writeAfterword", method = RequestMethod.POST)
	public String writeAfterword(Course course, Principal principal){
		/*�α����� ����� id�� ����*/
		String memberID = principal.getName();
		
		/*�ش� ����� ���� ���������� �� tarvelDiary�� �ڵ带 ����*/
		String lastCode = dao.getLastCode(memberID);
		/*���� DiaryCode�� �߰�*/
		course.setTravelCode(lastCode);
		
		courseDao.addCourse(course);
		
		return "redirect:/main/travelMain";
	}

	@RequestMapping(value = "postAfterwordWrite", method = RequestMethod.GET)
	public String postAfterwordWrite() {
		return "/WEB-INF/view/post/postAfterwordWrite.jsp";
	}

	
	/*----------------�ۼ����� �κ��Դϴ�. ���� ���� �߻�----------------*/
	@RequestMapping(value = "postAfterwordWrite", method = RequestMethod.POST)
	public String postAfterwordWrite(String a, Principal principal, HttpServletRequest req) {
		String travelCode = dao.getLastCode(principal.getName());
		String totalCost = "1";
		dao.addAfterword(travelCode, a, totalCost);
		return "redirect:/main/travelMain";
	}
	
}
