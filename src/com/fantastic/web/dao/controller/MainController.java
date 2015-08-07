package com.fantastic.web.dao.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantastic.web.dao.CommentDao;
import com.fantastic.web.dao.LikesDao;
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.Comment;
import com.fantastic.web.vo.Likes;
import com.fantastic.web.vo.TravelDiary;

@Controller 
@RequestMapping("/main/*")
public class MainController {
   
   private TravelDiaryDao travelDiaryDao;
   private CommentDao commentDao;
   private LikesDao likesDao;
   
   @Autowired
   public void setLikesDao(LikesDao likesDao) {
	this.likesDao = likesDao;
}

@Autowired
   public void setTravelDiaryDao(TravelDiaryDao travelDiaryDao) {
      this.travelDiaryDao = travelDiaryDao;
   }
   
   @Autowired
   public void setCommentDao(CommentDao commentDao) {
      this.commentDao = commentDao;
   }
   
   @RequestMapping("travelMain")
   public String travelMain(Model model){
      List<TravelDiary> list = travelDiaryDao.getTravelDiarys();
      model.addAttribute("List", list);
      
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
      
   @RequestMapping(value="add_like")
   public String addLike(Model model, Likes like,String tcode, Principal principal){
      
	  like.setMemberID(principal.getName());
	  like.setTravelCode(tcode);
	   
	  likesDao.addLike(like);

	  
      model.addAttribute("tcode",tcode);

      return "redirect:travelDetail";
      
   }
   
   

}