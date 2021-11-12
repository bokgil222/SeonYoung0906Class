package menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Data Access Object : Sql ó���� �ϴ� Ŭ����
public class MenuDao {

	private MenuDao() {
	}

	private static MenuDao dao = new MenuDao();

	static public MenuDao getInstance() {
		return dao;
	}

	// ��ü ����Ʈ ���ϴ� �޼ҵ� : select -> Connection�� ���� �ް�, List<Menu>
	public List<MenuDto> selectAllList(Connection conn) {

		Statement stmt = null;
		ResultSet rs = null;
		List<MenuDto> result = new ArrayList<MenuDto>();

		try {
			// ��� ����
			stmt = conn.createStatement();

			String sql = "select * from menu";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(new MenuDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}

		} catch (SQLException e) {
			System.out.println("����");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return result;
	}

	// �޴������� �˻� �޼ҵ� : select -> Connection�� ���� �ް�, �޴� ��ȣ, menu
	public List<MenuDto> selectByMtype(Connection conn, int mtype) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// �˻� ��� : �޴�����
		List<MenuDto> menu = new ArrayList<MenuDto>();

		String sql = "select * from menu where mtype=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mtype);
			// Sql : Select
			
			// ��� -> 1 �Ǵ� 0��
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menu.add(new MenuDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return menu;
	}

	// �޴� ������ �Է� �޼ҵ� : insert -> Connection�� ���� �ް�, Menu ��ü�� ���� �޾Ƽ� �Է�
	public int insertMenu(Connection conn, MenuDto menu) {

		PreparedStatement pstmt = null;

		int resultCnt = 0;

		// Sql : insert
		String sql = "insert into menu values (?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// sql �Ķ���� ����
			pstmt.setInt(1, menu.getMid());
			pstmt.setString(2, menu.getMname());
			pstmt.setInt(3, menu.getMprice());
			pstmt.setInt(4, menu.getMtype());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;

	}

	// �޴� ������ �����ϴ� �޼ҵ� : update -> Connection�� ���� �ް�, Menu ��ü�� ���� �޾Ƽ� ����
	public int editMenu(Connection conn, MenuDto menu) {

		PreparedStatement pstmt = null;

		int resultCnt = 0;

		// Sql : update
		String sql = "update menu set mid=?, mname=? mprice=? mtype?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, menu.getMid());
			pstmt.setString(2, menu.getMname());
			pstmt.setInt(3, menu.getMprice());
			pstmt.setInt(4, menu.getMtype());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	// �޴� ������ �����ϴ� �޼ҵ� : delete -> Connection�� ���� �ް�, �޴���ȣ(PK)�� ���� �޾� ����
	public int deleteMenu(Connection conn, int mid) {

		PreparedStatement pstmt = null;
		int resultCnt = 0;

		// Sql : delete
		String sql = "delete from menu where mid=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

}
