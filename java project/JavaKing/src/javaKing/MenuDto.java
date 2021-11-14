package javaKing;
public class MenuDto {
// DTO(Data Transfer Object): 데이터 전송 객체. 데이터가 포함된 객체를 한 시스템에서 다른 시스템으로 전달하는 작업을 처리하는 개체.
	
	// 변수
	private int mid; // 메뉴번호
	private String mname;  // 메뉴이름
	private int mprice;  //메뉴가격
	private int mtype;  // 메뉴종류
	private int mcount; // 메뉴수량

	// 생성자: 변수 초기화
	public MenuDto(int mid, String mname, int mprice, int mtype) {
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.mtype = mtype;
	}
	// 기본 생성자
	public MenuDto() {
	}	
	// getter, setter 메소드
	// getter: 클래스의 멤버 변수의 초기값을 그대로 가져와서 사용할 수 있도록 하는 메소드. 멤버변수의 초기값 설정에 관여할 수 없을 때 호출하여 단순하게 사용할 수 있다.
	// setter: 클래스에서 매개변수의 접근을 제한할 경우 setter()메소드를 통해 인스턴스 변수 값을 정할 수 있다.
	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMprice() {
		return mprice;
	}

	public void setMprice(int mprice) {
		this.mprice = mprice;
	}

	public int getMtype() {
		return mtype;
	}

	public void setMtype(int mtype) {
		this.mtype = mtype;
	}

	public int getMcount() {
		return mcount;
	}

	public void setMcount(int mcount) {
		this.mcount = mcount;
	}

	@Override
	public String toString() {
		return  mid + "번 메뉴\n" + "메뉴이름\t" + mname + "\n" + "가격 \t" + mprice + "\n";
		// toString 메소드를 이용해 String 형태로 변경하여 출력
	}
}