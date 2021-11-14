package javaKing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {
	// DAO(Data Access Object): 데이터베이스의 데이터에 접근하기 위한 객체. 데이터베이스에 접근을 하기 위한 로직을 따로 분리하기 위해 사용한다.
	private MenuDao() {
	}
	// 기본 생성자: Beans 클래스 생성 시 반드시 기본 생성자가 있어야 한다.

	private static MenuDao dao = new MenuDao();
	// dao 변수를 가진 MenuDao 클래스 생성한다.

	static public MenuDao getInstance() {
		//// SingleTon getInstance()를 통한 객체 사용:
		// 싱글톤 방식은 최초 한 번만 메모리를 할당하고 할당된 메모리에서만 사용하는 방식이다.
		// new 연산자를 통해 객체를 생성하지 않고 getInstance() 메소드를 통해 객체를 반환한다.
		return dao;
	}

	// 전체 리스트 검색하는 메소드 : menuDto list로 select
	public List<MenuDto> selectAllList(Connection conn) {

		Statement stmt = null;
		// Statement를 null로 초기화
		ResultSet rs = null;
		// ResultSet을 null로 초기화
		List<MenuDto> result = new ArrayList<MenuDto>();
		// menu 전체 리스트를 담을 ArrayList 생성

		// try{} catch{} finally{}블럭:
		// try {예외가 발생할 가능성이 있는 문장들} catch {예외 처리를 위한 문장} finally {예외의 발생 여부와 관계없이 항상 수행할 문장들} 블럭
		try {
			// 결과 생성
			stmt = conn.createStatement();
			// 받아 온 connection 객체를 statement 객체에 담는다.

			String sql = "select * from menu";
			// SQL문(SELECT)를 통해 menu 테이블에 들어 있는 모든 자료 출력
			rs = stmt.executeQuery(sql);
			// SQL문(SELECT)의 return 값을 받아 와서 resultSet에 넘긴다.

			while (rs.next()) {
				result.add(new MenuDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
			// while문을 통해 가져 온 컬럼의 메뉴번호, 메뉴이름, 메뉴가격, 메뉴종류를 list에 더해준다.

		} catch (SQLException e) {
			System.out.println("예외"); // SQLException e 예외가 발생할 경우 "예외" 메시지 출력
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);  //resultSet 종료
			JdbcUtil.close(stmt);   // statement 종료
		}

		return result;
	}

	// 메뉴종류를 검색하는 메소드: 메뉴종류(mtype)로 select하고 매개변수 connection을 통해 메뉴종류 리스트 반환
	public List<MenuDto> selectByMtype(Connection conn, int mtype) {
		
		PreparedStatement pstmt = null;
		// prepareStatement를 null로 초기화
		ResultSet rs = null;
		// select에 대한 결과를 담아서 처리하기 위한 resultSet을 null로 초기화

		// 검색 결과 : 메뉴정보
		List<MenuDto> menu = new ArrayList<MenuDto>();
		// 메뉴종류 리스트를 담을 ArrayList 생성

		String sql = "select * from menu where mtype=?";
		// SQL문(SELECT)를 통해 menu 테이블의 mtype(메뉴종류) 출력
		
		// try{} catch{} finally{}블럭:
		// try {예외가 발생할 가능성이 있는 문장들} catch {예외 처리를 위한 문장} finally {예외의 발생 여부와 관계없이 항상 수행할 문장들} 블럭
		try {
			pstmt = conn.prepareStatement(sql);
			// 매개변수화 된 SQL문을 데이터베이스에 보내기 위한 prepareStatement문을 만든다.
			pstmt.setInt(1, mtype);
			// SQL문: SQL문(SELECT)를 통해 첫번째 물음표인 메뉴종류

			rs = pstmt.executeQuery();
			// SQL문(SELECT)의 return(결과) 값을 받아 와서 resultSet에 담는다.
			while (rs.next()) {
				menu.add(new MenuDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
			// while문을 통해 가져 온 메뉴종류 리스트(햄버거세트, 햄버거, 사이드 메뉴, 음료)를 menu에 더한다.
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return menu;
	}

	// 사용자에게 메뉴와 수량 선택 받아서 업데이트(수정)하는 메소드
	public int selectMenu(Connection conn, int menuNum, int count) {

		PreparedStatement pstmt = null;
		
		int resultCnt = 0;
		// int resultCount 값이 0으로 아직 수정되지 않은 상태
		
		String sql = "update menu set mcount =? where mid =?";
		// SQL문: SQL문(SELECT)를 통해 메뉴 수량을 업데이트(수정), 메뉴번호(mid)는 업데이트하지 않는다.

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);  // SQL문의 첫번째 물음표인 메뉴수량
			pstmt.setInt(2, menuNum);  // SQL문의 두번째 물음표인 메뉴번호
			resultCnt = pstmt.executeUpdate();  
			// SQL문(SELECT)의 return(결과) 값을 받아 와서 resultCnt에 담는다.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}
}