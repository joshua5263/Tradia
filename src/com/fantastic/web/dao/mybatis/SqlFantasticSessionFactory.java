package com.fantastic.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sun.org.apache.xml.internal.security.Init;

public class SqlFantasticSessionFactory extends HttpServlet {

	public static SqlSessionFactory ssf;
	
	public void init() throws javax.servlet.ServletException {
		// TODO Auto-generated method stub

	
		String resource = "com/fantastic/web/dao/mybatis/configuration.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		ssf = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	public SqlSessionFactory getSqlSessionFactory(){
		return ssf;
	}
}
