package exam;

// 문제 1) 
// 다음 형태로 String 인스턴스를 생성.
// String str = "ABCDEFGHIJKLMN";
// 그리고 이 문자열을 역순을 다시 출력하는 프로그램을 작성

public class JavaAPI {
	public static void main(String[] args) {
		String str = "ABCDEFGHIJKLMN";
		
		StringBuffer reverse = new StringBuffer(str);
		System.out.println(reverse.reverse());

// 문제2)
// 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
// String str = "990929-1010123"
// 이 문자열을 이용하여 중간에 삽입된 -를 뺀 String 인스턴스를 생성.

		StringBuilder strB = new StringBuilder();
		strB.append("990929-1010123");
		strB.deleteCharAt(6);
		
		System.out.println(strB);
	}
}