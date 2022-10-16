<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 영화 등록</title>
<style>
	*{box-sizing:border-box;text-align:center;}
	div{border:1px solid black;}
	.container{
		margin:auto;
		width:200px;
		height:100px;
	}
	div button, div input{
		width:100%;height:100%;
	}
	
	   .box4{
                width: 100%;
                height: 100%;
                float: left;
            }
	
</style>
</head>
<body>
	<form action="input.netflix">
		<div class="container">
			<div class="caption">
				신규 영화 등록
			</div>
			<div class="title">
				<input type=text name=title placeholder="등록할 영화의 제목">
			</div>
			<div class="genre">
				<input type=text name=genre placeholder="등록할 영화의 장르">
			</div>
			<div class="date">
				<input type="date" name=launch_date placeholder="등록할 영화의 출시일">
			</div>
			<div class="btns">
				<button>등록</button>
				 <div class="box4"><a href="index.jsp"><button type="button">Back</button></a></div>
			</div> <!-- a태그 form태그 바깥으로 해야 -->
		</div>
	</form>
	
</body>
</html>