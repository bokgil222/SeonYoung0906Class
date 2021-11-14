package javaKing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {	
	public static void close(Connection conn) {   // connection: 특정 데이터베이스와의 연결
		if(conn != null) {
			// if (조건식) { }: 조건식이 참(ture)일 때 수행될 문장들을 적는다.
			// conn이 null이 아니면 try~catch문을 이용한 예외처리를 실행
			try {
				conn.close();  // 예외가 발생할 가능성이 있는 문장: connection 연결 종료
			} catch (SQLException e) {
				e.printStackTrace();
				// SQLException e가 발생했을 경우 처리하기 위한 문장
				// printStackTrace()를 통해 예외 발생 당시의 호출 스택에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
				// 예외의 발생 원인을 알 수 있다. 
			}
		}
	}	
	public static void close(Statement stmt) {   // statement: 컴파일된 SQL문을 나타내는 개체
		if(stmt != null) {   // stmt이 null이 아니면 try~catch문을 이용한 예외처리를 실행
			try {
				stmt.close();   // 예외가 발생할 가능성이 있는 문장: statement 연결 종료
			} catch (SQLException e) {
				e.printStackTrace();  // SQLException e가 발생했을 경우 처리하기 위한 문장
			}
		}
	}	
	public static void close(ResultSet rs) {
		// ResultSet: 데이터베이스를 쿼리하는 문을 실행하여 생성되는 데이터베이스 결과 집합을 나타내는 데이터 테이블
		if(rs != null) {    // rs가 null이 아니면 try~catch문을 이용한 예외처리를 실행
			try {
				rs.close();  // 예외가 발생할 가능성이 있는 문장: ResultSet 연결 종료
			} catch (SQLException e) {
				e.printStackTrace();  // SQLException e가 발생했을 경우 처리하기 위한 문장
			}
		}
	}
}
