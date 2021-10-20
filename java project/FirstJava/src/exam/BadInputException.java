package exam;

public class BadInputException extends Exception {

	public BadInputException(String message) {
		super("입력하신 아이디 " + message + 
				"에 영문자와 숫자 이외의 문자가 포함되어 있습니다.");
	}
}
