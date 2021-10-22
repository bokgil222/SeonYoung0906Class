package project02;

import project01.contact;

import project01.Contact;

// 프로젝트 2
// 프로젝트 1 에서 정의한 Contact 클래스를 기반으로 
// 아래 요구사항을 추가해서 프로그램을 작성 합니다. 

// 1. SmartPhone 클래스를 정의합니다. 이 클래스는 연락처 정보를 관리하는 클래스입니다. 
//    ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
//    ② 배열에 인스턴스를 저장, 수정, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

public class SmartPhone {
	private final int ARRAYSIZE = 10;
	private Contact[] arr;
	private int ArraySize;
	
	// 생성자
	public SmartPhone() {
		arr = new Contact[ARRAYSIZE];
		ArraySize = 0;
	}
	public Contact[] getArr() {
		return arr;
	}
	public int getArraySize() {
		return ArraySize;
	}
	
	// 배열에 인스턴스를 저장
	public void add(Contact obj) {
		arr[ArraySize++] = obj;
	}
	
	// 배열에 인스턴스를 수정

	public void change(Contact oldObj, Contact newObj) {
		if(indexOf(oldObj.getName() >= -1) {
			arr[indexOf(oldObj.getName())] = newObj;
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("존재하지 않는 연락처입니다.");
		}
	}
	
	// 리스트 출력
	public void printList() {
		for(int i = 0; i < ArraySize; i++) {
			System.out.println(" ".concat(arr[i].getName().contact("\t"));
			
			if (i == 4) {
				System.out.println("\n");
			}
		}
		System.out.println();
	}
	
	// 검색
	public void search(String name) {
		for (int i = 0; i < ArraySize; i++) {
			if(indexOf(name) > -1) {
				System.out.println(arr[indexOf(name)].toString());
				break;
			} else {
				System.out.println("존재하지 않는 연락처입니다.");
			}
		}
	}
	
	// 삭제
	public void delete(String name) {
		int index = indexOf(name);
		if(index > -1) {
			for (int i = index; i < ArraySize; i++) {
				arr[index] = arr[index + 1];
			}
			ArraySize--;
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("존재하지 않는 연락처입니다.");
		}
	}
	
	// indexOf
	public int indexOf(String name) {
		int index = -1;
		for (int i = 0; i < ArraySize; i++) {
			if(arr[i].getName().equals(name)) {
				return i;
			}
		}
		return index;
	}
}