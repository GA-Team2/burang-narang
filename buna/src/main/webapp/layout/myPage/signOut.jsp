<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	
<<<<<<< HEAD
	String nick = request.getParameter("nick");
=======
	String nickname = request.getParameter("current_nickname");
>>>>>>> 7514e05cf59a2404f731407a7d739d4dd728d767
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
<<<<<<< HEAD
    	<form action="infoDeleteOk.jsp?nick=${sessionScope.nick_s }" method="post">
=======
    	<form action="deleteOk.jsp?nickname=<%=URLEncoder.encode(nickname, "utf-8")%>" method="post">
>>>>>>> 7514e05cf59a2404f731407a7d739d4dd728d767
	        <h1>회원 탈퇴</h1>
	        <div>
	        	비밀번호 입력<input type="password" name="password">
	        </div>
	        <p>
	           	정말 탈퇴하시겠습니까?
	            <input type="submit" value="탈퇴">
	            <input type="button" value="취소" onclick="history.back()">
	        </p>
        </form>
    </div>
</body>
</html>