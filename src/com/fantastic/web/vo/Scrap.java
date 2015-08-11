package com.fantastic.web.vo;

import java.util.Date;
import java.util.List;

public class Scrap {

	private String memberID;
	private String travelCode;
	private String scrapDate;

	private String code;
	private String title;
	private String fellowTraveler;
	private int totalCost;
	private String startDate;
	private String lastDate;
	private String memo;
	private int share;
	private Date regDate;
	private String mpic;
	private int likeCnt;
	
	private String scrapID;

	private List<Course> oneCourse;
	

	public List<Course> getOneCourse() {
		return oneCourse;
	}

	public void setOneCourse(List<Course> oneCourse) {
		this.oneCourse = oneCourse;
	}

	public String getScrapID() {
		return scrapID;
	}

	public void setScrapID(String scrapID) {
		this.scrapID = scrapID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFellowTraveler() {
		return fellowTraveler;
	}

	public void setFellowTraveler(String fellowTraveler) {
		this.fellowTraveler = fellowTraveler;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getMpic() {
		return mpic;
	}

	public void setMpic(String mpic) {
		this.mpic = mpic;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getTravelCode() {
		return travelCode;
	}

	public void setTravelCode(String travelCode) {
		this.travelCode = travelCode;
	}

	public String getScrapDate() {
		return scrapDate;
	}

	public void setScrapDate(String scrapDate) {
		this.scrapDate = scrapDate;
	}


}
