package com.fantastic.web.dao;

import java.util.List;
import com.fantastic.web.vo.Admin;

public interface AdminDao {

	// field : �˻��ɼ� query : �˻��� startDate�� endDate : �Ⱓ ����
	public List<Admin> getAdmins(int page, String field, String query);

	// ��� �����ڸ� �˻��ϰ� ���� ��� page�� �Է�
	public List<Admin> getAdmins(int page);

	public List<Admin> getAdmins();

	// ������ �� ���� Ȯ��
	public Admin getAdmin(String id);

	//������ �߰�
	public int addAdmin(Admin admin);

	// ������ ����
/*	public int removeAdmin(String id);*/

	public int removeAdmin(Admin admin);
}
