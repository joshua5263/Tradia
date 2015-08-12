package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.LikesDao;
import com.fantastic.web.vo.Likes;



public class MybatisLikesDao implements LikesDao {

	@Autowired
	 private SqlSession session;

	@Override
	public List<Likes> getLikes(int page, String field, String query) {
		// TODO Auto-generated method stub

		LikesDao dao = session.getMapper(LikesDao.class);

		return dao.getLikes(1, "", "");
	}

	@Override
	public List<Likes> getLikes(int page) {
		// TODO Auto-generated method stub

		LikesDao dao = session.getMapper(LikesDao.class);

		return dao.getLikes(page);
	}

	@Override
	public List<Likes> getLikes() {
		// TODO Auto-generated method stub

		LikesDao dao = session.getMapper(LikesDao.class);

		return dao.getLikes();
	}
	
	

	@Override
	public Likes getLike(String memberID) {

		LikesDao dao = session.getMapper(LikesDao.class);
		
		return dao.getLike(memberID);
	}
	
	@Override
	public Likes getPageLike(String memberID, String travelCode) {
		// TODO Auto-generated method stub
		LikesDao dao = session.getMapper(LikesDao.class);
		
		return dao.getPageLike(memberID, travelCode);
	}
	
	@Override
	public int addLike(Likes like) 
	{
		int result = 0;

		LikesDao dao = session.getMapper(LikesDao.class);
		result = dao.addLike(like);
		
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

		int result = 0;

			LikesDao dao = session.getMapper(LikesDao.class);
			result = dao.removeLike(like);

		return result;
	}


}
