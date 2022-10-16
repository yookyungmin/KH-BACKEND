package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MoviesDTO;

public class MoviesDAO {

	private static MoviesDAO instance;
	public static MoviesDAO getInstance() throws Exception{
		if(instance == null) {
			instance = new MoviesDAO();
		}
		return instance;
	}

	private  MoviesDAO() {} 

	   private Connection getConnection() throws Exception {
		      Context ctx = new InitialContext(); // tomcat 환경 찾아서 요구하는 코드, //우클릭 했을때 메뉴 상황에 따라 다르게 나오는걸 컨텍스트메뉴
		      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // java:comp/env/ 고정값,  jdbc 찾아달라고 요청
		      
		      return ds.getConnection();
		   }

	public int insert(MoviesDTO dto) throws Exception{
		String sql = "insert into netflix values(netflix_seq.nextval,?,?,to_date(?, 'YYYY-MM-DD'))";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			pstat.setString(3, dto.getInput_date());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public int delete(int id) throws Exception{
		String sql = "delete from netflix where id = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public int update(MoviesDTO dto) throws Exception{
		String sql = "update netflix set title=?, genre=? where id= ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			pstat.setInt(3, dto.getId());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}


	public List<MoviesDTO> selectAll() throws Exception{
		String sql = "select * from netflix";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){

			List<MoviesDTO> list = new ArrayList<>();
			while(rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setLaunch_date(rs.getTimestamp("launch_date"));
				list.add(dto);
			}
			return list;
		}
	}

	public List<MoviesDTO> search(String title) throws Exception{
		String sql = "select * from netflix where title like ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, "%"+title+"%");
			try(ResultSet rs = pstat.executeQuery();){
				List<MoviesDTO> list = new ArrayList<>();
				while(rs.next()) {
					MoviesDTO dto = new MoviesDTO();
					dto.setId(rs.getInt("id"));
					dto.setTitle(rs.getString("title"));
					dto.setGenre(rs.getString("genre"));
					dto.setLaunch_date(rs.getTimestamp("launch_date"));
					list.add(dto);
				}
				return list;
			}
		}
	}
}
