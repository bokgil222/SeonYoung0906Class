// 8
package mm.service;

import mm.dao.Dao;
import mm.domain.Member;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;

public class ChangePasswordService {

	// 인스턴스 변수 생성
	private Dao dao;

	// 기본 생성자
	public ChangePasswordService() {
	}

	public ChangePasswordService(Dao dao) {
		this.dao = dao;
	}

	// setter
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	// changePassword 메소드 생성
	public void changePassword(String email, String oldPw, String newPw) throws NotFoundMemberException, IdPasswordNotMatchingException {

		// 회원이 존재하는지 여부 확인
		Member member = dao.selectByEmail(email);
		
		// 예외 발생: 회원이 존재하지 않음
		if (member == null) {
			throw new NotFoundMemberException("등록된 회원정보가 없습니다.");
		}

		// 회원이 존재할 경우
		member.changePassword(oldPw, newPw);

		// password  변경
		dao.update(member);

		System.out.println("비밀번호가 변경되었습니다.");
	}
}