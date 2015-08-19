package com.fantastic.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
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

	//ID로 멤버 가져오기
	@Override
	public Member getMember(String id) {
		//SqlSession session = factory.openSession();

		MemberDao dao = session.getMapper(MemberDao.class);
		return dao.getMember(id);
	}

	//회원가입
	@Override
	public int addMember(Member member) {
		//SqlSession session = factory.openSession();
		int result = 0;
		MemberDao dao = session.getMapper(MemberDao.class);
		result = dao.addMember(member);

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

	
	//선호지역 변경
	@Override
	public int preferLocaMember(Member member) {

		int result = 0;			

		MemberDao dao = session.getMapper(MemberDao.class);

		result = dao.preferLocaMember(member);		

		return result;
	}

	//프로필 글 변경
	@Override
	public int updateMemberProfile(String profile, String id) {

		int result = 0;			

		MemberDao dao = session.getMapper(MemberDao.class);

		result = dao.updateMemberProfile(profile, id);		

		return result;
	}

	
	//프로필 사진 변경
	@Override
	public int addProfilePicture(String picture, String id) {
		
		int result = 0;
				
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.addProfilePicture(picture, id);
		
		return result;
	}
	
	//프로필 배경 변경
	@Override
	public int addProfileBackground(String background, String id) {
		int result = 0;
		
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.addProfileBackground(background, id);
		
		return result;
	}

	//회원 정보 변경하기(비밀번호 변경)
	@Override
	public int modMemberInfo(String password, String id) {
		int result = 0;
		
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.modMemberInfo(password, id);
		
		return result;
	}

	//회원 정보 변경하기(생일 변경)
	@Override
	public int modMemberBirth(String birthday, String id) {
		int result = 0;
		
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.modMemberBirth(birthday, id);
		
		return result;
	}

	//회원 정보 변경하기(성별 변경)
	@Override
	public int modMemberGender(int gender, String id) {
		int result = 0;
		
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.modMemberGender(gender, id);
		
		return result;
	}

	//회원 정보 변경하기(비밀번호 & 성별 변경)
	@Override
	public int modMemberInfoGender(String password, int gender, String id) {
		int result = 0;
		
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.modMemberInfoGender(password, gender, id);
		
		return result;
	}

	//회원 정보 변경하기(비밀번호 & 생일 변경)
	@Override
	public int modMemberInfoBirth(String password, String birthday, String id) {
		int result = 0;
		
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.modMemberInfoBirth(password, birthday, id);
		
		return result;
	}

	//회원 정보 변경하기(생일 & 성별 변경)
	@Override
	public int modMemberBirthGender(String birthday, int gender, String id) {
		int result = 0;
		
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.modMemberBirthGender(birthday, gender, id);
		
		return result;
	}

	//회원 정보 변경하기(비밀번호 & 생일 & 성별 변경)
	@Override
	public int modMemberInfoBirthGender(String password, String birthday,
			int gender, String id) {
		int result = 0;
		
		MemberDao dao = session.getMapper(MemberDao.class);
		
		result = dao.modMemberInfoBirthGender(password, birthday, gender, id);
		
		return result;
	}

	

}