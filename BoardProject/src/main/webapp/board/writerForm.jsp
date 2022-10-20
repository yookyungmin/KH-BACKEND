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
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
                crossorigin="anonymous">
            <!-- JavaScript Bundle with Popper -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
                crossorigin="anonymous"></script>


            <script src="https://code.jquery.com/jquery-3.6.1.js"></script>

            <style>
                * {
                    box-sizing: border-box;
                }

                div {
                    border: 1px solid black;
                }

                .container {
                    width: 50%;
                    height: 100%;
                    padding: 0;
                }

                .wcontents {
                    height: 500px;
                }
                
                .right{
                	text-align:right;
                }
                #titlee{
                	width:100%;
                	height:100%;
                }
                
                textarea{
                	width:100%;
                	height:100%
                }
            </style>
        </head>

        <body>
            <form action="/writer.board" method="post" id="write">
            <div class="container">
                <div class="header">
                    <div style="text-align:center">
                        <Strong>자유게시판 글 작성하기</Strong>
                    </div>
                    <div>
                        <input type="text" placeholder="글 제목을 입력하세요" name="title" id="titlee">
                    </div>
                </div>
                <div class="contents">
                    <div class="wcontents">
                        <textarea name="wcontents" id ="textt"></textarea>
                    </div>

                </div>
                <div class="footer">
                    <div class="right">
                        <button type="button" id="toBoard">목록으로</button>
                          <button type="submit">작성완료</button>
                    </div>
                
                </div>
            </div>
            </form>
            <script>

                $("#toBoard").on("click", function () { //인덱스 화면으로 가기
                    location.href = "/list.board";
                })
                 
                $("#write").on("submit", function(){   //제목이나 내용 입력 안하고 작성하기 눌렀을떄
                	let title = $("#titlee").val();
                	let contents = $("#textt").val();
      	
                	if(title==""||contents==""){
                		alert("제목이나 내용을 입력하지 않았습니다")
                		return false;
                	}else{
                		alert("등록이 되었습니다")
                	}
                })
            </script>
        </body>

        </html>