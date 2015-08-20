package com.fantastic.web.dao.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javafx.scene.control.Alert;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fantastic.web.dao.AreasDao;
import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.dao.mybatis.MybatisCourseDao;
import com.fantastic.web.dao.mybatis.MybatisTravelDiaryDao;
import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.Member;
import com.fantastic.web.vo.TravelDiary;

@Controller
@RequestMapping("/post/*")
public class PostWriteController{
	private TravelDiaryDao dao;
	private CourseDao courseDao;
	private AreasDao areasDao;
	private MemberDao memberDao;
	
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setDao(TravelDiaryDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Autowired
	public void setAreasDao(AreasDao areasDao) {
		this.areasDao = areasDao;
	}

	//	GET ��û�� ���� ���
	@RequestMapping(value = "postBeforeWrite", method = RequestMethod.GET)
	public String postBeforeWrite(Member m, Principal principal, HttpServletRequest request) {
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
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
	public String postCourseWrite(Member m, Principal principal, HttpServletRequest request){
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		return "/WEB-INF/view/post/postCourseWrite.jsp";
	}
	
	@RequestMapping(value = "postCourseWrite", method = RequestMethod.POST)
	public String postCourseWrite(Course course, Principal principal, String option, String areaName,
			MultipartFile file, HttpServletRequest req) throws IOException{
		/*�α����� ����� id�� ����*/
		String memberID = principal.getName();
		
		/*���޵� areaName�� ���� areCode�� ���Ѵ�*/
		String areaCode = areasDao.getAreaCode(areaName);
		course.setAreasCode(areaCode);
		
		/*�ش� ����� ���� ���������� �� tarvelDiary�� �ڵ带 ����*/
		String lastCode = dao.getLastCode(memberID);
		/*���� DiaryCode�� �߰�*/
		course.setTravelCode(lastCode);
		courseDao.addCourse(course);
		
		
		/*--------------------���� �߰� �κ�--------------------*/
		ServletContext application = req.getServletContext();
		/*����� ������ courseCode ���ϱ�*/
		String courseCode = courseDao.getLastCode(lastCode);
		
		String url = "/resource/customer/upload/coursePic";
		String path = application.getRealPath(url);
		String temp = file.getOriginalFilename();
		String fname = temp.substring(temp.lastIndexOf("//") + 1);
		String fpath = path + "//" + fname;
		InputStream ins = file.getInputStream();
		OutputStream outs = new FileOutputStream(fpath);
		
		byte[] bowl = new byte[1024];
		int len = 0;
		
		while((len = ins.read(bowl, 0, 1024)) >= 0)
			outs.write(bowl, 0, len);
		
		outs.flush();
		outs.close();
		ins.close();
		
		/*ù��° ���� �߰�*/
		courseDao.addPic(courseCode, fpath);
		
		
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
	public String postAfterwordWrite(Member m, Principal principal, HttpServletRequest request) {
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		return "/WEB-INF/view/post/postAfterwordWrite.jsp";
	}

	
	@RequestMapping(value = "postAfterwordWrite", method = RequestMethod.POST)
	public String postAfterwordWrite(String memo, Principal principal, HttpServletRequest req) {
		String travelCode = dao.getLastCode(principal.getName());
		
		/*�� ��� ��� ������ �ۼ� ��*/
		String totalCost = "1";
		dao.addAfterword(travelCode, memo, totalCost);
		return "redirect:/main/travelMain";
	}
	/*----------------�ۼ����� �κ��Դϴ�.----------------*/
	
}
