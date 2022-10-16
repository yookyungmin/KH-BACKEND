package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NetflixDAO;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			int id = Integer.parseInt(request.getParameter("delId"));
			System.out.println("전달받은 id ="+id);
			NetflixDAO dao = NetflixDAO.getInstance();
			int result = dao.del(id);
			if(result>0) {
				response.sendRedirect("OutputServlet");
				System.out.println("삭제완료");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
