package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.mybatis.SqlFantasticSessionFactory;
import com.fantastic.web.dao.ScrapDao;
import com.fantastic.web.vo.Scrap;

public class MybatisScrapDao implements ScrapDao{

	
	SqlSessionFactory factory = new SqlFantasticSessionFactory().getSqlSessionFactory();

	@Override
	public List<Scrap> getScraps(int page, String field, String query) {
		// TODO Auto-generated method stub
		
		SqlSession session = factory.openSession();
		ScrapDao dao = session.getMapper(ScrapDao.class);
		
		return dao.getScraps(1, "", "");
	}

	@Override
	public List<Scrap> getScraps(int page) {
		// TODO Auto-generated method stub
		
		SqlSession session = factory.openSession();
		ScrapDao dao = session.getMapper(ScrapDao.class);
		
		return dao.getScraps(page);
	}

	@Override
	public List<Scrap> getScraps() {
		// TODO Auto-generated method stub
		
		SqlSession session = factory.openSession();
		ScrapDao dao = session.getMapper(ScrapDao.class);
		
		return dao.getScraps();
	}

	@Override
	public Scrap getScrap(String memberID) {
		// TODO Auto-generated method stub
		
		SqlSession session = factory.openSession();
		ScrapDao dao = session.getMapper(ScrapDao.class);
		
		return dao.getScrap(memberID);
	}

	@Override
	public int addScrap(Scrap scrap) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		int result = 0;

		try {
			ScrapDao dao = session.getMapper(ScrapDao.class);
			result = dao.addScrap(scrap);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public int removeScrap(Scrap scrap) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		int result = 0;

		try {
			ScrapDao dao = session.getMapper(ScrapDao.class);
			result = dao.removeScrap(scrap);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

}
