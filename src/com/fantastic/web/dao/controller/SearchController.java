package com.fantastic.web.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.vo.Course;

@Controller 
@RequestMapping("/search/*")
public class SearchController {
   
   private CourseDao courseDao;
   
   
   @Autowired
   public void setCourseDao(CourseDao courseDao) {
	this.courseDao = courseDao;
   }
   
   @RequestMapping("tradiasearch")
   public String travelMain(Model model, String headerQuery){	   
	   
	   List<Course> list = courseDao.searchCourse(headerQuery);
	      model.addAttribute("List", list);
	      model.addAttribute("headerQuery", headerQuery);
      
      return "/WEB-INF/view/main/travelSearch.jsp";
   }
   

}