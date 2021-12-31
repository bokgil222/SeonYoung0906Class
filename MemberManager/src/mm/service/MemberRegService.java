package mm.service;

import mm.dao.Dao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

public class MemberRegService {

	//MemberDao dao = new MemberDao();  // ���� ����
	
	private Dao dao;  
	// DaoŸ���� ��ü�� ���Թ޴� ���: ������, setter �޼ҵ�
	
	public MemberRegService() {}
	
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public void regMember(RegRequest request) throws DuplicateMemberException {
		
		// �̸��� �ߺ� üũ
		Member member = dao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new DuplicateMemberException("�̹� �����ϴ� �̸���!");
		}
		
		dao.insert(request.toMember());
		System.out.println("[msg: ��ϵǾ����ϴ�.]");
	}
}