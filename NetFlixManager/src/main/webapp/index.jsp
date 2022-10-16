<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<style>
	*{box-sizing:border-box;}
	div{border:1px solid black;}
	.container{
		margin:auto;
		width:200px;
		height:100px;
	}
	.box{text-align:center;}
	.title{height:40%;font-size:20px;line-height:35px;}
	.input,.output{height:30%;}
	
	.box button{
		width:100%;
		height:100%;
	}
	
</style>
</head>
<body>
	<div class=container>
		<div class="title box">
			Netflix Manager
		</div>
		<div class="input box">
			<a href="toinput.netflix"><button>신규 영화 등록</button></a>
		</div>
		<div class="output box">
			<a href="output.netflix"><button>영화 목록 출력</button></a>
		</div>
	</div>
</body>
</html>