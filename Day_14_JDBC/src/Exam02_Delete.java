import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class Exam02_Delete {

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
		
		String sql = "delete from cafe_menu where pid  = 1001"; //sql 삭제쿼리
	

		int result = stat.executeUpdate(sql);

		//step4 Query 실행 결과 확인
		if(result>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}

		con.commit();
		con.close(); //필수
	}

}
