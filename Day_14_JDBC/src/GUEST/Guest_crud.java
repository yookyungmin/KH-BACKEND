package GUEST;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.lang.model.element.NestingKind;

public class Guest_crud {
	//강사님코드 PRPAREDSTATEMENT 사용
	//뷰(메인) 모델(CafeMenuDao) 나누기
	public static void main(String[] args) throws Exception {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //뷰단에 있기엔 적합하지는 않다
		}catch (Exception e) {
			e.printStackTrace();
			System.exit(0); //DBMS연결 실패하면 시스템 종료
		}
		Scanner sc = new Scanner(System.in);

		GuestDAO dao = new GuestDAO();

		while(true) {
			System.out.println("<< 방명록 관리 프로그램 >>");
			System.out.println("1. 신규 방명록 등록");
			System.out.println("2. 방명록 목록 출력");
			System.out.println("3. 방명록 정보 삭제 (글번호로 삭제)");
			System.out.println("4. 방명록 정보 수정 (글번호로 변경)");
			System.out.println("5. 방명록 검색(작성자로 검색)");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu == 1) {
				System.out.print("작성자 이름 : ");
				String name = sc.nextLine();

				System.out.print("작성 내용: ");
				String content = sc.nextLine();


				try {
					int result = dao.insert(name, content);
					if(result > 0) {
						System.out.println("입력 완료");
					}
				} catch (Exception e) {

					e.printStackTrace(); //반드시 남겨둠 에러의 원인을 보여줌//개발단계에선 넣고 배포단계에선 뺴줌
					System.out.println("같은 오류가 반복되면 관리자에게 문의하세요.");
				}

			}else if(menu == 2) {
			
				String url = "jdbc:oracle:thin:@localhost:1521:xe";

				String id = "GUEST";

				String pw = "GUEST";
			      String sql = "select * from cafe_menu order by 1";
			      try {
				Connection con = DriverManager.getConnection(url,id,pw);            
				            PreparedStatement pstat = con.prepareStatement(sql);
				            ResultSet rs = pstat.executeQuery();
				            
				            while(rs.next()) {
				               int pid = rs.getInt("bid");
				               String pname = rs.getString("bname");
				               int pprice = rs.getInt("pprice");
				               
				               Timestamp write_date = rs.getTimestamp("regdate");
				               SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일hh시mm분");
				               String formed_writeDate = sdf.format(write_date);
				               
				               System.out.println();
				            }
				            con.close();
			      }catch (Exception e) {
					// TODO: handle exception
				}
			}else if(menu == 3) {
				System.out.print("삭제할 방명록 번호 : ");
				int delBid = Integer.parseInt(sc.nextLine());

				try {
					int result = dao.Delete(delBid);
					if(result > 0) {
						System.out.println("삭제 완료");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("같은 오류가 반복되면 관리자에게 문의하세요.");
				}

			}else if(menu == 4) {
				System.out.println("수정할 글의 번호");
				int upBid = Integer.parseInt(sc.nextLine());
				
				System.out.println("수정 할 작성자");
				String name = sc.nextLine();
				
				System.out.println("수정 할 내용 ");
				String content = sc.nextLine();
			

			} else if(menu==5) { //검색기능 조회와 마찬가지
				System.out.println("작성자 이름 입력");
				String write = sc.nextLine();
				
			}
			else if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}

	}
}