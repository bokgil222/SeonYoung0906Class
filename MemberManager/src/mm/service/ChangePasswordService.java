package mm.service;

import mm.dao.Dao;
import mm.domain.Member;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;

public class ChangePasswordService {

	private Dao dao;

	public ChangePasswordService() {
	}

	public ChangePasswordService(Dao dao) {
		this.dao = dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public void changePassword(String email, String oldPw, String newPw) throws NotFoundMemberException, IdPasswordNotMatchingException {

		// ȸ���� �����ϴ��� ���� -> ���� �߻�!
		Member member = dao.selectByEmail(email);

		if (member == null) {
			throw new NotFoundMemberException("��ϵ� ȸ�������� �����ϴ�.");
		}

		member.changePassword(oldPw, newPw);

		dao.update(member);

		System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
	}
}