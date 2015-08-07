package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.TravelDiary;


public interface TravelDiaryDao {

	
	public List<TravelDiary> getTravelDiarys(
			int page,
			String field,
			String query
			);
	
	public List<TravelDiary> getTravelDiarys(
			int page
			);
	
	public List<TravelDiary> getTravelDiarys();
	
	public List<TravelDiary> getTravelDiarysOne(String memberID);
	
	public TravelDiary getTravelDiary(String code);

	public int addTravelDiary(TravelDiary travelDiary) ;
	
	public int removeTravelDiary(String code);

	public int addBeforeTravelDiary(TravelDiary diary); 
	
	public String getLastCode(String memberID);
}
