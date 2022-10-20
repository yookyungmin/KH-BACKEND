<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
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
                        width: 100%;
                        height: 80%;
                    }

                    textarea{
                    	border:none;
                    	resize:none;
                        width: 100%;
                        height:500px;
                        background-color : transparent;
                        
                    }
	
					textarea:focus{
						outline:none;
					}
                    .right{
                        text-align: right;
                    }
                    
    </style>

    </head>
<body>
            <div class="container">
                <div class="row header">
                	<div class="d-none" id="seq">${list.seq}</div>
                    <div class="col-12 col-md-12">${list.title}</div>
                    <div class="col-12 col-md-4">${list.writer }</div>
                    <div class="col-8 col-md-6">${list.write_date}</div>
                    <div class="col-4 col-md-2">${list.view_count }</div>
                </div>
                <div class="row contents">
                    <div class="col-12">
                    	<textarea  disabled>${list.contents }</textarea>	
                    </div>
                </div>
                
                <div class="row footer">
                    <div class="col-12 right">
                    <c:choose>
                    <c:when test="${loginID==list.writer}">
                        <button type="button" class="btn btn-outline-secondary" id="toDelete">삭제하기</button>
                        <button type="button" class="btn btn-outline-secondary" id="toWriterForm">수정하기</button>
                        </c:when>
                           </c:choose>
                        <button type="button" class="btn btn-outline-secondary" id="toBoard">목록으로</button> 
                    </div>
                </div>

            </div>
          

            <script>
                $("#toBoard").on("click", function () { //인덱스 화면으로 가기
                        location.href = "/list.board";
                    })
                    
                    
                    $("#toDelete").on("click", function(){
                    	
                    	let seq= document.getElementById("seq").innerHTML;
                    	
                    	
                    
                    	let result = confirm("삭제하실건가요?");
                    	
                    	if(result){
                    	 	location.href="/delete.board?seq="+seq;
                    	}else{
                    		return false;
                    	}
                    	
                
                    })
                    
                    $("#toWriterForm").on("click", function(){
                    	let seq= document.getElementById("seq").innerHTML;
                    	location.href="/upwriterForm.board?seq="+seq;
                    })
                    
            </script>


</body>
</html>