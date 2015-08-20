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

	//	GET 요청을 받을 경우
	@RequestMapping(value = "postBeforeWrite", method = RequestMethod.GET)
	public String postBeforeWrite(Member m, Principal principal, HttpServletRequest request) {
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
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
	public String postCourseWrite(Member m, Principal principal, HttpServletRequest request){
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		return "/WEB-INF/view/post/postCourseWrite.jsp";
	}
	
	@RequestMapping(value = "postCourseWrite", method = RequestMethod.POST)
	public String postCourseWrite(Course course, Principal principal, String option, String areaName,
			MultipartFile file, HttpServletRequest req) throws IOException{
		/*로그인한 멤버의 id를 얻어옴*/
		String memberID = principal.getName();
		
		/*전달된 areaName을 토대로 areCode를 구한다*/
		String areaCode = areasDao.getAreaCode(areaName);
		course.setAreasCode(areaCode);
		
		/*해당 멤버가 가장 마지막으로 쓴 tarvelDiary의 코드를 얻어옴*/
		String lastCode = dao.getLastCode(memberID);
		/*얻어온 DiaryCode를 추가*/
		course.setTravelCode(lastCode);
		courseDao.addCourse(course);
		
		
		/*--------------------사진 추가 부분--------------------*/
		ServletContext application = req.getServletContext();
		/*멤버의 마지막 courseCode 구하기*/
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
		
		/*첫번째 사진 추가*/
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
	public String postAfterwordWrite(Member m, Principal principal, HttpServletRequest request) {
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		return "/WEB-INF/view/post/postAfterwordWrite.jsp";
	}

	
	@RequestMapping(value = "postAfterwordWrite", method = RequestMethod.POST)
	public String postAfterwordWrite(String memo, Principal principal, HttpServletRequest req) {
		String travelCode = dao.getLastCode(principal.getName());
		
		/*총 경비 계산 로직은 작성 중*/
		String totalCost = "1";
		dao.addAfterword(travelCode, memo, totalCost);
		return "redirect:/main/travelMain";
	}
	/*----------------작성중인 부분입니다.----------------*/
	
}
