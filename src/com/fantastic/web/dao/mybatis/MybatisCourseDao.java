package com.fantastic.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.TravelDiary;

public class MybatisCourseDao implements CourseDao{

	@Autowired
	private SqlSession session;

   @Override
   public List<Course> getCourses(int page, String field, String query) {
   
	  CourseDao dao = session.getMapper(CourseDao.class);

      return dao.getCourses(page, field, query);

   }

   @Override
   public List<Course> getCourses(int page) {
      // TODO 자동 생성된 메소드 스텁
	   
      return getCourses(page,"TITLE", "");
   }

   @Override
   public int addCourse(Course course) {

      int result = 0;
      CourseDao dao = session.getMapper(CourseDao.class);
      result = dao.addCourse(course);
      
      return result;
   }

   @Override
   public int removeCourse(String code) {

      int result = 0;
      CourseDao dao = session.getMapper(CourseDao.class);
      result = dao.removeCourse(code);
      
      return result;
   }

  @Override
  public List<Course> getCourse(String travelCode) {
	// TODO Auto-generated method stub

      CourseDao dao = session.getMapper(CourseDao.class);
      List<Course> list = dao.getCourse(travelCode);

      return list;

  }

@Override
public List<Course> searchCourse(String headerQuery) {
	
	CourseDao courseDao = session.getMapper(CourseDao.class);
	TravelDiaryDao travelDiaryDao = session.getMapper(TravelDiaryDao.class);	

	HashMap<String, Object> params = new HashMap<String, Object>();
	params.put("headerQuery", headerQuery);
	
	/*List<Course> list = courseDao.searchCourse(headerQuery);*/
	
	List<Course> list = session.selectList("searchCourse", params);
	
	for(Course c:list){
		c.setTravelDiaries(travelDiaryDao.getTravelDiariesOfSearch(c.getTravelCode()));
		c.setOneCourse(courseDao.getCourse(c.getTravelCode()));
	}
	
	return list;
}

@Override
public List<Course> preferLocaCourse(String preferLocation) {
	
	CourseDao courseDao = session.getMapper(CourseDao.class);
	TravelDiaryDao travelDiaryDao = session.getMapper(TravelDiaryDao.class);	
	
	List<Course> list = courseDao.preferLocaCourse(preferLocation);	
	
	for(Course c:list){
		c.setTravelDiaries(travelDiaryDao.getTravelDiariesOfSearch(c.getTravelCode()));
		c.setOneCourse(courseDao.getCourse(c.getTravelCode()));
	}
	
	return list;
}

@Override
public List<Course> preferLocaCourses() {
	CourseDao courseDao = session.getMapper(CourseDao.class);
	TravelDiaryDao travelDiaryDao = session.getMapper(TravelDiaryDao.class);
	
	List<Course> list = courseDao.preferLocaCourses();
	
	for(Course c:list){
		c.setTravelDiaries(travelDiaryDao.getTravelDiariesOfSearch(c.getTravelCode()));
		c.setOneCourse(courseDao.getCourse(c.getTravelCode()));
	}
	
	return list;
}
   
   
}