package com.fantastic.web.dao.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value= "myinfo", method=RequestMethod.GET)
	public String myinfo(Member m, Model model, Principal principal, HttpServletRequest request){
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		return "/WEB-INF/view/mypage/myinfo.jsp";
	}
	
	@RequestMapping(value= "myinfo_reg", method=RequestMethod.POST)
	public String myinfo(Model model, String password, String password2, Member member, Principal principal){
		
		/*if (password != "" && password2 != "" && password.equals(password2))
		{*/
			member.setPassword(password);
			memberDao.modMember(password, principal.getName());
		/*}*/
		
		return "redirect:myinfo";
	}
	
	@RequestMapping(value="update_member_profile2", method=RequestMethod.POST)
	public String myinfo(Model model, Member member, Principal principal, String myProfile){
		
		member = memberDao.getMember(principal.getName());
		member.setProfile(myProfile);
		memberDao.updateMemberProfile(myProfile, principal.getName());
		
		return "redirect:myinfo";
	}
	
	@RequestMapping(value= "mypage", method=RequestMethod.GET)
	public String mypage(Member m, Model model, Principal principal, HttpServletRequest request){
		
		String memberID = principal.getName();
		
		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		List<TravelDiary> travelDiary = travelDiaryDao.getTravelDiarysOne(memberID);
	    model.addAttribute("td", travelDiary);
	      
		return "/WEB-INF/view/mypage/mypage.jsp";
	}
	
	@RequestMapping(value="update_member_profile1", method=RequestMethod.POST)
	public String mypage(Model model, Member member, Principal principal, String myProfile){

/*		member = memberDao.getMember(principal.getName());*/
		member.setProfile(myProfile);
		memberDao.updateMemberProfile(myProfile, principal.getName());
		
		return "redirect:mypage";
	}
	
	@RequestMapping(value= "scrapinfo", method=RequestMethod.GET)
	public String scrapinfo(Member m, Model model, Principal principal, HttpServletRequest request){

		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		
		List<Scrap> scrap = scrapDao.getScraps(principal.getName());
	    model.addAttribute("sc", scrap);
		
	    return "/WEB-INF/view/mypage/scrapinfo.jsp";
	}
	
	@RequestMapping(value="update_member_profile3", method=RequestMethod.POST)
	public String scrapinfo(Model model, Member member, Principal principal, String myProfile){

		member = memberDao.getMember(principal.getName());
		member.setProfile(myProfile);
		memberDao.updateMemberProfile(myProfile, principal.getName());
		
		return "redirect:scrapinfo";
	}

	@RequestMapping(value="scrap_del", method=RequestMethod.POST)
	public String scrapinfo(Model model, Scrap scrap, String sCode, Principal principal){
		
		scrap.setTravelCode(sCode);
		scrap.setMemberID(principal.getName());
		
		scrapDao.removeScrap(scrap);
			
		return "redirect:scrapinfo";
	}
}
