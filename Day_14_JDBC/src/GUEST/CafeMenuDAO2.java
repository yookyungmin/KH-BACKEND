package GUEST;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//데이터 접근 오브젝트 DAO
public class CafeMenuDAO2 {
	//Exam05_CRUD4랑 호환

	public int insert(String pname, int pprice, String iced) throws Exception{ 
		//throws Exception은 메서드에 넣어서 예외발생시 콜러(메서드 콜한 메인)한테 넘어간다 
		//메인메서드에선 throws Exception 하면 안됨 최후보루
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";

		//DBMS접속
		Connection con = DriverManager.getConnection(url,id,pw); 
		//Step3 Query 전달 인스턴스 생성 및 실행
		//Statement stat = con.createStatement();  //해킹에 취약점이 있다
		String sql1 = "insert into cafe_menu values(Cafe_menu_seq.nextval,?,?,?)";

		PreparedStatement pstat = con.prepareStatement(sql1);
		pstat.setString(1, pname);
		pstat.setInt(2, pprice);
		pstat.setString(3, iced);

		int result =pstat.executeUpdate();


		con.commit();
		con.close();
		return result; 

		// 모델에선 예외처리 하지말고 뷰로
	}
		public String printMenu() throws Exception {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "kh";
			String pw = "kh";
			//DBMS접속
			Connection con = DriverManager.getConnection(url,id, pw); 
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
			con.close();
			return rs;
		}

	public int Delete(int delPID) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";

		Connection con = DriverManager.getConnection(url,id,pw);
		String sql1 = "delete from cafe_menu where pid = ?"; //sql 삭제쿼리
		PreparedStatement pstat1 = con.prepareStatement(sql1);
		pstat1.setInt(1, delPID);


		int result = pstat1.executeUpdate();

		if(result>0) {
			System.out.println("삭제 완료 되었습니다");
		}

		con.commit();
		con.close();

		return result;
	}
}
