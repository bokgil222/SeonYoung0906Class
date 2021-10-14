package chapter05;

public class MemberMain {

	public static void main(String[] args) {
		// 회원의 정보를 저장하는 프로그램
		// 데이터를 저장할 수 있는 구조(클래스)를 만든다.
		// Member 클래스로 인스턴스를 생성하면 데이터를 저장하는 것과 같다.
		Member member1 = new Member(
				"손흥민", 
				"010-8888-0000", 
				"축구", 
				1, 
				"son@gmail.com", 
				"2000.09.10", 
				"런던");
		
		// 객체의 정보(데이터들) 출력
		member1.showData();

		Member member2 = new Member(
				"이강인", 
				"010-9999-0000", 
				"야구", 
				4, 
				"lee@naver.com", 
				"2001.05.20", 
				"서울");
		member2.showData();
	}
}
