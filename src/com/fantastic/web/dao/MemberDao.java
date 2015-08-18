package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Member;

public interface MemberDao {

   public List<Member> getMembers(
         int page,
         String field,
         String query
         );
   
   public List<Member> getMembers(
         int page
         );

   public List<Member> getMembers();
   
   public Member getMember(String id);
   
   //public Member getMember();
   
   //회원가입
   public int addMember(Member member) ;
   
   //회원 삭제하기
   public int removeMember(String id); 
   
   //선호지역 변경하기
   public int preferLocaMember(Member member);
   
   //프로필 글 등록하기
   public int updateMemberProfile(String profile, String id);
   
   //프로필 사진 등록하기
   public int addProfilePicture(String picture, String id);
   
   //회원정보 변경하기(비밀번호 변경)
   public int modMemberInfo(String password, String id);

   //회원정보 변경하기(생일 변경)
   public int modMemberBirth(String birthday, String id);
   
   //회원정보 변경하기(성별 변경)
   public int modMemberGender(int gender, String id);
   
   //회원정보 변경하기(비밀번호 & 성별 변경)
   public int modMemberInfoGender(String password, int gender, String id);
   
   //회원정보 변경하기(비밀번호 & 생일 변경)
   public int modMemberInfoBirth(String password, String birthday, String id);
   
   //회원정보 변경하기(생일 & 성별 변경)
   public int modMemberBirthGender(String birthday, int gender, String id);
   
   //회원정보 변경하기(비밀번호 & 생일 & 성별 변경)
   public int modMemberInfoBirthGender(String password, String birthday, int gender, String id);
}