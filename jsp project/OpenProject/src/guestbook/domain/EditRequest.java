package guestbook.domain;

public class EditRequest {

	// 빈즈 생성
	private int guestbookIdx;
	private int memberIdx;
	private String subject;
	private String content;
	
	public EditRequest() {
		
	}
	
	public EditRequest(int guestbookIdx, int memberIdx, String subject, String content) {
		super();
		this.guestbookIdx = guestbookIdx;
		this.memberIdx = memberIdx;
		this.subject = subject;
		this.content = content;
	}

	public int getGuestbookIdx() {
		return guestbookIdx;
	}

	public void setGuestbookIdx(int guestbookIdx) {
		this.guestbookIdx = guestbookIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}