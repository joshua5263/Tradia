package com.fantastic.web.dao.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.CommentDao;
import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.Comment;
import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.Member;
import com.fantastic.web.vo.TravelDiary;

@Controller 
@RequestMapping("/main/*")
public class MainController {
   
   private TravelDiaryDao travelDiaryDao;
   private CommentDao commentDao;
   private CourseDao courseDao;
   private MemberDao memberDao;
   
   
   @Autowired
   public void setMemberDao(MemberDao memberDao) {
	this.memberDao = memberDao;
}

@Autowired
   public void setCourseDao(CourseDao courseDao) {
	this.courseDao = courseDao;
   }

   @Autowired
   public void setTravelDiaryDao(TravelDiaryDao travelDiaryDao) {
      this.travelDiaryDao = travelDiaryDao;
   }
   
   @Autowired
   public void setCommentDao(CommentDao commentDao) {
      this.commentDao = commentDao;
   }
   
   @RequestMapping(value="travelMain", method=RequestMethod.GET)
   public String travelMain(Model model, Member m, Principal principal, String preferLocation){
	   
	  m = memberDao.getMember(principal.getName());
	  String preLoca = m.getPreferLocation();
	   
	  if(m.getPreferLocation().equals("Àü±¹")){
	      /*List<TravelDiary> list = travelDiaryDao.getTravelDiarys();
	      model.addAttribute("List", list);*/
		  List<Course> list = courseDao.preferLocaCourses();
	      model.addAttribute("List", list);
	   }
	  
	  else{
		  List<Course> list = courseDao.preferLocaCourse(preLoca);
	      model.addAttribute("List", list);
		  
	  }
      
      return "/WEB-INF/view/main/travelMain.jsp";
   }
   
   @RequestMapping(value="travelDetail", method=RequestMethod.GET)
   public String travelDetail(Model model, String tcode){
      TravelDiary travelDiary = travelDiaryDao.getTravelDiary(tcode);
      model.addAttribute("td", travelDiary);
      
      return "/WEB-INF/view/main/travelDetail.jsp";
   }
   
   @RequestMapping(value="com_reg", method=RequestMethod.POST)
   public String travelDetail(Model model, Comment c, String tcode, Principal principal){
   
      c.setMemberID(principal.getName());
      c.setTravelCode(tcode);
            
      commentDao.addComment(c);
      model.addAttribute("tcode",tcode);

      return "redirect:travelDetail";
      
   }
   
   @RequestMapping(value="com_del", method=RequestMethod.POST)
   public String travelDetail(Model model, String tcode, String cmcode){
      
      commentDao.removeComment(cmcode);
      model.addAttribute("tcode",tcode);

      return "redirect:travelDetail";
      
   }
   
  /* @RequestMapping(value="tradiasearch", method=RequestMethod.POST)
   public String travelSearch(Model model, String headerQuery, String cmcode){
      
      List<Course> list = courseDao.searchCourse(headerQuery);
      model.addAttribute("List", list);
      
      return "redirect:travelSearch";
      
   }*/

}