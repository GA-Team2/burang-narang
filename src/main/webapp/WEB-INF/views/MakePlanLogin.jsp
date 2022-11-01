<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
    <!--css-->
    <link rel="stylesheet" href="../../styles/normalize.css">
    <link rel="stylesheet" href="../../styles/style_loginModal.css">
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- makePlan시 로그인 되어 있지 않을 경우 
		저장 누르면 login 요구하는 창 띄움
	 -->
	<div class="login_modal hidden" id="login">
        <form name="loginForm" method="post" action="/new/login">
            <div class="login_container">
                <img class="login_logo" src="../../images/logo_whole.png">
                <input type="text" name="nick" placeholder="닉네임" class="login_input"/>
                <p id="nickWarning" class="warning"></p>
                <input type="password" name="pwd" placeholder="비밀번호" class="login_input"/>
                <p id="pwdWarning" class="warning"></p>
                <input type="button" value="로그인" onclick="loginCheck()" class="login_btn">
                <input type="button" value="홈으로" onclick="location.href='/'" class="home_btn">
            </div>
        </form>
    </div>
    <!-- js -->
    <script src="../../scripts/planLogin.js"></script>
</body>
</html>