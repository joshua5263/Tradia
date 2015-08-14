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
	
	/*post에 후기 부분을 업데이트*/
	/*public void addAfterword(String travelCode, String memo, int totalCost);*/
	public void addAfterword(String travelCode, String memo, String totalCost);
	
	/*travelCode가 일치하는 course의 cost를 모두 합하여 반환*/
	public int totalCost(String travelCode);
}
