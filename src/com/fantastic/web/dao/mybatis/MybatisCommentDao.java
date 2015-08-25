package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.CommentDao;
import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.vo.Comment;
import com.fantastic.web.vo.Course;

public class MybatisCommentDao implements CommentDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<Comment> getComments(int page, String field, String query) {

		CommentDao dao = session.getMapper(CommentDao.class);

		return dao.getComments(page, field, query);

	}

	@Override
	public List<Comment> getComments(int page) {


		return getComments(page,"TITLE", "");
	}


	@Override
	public int removeComment(String code) {

		int result = 0;

		CommentDao dao = session.getMapper(CommentDao.class);
		result = dao.removeComment(code);
		
		return result;
	}

	@Override
	public List<Comment> getComment(String travelCode) {
		// TODO Auto-generated method stub
		CommentDao dao = session.getMapper(CommentDao.class);

		return dao.getComment(travelCode);
	}

	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		
		int result = 0;

		CommentDao dao = session.getMapper(CommentDao.class);
		result =dao.addComment(comment);

		return result;
	}

	@Override
	public Comment getOneComment(String memberID, String code) {
		// TODO Auto-generated method stub
		
		CommentDao dao = session.getMapper(CommentDao.class);

		return dao.getOneComment(memberID, code);
	}

	@Override
	public int editCommnet(String contents, String code) {
		// TODO Auto-generated method stub
		
		int result = 0;

		CommentDao dao = session.getMapper(CommentDao.class);
		
		result = dao.editCommnet(contents, code);

		return result;
	}


}
