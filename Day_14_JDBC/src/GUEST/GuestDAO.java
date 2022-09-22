package GUEST;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//데이터 접근 오브젝트 DAO
public class GuestDAO {

//Exam05_CRUD2랑 호환
//강사님
	
	public int insert(String name, String content) throws Exception{ 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//throws Exception은 메서드에 넣어서 예외발생시 콜러(메서드 콜한 메인)한테 넘어간다 
		//메인메서드에선 throws Exception 하면 안됨 최후보루
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String id = "GUEST";
	      String pw = "GUEST";
	      
		Connection con = DriverManager.getConnection(url,id,pw);
        String sql = 
              "insert into guest_book values(guest_book_seq.nextval,?,?,sysdate)";            
        
        PreparedStatement pstat = con.prepareStatement(sql);
        pstat.setString(1, name);
        pstat.setString(2, content);

        int result = pstat.executeUpdate(); //
       
        con.commit(); 
        con.close();
        return result;
        // 모델에선 예외처리 하지말고 뷰로
	}

	public int Delete(int delBID) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String id = "GUEST";
	      String pw = "GUEST";
	      

  
        Connection con = DriverManager.getConnection(url,id,pw);
        String sql = "delete from guest_book where bid = ?";
        PreparedStatement pstat = con.prepareStatement(sql);
        pstat.setInt(1, delBID);
        int result = pstat.executeUpdate();
    
        con.commit();
        con.close();
        
        return result;
        
	}
	public boolean isSeqExist(int seq) {// 시퀸스 값을 하나 받아서 그값이 존재하는지 안하는지 
		//삭제시 존재여부 파악메서드 중요
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String id = "GUEST";
	      String pw = "GUEST";
	      


      Connection con = DriverManager.getConnection(url,id,pw);
      String sql = "select * from guest_book where bid = ?";
      PreparedStatement pstat = con.prepareStatement(sql);
	//boolean return 시 존재하면 true 안하면 false
	}
	
	public boolean isWriterExist() { //검색시 사용자 존재여부
		
	}
	public int Update(int delBid, String name, String content) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String id = "GUEST";
	      String pw = "GUEST";
	      
	      
		 Connection con = DriverManager.getConnection(url,id,pw);
         String sql = "update guest_book set bname =?, content=? where bid=?";
         PreparedStatement pstat = con.prepareStatement(sql);
         pstat.setString(1, name);
         pstat.setString(2, content);
         pstat.setInt(3, delBid);
         
         int result = pstat.executeUpdate();
         
        
         
         con.commit();
         con.close();
         return result;
	}
	
	
}
