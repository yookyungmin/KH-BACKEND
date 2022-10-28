package controllers;

import java.io.IOException;
import java.util.List;

import javax.lang.model.element.Element;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;


@WebServlet("*.mem")
public class MembersController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf8"); //한글처리
			//HTTP상에서 주고 받는 데이터의 헤더값을 UTF-8로 인코딩
			//request.getParameter로 한글이 깨질 경우
		
		String uri = request.getRequestURI();
		try {
			
		if(uri.equals("/idcheck.mem")) {
			String id =request.getParameter("id");
			System.out.println("전달된 id="+id);
			System.out.println("Members Controller 동작");
			MemberDAO dao= MemberDAO.getInstance();

			boolean result = dao.isIdExist(id);
			System.out.println(result);
			response.getWriter().append(String.valueOf(result)); //ajax 식, 중복체크
//			request.setAttribute("result", result);
//			request.setAttribute("id",id);
//			request.getRequestDispatcher("/member/duplCheckView.jsp").forward(request, response);
		}else if(uri.equals("/toJoin.mem")) { //회원가입시 db입력, 암호화 적용
		
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
		
			
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String zipcode= request.getParameter("zipcode");
			String addr1 = request.getParameter("address1");
			String addr2= request.getParameter("address2");
			
			MemberDAO dao = MemberDAO.getInstance();
			String pwd = dao.getSha256(pw);
		
			int result= dao.insertSign(new MemberDTO(id, pwd, name, phone, email, zipcode, addr1, addr2, null));
			
			System.out.println("회원가입성공");
			response.sendRedirect("index.jsp");
			
		}else if(uri.equals("/login.mem")) { //로그인
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			MemberDAO dao = MemberDAO.getInstance();
////			MemberDTO dto = new  MemberDTO();
//			String pwd =dto.getSha256(pw); //dto 암호화
			String pwd = dao.getSha256(pw);
			boolean result = dao.login(id, pwd);
			
			System.out.println(id);
			System.out.println(pwd);
			
			if(result) {
					System.out.println("로그인 완료");
					request.getSession().setAttribute("loginID",id);// 실제 로그인, 창고의 주소값을 꺼낸다. 
					//로그인 성공하면 세션 창고에 id값을 남긴다(key, value), 서버쪽 모든 페이지 사용 가능
					//받은 key값은 브라우저 램에 저장, 세션 key와 key값의 key 별개
					//로그아웃은 값을 지우면 됨
					//세션에 저장되어서 foward를 안하고 redirect해도됨
				
			}
				response.sendRedirect("/"); //로그인 성공, 실패 해도 동일화면, // 로그인 성공하면 sso 적용
			

		}else if(uri.equals("/logout.mem")) { //로그아웃
			//request.getSession().setAttribute("loginID",null);  ex)장바구니는 남길떄
			request.getSession().invalidate(); //로그아웃 보편적으로는, invalidate 무효화 현재 key값의 창고데이터는 날림
			response.sendRedirect("/");
		}
		else if(uri.equals("/memberout.mem")) { //회원탈퇴
			MemberDAO dao= MemberDAO.getInstance();
			String id = request.getSession().getAttribute("loginID").toString();
			//String id=(String)request.getSession().getAttribute("loginID");
			//로그인 상태에서 로그인 id가져오기
			
				
			int result= dao.delete(id);
		
			
			request.getSession().invalidate();
			response.sendRedirect("/");
		}else if(uri.equals("/mypage.mem")){
			MemberDAO dao= MemberDAO.getInstance();
			String id = request.getSession().getAttribute("loginID").toString();  //dao에서 사용하기위해 id값을 가져옴
			
			MemberDTO dto = dao.selectMypage(id);
			
			request.setAttribute("list", dto);
			request.getRequestDispatcher("/member/mypage.jsp").forward(request, response);
		}else if(uri.equals("/toUpdate.mem")){
			String id=(String)request.getSession().getAttribute("loginID");
			String pw = request.getParameter("pw");
		
			
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String zipcode= request.getParameter("zipcode");
			String addr1 = request.getParameter("address1");
			String addr2= request.getParameter("address2");
			
			MemberDAO dao = MemberDAO.getInstance();
			String pwd = dao.getSha256(pw);
		
			int result= dao.update(new MemberDTO(id, pwd, name, phone, email, zipcode, addr1, addr2, null));
			
		
			response.sendRedirect("/index.jsp");
		}
		
		
		else if(uri.equals("/toSignup.mem")) {
			System.out.println("회원가입 버튼으로 이동");
			response.sendRedirect("member/signup.jsp");
		}else if(uri.equals("/toJoin.mem")) {
			System.out.println("회원가입 후 인덱스이동");
			response.sendRedirect("index.jsp");
			
		}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

	}  //중복확인

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
