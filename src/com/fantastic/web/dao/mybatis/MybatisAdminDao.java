package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.AdminDao;
import com.fantastic.web.vo.Admin;

public class MybatisAdminDao implements AdminDao {
	
	SqlSessionFactory factory = new SqlFantasticSessionFactory()
			.getSqlSessionFactory();

	// 모든 관리자 출력
	@Override
	public List<Admin> getAdmins(int page, String field, String query) {
		SqlSession session = factory.openSession();
		AdminDao dao = session.getMapper(AdminDao.class);

		return dao.getAdmins(page, field, query);
	}

	@Override
	public List<Admin> getAdmins(int page) {
		return getAdmins(page, "AdminID", "");
	}

	@Override
	public List<Admin> getAdmins() {
		return getAdmins(1, "AdminID", "");
	}

	// 관리자 1명 출력
	@Override
	public Admin getAdmin(String id) {
		SqlSession session = factory.openSession();
		AdminDao dao = session.getMapper(AdminDao.class);

		return dao.getAdmin(id);
	}

	// 관리자 추가
	@Override
	public int addAdmin(Admin admin) {
		SqlSession session = factory.openSession();

		int result = 0;
		// insert는 오토커밋 아님.
		try {
			AdminDao dao = session.getMapper(AdminDao.class);
			result = dao.addAdmin(admin);

			session.commit();
			
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	// 관리자 삭제
	/*	@Override
	public int removeAdmin(String id) {
		SqlSession session = factory.openSession();

		int result = 0;
		try {
			AdminDao dao = session.getMapper(AdminDao.class);
			result = dao.removeAdmin(id);
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}*/
	
	@Override
	public int removeAdmin(Admin admin) {
		SqlSession session = factory.openSession();

		int result = 0;
		try {
			AdminDao dao = session.getMapper(AdminDao.class);
			result = dao.removeAdmin(admin);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

}
