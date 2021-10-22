package project02;

//2. main()메소드를 아래의 요구조건을 정의해봅니다. 

//① SmartPhone 클래스의 인스턴스를 생성합니다.
//② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 
//SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다.
//③ 10번 반복해서 배열에 추가합니다.
//④ 배열의 모든 요소를 출력합니다.
//⑤ 배열의 모든 요소를 검색합니다.
//⑥ 배열의 요소를 삭제해 봅시다.
//⑦ 배열의 요소를 수정해 봅시다.

import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private smartPhone smartPhone;
	
	// 생성자
	public main() {
		// ① SmartPhone 클래스의 인스턴스를 생성합니다.
		smartPhone = new SmartPhone();
	}
	public static void main(String[] args) {
		
		Main main = new Main();
		
		//② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 
		//  SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다.
		//③ 10번 반복해서 배열에 추가합니다
		
		while(true) {
			main.showMenu();
			int userChoice = Integer.parseInt(sc.nextLine());
			
			switch (userChoice) {
			
			}
		}
	}
	
	
	public static void main(String)
	

}
