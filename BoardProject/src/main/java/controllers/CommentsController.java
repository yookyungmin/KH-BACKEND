package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CommentsDAO;
import DTO.CommentsDTO;


@WebServlet("*.comments")
public class CommentsController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String uri	= request.getRequestURI();
		System.out.println(uri);
		
		try {
		if(uri.equals("/insert.comments")) {
			//코멘트 내용, 작성자 정보(세션통해서), 작성시간, parent 글번호, 글번호
			System.out.println("댓글 db입력");
			String writer=(String)request.getSession().getAttribute("loginID");
			String contents = request.getParameter("replycontents");
			
			int pseq = Integer.parseInt(request.getParameter("parent_seq"));
			
			System.out.println(writer+contents+pseq);
			
			CommentsDAO dao= CommentsDAO.getInstance();
			dao.insertcomment(new CommentsDTO(0, writer, contents, null, pseq));
			
			response.sendRedirect("/detail.board?seq="+pseq);
		}else if(uri.equals("/delete.comments")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int pseq = Integer.parseInt(request.getParameter("parent_seq"));
			System.out.println("삭제할 rseq="+seq);
			System.out.println("부모"+pseq);
			
			int result=CommentsDAO.getInstance().commentsDelete(seq);
			response.sendRedirect("/detail.board?seq="+pseq);
		}else if(uri.equals("/update.comments")) {
		
			int seq = Integer.parseInt(request.getParameter("seq"));
			System.out.println("수정할 seq"+seq);
			
			String upcomments =request.getParameter("upcomments");
			System.out.println("수정할 코멘트"+upcomments);

			int pseq = Integer.parseInt(request.getParameter("parent_seq"));
			System.out.println("부모 seq"+pseq);
			
			String writer=(String)request.getSession().getAttribute("loginID");
			
			CommentsDAO dao = CommentsDAO.getInstance();
			
			int result= dao.update(new CommentsDTO(seq, writer, upcomments, null, pseq));
			
			response.sendRedirect("/detail.board?seq="+pseq);
			//CommentsDAO dao= CommentsDAO.getInstance();
			
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
