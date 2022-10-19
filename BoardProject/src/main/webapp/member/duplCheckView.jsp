<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Result</title>


	<style>
	
		table{
		width:100%;
		height :90vh;'
		}
		
		.result{
		height:30%
		text-align:center;
		
		}
	
		td{
			text-align:center;
		}
	</style>
</head>
<body>	

			<table border=1>
			<tr>
				<th>조회 결과
			</tr>
			<c:choose>
			<c:when test="${result}">
					<tr>
							<td class="result">
							이미 사용중인 id입니다
					</tr>
					<tr>
						<td><button id="close">닫기</button>
						<script>
							
							document.getElementById("close").onclick = function(){
								opener.document.getElementById("inputId").value="";//부모가 signup.jsp라 사용 가능
								window.close();
							}
							</script>
					</tr>
					
			</c:when>
			<c:otherwise>
					<tr>
							<td class="result">"${id}"<br>
							은(는) 사용할수 있는 ID입니다

					</tr>
					<tr>
						<td><button id="use"> 사용</button>
							<button id="cancel">취소</button>
							
							<script>
							document.getElementById("use").onclick = function(){
								opener.idcheckk=true; //use 누르면 idcheckk 변수 만들어지고 true값됨
								//opener= parent window
								window.close(); //팝업창 윈도우
							}
							
							document.getElementById("cancel").onclick = function(){
								opener.document.getElementById("inputId").value=""; //취소 시 입력칸지워지기
								window.close();
							}
							</script>
					</tr>
			</c:otherwise>
			</c:choose>

			</table>
</body>
</html>