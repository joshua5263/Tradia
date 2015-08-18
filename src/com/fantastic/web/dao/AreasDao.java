package com.fantastic.web.dao;

import java.util.List;

import com.fantastic.web.vo.Areas;


public interface AreasDao {
   
   public List<Areas> getAreas(int page, String field, String query);
   
   public List<Areas> getAreas(int page);
   
   public List<Areas> getAreas();

   public int addAreas(Areas areas);

   public int removeAreas(String code);
   
   public List<Areas> searchAreas(String areaQuery);

   public String getAreaCode(String areaName);
}