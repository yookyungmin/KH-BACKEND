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
import DTO.CommentsDTO;

public class CommentsDAO {
	
private static CommentsDAO instance= null;
	
	
	public static CommentsDAO getInstance() throws Exception{
		if(instance == null) {
			instance = new CommentsDAO();
		}
		return instance;
	}



	   private Connection getConnection() throws Exception {
		      Context ctx = new InitialContext(); // tomcat 환경 찾아서 요구하는 코드, //우클릭 했을때 메뉴 상황에 따라 다르게 나오는걸 컨텍스트메뉴
		      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // java:comp/env/ 고정값,  jdbc 찾아달라고 요청
		      
		      return ds.getConnection();
		   }
	   
	   
	   public int insertcomment(CommentsDTO dto) throws Exception{
			String sql = "insert into comments values(comments_seq.nextval, ?, ?, sysdate, ?)";
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
		
				pstat.setString(1, dto.getWriter());
				pstat.setString(2, dto.getContents());
				pstat.setInt(3, dto.getParent_seq());
			
				
				
				int result = pstat.executeUpdate();
				con.commit();
				return result;
			}
		}
	   
	   public List<CommentsDTO> commentsprint(int seq) throws Exception{ //selectByseq
		   String sql = "select * from comments where parent_seq =? order by write_date desc";
		   try(Connection con = this.getConnection();
				   PreparedStatement pstat = con.prepareStatement(sql);
				){
			   
			   pstat.setInt(1, seq);
			   List<CommentsDTO> list = new ArrayList<CommentsDTO>();
			   try(ResultSet rs = pstat.executeQuery();){
				
				   
				   while(rs.next()) {
					   CommentsDTO dto=new CommentsDTO();
					 	dto.setSeq(rs.getInt("seq"));
					   dto.setWriter(rs.getString("writer"));
					   dto.setContents(rs.getString("contents"));
					   dto.setWrite_date(rs.getTimestamp("write_date"));
					   dto.setParent_seq(rs.getInt("parent_seq"));
		
					 //하나의 dto만 나오기떄문에 while문 필요x
			 
					  list.add(dto);
				   
				   }
				   return list;
			   }
			  
		   }
		   
	   }
	   
	   
	   public int commentsDelete(int seq) throws Exception{  //byseq
			String sql = "delete from comments where seq = ?";
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
				pstat.setInt(1, seq);
				int result = pstat.executeUpdate();
				con.commit();
				return result;
			}
		}
	   
		public int update(CommentsDTO dto) throws Exception{
			String sql = "update comments set contents=? where seq=?";
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
				
				
				pstat.setString(1, dto.getContents());
				pstat.setInt(2, dto.getSeq());;
				System.out.println("dao con : "+dto.getContents());
				System.out.println("dao seq : "+dto.getSeq());
				
				int result = pstat.executeUpdate();
				con.commit();
				return result;
			}
		}

}
