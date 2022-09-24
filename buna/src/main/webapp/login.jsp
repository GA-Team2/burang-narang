<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login | 부랑나랑</title>
	<link rel="stylesheet" href="styles/normalize.css" />
    <link rel="stylesheet" href="styles/style_login.css" />
    <link rel="stylesheet" href="template.css?ver=1.3">

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrap inner">
        <div class="loginbox">
            <h1>부랑나랑</h1>
            <form method="post" action="loginOk.jsp">
              <input type="text" name="nick" placeholder="닉네임" />
              <input type="password" name="pwd" placeholder="비밀번호" />
              <input type="submit" name="submit" id="submit">
      
              <label for="submit">
                  <span>로그인</span>
              </label>
              <a href="index.jsp">홈으로</a>
	      	</form>
        </div>
    </div>
</body>
</html>