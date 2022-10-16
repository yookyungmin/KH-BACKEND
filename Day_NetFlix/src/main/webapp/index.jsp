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
            margin: auto;
          
           
        }
        
        .header{
            width: 100%;
            height: 60px;
            text-align: center;
            line-height: 20px;
             background-color: black;
            color: white;
            

        }

        .contents{
            width: 100%;
            height: 40px;
        }
        .input{
            width: 50%;
            float: left;
            height: 100%;
        }
        .select{
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

    <div class= "container">
            <div class="header">
                <h1>NetFlixManager</h1>
                
            </div>
            <div class="contents">
                <div class ="input">
                    <a href = "inputForm.jsp"><button>신규 영화 등록</button></a>
                    
                </div>
                <div class = "select">
                    <a href = "output.netflix"><button>영화 목록 출력</button></a>
                </div>
            </div>
    </div>
    
</body>
</html>