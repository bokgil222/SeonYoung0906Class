package mm.assembler;

import mm.dao.MemberDao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

public class Assembler {

	// ������
	// ��ü�� ����: ��ü ����(���� ����), ����, ����
	
	// ����
	private MemberDao dao;
	private MemberRegService regService;
	private ChangePasswordService passwordService;
	
	// ��ü ����
	public Assembler() {
		dao = new MemberDao();
		regService = new MemberRegService();
		//regService.setDao(dao);
		regService.setDao(new MemberDao());
		passwordService = new ChangePasswordService(dao);
	}
	
	// ��ü ����
	public MemberDao getDao() {
		return dao;
	}
	
	public MemberRegService getRegService() {
		return regService;
	}
	
	public ChangePasswordService getPasswordService() {
		return passwordService;
	}
}