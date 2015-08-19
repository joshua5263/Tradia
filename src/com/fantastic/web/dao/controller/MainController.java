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
import com.fantastic.web.dao.LikesDao;
import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.ScrapDao;
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.Comment;
import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.Likes;
import com.fantastic.web.vo.Member;
import com.fantastic.web.vo.Scrap;
import com.fantastic.web.vo.TravelDiary;



@Controller 
@RequestMapping("/main/*")
public class MainController {

	private TravelDiaryDao travelDiaryDao;
	private CommentDao commentDao;

	private CourseDao courseDao;
	private MemberDao memberDao;

	private LikesDao likesDao;
	private ScrapDao scrapDao; 



	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Autowired
	public void setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
	}

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
	
	//메인화면(최신순정렬)
	@RequestMapping(value="travelMain", method=RequestMethod.GET)
	public String travelMain(Model model, Member m, Principal principal, String preferLocation, HttpServletRequest request){

		m = memberDao.getMember(principal.getName());
		request.setAttribute("m", m);
		String preLoca = m.getPreferLocation();

		if(m.getPreferLocation().equals("전국")){
			/*List<TravelDiary> list = travelDiaryDao.getTravelDiarys();
	      model.addAttribute("List", list);*/
			List<Course> list = courseDao.preferLocaCourses();
			// list.remove() 리스트중 한개의 컬렉션을지울때
			model.addAttribute("List", list);
		}

		else{
			List<Course> list = courseDao.preferLocaCourse(preLoca);
			model.addAttribute("List", list);

		}

		return "/WEB-INF/view/main/travelMain.jsp";
	}
	
	//메인화면(인기순)
	@RequestMapping(value="travelMainPop", method=RequestMethod.GET)
	public String travelMainPop(Model model, Member m, Principal principal, String preferLocation){

		m = memberDao.getMember(principal.getName());
		String preLoca = m.getPreferLocation();

		if(m.getPreferLocation().equals("전국")){
			/*List<TravelDiary> list = travelDiaryDao.getTravelDiarys();
	      model.addAttribute("List", list);*/
			List<Course> list = courseDao.preferLocaCoursesPop();
			// list.remove() 리스트중 한개의 컬렉션을지울때
			model.addAttribute("List", list);
		}

		else{
			List<Course> list = courseDao.preferLocaCoursePop(preLoca);
			model.addAttribute("List", list);

		}

		return "/WEB-INF/view/main/travelMain.jsp";
	}
	
	//여행기 디테일화면
	@RequestMapping(value="travelDetail", method=RequestMethod.GET)
	public String travelDetail(Model model, String tcode, Principal principal){
		TravelDiary travelDiary = travelDiaryDao.getTravelDiary(tcode);
		model.addAttribute("td", travelDiary);
		model.addAttribute("loginID", principal.getName());

		return "/WEB-INF/view/main/travelDetail.jsp";
	}
	
	//여행기 삭제
	@RequestMapping(value="travel_Del")
	public String travelDeletel(Model model, String tcode){

		
		travelDiaryDao.removeTravelDiary(tcode);

		return "redirect:travelMain";

	}
	
	//댓글 등록
	@RequestMapping(value="com_reg", method=RequestMethod.POST)
	public String travelDetail(Model model, Comment c, String tcode, Principal principal){

		c.setMemberID(principal.getName());
		c.setTravelCode(tcode);

		commentDao.addComment(c);
		model.addAttribute("tcode",tcode);

		return "redirect:travelDetail";

	}

	//댓글 삭제
	@RequestMapping(value="com_del", method=RequestMethod.POST)
	public String travelDetail(Model model, String tcode, String cmcode, Principal principal){

		Comment com = commentDao.getOneComment(principal.getName(), cmcode);
		
		if (com != null)
		commentDao.removeComment(cmcode);

		model.addAttribute("tcode",tcode);

		return "redirect:travelDetail";

	}

	//좋아요 추가&삭제
	@RequestMapping(value="add_like_del")
	public String addLike(Model model, Likes like,String tcode, Principal principal){


		Likes dummy = likesDao.getPageLike(principal.getName(),tcode);
		if(dummy!=null){

			like.setMemberID(principal.getName());
			like.setTravelCode(tcode);

			likesDao.removeLike(like);
			model.addAttribute("tcode",tcode);
		}
		else{
			like.setMemberID(principal.getName());
			like.setTravelCode(tcode);

			likesDao.addLike(like);


			model.addAttribute("tcode",tcode);


		}


		return "redirect:travelDetail";
	}

	//스크랩 등록
	@RequestMapping(value="add_scrap")
	public String addScrap(Model model, Scrap scrap,String tcode, Principal principal){

		Scrap scrapCheak = scrapDao.getScrap(principal.getName(),tcode);
		String idCheak = travelDiaryDao.getTravelDiary(tcode).getMemberID();
				
		if (scrapCheak == null) 
		{
			if(!idCheak.equals(principal.getName()))
			{
				scrap.setMemberID(principal.getName());
				scrap.setTravelCode(tcode);

				scrapDao.addScrap(scrap);
			}
			
		}

				
		model.addAttribute("tcode",tcode);
		
		return "redirect:travelDetail";

	}
	
	

}
