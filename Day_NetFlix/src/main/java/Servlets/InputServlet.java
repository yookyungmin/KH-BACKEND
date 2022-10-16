package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.NetflixDAO;

import DTO.NetflixDTO;


@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {


		//FRONT CONTORLOER 패턴
	//메시지 관련 메시지 컨트로러
	//
	//카테고리별로 컨트롤러 구분
	//어떤 요청이 들어왔는지 url에서 확인 가능

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title = request.getParameter("title");
		String genre= request.getParameter("genre");  //리퀘스트는 Dao 분리 x
//		String date = request.getParameter(("launch_Date"); //2022-10-13 받고 있는 형식-> String to timestamp형식으로 바꿀때
		//문자열을 입력받아 db에 timestamp로 할떄
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 * try{
		 * Date temp_date = sdf.parse(date); // 포맷 = 타임스탬프 형식을 날자 형식으로  ,, 2022-10-13 형식을-> parse timestamp로
		 * Timestamp launch_date =new Timestamp(temp_date.getTime()); 타임스탬프 값을 long형으로
		 * }catch(ParseException e1){
		 * 		e1.printStackTrace();
		 * } 
		 * 		 */   //자바에서 날짜입력넣기
		
		try {
			NetflixDAO dao = NetflixDAO.getInstance();
			int result = dao.insert(new NetflixDTO(0, title, genre, null));  //컨트롤 //null ->launch_date
			if(result>0) {
				System.out.println("입력완료");
				
				response.sendRedirect("index.jsp"); //성공시 클라이언트 브라우저 명령
				
				//foward로 처리하면 f5를 누를시 무한적으로 입력 됨
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //오류 내용을 알려줌 개발단계에서 지우면 안됨
			response.sendRedirect("error.jsp"); // 에러시 클라이언트의 브라우저에 명령, error.html 뜸
			//redirect 방향 재설정
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
