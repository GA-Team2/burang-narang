<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/style_login.css" />

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrap inner">
        <div class="loginbox">
            <h1>부랑나랑</h1>
            <form method="post" action="loginOk.jsp">
              <input type="text" name="id" placeholder="아이디" />
              <input type="text" name="pwd" placeholder="비밀번호" />
              <input type="submit" id="submit">
      
              <label for="submit">
                  <span>로그인</span>
              </label>
	      	</form>
        </div>
    </div>
</body>
</html>