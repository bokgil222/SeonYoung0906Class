package chapter02;

public class Member {

//	�� String Ÿ���� �̸��� ������ �� �ִ� ���� name�� �����غ��ô�.
//	�� int Ÿ���� ���̸� ������ �� �ִ� ���� age�� �����غ��ô�.
//	�� double Ÿ���� Ű�� ������ �� �ִ� ���� height�� �����غ��ô�.
//	�� boolean Ÿ���� JAVAå�� ���� ���θ� ������ �� �ִ� ���� hasBook�� �����غ��ô�.
//	�� �̸��� ����, Ű, å�� ���� ���θ� ����غ��ô�
	
	// Ŭ���� ����
	// [����������] [final] Ŭ���� �̸� {}
	// {
	//  ���� ����
	//  �޼ҵ� ����
	// }
	// �ν��Ͻ� ������ �ڵ� �ʱ�ȭ
	String name;      // ������� �̸��� �����ϴ� ����
	int age;          // ������� ���̸� �����ϴ� ���� 
	double height;    // ������� Ű�� �����ϴ� ����
	// boolean hasBook;  // �ڹ� å ���� ����
	
	// ȸ���� �����͸� ����ϴ� �޼ҵ�
	void printData() {
		 System.out.println("�̸�:" + name);
		 System.out.println("����:" + age);
		 System.out.println("Ű:" + height);
		 // System.out.println("�ڹ� ������ ���� ����:" + hasBook);
	}
	
	public static void main(String[] args) {
		
		// long juminNumber = 9701011111111;
		
		// Member Ŭ������ �ν��Ͻ��� ���� -> �̸�(�⺻�� null), ����(0), Ű(0.0), å��������(false) ������ �� �ִ� �޸𸮰����� ����
		Member member = new Member();
		
		// �ν��Ͻ��� ������ �����ؼ� ���
//		 System.out.println("�̸�:" + member.name);
//		 System.out.println("����:" + member.age);
//		 System.out.println("Ű:" + member.height);
//		 System.out.println("�ڹ� ������ ���� ����:" + member.hasBook);
	
		member.printData();
		
		 // �ν��Ͻ� ������ ���� ����
		 member.name = "������";
		 member.age = 20;
		 member.height = 185.9;
		 // member.hasBook = true;
		 
		 System.out.println("------------------");
		 System.out.println("�ν��Ͻ� ������ ���� ����");
		 System.out.println("------------------");
		 
//		 System.out.println("�̸�:" + member.name);
//		 System.out.println("����:" + member.age);
//		 System.out.println("Ű:" + member.height);
//		 System.out.println("�ڹ� ������ ���� ����:" + member.hasBook);
		 
		 member.printData();
		 
		 // ���� �ڵ�� => �޼ҵ�� ���� => Member Ŭ�������� �޼ҵ带 
		 
	} 
}
