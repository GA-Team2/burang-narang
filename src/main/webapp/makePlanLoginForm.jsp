<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>부랑나랑</h1>
   		닉 네 임: <input type="text" name="nick" placeholder="닉네임" id="nick"/> <br>
   		비밀번호: <input type="password" name="pwd" placeholder="비밀번호" id="pwd" /> <br>
		<input type="submit" value="로그인" onclick="login_check()">
		<input type="button" value="취소" onclick="cancel_login()">
	<script src="scripts/modalLoginForm.js"></script>
</body>
</html>