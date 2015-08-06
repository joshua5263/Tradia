package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.LikesDao;
import com.fantastic.web.vo.Likes;

public class MybatisLikesDao implements LikesDao {

	SqlSessionFactory factory = new SqlFantasticSessionFactory()
			.getSqlSessionFactory();

	@Override
	public List<Likes> getLikes(int page, String field, String query) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		LikesDao dao = session.getMapper(LikesDao.class);

		return dao.getLikes(1, "", "");
	}

	@Override
	public List<Likes> getLikes(int page) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		LikesDao dao = session.getMapper(LikesDao.class);

		return dao.getLikes(page);
	}

	@Override
	public List<Likes> getLikes() {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		LikesDao dao = session.getMapper(LikesDao.class);

		return dao.getLikes();
	}

	@Override
	public Likes getLike(String memberID) {
		SqlSession session = factory.openSession();
		LikesDao dao = session.getMapper(LikesDao.class);
		
		return dao.getLike(memberID);
	}
	
	@Override
	public int addLike(Likes like) {
		// TODO Auto-generated method stub
		
		SqlSession session = factory.openSession();
		int result = 0;

		try {
			LikesDao dao = session.getMapper(LikesDao.class);
			result = dao.addLike(like);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	/*@Override
	public int removeLike(String memberID, String travelCode) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		
		int result = 0;
		try {

			LikeDao dao = session.getMapper(LikeDao.class);
			result = dao.removeLike(memberID, travelCode);
			session.commit();
		} 
		
		finally {
			session.rollback();
			session.close();
		}
		return result;
	}*/
	
	@Override
	public int removeLike(Likes like) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		
		int result = 0;
		try {

			LikesDao dao = session.getMapper(LikesDao.class);
			result = dao.removeLike(like);
			session.commit();
		} 
		
		finally {
			session.rollback();
			session.close();
		}
		return result;
	}

}
