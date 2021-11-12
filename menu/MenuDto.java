package menu;

public class MenuDto {
	public int mid;
	public String mname;
	public int mprice;
	public int mtype;

	public MenuDto(int mid, String mname, int mprice, int mtype) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.mtype = mtype;
	}

	public MenuDto() {
	}

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

	@Override
	public String toString() {
		String menuType;
		if (mtype == 1) {
			menuType = "햄버거";
		} else if (mtype == 2) {
			menuType = "사이드 메뉴";
		} else {
			menuType = "음료";
		}

		return "\n[" + menuType + "]\n" + mid + "번 메뉴\n" + "메뉴이름\t" + mname + "\n" + "가격 \t" + mprice + "\n";

	}

}
