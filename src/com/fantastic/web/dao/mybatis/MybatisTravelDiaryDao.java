package com.fantastic.web.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.TravelDiaryDao;
import com.fantastic.web.vo.TravelDiary;

public class MybatisTravelDiaryDao implements TravelDiaryDao {

	SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();
	/*SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();*/
	
	@Override
	public List<TravelDiary> getTravelDiarys(int page, String field, String query) {
		SqlSession session = factory.openSession();
		List<TravelDiary> list = null;
		try{
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
			list = dao.getTravelDiarys(page, field, query);
		} finally{
			session.close();
		}

		return list;
	}
	
	@Override
	public List<TravelDiary> getTravelDiarys(int page) {
		SqlSession session = factory.openSession();
		List<TravelDiary> list = null;
		try{
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);		
			list = dao.getTravelDiarys(page);
		}finally{
			session.close();
		}
		
		return list;
	}
	
	@Override
	public List<TravelDiary> getTravelDiarys() {
		SqlSession session = factory.openSession();
		List<TravelDiary> list = null;
		try{
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
			list = dao.getTravelDiarys();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<TravelDiary> getTravelDiarysOne(String memberID) {
		SqlSession session = factory.openSession();
		List<TravelDiary> list = null;
		
		try{
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);		
			list = dao.getTravelDiarysOne(memberID);
		}finally {
			session.close();
		}
		
		return list;
	}
	
	/*하나의 여행기를 조회*/
	@Override
	public TravelDiary getTravelDiary(String code) {
	      SqlSession session = factory.openSession();
	      TravelDiary diary = null;
	      
	      try {
	    	  TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
	    	  diary = dao.getTravelDiary(code);
	      }finally {
	    	  session.close();
	      }

	      return diary;
	}

	@Override
	public int addTravelDiary(TravelDiary travelDiary) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
			result = dao.addTravelDiary(travelDiary);
			session.commit();
		}finally {
			/*try가 정상실행되어 commit()이 실행됐다면 rollback()이 실행되어도 취소될 수 없다.*/
			session.rollback();
			session.close();
		}
		
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
		
		SqlSession session = factory.openSession();
		int result = 0;
		
		try{
			TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);
			result = dao.removeTravelDiary(code);
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}
		
		return result;
}


	@Override
	public void addBeforeTravelDiary(TravelDiary diary) {
		SqlSession session = factory.openSession();
		TravelDiaryDao dao = session.getMapper(TravelDiaryDao.class);

		try {
			dao.addBeforeTravelDiary(diary);
			session.commit();
		}finally {
			session.rollback();
			session.close();
		}
		
		
	}
}
