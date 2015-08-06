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
   
   public int addMember(Member member) ;
   
   public int removeMember(String id); 
   
   public int modMember(Member member);

   public int preferLocaMember(Member member);
}