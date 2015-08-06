package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.HelpDao;
import com.fantastic.web.dao.mybatis.SqlFantasticSessionFactory;
import com.fantastic.web.vo.Help;

public class MybatisHelpDao implements HelpDao {

	private SqlSession session;
	
	@Autowired	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Help> getHelps(int page, String field, String query) {
		
		//SqlSession session = factory.openSession();
		HelpDao dao = session.getMapper(HelpDao.class);

		return dao.getHelps(page, field, query);
	}

	@Override
	public List<Help> getHelp(int page) {
		
		//SqlSession session = factory.openSession();
		//HelpDao dao = session.getMapper(HelpDao.class);
		
		return getHelps(page, "TITLE", "");
	}
			
	@Override
	public List<Help> getHelps() {
		// TODO Auto-generated method stub
		
		//SqlSession session = factory.openSession();
		//HelpDao dao = session.getMapper(HelpDao.class);

		return getHelps(1, "TITLE", "");
	}
	
	@Override
	public Help getHelp(String code) {
		// TODO Auto-generated method stub
		
		//SqlSession session = factory.openSession();
		HelpDao dao = session.getMapper(HelpDao.class);
		
		return  dao.getHelp(code);
	}	

	@Override
	public int addHelp(Help help) {
		// TODO Auto-generated method stub
		
		//SqlSession session = factory.openSession();
		
		int result = 0;
		
		HelpDao dao = session.getMapper(HelpDao.class);
		
		result = dao.addHelp(help);
		
		/*try {*/
			/*result = session.insert("com.fantastic.web.dao.HelpDao.addHelp", help);
			session.commit();*/
		/*} finally {
			session.rollback();
			session.close();
		}*/
		return result;
	}

	@Override
	public int editHelp(Help help) {
		// TODO Auto-generated method stub
		
		//SqlSession session = factory.openSession();
		
		int result = 0;
		
		HelpDao dao = session.getMapper(HelpDao.class);
		
		result = dao.editHelp(help);
		
	/*	try {
			result = session.update(
					"com.fantastic.web.dao.HelpDao.editHelp", help);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}*/
		return result;
	}

	@Override
	public int removeHelp(String code) {
		// TODO Auto-generated method stub
		
		//SqlSession session = factory.openSession();
		
		int result = 0;
		
		HelpDao dao = session.getMapper(HelpDao.class);
		
		result = dao.removeHelp(code);
		
		/*try {
			result = session.delete(
					"com.fantastic.web.dao.HelpDao.removeHelp", code);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}*/
		return result;
	}

}
