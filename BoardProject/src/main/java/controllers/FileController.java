package controllers;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.file")
public class FileController extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String uri =request.getRequestURI();
			
			String filePath = request.getServletContext().getRealPath("files");
		if(uri.equals("/download.file")) { //파일 다운로드
			String sysname = request.getParameter("sysname");
			System.out.println(filePath+"/"+sysname);  //파일의 절대 경로
			String oriname = request.getParameter("oriname");

			
			File target = new File(filePath+"/"+sysname); //하드디스크에 있는걸 램으로 가져오려면 input 램을 기준으로 input, output
			
			//하드디스크에 네트워크로 내보내는법은 없고 램을 거쳐야 한다.
			byte[] fileContents = new byte[(int)target.length()]; 
			oriname= new String(oriname.getBytes("utf8"), "iso-8859-1");
			
			
			response.reset(); //혹시나 발생할수 있는 에러 제거
			response.setHeader("Content-Disposition", "attachment; filename=\""+oriname+"\"");  //첨부 파일이라고 알려주는 코드 download로 동자
			
			try(ServletOutputStream sos = response.getOutputStream();
					FileInputStream fis = new FileInputStream(target);
					DataInputStream dis = new DataInputStream(fis);){
				dis.readFully(fileContents);
				sos.write(fileContents);
				sos.flush();
				
				//개발자가 의도하지 않은 동작을 방지하기 위함, 권한체크 검사 추가 가능
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
