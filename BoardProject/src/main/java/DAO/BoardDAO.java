package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DTO.BoardDTO;
import DTO.MemberDTO;

public class BoardDAO {
	private static BoardDAO instance;
	
	
	public static BoardDAO getInstance() throws Exception{
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	private  BoardDAO() {} 

	   private Connection getConnection() throws Exception {
		      Context ctx = new InitialContext(); // tomcat 환경 찾아서 요구하는 코드, //우클릭 했을때 메뉴 상황에 따라 다르게 나오는걸 컨텍스트메뉴
		      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // java:comp/env/ 고정값,  jdbc 찾아달라고 요청
		      
		      return ds.getConnection();
		   }
	   
	   public int insertwrite(BoardDTO dto) throws Exception{
			String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
		
				pstat.setString(1, dto.getWriter());
				pstat.setString(2, dto.getTitle());
				pstat.setString(3, dto.getContents());
				
				
				int result = pstat.executeUpdate();
				con.commit();
				return result;
			}
		}
	   
	   public List<BoardDTO> printBoard() throws Exception{ //자유게시판 출력
		   String sql = "select * from board order by write_Date";
		   try(Connection con = this.getConnection();
				   PreparedStatement pstat = con.prepareStatement(sql);
				   ResultSet rs = pstat.executeQuery();
				){

				   List<BoardDTO> list = new ArrayList();
				   
				   while(rs.next()) {
					   BoardDTO dto = new BoardDTO();
					   dto.setSeq(rs.getInt("seq"));
					   dto.setWriter(rs.getString("writer"));
					   dto.setTitle(rs.getString("title"));
					   dto.setContents(rs.getString("contents"));
					   dto.setWrite_date(rs.getTimestamp("write_date"));
					   dto.setView_count(rs.getInt("view_count"));
					  
					   list.add(dto);
			 
			   }
				   return list;
			
		   }
		   
	   
	   }
}

