package menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		MenuDao menuDao = MenuDao.getInstance();

		Connection conn = null;

		List<MenuDto> list = null;

		try {
			conn = ConnectionProvider.getConnection();

			// 트랜젝션 일의 단위
			conn.setAutoCommit(false);

			// 메뉴 리스트를 확인
			list = menuDao.selectAllList(conn);

			System.out.println("메뉴를 선택합니다.\n");
			System.out.println("==================================================");
			System.out.println("1. 햄버거 2. 사이드 메뉴 3. 음료 4. 종료");
			System.out.print("> ");
			int select = scanner.nextInt();
			System.out.println(menuDao.selectByMtype(conn, select));

			System.out.println("--------------------------------------------------\n");

			System.out.println("==================================================");

			conn.commit();

		} catch (SQLException e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}
}
