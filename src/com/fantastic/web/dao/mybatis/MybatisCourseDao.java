package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.vo.Course;

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

      return dao.getCourse(travelCode);

}
   
   
}