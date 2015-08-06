package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Help;

public interface HelpDao {

	public List<Help> getHelps(int page, String field, String query);

	public List<Help> getHelp(int page);
	
	public List<Help> getHelps();
	
	public Help getHelp(String code);

	public int addHelp(Help help);
	
	public int editHelp(Help help);

	public int removeHelp(String code);
	
}
