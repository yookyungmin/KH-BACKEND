<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl 태그립,  core 기능자의 구분자 이름 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#msg{
	height:30px
	}
</style>
</head>
<body>
		<table border=1 align="center">
		<tr>
		<th colspan =10> NetFlixList
		</tr>
		<tr>
			<th>id
			<th>Writer
			<th>genre
			<th>Date
		</tr>
		<c:choose>
			<c:when test="${not empty list}"> <!-- 비어있지 않다면 -->
			<c:forEach var="i" items="${list}">  <!-- jstl에선 "" 필수 -->
			<tr>
				<td>${i.id}
				<td>${i.title}
				<td>${i.genre}
				<td>${i.formedDate }  <!-- 필드명을 입력하는것처럼 보이지만 게터 메서드를 꺼내는것 그래서 게터 메서드 필수-->
			
			</tr>
			</c:forEach>
			</c:when>
			<c:otherwise>
				<th colspan=4> 출력할 내용이 없습니다.
			</c:otherwise>
		</c:choose>
		<tr>
		<form action="search.netflix">
		<td colspan=4>
		<input tpye=text name=title placeholder="검색하실 영화 제목이나, 일부" ><button>Search</button>
		</tr>
		</form>
		<tr>
			<Form action="delete.netflix">
			<td colspan=10>
			<input type=text name=delId placeholder="input id to delete"><button>Delete</button>
			</Form>
		</tr>
		<tr>
			<td colspan=10>
			<form action="update.netflix">
			<input type="text" name = id placeholder="Input id to Modify"><br>
			<input type="text" name = title placeholder="Input title to Modify"><br>
			<input type="text" name = genre placeholder="Input genre to Modify">
			<button>Modify</button>
			</form>
		</tr>
		<tr>
			<td colspan=10 align =center><a href="index.jsp"><button>Back</button></a>
		</tr>
		</table>
		
			<script>
			
			</script>
		
</body>
</html>