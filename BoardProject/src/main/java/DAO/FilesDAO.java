package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DTO.FilesDTO;



public class FilesDAO {
	private static FilesDAO instance = null;
	public static FilesDAO getInstance() throws Exception{
		if(instance == null) {
			instance = new FilesDAO();
		}
		return instance;
	}



	   private Connection getConnection() throws Exception {
		      Context ctx = new InitialContext(); // tomcat 환경 찾아서 요구하는 코드, //우클릭 했을때 메뉴 상황에 따라 다르게 나오는걸 컨텍스트메뉴
		      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // java:comp/env/ 고정값,  jdbc 찾아달라고 요청
		      
		      return ds.getConnection();
		   }
	   
	   public int insertFile(FilesDTO dto) throws Exception{
		   String sql = "insert into files values(files_seq.nextval,?,?,?)";
		   try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
		
				pstat.setString(1, dto.getOriname());
				pstat.setString(2, dto.getSysname());
				pstat.setInt(3, dto.getParent_seq());
			
				
				
				int result = pstat.executeUpdate();
				con.commit();
				return result;
			}
		   
	   }
	   
	   public List<FilesDTO> selectFileByParent(int pseq) throws Exception{
		   String sql="select * from files where parent_seq = ?";
		   try(Connection con = this.getConnection();
				   PreparedStatement pstat = con.prepareStatement(sql);
				  
				){
			   
			   
			   pstat.setInt(1, pseq);
			   
			   try( ResultSet rs = pstat.executeQuery();){
				   	List<FilesDTO> list = new ArrayList<FilesDTO>();
				   
				   
				   while(rs.next()) {
					   FilesDTO dto = new FilesDTO();
					   dto.setSeq(rs.getInt("seq"));
					   dto.setOriname(rs.getString("oriname"));
					   dto.setSysname(rs.getString("sysname"));
					   dto.setParent_seq(rs.getInt("parent_seq"));
				
					  
					   list.add(dto);
			   }
				   return list;
			 
			   }
			
			
		   }
   
	   }
}
