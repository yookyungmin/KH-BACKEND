import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.processing.AbstractProcessor;

public class Exam05_CRUD2 {
	//강사님코드 PRPAREDSTATEMENT 사용
	//뷰(메인) 모델(CafeMenuDao) 나누기
	public static void main(String[] args)  {

//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		}catch (Exception e) {
//			e.printStackTrace();
//			System.exit(0); //DBMS연결 실패하면 시스템 종료
//		}
		Scanner sc = new Scanner(System.in);

		CafeMenuDAO dao = CafeMenuDAO.getInstance(); //static 메서드라서 객체생성없이 getInstance 호출
		//접속시마다 dao를 만드는게 아니라 하나의 Dao만 가지고 여러명이 사용

		while(true) {
			System.out.println("<< 카페 메뉴 관리 프로그램 >>");
			System.out.println("1. 신규 메뉴 등록");
			System.out.println("2. 메뉴 목록 출력");
			System.out.println("3. 메뉴 정보 삭제 (상품코드로 삭제)");
			System.out.println("4. 메뉴 정보 수정 (상품코드로 변경)");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu == 1) {
				System.out.print("메뉴 이름 : ");
				String pname = sc.nextLine();

				System.out.print("메뉴 가격 : ");
				int pprice = Integer.parseInt(sc.nextLine());

				System.out.print("아이스 가능 (Y,N) ? ");
				String iced = sc.nextLine();

				try {
					int result = dao.insert(new CafeMenuDTO(0, pname, pprice, iced)); //시퀸스값0 넣어도 ㄱㅊ
					if(result > 0) {
						System.out.println("입력 완료");
					}
				} catch (Exception e) {

					e.printStackTrace(); //반드시 남겨둠 에러의 원인을 보여줌
					System.out.println("같은 오류가 반복되면 관리자에게 문의하세요.");
				}

			}else if(menu == 2) {
				
				try {
				List<CafeMenuDTO> result = dao.selectAll(); //ArrayList가 List의 자손이기때문에 사용가능
				for(CafeMenuDTO dto :result) {
					System.out.println(dto.getPid()+"\t"+dto.getPname()+"\t"+dto.getPprice()+"\t"+dto.getIced());
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else if(menu == 3) {
				System.out.print("삭제할 상품 코드 : ");
				int delPID = Integer.parseInt(sc.nextLine());

				try {
					int result = dao.Delete(delPID);
					if(result > 0) {
						System.out.println("삭제 완료");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("같은 오류가 반복되면 관리자에게 문의하세요.");
				}

			}else if(menu == 4) {

				System.out.print("변경할 메뉴의 상품 코드 : ");
				int updPID = Integer.parseInt(sc.nextLine());


				try {

					if(dao.isPidExist(updPID)) {

						System.out.print("메뉴 이름 : ");
						String pname = sc.nextLine();

						System.out.print("메뉴 가격 : ");
						int pprice = Integer.parseInt(sc.nextLine());

						System.out.print("아이스 가능 (Y,N) ? ");
						String iced = sc.nextLine();
						int result = dao.update(new CafeMenuDTO(updPID, pname, pprice, iced));
						//고유값을 시퀸스로 써서 굳이 PID를 변경할 필요가 없다

						if(result > 0) {
							System.out.println("변경 완료");
						}
					}else {
						System.out.println("수정할 대상 메뉴가 존재하지 않습니다");
					}
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("문제가 발생했습니다. 관리자에게 문의하세요.");
				}

			}else if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}

	}
}