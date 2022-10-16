package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoviesDAO;
import dto.MoviesDTO;


@WebServlet("/InputController")
public class InputController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		String date = request.getParameter("launch_date");
		
		System.out.println(date);

		MoviesDTO dto = new MoviesDTO(0, title, genre, null, date);
		try {
			MoviesDAO dao = MoviesDAO.getInstance();
			int result = dao.insert(dto);
			response.sendRedirect("index.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
