package com.fantastic.web.vo;

import java.util.Date;
import java.util.List;

public class Comment {
	private String code;
	private String memberID;
	private String travelCode;
	private Date regDate;
	private String contents;
	private String mpic;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getMpic() {
		return mpic;
	}
	public void setMpic(String mpic) {
		this.mpic = mpic;
	}
	

}
