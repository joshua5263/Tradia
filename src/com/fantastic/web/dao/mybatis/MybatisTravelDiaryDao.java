package com.fantastic.web.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.TravelDiary;

public class MybatisTravelDiaryDao implements TravelDiaryDao {

	@Autowired
	private SqlSession session;
	
	   /*public void setSession(SqlSession session) {
			this.session = session;
		}*/
	
	@Override
	public List<TravelDiary> getTravelDiarys(int page, String field, String query) {
		//SqlSession session = factory.openSession();
		List<TravelDiary> list = null;
		
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
			list = dao.getTravelDiarys(page, field, query);
		

		return list;
	}
	
	@Override
	public List<TravelDiary> getTravelDiarys(int page) {
		//SqlSession session = factory.openSession();
		List<TravelDiary> list = null;
		
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);		
			list = dao.getTravelDiarys(page);
		
		
		return list;
	}
	
	@Override
	public List<TravelDiary> getTravelDiarys() {
		//SqlSession session = factory.openSession();
		List<TravelDiary> list = null;
		
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
			list = dao.getTravelDiarys();
		
		
		return list;
	}

	@Override
	public List<TravelDiary> getTravelDiarysOne(String memberID) {
		//SqlSession session = factory.openSession();
		List<TravelDiary> list = null;
		
		
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);		
			list = dao.getTravelDiarysOne(memberID);
		
		
		return list;
	}
	
	/*�ϳ��� ����⸦ ��ȸ*/
	@Override
	public TravelDiary getTravelDiary(String code) {
	     // SqlSession session = factory.openSession();
	      TravelDiary diary = null;
	      
	      
	    	  TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
	    	  diary = dao.getTravelDiary(code);
	      

	      return diary;
	}

	@Override
	public int addTravelDiary(TravelDiary travelDiary) {
		//SqlSession session = factory.openSession();
		int result = 0;
		
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
			result = dao.addTravelDiary(travelDiary);
	
		
		return result;
		
		/*try{
		 result = session.insert(
				"com.fantastic.web.dao.TravelDiaryDao.addTravelDiary",travelDiary);
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}
		
		return result;*/
	}
	@Override
	public int removeTravelDiary(String code) {

		int result = 0;
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		result = dao.removeTravelDiary(code);

		return result;
	}

	@Override
	public int addBeforeTravelDiary(TravelDiary diary) {
		
		int result = 0;
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
		result = dao.addBeforeTravelDiary(diary);
		
		return result;
	}
}
