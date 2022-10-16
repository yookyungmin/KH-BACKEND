package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.jsp.JspWriter;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import DTO.NetflixDTO;



public class NetflixDAO {
	
private static	NetflixDAO instance;
	
	synchronized public  static NetflixDAO getInstance() throws Exception{ 
		
			if(instance==null) {
				instance = new NetflixDAO();
			}
			return instance;
		
	}  //싱글톤 적용
	
	
	private NetflixDAO(){} 
	//싱글톤 적용위해서 private
			//커넥션 기본 30개
	// 한번만 실행하기 위해  생성자로 뺴두기\ //톰캣에서 실행하게끔 context.xml 에작성
	
	
	
	//많은 종류의 Dao가 만들어지면 싱글톤, dbcp적용을 해도 여러개가 만들어져서   db가 뻗을수 있다.
	//자바 코드로 만들지 않고 dbcp 인스턴스 자체를 톰캣에게 만들어달라 하자, jndi 기술
	//의존성 di 주입의 전신기술
	
	
	
	
	   private Connection getConnection() throws Exception {
		      Context ctx = new InitialContext(); // tomcat 환경 찾아서 요구하는 코드, //우클릭 했을때 메뉴 상황에 따라 다르게 나오는걸 컨텍스트메뉴
		      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // java:comp/env/ 고정값,  jdbc 찾아달라고 요청
		      
		      return ds.getConnection();
		   }//dbcp 적용 dbcp라이브러리 톰캣에 포함되서 라이브러리 따로 설치 필요 x, 표준 라이브러리 //

	
	
//	private Connection getConnection() throws Exception{
//		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
//		String dbID = "kh";
//		String dbPW = "kh";
//		return DriverManager.getConnection(dbURL, dbID, dbPW);
//	} //dbcp 적용하면서 제거
//



	
	public int  insert(NetflixDTO dto) throws Exception{ //추가
		String sql = 
				"insert into netflix values(netflix_seq.nextval,?,?, sysdate)";  
		
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){  //try with resource 적용
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			int result = pstat.executeUpdate();

			con.commit();
			con.close();
			return result;
		}		
	}
	
	
	public List<NetflixDTO> selectAll() throws Exception {
		String sql ="select * from netflix order by 1";
		
		try(Connection con= this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			List<NetflixDTO> result = new ArrayList<NetflixDTO>();  //rs을 닫히면 보낼수 없기에 리스트사용
			
			while(rs.next()){
				int id = rs.getInt("id");
				String  title = rs.getString("title");
				String genre = rs.getString("genre");
				Timestamp launch_date = rs.getTimestamp("launch_date");
				NetflixDTO dto = new NetflixDTO(id, title, genre, launch_date);
				
				result.add(dto);
				
			}
			return result;
		}
	}
	
	
	public int del(int delid) throws Exception{
		String sql ="delete from netflix where id = ?";
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, delid);
			int result = pstat.executeUpdate();
			con.commit();
			return result;
			
		}
	}
	
	public int update(NetflixDTO dto) throws Exception{
		String sql = "update netflix set title =?, genre = ? where id = ? ";
	
		try(Connection con=this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			pstat.setInt(3, dto.getId());
			
			int result = pstat.executeUpdate();
			con.commit();
			return result;
			
		}
	}
	
	public List<NetflixDTO> search(String titlee) throws Exception{
		String sql = "select * from netflix where title like '%"+titlee+"%'";
		
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			
				ResultSet rs = pstat.executeQuery();){
			
//				pstat.setString(1, "%"+titlee+"%"); // 다른방
		
			/*try(Result rs pstat.executeQuery();){
			List<NetflixDTO> result = new ArrayList<NetflixDTO>();
				
				while(rs.next()) {
				int id=rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				Timestamp write_date = rs.getTimestamp("launch_Date");
				
				NetflixDTO dto = new NetflixDTO(id, title, genre, write_date);
				
				result.add(dto);
				}
				
				
				}*/
			List<NetflixDTO> result = new ArrayList<NetflixDTO>();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				Timestamp write_date = rs.getTimestamp("launch_Date");
				
				NetflixDTO dto = new NetflixDTO(id, title, genre, write_date);
				
				result.add(dto);
				}
			
			return result;
			
		}
	}
	
//	public boolean isTitleExist(String title) throws Exception {
//		//검색시 사용자 존재여부
//	Connection con = getConnection();
//				String sql ="select *from netflix where title p?";
//			PreparedStatement pstat = con.prepareStatement(sql);
//			
//			pstat.setString(1, title);
//			ResultSet rs = pstat.executeQuery();
//			boolean result = rs.next();
//			return result;
//		
//		
//	}
}














