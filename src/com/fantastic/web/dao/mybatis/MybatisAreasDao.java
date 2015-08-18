package com.fantastic.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.AreasDao;
import com.fantastic.web.vo.Areas;
import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.TravelDiary;


public class MybatisAreasDao implements AreasDao {
   
   //SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();
	
	private SqlSession session;
	

	   @Autowired
	   public void setSession(SqlSession session) {
			this.session = session;
		}

   @Override
   public List<Areas> getAreas(int page, String field, String query) {
     // SqlSession session = factory.openSession();
      AreasDao dao = session.getMapper(AreasDao.class);
      
      return dao.getAreas(page, field, query);
   }

   @Override
   public List<Areas> getAreas(int page) {
      // TODO Auto-generated method stub
      return null;
   }
   
   @Override
   public List<Areas> getAreas() {
   	// TODO 자동 생성된 메소드 스텁
   	return getAreas(1, "", "");
   }

   @Override
   public int addAreas(Areas areas) {
      
     // SqlSession session = factory.openSession();
      int result = 0;
     
         AreasDao dao = session.getMapper(AreasDao.class);
         result = dao.addAreas(areas);
    
      
      return result;
   }

   @Override
   public int removeAreas(String code) {

      //SqlSession session = factory.openSession();
      int result = 0;
      
         result = session.delete(
               "com.fantastic.java.dao.AreasDao.removeAreas", code);
      
      return result;
   }

@Override
public List<Areas> searchAreas(String areaQuery) {
	
	
	//AreasDao dao = session.getMapper(AreasDao.class);
	 /*List<Areas> list = dao.searchAreas(areaQuery);*/
	 
	 HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("areaQuery", areaQuery);
		
		/*List<Course> list = courseDao.searchCourse(headerQuery);*/
		
		List<Areas> list = session.selectList("searchAreas", params);
	
	return list;
}

/*--------------작성 중인 코드입니다. by 한--------------*/
@Override
public String getAreaCode(String areaName) {
	AreasDao dao = session.getMapper(AreasDao.class);
	String code = dao.getAreaCode(areaName);
	
	return code;
}


}