import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class Exam03_update {
	//Americano 가격을 5000원으로 변경하는 프로그램 작성
	public static void main(String[] args) throws Exception {
		//Step1. DBMS 라이브러리 등록하기
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//Step 2. DBMS 에 접속하기
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW= "kh";
		
		Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
		
		//Step3 Query 전달 인스턴스 생성 및 실행
		Statement stat = con.createStatement();
		
		String sql = "update cafe_menu set pprice = 5000 where pname = 'Americano'"; //sql 업데이트쿼리
	

		int result = stat.executeUpdate(sql);

		//step4 Query 실행 결과 확인
		if(result>0) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패");
		}

		con.commit();
		con.close(); //필수
	}

}
