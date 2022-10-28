package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicPanelUI;
import javax.swing.plaf.multi.MultiOptionPaneUI;

import org.w3c.dom.css.ElementCSSInlineStyle;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.BoardDAO;
import DAO.CommentsDAO;
import DAO.FilesDAO;
import DAO.MemberDAO;
import DTO.BoardDTO;
import DTO.CommentsDTO;
import DTO.FilesDTO;
import DTO.MemberDTO;

@WebServlet("*.board")
public class BoardController extends HttpServlet {


 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String uri	= request.getRequestURI();
		
		try {
			
			if(uri.equals("/list.board")) {  //자유게시판 목록
				System.out.println("자유게시판 목록");
				
				int capge = Integer.parseInt(request.getParameter("cpage")); //네비바 
				BoardDAO dao = BoardDAO.getInstance();
				String navi=dao.getPageNavi(capge); //네비바 dao 인자
				
				//List<BoardDTO> list = dao.printBoard(); //네비바 적용전 모두 출력
				List<BoardDTO> list = BoardDAO.getInstance().selectByRange(capge*10-9,capge*10);
				//1~10 페이지만 보이게
				
		
				request.setAttribute("list", list);
				request.setAttribute("navi", navi);
				request.getRequestDispatcher("/board/boardlist.jsp").forward(request, response);
				
			}else if(uri.equals("/writer.board")) { //글쓰기
				
				int maxSize =1024*1024*10; // 10MB
				String savePath = request.getServletContext().getRealPath("files");
				System.out.println(savePath);
				
				File fileSavePath = new File(savePath);
				
			
				if(!fileSavePath.exists()) { //파일이 존재하지 않는다면 
					fileSavePath.mkdir(); //만들어라 makedirectory
				} //하드디스크와 관련된 작업들은 언제든 오류가 생길수 있다
				
				MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF8", new DefaultFileRenamePolicy());
				
				//multipart에선 request.이 아닌 multi.
				System.out.println("글쓰기 완료");
				String writer=(String)request.getSession().getAttribute("loginID");
				String title = multi.getParameter("title");
				String contents = multi.getParameter("wcontents");
				//게시글 seq, writer, title, contents, write_date, view count
				
			
				int nextVal= BoardDAO.getInstance().getNextval(); //seq를 직접 넣기 위한
				BoardDAO dao = BoardDAO.getInstance();
				dao.insertwrite(new BoardDTO(nextVal, writer,title,contents,null,0)); // 게시글 db에저장
				
				
				
				Enumeration<String> e =  multi.getFileNames();  //여러개의 파일
				while(e.hasMoreElements()) {  //rs.next와 유사 다음 데이터가 있다면 true가 되면서 꺼내고 없으면 false가되면서 while문 끝
					String name= e.nextElement();
					System.out.println(name);//파일 네임 확인
					String oriname = multi.getOriginalFileName(name);
					if(oriname==null) {
						continue; // null값이라면 건너띄기
					}
					String sysname = multi.getFilesystemName(name);
					FilesDAO.getInstance().insertFile(new FilesDTO(0, oriname, sysname, nextVal ));
//					if(!(oriname==null)) {
//						FilesDAO.getInstance().insertFile(new FilesDTO(0, oriname, sysname, nextVal ));
//						}//프론트에서도 값이 없을때 서브밋 안되게 하는법도 있다
				}//파일
				
				
//				String oriname = multi.getOriginalFileName("file");
//				String sysname = multi.getFilesystemName("file");  //파일 한개씩만 넣을때

				  //oriname이 null값이 아니라면 파일 넣기
				
				//parent_seq는 어디서 가져오냐? 게시글 seq를 직접 넣어줘서
				
				

				response.sendRedirect("/list.board?cpage=1");
					//forward로 하면 f5누를떄 계속등록됭서 리다이렉트
		
				
			}else if(uri.equals("/detail.board")) {
				//System.out.println("작성된글 불러오기");
				
				//String id = request.getSession().getAttribute("loginID").toString();  //출력할떈 필요없다, 근데 수정 삭제하기위해서 필요함
				/*
				 *  String() - 어떤 형태이든 문자로 형변환
					.toString() - null(존재하지 않는 값, 비어있는 값, 알 수 없는 값), undefined(값이 할당되지 않은 상태) 형 변환 시 오류
				 */
				
				//String id = (String)request.getSession().getAttribute("loginID");
		
				int seq = Integer.parseInt(request.getParameter("seq")); //시퀸스값 불러오기
				
				//System.out.println(seq+"넘어오나");
				BoardDAO dao = BoardDAO.getInstance();
				CommentsDAO cdao = CommentsDAO.getInstance();
				
				
				List<CommentsDTO> list2 = cdao.commentsprint(seq); //댓글
				
				//System.out.println("list2"+list2);
				
				dao.addViewCount(seq);  //조회수 증가
				
				List<FilesDTO> list3 = FilesDAO.getInstance().selectFileByParent(seq); //부모 시퀸스로 파일 출력
				request.setAttribute("filelist", list3);
				
				BoardDTO list = dao.selectBoard(seq);
				request.setAttribute("list", list);
				request.setAttribute("list2", list2); //댓글리스트
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
					
				response.sendRedirect("/detail.board?seq="+seq); //리다이렉트방법 이방법도됨 ,, 브라우저 주소창에 주소를 입력하고 엔터치는 효과와 동일
		
				//request.setAttribute("seq",seq); //시퀸스를 detail.board에 보내기 포워드 방법   이방법도됨 
			//	request.getRequestDispatcher("/detail.board").forward(request, response);
				
				
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
