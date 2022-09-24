<%@page import="org.ga2.buna.dto.MonthCheckBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		한글 깨짐 방지 
	*/
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MonthCheckBean mcb = new MonthCheckBean();
		String setY = request.getParameter("year");
		String setM = request.getParameter("month");
		
		mcb.setMonth(setM);
		mcb.setYear(setY);
		response.sendRedirect("index.jsp?month=" + mcb.getMonth() + "&&year=" + mcb.getYear());
	%>

</body>
</html>