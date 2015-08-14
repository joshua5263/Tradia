package com.fantastic.web.vo;

import java.util.List;


public class Course {


	private String code;
	private int cost;
	private String memo;
	private String pic1;
	private String pic2;
	private String pic3;
	private String pic4;
	private String pic5;
	private String feeling;
	private String traffic;
	private String csDate;
	private String travelCode;
	private String areasCode;
	private String areasName;

	private List<TravelDiary> travelDiaries;
	private List<Course> oneCourse;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getPic3() {
		return pic3;
	}
	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}
	public String getPic4() {
		return pic4;
	}
	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}
	public String getPic5() {
		return pic5;
	}
	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}
	public String getFeeling() {
		return feeling;
	}
	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getCsDate() {
		return csDate;
	}
	public void setCsDate(String csDate) {
		this.csDate = csDate;
	}
	public String getTravelCode() {
		return travelCode;
	}
	public void setTravelCode(String travelCode) {
		this.travelCode = travelCode;
	}
	public String getAreasCode() {
		return areasCode;
	}
	public void setAreasCode(String areasCode) {
		this.areasCode = areasCode;
	}
	public List<TravelDiary> getTravelDiaries() {
		return travelDiaries;
	}
	public void setTravelDiaries(List<TravelDiary> travelDiaries) {
		this.travelDiaries = travelDiaries;
	}
	public List<Course> getOneCourse() {
		return oneCourse;
	}
	public void setOneCourse(List<Course> oneCourse) {
		this.oneCourse = oneCourse;
	}
	public String getAreasName() {
		return areasName;
	}
	public void setAreasName(String areasName) {
		this.areasName = areasName;
	}


}






