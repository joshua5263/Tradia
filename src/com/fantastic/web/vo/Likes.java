package com.fantastic.web.vo;

import java.util.Date;

public class Likes {

	private String memberID;
	private String travelCode;
	private Date likeDate;

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
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	 
	
	
}
