package com.fantastic.web.dao.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.AreasDao;
import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.mybatis.MybatisMemberDao;
import com.fantastic.web.vo.Areas;
import com.fantastic.web.vo.Member;

@Controller
@RequestMapping("/addarea/*")
public class AddAreaController{
	
	private MemberDao memberDao;
	private AreasDao areasDao;
	
	
	@Autowired
	public void setAreasDao(AreasDao areasDao) {
		this.areasDao = areasDao;
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping(value="addarea", method=RequestMethod.GET)
	public String addarea(Principal principal, Model model){
		
		List<Areas> list = areasDao.getAreas();
		model.addAttribute("List", list);
		
		return "/WEB-INF/view/post/addarea.jsp";
		
		/*Member m = memberDao.getMember(principal.getName());*/
		
		
		
		/*if(m.getPreferLocation() == null){
			return "/WEB-INF/view/selectpreferlocation/selectpreferlocation.jsp";
		}
		else{
			return "redirect:/main/travelMain";
		}*/
		
		/*HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberId = (String)session.getAttribute("mid");
		Member m = memberDao.getMember(memberId);
		request.setAttribute("m", m);*/
		
		
	}
	
	@RequestMapping(value= "addarea", method=RequestMethod.POST)
	public String addarea(Member m, Principal principal, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
			/*HttpSession session = request.getSession();
			MemberDao memberDao = new MybatisMemberDao();
			String memberId = (String)session.getAttribute("mid");
			Member m = memberDao.getMember(memberId);
			request.setAttribute("m", m);*/
			
	
			String preferLocation = request.getParameter("preferLocation");
			/*response.getWriter().println(preferLocation);*/
			
			/*Member member = new Member();*/
			m = memberDao.getMember(principal.getName());
			m.setPreferLocation(preferLocation);
			
			memberDao.preferLocaMember(m);		
		
			/*String preferLocation = request.getParameter("select-prefer-location");
			response.getWriter().println(preferLocation);
			
			MemberDao memberDao = new MybatisMemberDao();
			Member member = memberDao.getMember(id);	*/	
			return "redirect:/main/travelMain";		
				
	}
	
	@RequestMapping(value= "searcharea", method=RequestMethod.POST)
	public String addarea(String areaQuery, Model model) throws IOException{
		
		List<Areas> list = areasDao.searchAreas(areaQuery);
		model.addAttribute("List", list);
		
		return "/WEB-INF/view/post/searcharea.jsp";
	}
		
	@RequestMapping(value="createarea", method=RequestMethod.GET)
	public String createarea(){
		
		return "/WEB-INF/view/post/createarea.jsp";
	}
	
	@RequestMapping(value="createarea", method=RequestMethod.POST)
	public String createarea(Areas areas, Model model, String addressTxt, String areaname){
		
		areas.setName(areaname);
		areas.setFirstAdd(addressTxt);
		
		areasDao.addAreas(areas);
		
		return "redirect:../addarea/searcharea";
	}
	
}
