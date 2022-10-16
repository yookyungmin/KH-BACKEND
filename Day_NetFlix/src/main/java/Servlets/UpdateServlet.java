package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.NetflixDAO;

import DTO.NetflixDTO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			
			try {	int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			System.out.println(id+title+genre);
		
				NetflixDAO dao = NetflixDAO.getInstance();
				int result = dao.update(new NetflixDTO(id, title, genre, null));
				if(result>0) {
					System.out.println("수정완료");
					response.sendRedirect("OutputServlet");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
