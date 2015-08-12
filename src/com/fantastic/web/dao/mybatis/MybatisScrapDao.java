package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.ScrapDao;
import com.fantastic.web.vo.Scrap;

public class MybatisScrapDao implements ScrapDao{

	@Autowired
	 private SqlSession session;

	@Override
	public List<Scrap> getScraps(int page, String field, String query) {
		// TODO Auto-generated method stub

		ScrapDao dao = session.getMapper(ScrapDao.class);
		
		return dao.getScraps(1, "", "");
	}

/*	@Override
	public List<Scrap> getScraps(int page) {
		// TODO Auto-generated method stub

		ScrapDao dao = session.getMapper(ScrapDao.class);
		
		return dao.getScraps(page);
	}
*/
	@Override
	public List<Scrap> getScraps() {
		// TODO Auto-generated method stub

		ScrapDao dao = session.getMapper(ScrapDao.class);
		
		return dao.getScraps();
	}

	@Override
	public Scrap getScrap(String memberID) {
		// TODO Auto-generated method stub

		ScrapDao dao = session.getMapper(ScrapDao.class);
		
		return dao.getScrap(memberID);
	}

	@Override
	public int addScrap(Scrap scrap) {
		// TODO Auto-generated method stub

		int result = 0;

			ScrapDao dao = session.getMapper(ScrapDao.class);
			result = dao.addScrap(scrap);

		return result;
	}

	@Override
	public int removeScrap(Scrap scrap) {
		// TODO Auto-generated method stub

		int result = 0;

			ScrapDao scrapdao = session.getMapper(ScrapDao.class);
			result = scrapdao.removeScrap(scrap);

		return result;
	}

	@Override
	public int removeScrap(String memberID, String travelCode) {
		
		int result = 0;

		ScrapDao scrapdao = session.getMapper(ScrapDao.class);
		result = scrapdao.removeScrap(memberID, travelCode);

		return result;
	}
	
	@Override
	public List<Scrap> getScraps(String scrapID) {
				
		CourseDao courseDao = session.getMapper(CourseDao.class);
		ScrapDao scrapDao = session.getMapper(ScrapDao.class);
			 
		List<Scrap> list = scrapDao.getScraps(scrapID);
			 
		  for(Scrap sc:list)
			    sc.setOneCourse(courseDao.getCourse(sc.getCode()));
			 
		return list;				
	}
}
