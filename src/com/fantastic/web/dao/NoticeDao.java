package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Notice;

public interface NoticeDao {

	public List<Notice> getNotices(int page, String field, String query);

	public List<Notice> getNotices(int page);
	
	public List<Notice> getNotices();
	
	public Notice getNotice(String code);

	public int addNotice(Notice notice);
	
	public int editNotice(Notice notice);

	public int removeNotice(String code);
	
}
