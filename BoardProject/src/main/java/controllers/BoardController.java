package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DAO.MemberDAO;
import DTO.BoardDTO;
import DTO.MemberDTO;

@WebServlet("*.board")
public class BoardController extends HttpServlet {


 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String uri	= request.getRequestURI();
		
		try {
			
			if(uri.equals("/list.board")) {  //자유게시판 목록
				System.out.println("자유게시판 목록");
				
				BoardDAO dao = BoardDAO.getInstance();
				
					List<BoardDTO> list = dao.printBoard();
				
		
				request.setAttribute("list", list);
				request.getRequestDispatcher("board/boardlist.jsp").forward(request, response);
				
			}else if(uri.equals("/writer.board")) {
				System.out.println("글쓰기 완료");
				String writer=(String)request.getSession().getAttribute("loginID");
				String title = request.getParameter("title");
				String contents = request.getParameter("wcontents");
				
				BoardDAO dao = BoardDAO.getInstance();
				int result = dao.insertwrite(new BoardDTO(0, writer,title,contents,null,0));
				
				List<BoardDTO> list = dao.printBoard();
				request.setAttribute("list", list);
				request.getRequestDispatcher("board/boardlist.jsp").forward(request, response);
		
				
			}
			
			
			else if(uri.equals("/towriter.board")){  //글쓰기로 접속
				System.out.println("글쓰기 접속");
				
				
				response.sendRedirect("board/writerForm.jsp");
			}else if(uri.equals("/toindex.board")) { //자유게시판에서 뒤로가기
				response.sendRedirect("/index.jsp");
				
			}
			
			
		}catch (Exception e) {
			System.out.println("오류좀보자");
		e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
