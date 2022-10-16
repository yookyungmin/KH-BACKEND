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
                width: 700px;
                height: 100%;
                margin: auto;
            }
            .header{
                width: 100%;
                height: 70px;
                background-color: black;
                text-align: center;
                color: white;
                line-height: 30px;
                overflor:hidden;
            }
            .contents{
                width: 100%;
                height: 400px;
            }
            .box1{
                width: 100%;
                height: 40px;
            }

            .box1 div{
                text-align: center;
                line-height: 40px;
               float: left;
                height: 100%;
            }
            .title-1{
                width: 10%;
            }
            .title-2{
                width: 40%;
         
            }
            .title-3{
                width: 10%;
            }
            .title-4{
                width: 40%;
            }
            .footer{
                width: 100%;
                height: 40px;
            }
            .box2{
                width: 100%;
                height: 100%;
                float: left;
            }
            button{
                width: 100%;
                height: 100%;
            }

            .conbox div{
                text-align: center;
                line-height: 40px;
               float: left;
                height: 100%;
            }

             .cont-1{
                width: 10%;
            }
             .cont-2{
                width: 40%;
         
            }

             .cont-3{
                width: 10%;
            }
            .cont-4{
                width: 40%;
            }
        



      
    </style>
</head>
<body>


        <div class="container">
            <div class="header">
                <h1>영화 목록</h1>
            </div>
            <div class="contents">
                <div class="box1">
                <div class="title-1">아이디</div>
                <div class="title-2">제목</div>
                <div class="title-3">장르</div>
                <div class="title-4">개봉일</div>
                </div>
                <c:choose>
                    <c:when test="${not empty list}">
                    <c:forEach var="i" items="${list}">
                <div class="conbox">
                    <div class="cont-1">${i.id}</div>
                    <div class="cont-2">${i.title}</div>
                    <div class="cont-3">${i.genre}</div>
                    <div class="cont-4">${i.launch_date}</div>
                </div>
                </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="cont-5">출력할 내용이 없습니다</div>
                </c:otherwise>
                </c:choose>
            </div>
            <div class="footer">
                <div class="box2">
                    <a href="index.jsp"><button>
                        Back
                    </button></a>
                    
                </div>
            </div>
        </div>
    
</body>
</html>