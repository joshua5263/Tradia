package com.fantastic.web.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.CommentDao;
import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.ScrapDao;
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.Scrap;
import com.fantastic.web.vo.TravelDiary;

public class MybatisTravelDiaryDao implements TravelDiaryDao {

	@Autowired
	 private SqlSession session;
	 
	 @Override
	 public List<TravelDiary> getTravelDiarys(int page, String field, String query) {
	  
	  TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
	  CourseDao courseDao = session.getMapper(CourseDao.class);
	  
	  List<TravelDiary> list = dao.getTravelDiarys(page, field, query);
	  
	  for(TravelDiary t:list)
	    t.setOneCourse(courseDao.getCourse(t.getCode()));
	  
	  return list;
	 }
	 
	 @Override
	 public List<TravelDiary> getTravelDiarys(int page) {
	  
	  return getTravelDiarys(page,"TITLE", "");
	 }
	 
	 @Override
	 public List<TravelDiary> getTravelDiarys() {
	  
	  return getTravelDiarys(1,"TITLE", "");
	 }

	 public List<TravelDiary> getTravelDiaryScarp(String code) {
		 
		 TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		 CourseDao courseDao = session.getMapper(CourseDao.class);
		 
		 List<TravelDiary> list = dao.getTravelDiarysOne(code);
		 
		 for(TravelDiary t:list)
			 t.setOneCourse(courseDao.getCourse(t.getCode()));
		 
		 return list;
	 
	 }
	 
	 @Override
	 public List<TravelDiary> getTravelDiarysOne(String memberID) {
		  TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		  CourseDao courseDao = session.getMapper(CourseDao.class);
		  
		  List<TravelDiary> list = dao.getTravelDiarysOne(memberID);
		  
		  for(TravelDiary t:list)
		    t.setOneCourse(courseDao.getCourse(t.getCode()));
		  
		  return list;
	 }
	 
	 @Override
	 public int addTravelDiary(TravelDiary travelDiary) {
	  int result = 0;
	  
	  TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
	  result = dao.addTravelDiary(travelDiary);
	  return result;
	  
	 }
	    @Override
	  public int removeTravelDiary(String code) {
	  int result = 0;
	  
	  TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
	  result = dao.removeTravelDiary(code);
	  
	  return result;
	  
	}
	 @Override
	 public TravelDiary getTravelDiary(String code) {
	    TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
	    CourseDao couseDao = session.getMapper(CourseDao.class);
	    CommentDao commentDao = session.getMapper(CommentDao.class);
	       
	    TravelDiary t = dao.getTravelDiary(code);
	    t.setOneCourse(couseDao.getCourse(code));
	    t.setTravelCommnet(commentDao.getComment(code));
	       
	    return t;
	 }

	@Override
	public int addBeforeTravelDiary(TravelDiary diary) {
		int result = 0;
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		result = dao.addBeforeTravelDiary(diary);
		
		return result;
	}

	@Override

	public List<TravelDiary> getTravelDiaries(String code) {
		
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		List<TravelDiary> list = dao.getTravelDiaries(code);
		
		return list;
	}

	@Override
	public List<TravelDiary> getTravelDiariesOfSearch(String code) {
		
		TravelDiaryDao dao = (TravelDiaryDao)session.getMapper(TravelDiaryDao.class);
		CourseDao courseDao = session.getMapper(CourseDao.class);
		
		List<TravelDiary> travelList = dao.getTravelDiariesOfSearch(code);
		
		return travelList;
	}

	@Override
	public List<TravelDiary> getTravelDiariesByPreferLoca(String preferLocation) {
		 TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		  CourseDao courseDao = session.getMapper(CourseDao.class);
		  
		  List<TravelDiary> list = dao.getTravelDiariesByPreferLoca(preferLocation);
		  
		  for(TravelDiary t:list)
		    t.setOneCourse(courseDao.getCourse(t.getCode()));
		  
		  return list;
	}

	/*travelDiary의 마지막 코드 반환*/
	@Override
	public String getLastCode(String memberID) {
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		String lastCode = dao.getLastCode(memberID);
		
		return lastCode;
	}

	/*후기 추가*/
	@Override
	public void addAfterword(String travelCode, String memo) {
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		
		dao.addAfterword(travelCode, memo);
	}

	/*토탈 코스트 계산*/
	@Override
	public int getTotalCost(String travelCode) {
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		int result = dao.getTotalCost(travelCode);
		
		return result;
	}
}
