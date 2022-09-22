package GUEST;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam01_insert {

	public static void main(String[] args) throws Exception {
		//JDBC
		// JAVA DataBase Connectivity
		// 자바 프로그램을 통해서 DBMS를 사용하는 문법

		
		
		// new를 사용하지 않고 인스턴스를 만들어서 사용하는 하나의 방법
		//Step1. DBMS 라이브러리 등록하기
		Class.forName("oracle.jdbc.driver.OracleDriver"); 

		//Step 2. DBMS 에 접속하기
		//DriverManager = 클래스 getConnection = 스태틱 메서드 , 객체생성없이 메서드 사용
		//DriverManager = 클래스 getConnection = 스태틱 메서드
		//localhost = IP주소, 포트 = 포트번호 1521, sid = xe
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "GUEST";
		String dbPW = "GUEST";
		Connection con = DriverManager.getConnection(dbURL,dbID, dbPW); 
		
		//Step3 Query 전달 인스턴스 생성 및 실행
		Statement stat = con.createStatement();
		String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, 'Cafe Mocha', 4000, 'Y')";
		//select executeQuery
		//insert update delete executeUpdate
		int result = stat.executeUpdate(sql);
		
		//step4 Query 실행 결과 확인
		if(result>0) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
		//step 5. 마무리 작업
		con.commit();
		con.close();  //필수
	}
}
