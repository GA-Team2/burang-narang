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
        <div class="login_form">
            <h1>부랑나랑</h1>
            닉 네 임: <input type="text" name="nick" placeholder="닉네임" id="nick" />
            <br>
            비밀번호: <input type="password" name="pwd" placeholder="비밀번호" id="pwd" />
            <br>
            <input type="submit" value="로그인" onclick="login_check()">
            <input type="button" value="취소" onclick="cancel_login()">
        </div>
    </div>
    <!-- js -->
    <script src="../../scripts/modalLoginForm.js"></script>
</body>
</html>