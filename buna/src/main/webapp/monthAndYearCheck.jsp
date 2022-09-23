<%@page import="dateCheckPackage.DateCheckBean"%>
<%@page import="dateCheckPackage.DateCheckDBBean"%>
<%@page import="dateCheckPackage.MonthCheckBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<meta charset="EUC-KR">
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