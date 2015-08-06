package com.fantastic.web.dao;

import java.util.List;
import com.fantastic.web.vo.Admin;

public interface AdminDao {

	// field : 검색옵션 query : 검색어 startDate와 endDate : 기간 설정
	public List<Admin> getAdmins(int page, String field, String query);

	// 모든 관리자를 검색하고 싶을 경우 page만 입력
	public List<Admin> getAdmins(int page);

	public List<Admin> getAdmins();

	// 관리자 상세 정보 확인
	public Admin getAdmin(String id);

	//관리자 추가
	public int addAdmin(Admin admin);

	// 관리자 삭제
/*	public int removeAdmin(String id);*/

	public int removeAdmin(Admin admin);
}
