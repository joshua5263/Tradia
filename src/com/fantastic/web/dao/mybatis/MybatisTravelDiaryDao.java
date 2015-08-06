package com.fantastic.web.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.CommentDao;
import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.TravelDiaryDao;
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
	  // TODO Auto-generated method stub
	  
	  return getTravelDiarys(1,"TITLE", "");
	 }
	 @Override
	 public List<TravelDiary> getTravelDiarysOne(String memberID) {
	  
	  TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);  
	  
	  return dao.getTravelDiarysOne(memberID);
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
	  // TODO Auto-generated method stub
	    
	    TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
	       CourseDao couseDao = session.getMapper(CourseDao.class);
	       CommentDao commentDao = session.getMapper(CommentDao.class);
	       
	       TravelDiary t = dao.getTravelDiary(code);
	       t.setOneCourse(couseDao.getCourse(code));
	       t.setTravelCommnet(commentDao.getComment(code));
	       
	       return t;
	 } 


	@Override
	public void addBeforeTravelDiary(TravelDiary diary) {
		//SqlSession session = factory.openSession();
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);

			dao.addBeforeTravelDiary(diary);
		
	}
}
