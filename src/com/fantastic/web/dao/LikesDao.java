package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Likes;

public interface LikesDao {

	public List<Likes> getLikes(int page, String field, String query);
	
	public List<Likes> getLikes(int page);
	
	public List<Likes> getLikes();
	
	public Likes getLike(String memberID);

	public int addLike(Likes like);
	
	/*public int removeLike(String memberID, String travelCode);*/
	
	public int removeLike(Likes like);
	
	
}
