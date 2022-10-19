<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <form method="post" action="loginOk">
              <input type="text" name="nick" placeholder="닉네임" />
              <input type="password" name="pwd" placeholder="비밀번호" />
              <input type="submit" name="submit" id="submit">
      
              <label for="submit">
                  <span>로그인</span>
              </label>
              <a class="home" href="Index">홈으로</a>
	      	</form>
        </div>
    </div>
</body>
</html>