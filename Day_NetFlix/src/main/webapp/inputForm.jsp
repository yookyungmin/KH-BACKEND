<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
        
        <style>
            *{
               box-sizing: border-box;
            }

            div{
                border: 1px solid black;
            }
            .container{
                width: 400px;
                height: 100%;
                background-color:black;
                text-align: center;
                margin: auto;
            }
            .header{
                width: 100%;
                height: 70px;
                color:white;
            }

            .contents{
                width: 100%;
                height: 100px;
                background-color: white;
            }
            .footer{
                width: 100%;
                height: 60px;
                background-color: black;
            }
            .row{width: 100%; height: 50px;}
            .box1{
                width: 20%;
                height: 100%;
                float: left;
                text-align: center;
                line-height: 50px;
            }
            .box2{
                width: 80%;
                height: 100%;
          
                float: left;
            }
            input{
                width: 100%;
                height: 100%;
            }
           
            .box3{
                width: 50%;
                height: 100%;
                float: left;
            }
            .box4{
                width: 50%;
                height: 100%;
                float: left;
            }
             button{
                width: 100%;
                height: 100%;
            }

        </style>
</head>
<body>

		<form action="input.netflix">
        <div class = "container">
            <div class="header">
                <h1>영화 신규 입력</h1>
            </div>
            <div class="contents">
                <div class="row">
                    <div class="box1">영화 제목</div>
                    <div class="box2"><input type="text" name="title" placeholder="Input Moive Name"></div>
                </div>
                <div class="row">
                    <div class="box1">영화 장르</div>
                    <div class="box2"><input type="text" name="genre" placeholder="Input Moive Name"></div>
                </div>
                
            </div>
            <div class="footer">
                <div class="box3"><button>SEND</button></div>
                <div class="box4"><a href="index.jsp"><button type="button">Back</button></a></div>
            </div>
        </div>
        </form>
</body>
</html>