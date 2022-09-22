import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class Exam04_select {

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
		
		String sql = "select * from cafe_menu"; //sql select 문
	
		ResultSet rs = stat.executeQuery(sql); //ResultSet select쿼리를 날린값을 가지고 있는 값이 아님
		//쿼리를 날려 발생시킨 주소의 데이터를 가리키고 있다 화살표로

		//rs.next(); // 화살표를 다음 한행 내리고 데이터가 있으면 true  ///boolean 리턴은 의무문으로읽기
	
		while(rs.next()) {
			// int pid = rs.getInt(1); //첫번쨰 컬럼이라 1 가능, //컬럼명은 똑같이, 참조변수 다르게 가능
		int pid = rs.getInt("pid"); // Resultset 가르키고 있는 행에서 pid라는 컬럼을 가져온다
		String pname = rs.getString("pname");  
		int pprice = rs.getInt("pprice");
		System.out.println(pid+":"+pname+":"+pprice);
		}
		
		//java.sql.sqlException : 결과 집합 모두 소모< 다음 행이 없을시
		
		
		//commit은 불필요 
		//입력해서 데이터 넘겨서 저장하는게 아니라 그냥 출력만 하면 되어서
		con.close(); //필수
	}

}
