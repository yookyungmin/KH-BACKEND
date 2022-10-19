package DAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.print.DocFlavor.INPUT_STREAM;
import javax.sql.DataSource;

import DTO.MemberDTO;




public class MemberDAO {
	private static MemberDAO instance;
	
	
	public static MemberDAO getInstance() throws Exception{
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	private  MemberDAO() {} 

	   private Connection getConnection() throws Exception {
		      Context ctx = new InitialContext(); // tomcat 환경 찾아서 요구하는 코드, //우클릭 했을때 메뉴 상황에 따라 다르게 나오는걸 컨텍스트메뉴
		      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // java:comp/env/ 고정값,  jdbc 찾아달라고 요청
		      
		      return ds.getConnection();
		   }
	   
	   public boolean isIdExist(String idd) throws Exception{  //id중복확인 dao
		   String sql = "select id from Members where id = ?";
		   try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);
				  ){
			   pstat.setString(1, idd);
			   try( ResultSet rs = pstat.executeQuery();){
				   boolean result = rs.next(); //id가 존재하면 true
					return result;
					//return rs.next(); 가능
			   }
	

	   }
		
}
	   public int insertSign(MemberDTO dto) throws Exception{
			String sql = "insert into members values(?, ?, ?, ?, ?, ?, ?,?,sysdate)";
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
				pstat.setString(1, dto.getId());
				pstat.setString(2, dto.getPw());
				pstat.setString(3, dto.getName());
				pstat.setString(4, dto.getPhone());
				pstat.setString(5, dto.getEmail());
				pstat.setString(6, dto.getZipcode());
				pstat.setString(7, dto.getAddress1());
				pstat.setString(8, dto.getAddress2());
				int result = pstat.executeUpdate();
				con.commit();
				return result;
			}
		}
	   
	   public boolean login(String idd, String pww) throws Exception{  //id중복확인 dao
		   String sql = "select id, pw from Members where id = ? and pw=?";
		   try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);
				  ){
			   pstat.setString(1, idd);
			   pstat.setString(2, pww);
			   try( ResultSet rs = pstat.executeQuery();){
				   boolean result = rs.next(); //id가 존재하면 true
					return result;
					//return rs.next(); 가능
			   }
	

	   }
		
}
	   
		public int delete(String id) throws Exception{
			String sql = "delete from members where id = ?";
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
				pstat.setString(1, id);
				int result = pstat.executeUpdate();
				con.commit();
				return result;
			}
		}
	   
	   public MemberDTO selectMypage(String id) throws Exception{ //selectById
		   String sql = "select * from members where id =?";
		   try(Connection con = this.getConnection();
				   PreparedStatement pstat = con.prepareStatement(sql);
				){
			   
			   pstat.setString(1, id);
			   
			   try(ResultSet rs = pstat.executeQuery();){
				   MemberDTO dto = new MemberDTO();
				   
				   rs.next();
					   
					   dto.setId(rs.getString("id"));
					   dto.setPw(rs.getString("pw"));
					   dto.setName(rs.getString("name"));
					   dto.setPhone(rs.getString("phone"));
					   dto.setEmail(rs.getString("email"));
					   dto.setZipcode(rs.getString("zipcode"));
					   dto.setAddress1(rs.getString("address1"));
					   dto.setAddress2(rs.getString("address2"));
					   dto.setSignup_date(rs.getTimestamp("signup_date"));
			 
					   return dto;
				   

			   }
		   }
		   
	   }
		public int update(MemberDTO dto) throws Exception{
			String sql = "update members set pw=?, name=?, phone=?, email=?, zipcode=?, address1=?, address2=? where id= ?";
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
				
				pstat.setString(1, dto.getPw());
				pstat.setString(2, dto.getName());
				pstat.setString(3, dto.getPhone());
				pstat.setString(4, dto.getEmail());
				pstat.setString(5, dto.getZipcode());
				pstat.setString(6, dto.getAddress1());
				pstat.setString(7, dto.getAddress2());
				pstat.setString(8, dto.getId());
				
				int result = pstat.executeUpdate();
				con.commit();
				return result;
			}
		}
	   
	   public String getSha256(String pwd) { //암호화
			String toReturn = "";

			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
				digest.reset();
				digest.update(pwd.getBytes("utf8"));
				toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return toReturn;
		}
}
