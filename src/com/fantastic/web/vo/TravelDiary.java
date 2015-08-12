package com.fantastic.web.vo;

import java.util.Date;
import java.util.List;

import com.fantastic.web.dao.CommentDao;
import com.fantastic.web.dao.CourseDao;
import com.fantastic.web.dao.mybatis.MybatisCommentDao;
import com.fantastic.web.dao.mybatis.MybatisCourseDao;

public class TravelDiary {
	
	private String code;
	private String title;
	private String fellowTraveler;
	private int totalCost;
	private String startDate;
	private String lastDate;
	private String memo;
	private int share;
	private Date regDate;
	private String memberID;
	private String mpic;
	private int likeCnt;
	
	private List<Course> oneCourse;
	private List<Comment> travelCommnet;
	
	public List<Course> getOneCourse() {
		return oneCourse;
	}
	public void setOneCourse(List<Course> oneCourse) {
		this.oneCourse = oneCourse;
	}
	public List<Comment> getTravelCommnet() {
		return travelCommnet;
	}
	public void setTravelCommnet(List<Comment> travelCommnet) {
		this.travelCommnet = travelCommnet;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getMpic() {
		return mpic;
	}
	public void setMpic(String mpic) {
		this.mpic = mpic;
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
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	
	

}
