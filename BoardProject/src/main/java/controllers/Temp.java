package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Temp {

	public static void main(String[] args) throws Exception{
		//톰캣이 메인을 가지고 있었기 떄문에 메인을 만들필요 없었다

		//Run on sever 톰캣 시작하것이냐ㅑ, JAVA APPLICATION 자바 메인을 시작할것이냐
		System.out.println("hello world"); 
		//자바 어플리케이션에서 jdbc 구동시키려면 external 라이브러리에서 ojdbc에 추가해야함 , lib폴더에 들어간 ojdbc는 톰캣에서만 인식
		
		//테스트 db 입력
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url="jdb:oracle:thin:@localhost:1521:xe";
		String id="kh";
		String pw="kh";
		
			String sql="insert into board values(board_seq.nextval,?,?,?,sysdate,0)";
		Connection con = DriverManager.getConnection(url, id, pw);
		PreparedStatement pstat = con.prepareStatement(sql);
		
		for(int i=1; i<144; i++) {
			pstat.setString(1, "Test"+i);
			pstat.setString(2, "Title"+i);
			pstat.setString(3, "Contents"+i);
			
			pstat.executeUpdate();
			Thread.sleep((long)(Math.random()*(700-200+1)+200));
			System.out.println(i+"번째 데이터 : test"+i);
			
		//	pstat.addBatch();
		}
	//	pstat.executeBatch();   //for문을 돌면서 어딘가에 누적시켜놨다가 executeBatch로 하면 효율적
		con.commit();
		con.close();
		
	}

}
