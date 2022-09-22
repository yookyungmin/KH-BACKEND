import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

//데이터 접근 오브젝트 DAO
public class CafeMenuDAO {

	//Exam05_CRUD2랑 호환
	//강사님

	//	private Connection getConnection() throws Exception{  // 똑같은 코드 반복 묶기
	//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//		String id = "kh";
	//		String pw = "kh";
	//
	//		Connection con = DriverManager.getConnection(url,id,pw);
	//		return con;
	//	} //DBCP로 인해 삭제

//		왜 Singleton을 써야 하는가 
//		
//		기존처럼 Main(뷰)에서 CafeMenuDAO dao = new CafeMenuDAO(); 를 다수의 사용자가 발생하면 접속자 한명한명마다 DAO를 하나씩 만들어서 쓰는데( 따로따로 코드를 실행)
//		CafeMenuDAO dao = new CafeMenuDAO(); 하면 내부의 	private BasicDataSource bds = new BasicDataSource(); 도 계속 생성이 되면
//		 BasicDataSource의 커넥션도 this.bds.setInitialSize(30); 30개 60개 ~  계속 생성되기 떄문에 생성자로 빼두고, 
//		싱글톤 패턴 사용으로 한개의 DAO만을 가지고 여러명이 사용하게끔 


	//왜 싱글톤패턴에 Static을 사용하는가?
	// static 은 new , 객체 생성없이 사용 가능.  // 싱글톤패턴을 사용하려는데 어떻게 new 없이 접근을 할것인가 ? 그래서 public static CafeMenuDAO getInstance() static으로 만들어서
	//객체생성없이 CafeMenuDAO dao = CafeMenuDAO.getInstance(); 접근을 하고 if 과정을 통해 new CafeMenuDAO()를 사용하기 위함.



	//	Singleton Pattern
	//	특정 클래스들은 new를 자유롭게 사용해선 안되고 단하나의 인스턴스로만 사용하게끔 제한해야 하는데, 
	//	이떄 사용 되는 디자인 패턴
	//	들어오는 접속자마다 DAO를 생성하는게 아니라 하나를 만들어놓고 하나가지고
	//여러명이 쓰게끔 해줘야 함

	
	
	private static CafeMenuDAO instance = null;

	public synchronized static CafeMenuDAO getInstance() { //싱글톤패턴
		if(instance == null) { // null과 같으면 true
			instance = new CafeMenuDAO();  //CafeMenuDAO의 주소가 instance에 들어감  , 
		}
		// 두번쨰 사용자부터는 instance의 값이 null값이 아닌 첫번쨰 사용자의해 이미 new CafeMenuDAO 되어 있기에 false가 되기때문에
		//바로 instance 값을 가지고 return  됨
		return instance;  //instance의 값을 가지고 메서드 콜한쪽으로 반환
	}
	//synchronized 메서드 작업이 끝날때까지 기다려줘야 함 다음 쓰레드로부터 안전한 쓰레드 세이프, 동시에 여러명이 사용하면 안되는 메서드에 사용,
	// 쓰레드 세이프로 인해 안전하지만 비용이라는 문제점이 생긴다.
	//싱글톤패턴도 DAO의 종류가 많아지면 싱글톤패턴도 무효화 될수 있다< 코드 상에 DBCP 를 만들지 않고 플랫폼에 DBCP 요청



	//DBCP : DATABASE Connection Pool, 데이터베이스에서 사용되는 커넥션 객체들의 울타리
	//dbcp 외장 라이브러리 인스턴스
	private BasicDataSource bds = new BasicDataSource(); // 바깥으로 new를 뺴두어야 커넥션 에러가 안남
	private CafeMenuDAO() { //생성자
		this.bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		this.bds.setUsername("kh");
		this.bds.setPassword("kh");
		this.bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.bds.setInitialSize(30); //30개 Connection / 기본8?
	}

	private Connection getConnection() throws Exception{ 
		return bds.getConnection();
		//	bds.getConnection(); //DirverManager.getConnection과 유사
		//Connection 을 울타리에 미리 만들어놓고 대여&반환 시스템
	}



	public int insert(CafeMenuDTO dto) throws Exception{ 
		//Resultset SQL쿼리 떄문에 못뺴고, 커넥션처럼 뺸다 하더라도 리턴값을 하나밖에 못하기떄문에
		//throws Exception은 메서드에 넣어서 예외발생시 콜러(메서드 콜한 메인)한테 넘어간다 
		//메인메서드에선 throws Exception 하면 안됨 최후보루

		//중간에서 오류가 생겨 튕겼을때 close를 해주기 위해 try() {}  사용
		String sql = 
				"insert into cafe_menu values(cafe_menu_seq.nextval,?,?,?)";            

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){

			pstat.setString(1, dto.getPname());
			pstat.setInt(2, dto.getPprice());
			pstat.setString(3, dto.getIced());
			int result = pstat.executeUpdate();

			con.commit();
			return result; 
			//close는 try() 에서 처리
		}        

		// 모델에선 예외처리 하지말고 뷰로
	}

	public int Delete(int delPID) throws Exception{
		String sql = "delete from cafe_menu where pid = ?";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, delPID);
			int result = pstat.executeUpdate();

			con.commit();	        
			return result;

		}


	}

	public boolean isPidExist(int pid) throws Exception{
		// 시퀸스 값을 하나 받아서 그값이 존재하는지 안하는지 
		//삭제시 존재여부 파악메서드 중요
		String sql = "select * from cafe_menu where pid = ?";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, pid);
			ResultSet rs = pstat.executeQuery();
			boolean result = rs.next();
			return result;	
		}


	}

	public int update(CafeMenuDTO dto) throws Exception {
		String sql = "update cafe_menu set  pname=?, pprice=?,iced=? where pid=?";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getPname());
			pstat.setInt(2, dto.getPprice());
			pstat.setString(3, dto.getIced());
			pstat.setInt(4, dto.getPid());            
			int result = pstat.executeUpdate();

			con.commit();
			return result;
		}


	}

	public List<CafeMenuDTO> selectAll() throws Exception{  //출력문
		//Resultset 은 db 데이터 행 들을 화살표로 가르키고 있다
		//con, pstat, rs close 필요
		//ResultSet은 Close(를 하면 화살표가 끊김)전까지만 사용 가능
		//

		String sql = "select * from cafe_menu order by 1";
		try(			Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){

			List<CafeMenuDTO>  result = new ArrayList(); //while문안으로넣으면 돌때마다 초기화
			//ResultSet을 바로 리턴할수 없기 떄문에 ResultSet을 ArrayList에 저장을 하고나서  close하고 ArrayList을 리턴
			//object 타입이라 다양한 타입 저장가능하지만 사용할때 다운캐스팅을 해야하기 떄문에
			//사용하기 어렵다 그래서 CafeMenuDTO 제네릭스 사용
			while(rs.next()) {
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int pprice = rs.getInt("pprice");
				String iced = rs.getString("iced");
				CafeMenuDTO dto = new CafeMenuDTO(pid, pname, pprice, iced); //dto 에 담기
				result.add(dto);
			} //while문이 끝나는순간 ArrayList dto안에는 테이블 모든 내용이 담김
			return result;   //반환타입 ArrayList<CafeMenuDTO>
		}

	}
	public List<CafeMenuDTO> selectbyAll(int ppid) throws Exception{  //출력문

		String sql = "select * from cafe_menu where pid=? order by 1";
		try(			Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){

			pstat.setInt(1, ppid);
			//select 문 시 ? 있을때 try() {} 이중으로 사용
			try(ResultSet rs = pstat.executeQuery();){

				List<CafeMenuDTO>  result = new ArrayList(); 

				while(rs.next()) {
					int pid = rs.getInt("pid");
					String pname = rs.getString("pname");
					int pprice = rs.getInt("pprice");
					String iced = rs.getString("iced");
					CafeMenuDTO dto = new CafeMenuDTO(pid, pname, pprice, iced); //dto 에 담기
					result.add(dto);
				} //while문이 끝나는순간 ArrayList dto안에는 테이블 모든 내용이 담김
				return result;   //반환타입 ArrayList<CafeMenuDTO>
			}

		}
	}
}