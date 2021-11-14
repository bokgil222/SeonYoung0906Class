package javaKing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuMain {
	static Scanner scanner = new Scanner(System.in);
	// Scanner 클래스: Scanner 클래스의 객체를 생성하고, 콘솔 창에서 입력받을 있는 입력 스트림인 System.in을 이용해 사용자에게 입력받는다.   
	
	public void menuMain() {
		Cart cart = new Cart();
		
		MenuDao menuDao = MenuDao.getInstance();
		// SingleTon getInstance()를 통한 객체 사용: 
		// 싱글톤 방식은 최초 한 번만 메모리를 할당하고 할당된 메모리에서만 사용하는 방식.
		// new 연산자를 통해 객체를 생성하지 않고 getInstance() 메소드를 통해 객체를 반환한다. 
		
		Connection conn = null;   // Connection을 null로 초기화
		
		List<MenuDto> list = null;
		List<CartDto> cartList = new ArrayList<CartDto>();
		int menuNum =0;

		// 예외 처리(Exception handling):
		// 예외 발생 시 나머지 코드가 실행되지 않고 프로그램이 비정상적으로 종료되므로 예외 처리를 통해 정상적인 실행 상태를 유지해야 한다.
		// 예외 처리를 위해 "try ~catch문" 사용. 
		// try 블록 내에 예외가 발생할 가능성이 있는 문장을 적고, catch 블록 내에 SQLException e이 발생했을 경우 처리하기 위한 문장을 적는다.
		// 여러 종류의 예외 처리를 위해 하나 이상의 catch블럭을 넣을 수 있으며, 발생한 예외와 일치하는 한 개의 catch 블럭만 수행됨. 
		// 발생한 예외와 일치하는 catch블럭이 없으면 예외는 처리되지 않는다.

		try {
			conn = ConnectionProvider.getConnection();

			// 트랜잭션 시작(자동)
			conn.setAutoCommit(false);

			// 메뉴 리스트를 확인
			list = menuDao.selectAllList(conn);
			while(true) {
				// 사용자에게 메뉴종류 리스트 출력
				System.out.println("메뉴를 선택합니다.\n");
				System.out.println("==================================================");
				System.out.println("1. 햄버거 세트 2. 햄버거 3. 사이드 메뉴  4. 음료");
				System.out.print("> ");
				// Scanner로 사용자에게 메뉴종류(mtype) 선택받기
				int select = scanner.nextInt();
				// menueDao를 클래스의 selectByMtype 메소드를 이용해 사용자가 선택한 메뉴종류의 메뉴 리스트 출력
				System.out.println(menuDao.selectByMtype(conn, select));
				System.out.println("메뉴를 선택하세요. >");
				menuNum = scanner.nextInt();
				System.out.println("수량을 선택하세요. >");
				int count = scanner.nextInt();
				// selectMenu 메소드를 이용해 사용자에게 선택할 메뉴 입력받아서 리턴하고, 수량 받아서 DB에 업데이트
				menuDao.selectMenu(conn,menuNum,count);
				// 트랜잭션 커밋
				conn.commit();
				
				try {
					System.out.println("장바구니에 담는중...");
					cart.addCart(cartList,menuNum);
					Thread.sleep(3000);
					System.out.println("선택하신 메뉴를 장바구니에 담았습니다.");
					System.out.println("1. 계속 주문하기 2. 장바구니 보기");
					System.out.print("> ");
					int userChoice = scanner.nextInt();  
					
					if(userChoice == 2){
						cart.showCart(cartList);
						break;
					}  // 예외가 발생할 가능성이 있는 문장
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// InterruptedException e가 발생했을 경우 처리하기 위한 문장.
				// printStackTrace()를 통해 예외 발생 당시의 호출 스택에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다. 예외의 발생 원인을 알 수 있다. 				
			}
			
			System.out.println("--------------------------------------------------\n");
			System.out.println("==================================================");
			
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
