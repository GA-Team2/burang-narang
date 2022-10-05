<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	body, html {height: 100%;}
        .login_Modal {
            width: 100%;
            height: 100%;
            position: fixed;
            top: 0;
            z-index: 100;
            background-color: rgba(0, 0, 0, 0.8);
            display: block;
        }
        .login_form {
            width: 500px;
            height: 500px;
            background-color: white;
            position: fixed;
            top: 100px;
            left: 50%;
            transform: translateX(-50%);
            z-index: 999;
            text-align: center;
        }
        .hidden{
        	display: none;
        }
        h1 {
        	font-size: 70px;
        	margin: 50px auto 70px;
        }
</style>
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- makePlan시 로그인 되어 있지 않을 경우 
		저장 누르면 login 요구하는 창 띄움
	 -->
	<div class="login_Modal hidden" id="login">
        <div class="login_form">
        </div>
    </div>
    <script src="scripts/modalLoginForm.js"></script>
</body>
</html>