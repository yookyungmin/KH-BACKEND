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


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

       
  


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title = request.getParameter("title");
		
		try {
			
		NetflixDAO dao = NetflixDAO.getInstance();
			
//			if(dao.isTitleExist(title)){
//				List<NetflixDTO> list=dao.search(title);
//				request.setAttribute("list", list);
//				request.getRequestDispatcher("OutputView.jsp").forward(request, response);
//			}else {
//				
//				request.getRequestDispatcher("OutputView.jsp").forward(request, response);
//			}
			List<NetflixDTO> list=dao.search(title);
			request.setAttribute("list", list);
			request.getRequestDispatcher("OutputView.jsp").forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
