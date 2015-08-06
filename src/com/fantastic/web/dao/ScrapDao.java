package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Likes;
import com.fantastic.web.vo.Scrap;

public interface ScrapDao {
	
	public List<Scrap> getScraps(int page, String field, String query);

	public List<Scrap> getScraps(int page);

	public List<Scrap> getScraps();

	public Scrap getScrap(String memberID);

	public int addScrap(Scrap scrap);

	public int removeScrap(Scrap scrap);

}
