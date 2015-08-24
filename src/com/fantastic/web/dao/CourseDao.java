package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Course;
import com.fantastic.web.vo.TravelDiary;

public interface CourseDao {
   
   public List<Course> getCourses(
         int page,
         String field,
         String query
         );
   
   public List<Course> getCourses(
         int page
         );
   
   public List<Course> getCourse(String travelCode);

   public int addCourse(Course course);
   
   public int removeCourse(String code);
   
   public List<Course> searchCourse(String headerQuery);
   
   public List<Course> preferLocaCourse(String preferLocation);
   
   public List<Course> preferLocaCourses();
   
   public List<Course> preferLocaCoursePop(String preferLocation);
   
   public List<Course> preferLocaCoursesPop();
   
   /*----------------작성중인 부분입니다.----------------*/
   /*코스 사진 추가 by한*/
   public void addPic(String courseCode, String path);
   
   /*한 유저의 마지막 courseCode 구하기 by한*/
   public String getLastCode(String memberID);
}