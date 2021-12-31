package mm.main;

import java.util.Scanner;

import mm.assembler.Assembler;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

public class MemberManager {

	static Assembler assembler = new Assembler();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			 printMenu();
			 
			 String command = sc.nextLine();
			 
			 // exit
			 if(command.equals("exit")) {
				 System.out.println("���α׷� ����");
				 return;
			 }
			 
			 if(command.startsWith("new")) {
				 String[] values = command.split(" ");
				 processNewMember(values);
			 }
			 
			 if(command.startsWith("change")) {
				 processChangePassword(command.split(" "));
			 }
		}	
	}
	
	private static void processChangePassword(String[] values) {
		
		ChangePasswordService changePassword = assembler.getPasswordService();
		
		// change 
		// son@gmail.com 
		// 123 
		// 000
		try {
			
			changePassword.changePassword(values[1], values[2], values[3]);
			
		} catch (NotFoundMemberException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (IdPasswordNotMatchingException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	private static void processNewMember(String[] values) {
		
		MemberRegService regService = assembler.getRegService();
		
		// new 0 
		// son@gmail.com 1 
		// ����� 2
		// 123 3
		// 123 4
		RegRequest request = new RegRequest(values[1], values[3], values[4], values[2]);
		
		// ��й�ȣ�� ��й�ȣ Ȯ�� ��
		if(!request.isPwRePwEquals()){
			System.out.println("��й�ȣ�� ��й�ȣȮ�� �� ���� ��ġ ���� �ʽ��ϴ�.");
			return;
		}
		
		try {
			
			regService.regMember(request);
			
		} catch (DuplicateMemberException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	static void printMenu() {
		System.out.println();
		System.out.println("��ɾ� ����");
		System.out.println("-----------------------------------");
		System.out.println("�ű� �Է�");
		System.out.println("new �̸��� �̸� ��й�ȣ ��й�ȣȮ��"); // new son@gmail.com ����� 123 123
		System.out.println("new son@gmail.com ����� 123 123");
		System.out.println("��й�ȣ ����");
		System.out.println("change �̸��� ������ ���ο���"); // change son@gmail.com 123 000
		System.out.println("change son@gmail.com 123 000");
		System.out.println("-----------------------------------");
	}
}