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

			// Ʈ������ ���� ����
			conn.setAutoCommit(false);

			// �޴� ����Ʈ�� Ȯ��
			list = menuDao.selectAllList(conn);

			System.out.println("�޴��� �����մϴ�.\n");
			System.out.println("==================================================");
			System.out.println("1. �ܹ��� 2. ���̵� �޴� 3. ���� 4. ����");
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
