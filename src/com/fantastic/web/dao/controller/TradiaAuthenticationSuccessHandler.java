package com.fantastic.web.dao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.vo.Member;

public class TradiaAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {		
		//�α��� �� ���� ���̵� ��������
		String uid = authentication.getName();
		
		//������ DefaultRole�� �������� ���� Member vo�� Dao import
		Member m = memberDao.getMember(uid);
		
		//������ DefaultRole�� type�̶�� ������ ���
		String type = m.getLevels();
		
		//�Ϲ� ������ ��� �α��� ���� �� �̵��� Ÿ�� ������
		String targetUrl = "/selectpreferlocation/selectpreferlocation";
		
		//���ҿ� ���� �α��� ���� �� �̵��� Ÿ�� ������ ���ǹ����� ����
		if(type.equals("ROLE_Admin")){
			targetUrl = "/main/travelMain";
		}
		
		//RedirectStrategy�� ���� ������ �̵���Ű��
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
}
