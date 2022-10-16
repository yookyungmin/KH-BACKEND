package Servlets;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NetflixDAO;
import DTO.NetflixDTO;


@WebServlet("*.netflix")
public class NetflixController extends HttpServlet {

//FrontControlelr / 서블릿 합치기


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		//print문하면 /가 붙어서 나와서 (uri.equals("/input.netflix")) 형식으로 입력
		
		try {
		if(uri.equals("/input.netflix")) {
			String title = request.getParameter("title");
			String genre= request.getParameter("genre");
			
			NetflixDAO dao = NetflixDAO.getInstance();
			int result = dao.insert(new NetflixDTO(0, title, genre, null));	
		
			response.sendRedirect("index.jsp");
	
		}else if(uri.equals("/output.netflix")){
			NetflixDAO dao = NetflixDAO.getInstance();
			List<NetflixDTO> list = dao.selectAll();  //sendredirect하면 데이터 전달이 안됨 //foward사용해야함
	
			request.setAttribute("list", list);  //29번줄을 담아서 보내겠다. //키, 밸류 // request에 list를 담는것
			request.getRequestDispatcher("OutputView.jsp").forward(request, response); 
	
		}else if(uri.equals("/delete.netflix")) {
			int id = Integer.parseInt(request.getParameter("delId"));
			System.out.println("전달받은 id ="+id);
			NetflixDAO dao = NetflixDAO.getInstance();
			int result = dao.del(id);
			response.sendRedirect("output.netflix");
			
		}else if(uri.equals("/update.netflix")) {
				int id = Integer.parseInt(request.getParameter("id"));
				String title = request.getParameter("title");
				String genre = request.getParameter("genre");
				System.out.println(id+title+genre);
			
					NetflixDAO dao = NetflixDAO.getInstance();
					int result = dao.update(new NetflixDTO(id, title, genre, null));
					response.sendRedirect("output.netflix");
			
			}else if(uri.equals("/search.netflix")) {
				
				String title = request.getParameter("title");
		
				NetflixDAO dao = NetflixDAO.getInstance();
					

					List<NetflixDTO> list=dao.search(title);
					request.setAttribute("list", list);
					request.getRequestDispatcher("OutputView.jsp").forward(request, response);

			}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
