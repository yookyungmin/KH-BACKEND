import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exam05_CRUD4 {
	//preparedstatement 사용
	//내코드 CRUD 적용
	public static void main(String[] args) throws Exception {

		//Step1. DBMS 라이브러리 등록하기
		 try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }catch (Exception e) {
			e.printStackTrace();
			System.exit(0); //DBMS연결 실패하면 시스템 종료
		}

		Scanner sc = new Scanner(System.in);
		CafeMenuDAO2 dao = new CafeMenuDAO2();
		while(true) {
			System.out.println("<<카페 메뉴 관리 프로그램>>");
			System.out.println("1. 신규 메뉴 등록");
			System.out.println("2. 메뉴 등록 출력");
			System.out.println("3. 메뉴 삭제(상품코드로 삭제)");
			System.out.println("4. 메뉴 정보 수정(상품코드로 변경)");
			System.out.println("0. 프로그램 종료");
			System.out.println(">>");

			int menu = Integer.parseInt(sc.nextLine());

			if(menu == 1) {
				System.out.println("메뉴이름: ");
				String pname = sc.nextLine();


				System.out.println("메뉴 가격 : ");
				int pprice = Integer.parseInt(sc.nextLine());

				System.out.println("아이스 가능(Y,N) ? ");
				String iced = sc.nextLine();

				
				 try {
		        	   int result = dao.insert(pname, pprice, iced);
		        	   if(result > 0) {
		        		   System.out.println("입력 완료");
		        	   }
				} catch (Exception e) {
					
					e.printStackTrace(); //반드시 남겨둠 에러의 원인을 보여줌
					System.out.println("같은 오류가 반복되면 관리자에게 문의하세요.");
				}
				
			}else if(menu==2) {
				
				
				dao.printMenu();
			}else if(menu==3) {
				System.out.println("현재 메뉴판 : ");
				//DBMS접속
				Connection con = DriverManager.getConnection(dbURL,dbID, dbPW); 
				//Step3 Query 전달 인스턴스 생성 및 실행
				String sql1 = "select *from cafe_menu";
				PreparedStatement pstat = con.prepareStatement(sql1);
				
				
				ResultSet rs = pstat.executeQuery();
				
				while(rs.next()) {
					int pid = rs.getInt("pid");
					String pname = rs.getString("pname"); //
					int pprice = rs.getInt("pprice");
					String iced = rs.getString("iced");
					System.out.println(pid+": " +pname+": "+pprice+":" +iced);
				}
				
				System.out.println("삭제하실 상품 코드를 입력하세요");
					int delpid = Integer.parseInt(sc.nextLine());
			
				
					dao.Delete(delpid);
			}else if(menu==4) {
				System.out.println("현재 메뉴판 : ");
				//DBMS접속
				Connection con = DriverManager.getConnection(dbURL,dbID, dbPW); 
				//Step3 Query 전달 인스턴스 생성 및 실행
				String sql1 = "select *from cafe_menu";
				PreparedStatement pstat = con.prepareStatement(sql1);
				
				
				ResultSet rs = pstat.executeQuery();
				
				while(rs.next()) {
					int pid = rs.getInt("pid");
					String pname = rs.getString("pname"); //
					int pprice = rs.getInt("pprice");
					String iced = rs.getString("iced");
					System.out.println(pid+": " +pname+": "+pprice+":" +iced);
				}
				
				System.out.println("수정하실 번호를 입력하세요");
				int pid = Integer.parseInt(sc.nextLine());
				
				System.out.println("메뉴코드를 몇번으로 수정 하시겠습니까?");
				int uppid = Integer.parseInt(sc.nextLine());
				
				System.out.println("무슨 이름으로 바꾸시겠습니까?");
				String upname = sc.nextLine();
				
				System.out.println("얼마로 책정 하시겠습니까?");
				int uppprice = Integer.parseInt(sc.nextLine());
				System.out.println("아이스 가능(Y,N) ? ");
				String upiced = sc.nextLine();
				
				String sql = "update cafe_menu set pid = ?, pname = ?, pprice = ?, iced = ? where pid = ?"; //sql 업데이트쿼리

				PreparedStatement pstat1 = con.prepareStatement(sql);
				pstat1.setInt(1, uppid);
				pstat1.setString(2, upname);
				pstat1.setInt(3, uppprice);
				pstat1.setString(4, upiced);
				pstat1.setInt(5, pid);
				int result = pstat1.executeUpdate();
				
				   
	            if(result > 0) {
	               System.out.println("변경 완료");
	            }
				con.commit();
				con.close(); //필수
			}
			else if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			}else {
				System.out.println("메뉴를 다시 확인해주세요");
			}
		}

	}
}
