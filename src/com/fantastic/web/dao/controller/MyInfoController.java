package com.fantastic.web.dao.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.ScrapDao;
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.Member;
import com.fantastic.web.vo.Scrap;
import com.fantastic.web.vo.TravelDiary;

@Controller
@RequestMapping("/mypage/*")

public class MyInfoController{
	
	private MemberDao memberDao;
	private TravelDiaryDao travelDiaryDao;
	private ScrapDao scrapDao;
	private	CourseDao courseDao;
	
	@Autowired
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
	public void setTravelDiaryDao(TravelDiaryDao travelDiaryDao) {
		this.travelDiaryDao = travelDiaryDao;
	}
	@Autowired
	public void setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
	}

	//내 정보 페이지 가져오기
	@RequestMapping(value= "myinfo", method=RequestMethod.GET)
	public String myinfo(Member m, Model model, Principal principal, HttpServletRequest request){
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		return "/WEB-INF/view/mypage/myinfo.jsp";
	}
	
	//내 정보 페이지 프로필 글 수정하기
	@RequestMapping(value="update_member_profile2", method=RequestMethod.POST)
	public String myinfo(Model model, Member member, Principal principal, String myProfile){
		
		member = memberDao.getMember(principal.getName());
		member.setProfile(myProfile);
		memberDao.updateMemberProfile(myProfile, principal.getName());
		
		return "redirect:myinfo";
	}
	
	//내 정보 페이지 내 정보 수정하기
	@RequestMapping(value="modMyInfo", method=RequestMethod.POST)
	public String modMyInfo(Member m, Principal principal, HttpServletRequest request){
		
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String birthday = request.getParameter("birthday");
		int genderCheck = Integer.parseInt(request.getParameter("gender-check"));
		
		m = memberDao.getMember(principal.getName());
		
		/*비밀번호 & 생일 & 성별 변경하기*/
		if(password != "" && password2 != "" && password.equals(password2) && birthday != "" && m.getGender() != genderCheck){
			m.setPassword(password2);
			m.setBirthday(birthday);
			m.setGender(genderCheck);
			memberDao.modMemberInfoBirthGender(password, birthday, genderCheck, principal.getName());
		}
		
		/*비밀번호 & 성별 변경하기*/
		else if(password != "" && password2 != "" && password.equals(password2) && birthday == "" && m.getGender() != genderCheck){
			m.setPassword(password);
			m.setGender(genderCheck);
			memberDao.modMemberInfoGender(password, genderCheck, principal.getName());
		}
		
		/*비밀번호 & 생일 변경하기*/
		else if(password != "" && password2 != "" && password.equals(password2) && birthday != ""){
			m.setPassword(password);
			m.setBirthday(birthday);
			memberDao.modMemberInfoBirth(password, birthday, principal.getName());
		}
		
		/*생일 & 성별 변경하기*/
		else if(password == "" && birthday != "" && m.getGender() != genderCheck){
			m.setBirthday(birthday);
			m.setGender(genderCheck);
			memberDao.modMemberBirthGender(birthday, genderCheck, principal.getName());
		}
		
		/*성별 변경하기*/
		else if(password == "" && birthday == "" && m.getGender() != genderCheck){
			m.setGender(genderCheck);
			memberDao.modMemberGender(genderCheck, principal.getName());
		}
		
		/*생일 변경하기*/
		else if(password == "" && birthday != ""){
			m.setBirthday(birthday);
			memberDao.modMemberBirth(birthday, principal.getName());			
		}
		
		/*비밀번호 변경하기*/
		else if(password != "" && password2 != "" && password.equals(password2)){
			m.setPassword(password);
			memberDao.modMemberInfo(password, principal.getName());
		}
		
		return "redirect:myinfo";
	}
	
	//MyPage 가져오기
	@RequestMapping(value= "mypage", method=RequestMethod.GET)
	public String mypage(Member m, Model model, Principal principal, HttpServletRequest request){
		
		String memberID = principal.getName();
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		List<TravelDiary> travelDiary = travelDiaryDao.getTravelDiarysOne(memberID);
	    model.addAttribute("td", travelDiary);
	      
		return "/WEB-INF/view/mypage/mypage.jsp";
	}
	
	//MyPage 프로필 글 수정하기
	@RequestMapping(value="update_member_profile1", method=RequestMethod.POST)
	public String mypage(Model model, Member member, Principal principal, String myProfile){

/*		member = memberDao.getMember(principal.getName());*/
		member.setProfile(myProfile);
		memberDao.updateMemberProfile(myProfile, principal.getName());
		
		return "redirect:mypage";
	}
	
	//스크랩목록 페이지 가져오기
	@RequestMapping(value= "scrapinfo", method=RequestMethod.GET)
	public String scrapinfo(Member m, Model model, Principal principal, HttpServletRequest request){

		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		List<Scrap> scrap = scrapDao.getScraps(principal.getName());
	    model.addAttribute("sc", scrap);
		
	    return "/WEB-INF/view/mypage/scrapinfo.jsp";
	}
	
	//스크랩목록 페이지 프로필 글 수정하기
	@RequestMapping(value="update_member_profile3", method=RequestMethod.POST)
	public String scrapinfo(Model model, Member member, Principal principal, String myProfile){

		member = memberDao.getMember(principal.getName());
		member.setProfile(myProfile);
		memberDao.updateMemberProfile(myProfile, principal.getName());
		
		return "redirect:scrapinfo";
	}

	//스크랩 삭제하기
	@RequestMapping(value="scrap_del", method=RequestMethod.POST)
	public String scrapinfo(Model model, Scrap scrap, String sCode, Principal principal){
		
		scrap.setTravelCode(sCode);
		scrap.setMemberID(principal.getName());
		
		scrapDao.removeScrap(scrap);
			
		return "redirect:scrapinfo";
	}
	
	//프로필 사진 업로드
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public String profilePictureUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, Member m, Principal principal) throws IOException, ServletException{
		
		if(!file.isEmpty()){
			ServletContext application = request.getServletContext();
			
			String url = "/resource/upload/profilePicture";
			String path = application.getRealPath(url);
			String temp = file.getOriginalFilename();//part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf('\\') + 1);
			String fpath = path + "\\" + fname;
		
			InputStream ins = file.getInputStream();//part.getInputStream();
			OutputStream outs = new FileOutputStream(fpath);
			
			byte[] aa = new byte[1024];
			int len = 0;
			
			while((len = ins.read(aa, 0, 1024)) >= 0)
			outs.write(aa, 0, len);
			
			outs.flush();
			outs.close();
			ins.close();
			
			//m.setPicture(fpath);
			memberDao.addProfilePicture(fname, principal.getName());
		}
		
		return "redirect:myinfo";
	}
}
