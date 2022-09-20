<%@page import="java.net.URLEncoder"%>
<%@page import="signUpPackage.SignUpDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	
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
		SignUpDBBean sdb = SignUpDBBean.getInstance();
	
		if(sdb.confirmID(nick) == 1){
			response.sendRedirect("signUp.jsp?nickC=1");
		} else {
			String str = URLEncoder.encode(nick,"UTF-8");
			response.sendRedirect("signUp.jsp?nickC=0&&nickN=" + str);
		}
	%>
</body>
</html>