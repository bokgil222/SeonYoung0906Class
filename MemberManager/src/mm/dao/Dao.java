package mm.dao;

import java.util.Collection;

import mm.domain.Member;

public interface Dao {
	
	// ȸ�� ���� ����
	void insert(Member member);
	
	// ȸ�� ������ ����
	void update(Member member);
	
	// ȸ�� ������ email �˻� -> Member ��ü�� ��ȯ
	Member selectByEmail(String email);
	
	// ��ü ������ ��ȯ
	Collection<Member> selectAll();
}