<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
    <!--css-->
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/style_loginModal.css">
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- makePlan시 로그인 되어 있지 않을 경우 
		저장 누르면 login 요구하는 창 띄움
	 -->
	<div class="login_Modal hidden" id="login">
        <div class="login_form">
        <!-- makePlanLoginForm.jsp가 로드되는 공간 -->
        </div>
    </div>
    <!-- js -->
    <script src="scripts/modalLoginForm.js"></script>
</body>
</html>