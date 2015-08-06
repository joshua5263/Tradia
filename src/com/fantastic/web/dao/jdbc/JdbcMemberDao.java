package com.fantastic.web.dao.jdbc;
/*package com.fantastic.java.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fantastic.java.dao.MemberDao;
import com.fantastic.java.vo.Member;

public class JdbcMemberDao implements MemberDao{

	@Override
	public List<Member> getMember(int page, String field, String query) {
		// TODO 자동 생성된 메소드 스텁
		
		List<Member> list = new ArrayList<Member>();
		
		 try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://win.newlecture.com:1433;" +
					"databaseName=fantasticdb;user=fantastic4;password=1390;";      
			
			Connection con = DriverManager.getConnection(url, "fantastic4", "1390");     
			String sql = "SELECT * FROM Fantastic";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			Member m;
			
			while(rs.next()){
				
				m = new Member();
				
				m.setId(rs.getString("UID"));
				m.setNickName(rs.getString("NICKNAME"));
				m.setPassword(rs.getString("PWD"));
				m.setPicture(rs.getString("IMAGE"));
				m.setBackground(rs.getString("BACKGROUND"));
				m.setPreferLocation(rs.getString("PREFERLOCATION"));
				m.setRegDate(rs.getDate("REGDATE"));
				
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	      
	      
	      
		return list;
	}

	@Override
	public List<Member> getMember(int page) {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	

}
*/