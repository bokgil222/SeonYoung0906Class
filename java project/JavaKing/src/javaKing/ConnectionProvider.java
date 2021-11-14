package javaKing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		// thorws: 예외 처리를 메소드를 호출한 쪽(Main calss try문)에서 작성하게 만든다.
		// 메서드 내용과 예외처리 내용을 같이 작성하면 메서드가 길어지므로, 
		// 메서드 안에는 메서드 처리를 위한 핵심 내용만 작성하여 메서드의 코드를 간결화함
		// 예시: public void 메서드이름() throws 예외클래스이름{ }
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		// 데이터베이스 연결(Connection): String jdbcUrl = "jdbc:oracle:thin:@[주소]:[포트]:[데이터 베이스]";
		String user = "scott";  // SQL 유저 아이디
		String password = "tiger";  // SQL 유저 비밀번호

		return DriverManager.getConnection(jdbcUrl, user, password);
		// return: 현재 실행중인 메서드를 종료하고 호출한 메서드로 되돌아간다.	
		// Driver manager: SQL의 클래스
	}
}