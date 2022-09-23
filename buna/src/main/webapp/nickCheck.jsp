<%@page import="java.net.URLEncoder"%>
<%@page import="signUpPackage.SignUpDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		한글 깨짐 방지 
	*/
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	/* signUp.jsp로부터 받은 닉네임 파라미터 변수 선언 */
	String nick = request.getParameter("nick");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nickCheck | 부랑나랑</title>
</head>
<body>
	<%
		/* 데이터 베이스 객체 선언 */
		SignUpDBBean sdb = SignUpDBBean.getInstance();
		
		/* 
			닉네임 중복체크 조건문 
		*/
		if(sdb.confirmID(nick) == 1){  /* 닉네임이 중복될 경우 */
			/* 닉네임 중복 여부 판단 값인 nickC의 value를 1로 설정 후 signUp.jsp로 보냄 */
			response.sendRedirect("signUp.jsp?nickC=1");
		} else {  /* 닉네임이 중복되지 않았을 경우 */
			/* 한글 깨짐 방지 */
			String str = URLEncoder.encode(nick,"UTF-8");
			/* nickC를 0으로 설정 및 중복체크 여부 판단 값인 nickN의 값을 signUp.jsp로 보냄 */
			response.sendRedirect("signUp.jsp?nickC=0&&nickN=" + str);
		}
	%>
</body>
</html>