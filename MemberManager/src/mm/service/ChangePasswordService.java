// 8
package mm.service;

import mm.dao.Dao;
import mm.domain.Member;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;

public class ChangePasswordService {

	// �ν��Ͻ� ���� ����
	private Dao dao;

	// �⺻ ������
	public ChangePasswordService() {
	}

	public ChangePasswordService(Dao dao) {
		this.dao = dao;
	}

	// setter
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	// changePassword �޼ҵ� ����
	public void changePassword(String email, String oldPw, String newPw) throws NotFoundMemberException, IdPasswordNotMatchingException {

		// ȸ���� �����ϴ��� ���� Ȯ��
		Member member = dao.selectByEmail(email);
		
		// ���� �߻�: ȸ���� �������� ����
		if (member == null) {
			throw new NotFoundMemberException("��ϵ� ȸ�������� �����ϴ�.");
		}

		// ȸ���� ������ ���
		member.changePassword(oldPw, newPw);

		// password  ����
		dao.update(member);

		System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
	}
}