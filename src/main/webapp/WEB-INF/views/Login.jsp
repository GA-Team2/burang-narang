<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login | 부랑나랑</title>
	<link rel="stylesheet" href="../../styles/normalize.css" />
    <link rel="stylesheet" href="../../styles/style_login.css" />

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	<div class="wrap inner">
        <div class="loginbox">
        	<img id="logo" src="../../images/logo_whole.png">
            <form name="loginForm" method="post" action="loginOk">
              <input type="text" name="memberNickname" id="memberNickname" placeholder="닉네임" value="${nick}"/>
              <p id="nickWarning" class="warning"></p>
              <input type="password" name="memberPassword" id="memberPassword" placeholder="비밀번호" />
              <p id="pwdWarning" class="warning"></p>
              <input type="button" id="good" onclick="loginCheck()">
      
              <label for="good">
                  <span>로그인</span>
              </label>
              <a class="home" href="Index">홈으로</a>
	      	</form>
        </div>
    </div>
    <script src="../../scripts/login.js"></script>
</body>
</html>