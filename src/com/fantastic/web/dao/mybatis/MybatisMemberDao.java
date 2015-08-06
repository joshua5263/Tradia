package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.vo.Member;

public class MybatisMemberDao implements MemberDao {

	
	private SqlSession session;
	

   @Autowired
   public void setSession(SqlSession session) {
		this.session = session;
	}

@Override
   public List<Member> getMembers(int page, String field, String query) {

      //SqlSession session = factory.openSession();
      MemberDao dao = session.getMapper(MemberDao.class);
      return dao.getMembers(page, field, query);

   }

   @Override
   public List<Member> getMembers(int page) {
      //SqlSession session = factory.openSession();
      //MemberDao dao = session.getMapper(MemberDao.class);
      return getMembers(page, "TITLE", "");
   }

   public List<Member> getMembers() {
      //SqlSession session = factory.openSession();
      //MemberDao dao = session.getMapper(MemberDao.class);
      return getMembers(1, "TITLE", "");

   }

   @Override
   public Member getMember(String id) {
      //SqlSession session = factory.openSession();
      
      MemberDao dao = session.getMapper(MemberDao.class);
      return dao.getMember(id);
   }

   @Override
   public int addMember(Member member) {
      //SqlSession session = factory.openSession();
      MemberDao dao = session.getMapper(MemberDao.class);
      int result = 0;
      result = session.insert("com.fantastic.web.dao.MemberDao.addMember", member);
      
      return result;
   }

   @Override
   public int removeMember(String id) {
      //SqlSession session = factory.openSession();

      MemberDao dao = session.getMapper(MemberDao.class);
      int result = 0;
      result = session.delete("com.fantastic.web.dao.MemberDao.removeMember", id);
      
      return result;
   }

   public int modMember(Member member) {
     // SqlSession session = factory.openSession();
      MemberDao dao = session.getMapper(MemberDao.class);
      int result = 0;
      
      result = session.update("com.fantastic.web.dao.MemberDao.modMember", member);
      
      return result;
   }

	@Override
	public int preferLocaMember(Member member) {
		// SqlSession session = factory.openSession();
	    /* MemberDao dao = session.getMapper(MemberDao.class);
	     int result = 0;
	     
	     result = session.update("com.fantastic.web.dao.MemberDao.preferLocaMember", member);*/
	   
	     /*return result;*/
	     
	     int result = 0;			
			
	     MemberDao dao = session.getMapper(MemberDao.class);
			
		 result = dao.preferLocaMember(member);		
			
		 return result;
	}
}