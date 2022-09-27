<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	
	String nickSession = (String)session.getAttribute("nick_s");
	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/signOut_style.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="scripts/mypage.js"></script>
    <title>Document</title>
</head>
<body>
    <div class="signOut_wrap">
    	<form action="infoDeleteOk.jsp?nick=<%=nick %>" method="post">
	        <h1>회원 탈퇴</h1>
	        <div>
	        	비밀번호 입력<input type="password" name="password">
	        </div>
	        <p>
	           	정말 탈퇴하시겠습니까?
	            <input type="submit" value="탈퇴">
	           <input type="button" value="취소" onclick="location.href='myPage.jsp'">
	        </p>
        </form>
    </div>
</body>
</html>