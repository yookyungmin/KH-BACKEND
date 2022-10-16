<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
<style>
	*{box-sizing: border-box;text-align:center;}
	div{border:1px solid black;}
	.container{margin:auto;width:400px;}
	.header,.movie{overflow:hidden;}
	.header div, .movie div{
		float:left;
	}
	.id{width:10%;}
	.title{width:40%;}
	.genre{width:20%;}
	.launch_date{width:30%;}
</style>
</head>
<body>
	<div class="container">
		<div class="caption">Netflix 영화 목록</div>
		<div class="header">
			<div class="id">ID</div>
			<div class="title">제목</div>
			<div class="genre">장르</div>
			<div class="launch_date">출시일</div>
		</div>
		<c:forEach var="i" items="${list }">
		<div class="movie">
			<div class="id">${i.id }</div>
			<div class="title">${i.title }</div>
			<div class="genre">${i.genre }</div>
			<div class="launch_date">${i.formedDate }</div>
		</div>
		</c:forEach>
		<div class="delete">
			<form action="delete.netflix">
				<input type=text name="id" placeholder="삭제할 영화 번호 입력"><button>삭제</button>
			</form>
		</div>
		<div class="update">
			<form action="update.netflix">
				<input type=text name="title" placeholder="수정할 영화 제목"><br>
				<input type=text name="genre" placeholder="수정할 영화 장르"><br>
				<input type=text name="id" placeholder="수정할 영화 번호 입력"><br>
				<button>수정</button>
			</form>
		</div>
		<div class="search">
			<form action="search.netflix">
				<input type=text name=title placeholder="검색할 영화의 제목">
				<button>검색</button>
			</form>
		</div>
		<div class="footer">
			<a href="index.jsp"><button>back</button></a>
		</div>
	</div>

</body>
</html>