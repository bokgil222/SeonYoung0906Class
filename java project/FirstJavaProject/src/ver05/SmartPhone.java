package ver05;

import java.util.Scanner;

public class SmartPhone {

	// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
	// ② 배열에 인스턴스를 저장, 수정, 삭제, 저장된 데이터의 리스트를 출력하는 
	//   메소드를 정의합니다.

	private Contact[] contacts; // Contact 타입의 인스턴스를 저장하는 배열을 선언(생성이 아니고 선언임, 생성은 new..)
	private int cnt; // 저장된 Contact 타입의 인스턴스 개수, 배열의 index로 사용

	public static Scanner sc = new Scanner(System.in); // scanner는 다른 곳에서도 쓸 변수라서 static을 사용

	public SmartPhone(int size) {
		contacts = new Contact[size]; // 배열 생성
		cnt = 0;
	}

	// 배열의 요소를 '추가'(반환안함)하는 메소드: 참조값을 전달받아 배열에 추가하는 기능
	public void addContact(Contact contact) {
		contacts[cnt++] = contact;
		System.out.println("데이터가 저장되었습니다.");
	}

	// 사용자로부터 데이터를 받아 Contact 객체를 생성하고 배열에 참조값을 저장하는 메소드 호출
	public void insertContact(int select) {
		System.out.println("연락처 등록을 시작합니다.");
		System.out.println("이름>>");
		String name = getString();

		System.out.println("전화번호>>");
		// String phoneNumber = getString();
		String phoneNumber = checkPhoneNumber();
		
//		if(checkPhoneNumber(phoneNumber)) {
//			System.out.println("입력한 전화번호가 이미 존재합니다.");
//			System.out.println("메뉴로 돌아갑니다.");
//			return;
//		}

		System.out.println("이메일>>");
		String email = getString();

		System.out.println("주소>>");
		String address = getString();

		System.out.println("생일>>");
		String birthday = getString();

		System.out.println("그룹>>");
		String group = getString();

		if (select == 1) {

			System.out.println("회사이름을 입력하세요. >>");
			String companyName = getString();
			System.out.println("부서이름을 입력하세요. >>");
			String divName = getString();
			System.out.println("직급을 입력하세요. >>");
			String job = getString();

			addContact(
					new CompanyContact(name, phoneNumber, email, address, 
							birthday, group, companyName, divName, job));

		} else { // select == 2

			System.out.println("거래처 회사이름을 입력하세요. >>");
			String companyName = getString();
			System.out.println("거래품목을 입력하세요. >>");
			String product = getString();
			System.out.println("담당자의 직급을 입력하세요. >>");
			String job = getString();

			addContact(
					new CustomerContact(name, phoneNumber, email, address, birthday, group, companyName, product, job));
		}
	}

	// 사용자로부터 문자열을 입력 받고 -> 공백 여부를 확인
	// -> 공백이면 다시 입력 -> 입력받은 데이터를 반환
	private String getString() {
		String result = null;

		while (true) {

			result = sc.nextLine();

			result = result.trim(); // " 손흥민" => "손흥민", " " =>""

			if (result.length() == 0) {
				System.out.println("공백입력은 허용하지 않습니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		return result;
	}

	// 전화번호를 받고 배열에 저장된 데이터와 비교 후 결과를 반환
	private boolean checkPhoneNumber(String number) {
		
		boolean chk = false;
			
		// 배열 반복하면서 전화번호 비교 -> 같은 번호가 있으면 -> chk=true
		for(int i =0; i < cnt; i++) {
			if(contacts[i].getPhoneNumber().equals(number)) {
				chk = true;
				break;
			}
		}
		
		return chk;
	}
	
	private String checkPhoneNumber() {
		
		String number = null;
		
		while(true) {
			
			number = sc.nextLine().trim(); // 사용자에게 입력받으면서 좌우의 여백 자름
			
			// 전화번호 존재 체크
			boolean chk = false;
			
			if(number.length() > 0) {
				
			for(int i = 0; i < cnt; i++) {
				
				if(contacts[i].getPhoneNumber().equals(number)) {
					
					chk = true;	 // 같으면 check 값을 true로 바꿈
					System.out.println("같은 번호가 존재합니다. 다시 입력하세요.");
					break;  // for문 벗어남
				}
			}	
			
			// 같은 번호가 존재하면 while문을 벗어나지 않는다.(같으면 벗어남)
			if(!chk) {  // true의 논리부정은 false 
				break;
			}
			
			} else {
				System.out.println("공백문자를 허용하지 않습니다. 다시 입력하세요.");		
			}
		}
		return number;
	}
	
	// 전체 데이터 출력: 배열은 반복문
	public void printAllData() {

		System.out.println("리스트를 출력합니다.("+cnt+"명)");
		System.out.println("=============================");

		for (int i = 0; i < cnt; i++) {
			contacts[i].printContact();
			System.out.println("------------------");
		}
	}

	public void printAllSimpleData() {
		System.out.println("리스트를 출력합니다.(" + cnt + "명)");
		System.out.println("=============================");

		for (int i = 0; i < cnt; i++) {
			contacts[i].printSimpleData();
			System.out.println("------------------");
		}
	}

	// 이름(문자열)을 전달받아서 배열의 각 요소의 이름과 비교, 같은 요소가 있으면 해당 index 반환
	private int searchIndex(String name) {
		int index = -1;

		// 배열의 요소를 반복해서 참조하고 이름과 비교 -> 찾으면 반복 종료 index 값을 주기
		for (int i = 0; i < cnt; i++) {
			if (contacts[i].getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}

	// 이름으로 검색(index 찾기) -> 해당 데이터 출력
	public void searchPrint() {

		System.out.println("검색을 시작합니다.");
		System.out.println("찾고자 하는 이름을 입력하세요. >>");
		String name = getString();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 이름 " + name + " 의 정보가 존재하지 않습니다."); // 찾는 데이터가 없다.
		} else {
			System.out.println("검색 결과입니다.");
			System.out.println("----------------------");
			contacts[index].printContact();
			System.out.println("----------------------");
		}
	}

	// 이름으로 검색 -> 해당 데이터 삭제
	public void deleteContact() {

		System.out.println("데이터 삭제를 시작합니다.");
		System.out.println("삭제하고자 하는 데이터의 이름을 입력하세요. >>");
		String name = getString();

		int index = searchIndex(name);
		// System.out.println(index);

		if (index < 0) {
			System.out.println("삭제하고자 하는 이름" + name + "의 데이터가 존재하지 않습니다.");
		} else {
			// 삭제 처리: index 위치의 참조값을 index+1 위치의 값으로 치환, 시프트

			if (cnt == 1 && index == 0) {
				contacts[0] = null;
				cnt--;
			} else {
				for (int i = index; i < cnt-1; i++) {
					contacts[i] = contacts[i + 1];
				}
				cnt--;
			}

			System.out.println(name + " 의 데이터가 삭제되었습니다.");
		}
	}

	// 이름으로 검색 -> 데이터 수정: 수정할 데이터를 받아서 처리
	public void editContact() {

		System.out.println("데이터 수정을 시작합니다.");
		System.out.println("변경을 원하는 정보의 이름을 입력하세요. >>");
		String name = getString();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 이름" + name + " 의 정보가 존재하지 않습니다.");
		} else {
			System.out.println("데이터 수정을 위해 각각의 데이터를 입력하세요.");

			System.out.println("이름>>");
			String ename = getString();

			System.out.println("전화번호>>");
			String phoneNumber = getString();

			System.out.println("이메일>>");
			String email = getString();

			System.out.println("주소>>");
			String address = getString();

			System.out.println("생일>>");
			String birthday = getString();

			System.out.println("그룹>>");
			String group = getString();

			// 회사 동료인지 고객인지 분기
			if (contacts[index] instanceof CompanyContact) {
				
				CompanyContact contact = (CompanyContact) contacts[index];
				
				System.out.println("회사이름을 입력하세요. >>");
				String companyName = getString();
				System.out.println("부서이름을 입력하세요. >>");
				String divName = getString();
				System.out.println("직급을 입력하세요. >>");
				String job = getString();

				contact.setName(ename);
				contact.setPhoneNumber(phoneNumber);
				contact.setEmail(email);
				contact.setAddress(address);
				contact.setBirthday(birthday);
				contact.setGroup(group);
				contact.setCompanyName(companyName);
				contact.setDivName(divName);
				contact.setJob(job);

			} else { // CustomerContact

				CustomerContact contact = (CustomerContact) contacts[index];

				System.out.println("거래처 회사이름을 입력하세요. >>");
				String companyName = getString();
				System.out.println("거래품목을 입력하세요. >>");
				String product = getString();
				System.out.println("담당자의 직급을 입력하세요. >>");
				String job = getString();

				contact.setName(ename);
				contact.setPhoneNumber(phoneNumber);
				contact.setEmail(email);
				contact.setAddress(address);
				contact.setBirthday(birthday);
				contact.setGroup(group);
				contact.setCompanyName(companyName);
				contact.setProduct(product);
				contact.setJob(job);

			}

			System.out.println(name + " 의 정보가 수정되었습니다.");
		}
	}
}
