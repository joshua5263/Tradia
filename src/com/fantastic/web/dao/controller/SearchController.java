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
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.Comment;
import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.TravelDiary;

@Controller 
@RequestMapping("/search/*")
public class SearchController {
   
   private TravelDiaryDao travelDiaryDao;
   private CommentDao commentDao;
   private CourseDao courseDao;
   
   
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
   
   @RequestMapping("tradiasearch")
   public String travelMain(Model model, String headerQuery){
	   
	   
	   
	   List<Course> list = courseDao.searchCourse(headerQuery);
	      model.addAttribute("List", list);
      
      return "/WEB-INF/view/main/travelSearch.jsp";
   }
   
 /*  @RequestMapping(value="tradiasearch", method=RequestMethod.GET)
   public String travelDetail(Model model, String tcode){
      TravelDiary travelDiary = travelDiaryDao.getTravelDiary(tcode);
      model.addAttribute("td", travelDiary);
      
      return "/WEB-INF/view/main/travelDetail.jsp";
   }
   
   @RequestMapping(value="tradiasearch", method=RequestMethod.POST)
   public String travelSearch(Model model, String headerQuery, String cmcode){
      
      List<Course> list = courseDao.searchCourse(headerQuery);
      model.addAttribute("List", list);
      
      return "redirect:travelSearch";
      */
   /*}*/

}