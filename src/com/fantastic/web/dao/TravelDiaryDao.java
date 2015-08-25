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
	
	public List<TravelDiary> getTravelDiaries(String code);
	
	public List<TravelDiary> getTravelDiariesByPreferLoca(String preferLocation);
	
	public List<TravelDiary> getTravelDiarys();
	
	public List<TravelDiary> getTravelDiarysOne(String memberID);
	
	public List<TravelDiary> getTravelDiaryScarp(String code);
    
	public TravelDiary getTravelDiary(String code);
	
	public int addTravelDiary(TravelDiary travelDiary) ;
	
	public int removeTravelDiary(String code);

	public int addBeforeTravelDiary(TravelDiary diary); 
	
	public List<TravelDiary> getTravelDiariesOfSearch(String code);

	public String getLastCode(String memberID);
	
	/*post�� �ı� �κ��� ������Ʈ by��*/
	public void addAfterword(String travelCode, String memo);
	
	public int getTotalCost (String travelCode);
	
}
