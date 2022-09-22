package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

import org.apache.commons.dbcp2.BasicDataSource;

import Dto.GuestDTO;

import oracle.net.nt.NTAdapter;

public class GuestDao {
	
	
	private static GuestDao instance = null;

	public synchronized static GuestDao getInstance() {
		if(instance == null) {
			instance = new GuestDao();
		}
		return instance;
	}
	
	private BasicDataSource bds = new BasicDataSource();
	
	
	private GuestDao() { //반복으로 인해 생성자로 빼두기
		this.bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		this.bds.setUsername("kh");
		this.bds.setPassword("kh");
		this.bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.bds.setInitialSize(30); //30개 커넥션 //기본 8?
	}

	private Connection getConnection() throws Exception {
		return bds.getConnection();
	}

//	private Connection getConnection() throws Exception {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String id = "kh";
//		String pw = "kh";
//		
//		Connection con = DriverManager.getConnection(url,id,pw);
//		return con;
//	}  //DBCP 적용하면 삭제 예정
	
	
	
		public int  insert(GuestDTO dto) throws Exception { //값넣기, 매개변수 dto
			
			String sql = "insert into guestbook values(guestbook_seq.nextval, ?, ?,sysdate)";
			
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getContents());
			int result = pstat.executeUpdate(); //성공 시 1반환
			
			con.commit();
			con.close();
			
			return result;
			
		}
		
		public List<GuestDTO>  selectAll() throws Exception{ //모두 출력, 매개변수 없다
			
			
			String sql = "select * from guestbook";
			
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			
			List<GuestDTO> result = new ArrayList<>();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String content = rs.getString("contents");
				Timestamp write_date = rs.getTimestamp("write_date");
				
				GuestDTO dto = new GuestDTO(seq, writer, content, write_date);
				//import java.security.Timestamp;
				result.add(dto);
			}
			return result;
		}
		
		public int delete(int seq) throws Exception{ //dto 작업 무필요
			String sql = "delete from guestbook where seq=?";
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();
			con.commit();
			con.close();
			
			return result;
		}
		public boolean isSeqExist(int seq) throws Exception{
			//삭제전 시퀸스 존재여부 확인
		
			String sql = "select * from guestbook where seq = ?";
			
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			
			ResultSet rs = pstat.executeQuery();
			boolean result = rs.next();
			return result;
		}



		public int update(GuestDTO dto) throws Exception {
			String sql = "update guestbook set writer=?, contents= ? where seq = ?";
			
			Connection con = getConnection();
			PreparedStatement pstat  = con.prepareStatement(sql);
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getContents());;
			pstat.setInt(3, dto.getSeq());
			
			int result = pstat.executeUpdate();
			
			con.commit();
			return result;
			
			
		
		}



		public boolean isWriterExist(String swriter) throws Exception { //검색전 작성자 존재 여부확인
			Connection con = getConnection();
			String sql = "select * from guestbook where writer = ?";
			PreparedStatement pstat = con.prepareStatement(swriter);
		
			pstat.setString(1, swriter);
			
			ResultSet rs = pstat.executeQuery();
			
			boolean result = rs.next();
			return result;
			
		}



		public List<GuestDTO> serach(String swriter) throws Exception { //작성자로 검색
			String sql = "select * from guestbook wehre writer=?";
			
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			
			pstat.setString(1,swriter);
			ResultSet rs = pstat.executeQuery();
			
			List<GuestDTO> result = new ArrayList<GuestDTO>();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String contents = rs.getString("contens");
				Timestamp write_date = rs.getTimestamp("write_date");
				
				GuestDTO dto = new GuestDTO(seq, writer, contents, write_date);
				
				result.add(dto);
			}
			return result;
			
		}
		
		
		
		
}
