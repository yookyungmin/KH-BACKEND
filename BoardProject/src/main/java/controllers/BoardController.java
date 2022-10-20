package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.css.ElementCSSInlineStyle;

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
				request.getRequestDispatcher("/board/boardlist.jsp").forward(request, response);
				
			}else if(uri.equals("/writer.board")) { //글쓰기
				System.out.println("글쓰기 완료");
				String writer=(String)request.getSession().getAttribute("loginID");
				String title = request.getParameter("title");
				String contents = request.getParameter("wcontents");
				
				BoardDAO dao = BoardDAO.getInstance();
				dao.insertwrite(new BoardDTO(0, writer,title,contents,null,0)); // db에저장

				response.sendRedirect("/list.board");
					//forward로 하면 f5누를떄 계속등록됭서 리다이렉트
		
				
			}else if(uri.equals("/detail.board")) {
				System.out.println("작성된글 불러오기");
				
				//String id = request.getSession().getAttribute("loginID").toString();  //출력할떈 필요없다, 근데 수정 삭제하기위해서 필요함
				/*
				 *  String() - 어떤 형태이든 문자로 형변환
					.toString() - null(존재하지 않는 값, 비어있는 값, 알 수 없는 값), undefined(값이 할당되지 않은 상태) 형 변환 시 오류
				 */
				
				//String id = (String)request.getSession().getAttribute("loginID");
				BoardDAO dao = BoardDAO.getInstance();
				int seq = Integer.parseInt(request.getParameter("seq"));
				
				System.out.println(seq+"넘어오나");
				
				BoardDTO list = dao.selectBoard(seq);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/board/detailboard.jsp").forward(request, response);
				
			}else if(uri.equals("/delete.board")){ //삭제
				System.out.println("삭제");
				int seq = Integer.parseInt(request.getParameter("seq"));
				
				BoardDAO dao = BoardDAO.getInstance();
				dao.boardDelete(seq);
				
				System.out.println("삭제!");
				response.sendRedirect("/list.board");
				
			}else if(uri.equals("/update.board")) { //업데이트
				int seq = Integer.parseInt(request.getParameter("seq"));
				String title = request.getParameter("uptitle");
				String contents =request.getParameter("upcontents");
				System.out.println(seq+title+contents);
				System.out.println("업데이트 시작");
				
				BoardDAO dao = BoardDAO.getInstance();
				
				int result = dao.update(new BoardDTO(seq, title, contents));
		
//					BoardDTO list = dao.selectBoard(seq);		
//					request.setAttribute("list",list);
//					request.getRequestDispatcher("/board/detailboard.jsp").forward(request, response);
				//여기서 글작성과 다르게 수정에서는 foward로 해야하는 이유는 detail.board로 selectBoard dao를 출력하려면
					// seq매개변수 인자값이 필요한데 이곳에서 해당 서블릿으로 seq를 보내는 방법이 필요하다  3순위
					
				//response.sendRedirect("/detail.board?seq="+seq); //리다이렉트방법 이방법도됨
				
				request.setAttribute("seq",seq); //시퀸스를 detail.board에 보내기 포워드 방법   이방법도됨
				request.getRequestDispatcher("/detail.board").forward(request, response);
				
				
			}else if(uri.equals("/upwriterForm.board")) { //수정하기 게시판으로 이동
				BoardDAO dao = BoardDAO.getInstance();
				int seq = Integer.parseInt(request.getParameter("seq"));
				
				System.out.println("수정하기로 가기");
				
				BoardDTO list = dao.selectBoard(seq);
				request.setAttribute("list", list);
			//	request.setAttribute("seq", seq);
				request.getRequestDispatcher("/board/upwriterForm.jsp").forward(request, response);
				
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
