package com.fantastic.web.vo;

import java.util.Date;


public class Member {
   
   private String id;
   private String password;
   private int preferLocation;
   private String picture;
   private String background;
   private String levels;
    private String profile;
   private Date regDate;
   private int gender;
   private Date birthday;

   public Date getBirthday() {
      return birthday;
   }
   public void setBirthday(Date birthday) {
      this.birthday = birthday;
   }
   public int getGender() {
      return gender;
   }
   public void setGender(int gender) {
      this.gender = gender;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public int getPreferLocation() {
      return preferLocation;
   }
   public void setPreferLocation(int preferLocation) {
      this.preferLocation = preferLocation;
   }
   public String getPicture() {
      return picture;
   }
   public void setPicture(String picture) {
      this.picture = picture;
   }
   public String getBackground() {
      return background;
   }
   public void setBackground(String background) {
      this.background = background;
   }
   public String getProfile() {
      return profile;
   }
   public void setProfile(String profile) {
      this.profile = profile;
   }
   public Date getRegDate() {
      return regDate;
   }
   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }
   public String getLevels() {
      return levels;
   }
   public void setLevels(String levels) {
      this.levels = levels;
   }
   

   
}