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
   
   //ȸ������
   public int addMember(Member member) ;
   
   //ȸ�� �����ϱ�
   public int removeMember(String id); 
   
   //��ȣ���� �����ϱ�
   public int preferLocaMember(Member member);
   
   //������ �� ����ϱ�
   public int updateMemberProfile(String profile, String id);
   
   //������ ���� ����ϱ�
   public int addProfilePicture(String picture, String id);
   
   //ȸ������ �����ϱ�(��й�ȣ ����)
   public int modMemberInfo(String password, String id);

   //ȸ������ �����ϱ�(���� ����)
   public int modMemberBirth(String birthday, String id);
   
   //ȸ������ �����ϱ�(���� ����)
   public int modMemberGender(int gender, String id);
   
   //ȸ������ �����ϱ�(��й�ȣ & ���� ����)
   public int modMemberInfoGender(String password, int gender, String id);
   
   //ȸ������ �����ϱ�(��й�ȣ & ���� ����)
   public int modMemberInfoBirth(String password, String birthday, String id);
   
   //ȸ������ �����ϱ�(���� & ���� ����)
   public int modMemberBirthGender(String birthday, int gender, String id);
   
   //ȸ������ �����ϱ�(��й�ȣ & ���� & ���� ����)
   public int modMemberInfoBirthGender(String password, String birthday, int gender, String id);
}