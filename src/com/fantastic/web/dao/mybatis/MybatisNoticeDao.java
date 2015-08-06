package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fantastic.web.dao.NoticeDao;
import com.fantastic.web.dao.mybatis.SqlFantasticSessionFactory;
import com.fantastic.web.vo.Notice;

public class MybatisNoticeDao implements NoticeDao {

	SqlSessionFactory factory = new SqlFantasticSessionFactory()
			.getSqlSessionFactory();

	@Override
	public List<Notice> getNotices(int page, String field, String query) {

		SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);

		return dao.getNotices(1, "TITLE", "");
	}

	@Override
	public List<Notice> getNotices(int page) {

		SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);

		return dao.getNotices(page, "TITLE", "");
	}

	@Override
	public List<Notice> getNotices() {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);

		return dao.getNotices(1, "TITLE", "");
	}

	@Override
	public Notice getNotice(String code) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);

		return dao.getNotice(code);
	}

	@Override
	public int addNotice(Notice notice) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();

		int result = 0;

		try {
			result = session.insert(
					"com.fantastic.web.dao.NoticeDao.addNotice", notice);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public int editNotice(Notice notice) {

		SqlSession session = factory.openSession();

		int result = 0;

		try {
			result = session.update(
					"com.fantastic.web.dao.NoticeDao.editNotice", notice);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public int removeNotice(String code) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();

		int result = 0;

		try {
			result = session.delete(
					"com.fantastic.web.dao.NoticeDao.removeNotice", code);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

}
