package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NetflixDAO;
import DTO.NetflixDTO;




@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		NetflixDAO dao = NetflixDAO.getInstance();
		List<NetflixDTO> list = dao.selectAll();  //sendredirect하면 데이터 전달이 안됨 //foward사용해야함
		
	
		
		request.setAttribute("list", list);  //29번줄을 담아서 보내겠다. //키, 밸류 // request에 list를 담는것
		request.getRequestDispatcher("OutputView.jsp").forward(request, response); 
		//request 운행 관리자, foward로 보내면 OutputServlet으로 주소창에 나옴
		//foward = 매개변수 두개 request, response를 를 jsp로 보내는것 가져가야 할 데이터가 있을떄 사용
		//redirect 가져가야 할 데이터가 없으면 사용
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		response.sendRedirect("error.jsp");
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
