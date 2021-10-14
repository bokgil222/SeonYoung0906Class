package project;
// 저장 정보: 이름, 전화번호, 이메일, 주소, 생일, 그룹
// 기능: 위 데이터를 출력하는 기능

import java.util.Scanner;
public class Contact {

	// 변수들은 직접 참조를 막아 캡슐화 처리
	private String name;
	private String tel;
	private String email;
	private String address;
	private String birthday;
	private String group;

	// 변수의 직접 참조는 안되지만 변수의 값을 얻을 수 있는 메소드(getter)와
	// 변수에 값을 저장할 수 있는 메소드(setter)를 정의
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	// 연락처 데이터를 저장하는 인스턴스를 생성.
	public Contact(
			String name, 
			String tel, 
			String email, 
			String address, 
			String birthday, 
			String group) {
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
		}
	
	// 인스턴스 생성과 함께 데이터를 초기화 할 수 있도록 생성자를 정의.
	public Contact() {
	}
	
	public void showData() {
		System.out.println("이름:" + this.name);
		System.out.println("전화번호:" + this.tel);
		System.out.println("이메일:" + this.email);
		System.out.println("주소:" + this.address);
	    System.out.println("생일:" + this.birthday);
	    System.out.println("그룹:" + this.group);
	}
	
	// main()메소드를 정의.
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Contact c = new Contact();
		
		// 변수 값을 반환하는 각각의 메소드를 호출해서 각 데이터를 출력문으로 출력.
		// 생성된 인스턴스의 정보 출력 메소드를 호출.
		System.out.println("이름:" + c.getName());
		System.out.println("전화번호:" + c.getTel());
		System.out.println("이메일:" + c.getEmail());
		System.out.println("주소:" + c.getAddress());
		System.out.println("생일:" + c.getBirthday());
		System.out.println("그룹:" + c.getGroup());
		
		// 저장할 데이터를 콘솔에서 사용자의 입력 값으로 인스턴스를 생성.
		// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정.
		System.out.println();
		System.out.println("이름을 입력하세요.");
		System.out.print("> ");
		c.setName(scanner.nextLine());

		System.out.println("전화번호를 입력하세요.");
		System.out.print("> ");
		c.setTel(scanner.nextLine());
		
		System.out.println("이메일을 입력하세요.");
		System.out.print("> ");
		c.setEmail(scanner.nextLine());
		
		System.out.println("주소를 입력하세요.");
		System.out.print("> ");
		c.setAddress(scanner.nextLine());
		
		System.out.println("생일을 입력하세요.");
		System.out.print("> ");
		c.setBirthday(scanner.nextLine());
		
		System.out.println("그룹을 입력하세요.");
		System.out.print("> ");
		c.setGroup(scanner.nextLine());
		

		// 인스턴스의 출력메소드를 다시 실행.
		System.out.println("이름:" + c.getName());
		System.out.println("전화번호:" +c.getTel());
		System.out.println("이메일:" + c.getEmail());
		System.out.println("주소:" + c.getAddress());
		System.out.println("생일:" + c.getBirthday());
		System.out.println("그룹:" + c.getGroup());
		
		scanner.close();
	}
}

