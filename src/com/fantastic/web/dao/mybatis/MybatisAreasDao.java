package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.AreasDao;
import com.fantastic.web.vo.Areas;


public class MybatisAreasDao implements AreasDao {
   
   SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();

   @Override
   public List<Areas> getAreas(int page, String field, String query) {
      SqlSession session = factory.openSession();
      AreasDao dao = session.getMapper(AreasDao.class);
      
      return dao.getAreas(page, field, query);
   }

   @Override
   public List<Areas> getAreas(int page) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public int addAreas(Areas areas) {
      
      SqlSession session = factory.openSession();
      int result = 0;
      try{
         AreasDao dao = session.getMapper(AreasDao.class);
         result = dao.addAreas(areas);
         
         session.commit();
      }
      finally{
         session.rollback();
         session.close();
      }
      
      return result;
   }

   @Override
   public int removeAreas(String code) {

      SqlSession session = factory.openSession();
      int result = 0;
      try {
         result = session.delete(
               "com.fantastic.java.dao.AreasDao.removeAreas", code);
         session.commit();
      } finally {
         session.rollback();
         session.close();
      }
      return result;
   }
}