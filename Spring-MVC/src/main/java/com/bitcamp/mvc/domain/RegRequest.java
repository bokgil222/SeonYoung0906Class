package com.bitcamp.mvc.domain;

public class RegRequest {
	
	// 변수
	private String uid;
	private String pw;
	private String uname;
	
	// 기본 생성자
	public RegRequest() {}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "RegRequest [uid=" + uid + ", pw=" + pw + ", uname=" + uname + "]";
	}
}