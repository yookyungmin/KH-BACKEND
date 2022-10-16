package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoviesDAO;
import dto.MoviesDTO;


@WebServlet("*.netflix")
public class NetflixController2 extends HttpServlet {
	
	//FrontControlelr / 서블릿 합치기

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		//print문하면 /가 붙어서 나와서 (uri.equals("/input.netflix")) 형식으로 입력
		try {
		
			if(uri.equals("/input.netflix")) {
				String title = request.getParameter("title");
				String genre = request.getParameter("genre");
				String date = request.getParameter("launch_date");
		
				MoviesDTO dto = new MoviesDTO(0, title, genre, null, date);
				MoviesDAO dao = MoviesDAO.getInstance();
				int result = dao.insert(dto);
				response.sendRedirect("index.jsp");
			
			}else if(uri.equals("/output.netflix")) {
				MoviesDAO dao = MoviesDAO.getInstance();
				List<MoviesDTO> list = dao.selectAll();
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);
			}else if(uri.equals("/delete.netflix")) {
				int id = Integer.parseInt(request.getParameter("id"));
				int result = MoviesDAO.getInstance().delete(id);
				response.sendRedirect("output.netflix");
			
			}else if(uri.equals("/update.netflix")) {
				String title = request.getParameter("title");
				String genre = request.getParameter("genre");
				int id = Integer.parseInt(request.getParameter("id"));
				MoviesDTO dto = new MoviesDTO(id,title,genre,null, null);
				int result = MoviesDAO.getInstance().update(dto);
				
				response.sendRedirect("output.netflix");
			
			}else if(uri.equals("/search.netflix")) {
				String title = request.getParameter("title");
				List<MoviesDTO> list = MoviesDAO.getInstance().search(title);
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);
			}else if(uri.equals("/toinput.netflix")) {
				response.sendRedirect("inputForm.jsp");
//				
			}
//			else if(uri.equals("/back.netflix")){
//				response.sendRedirect("index.jsp");
//			}//페이지 전환도 서블릿 적용
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
