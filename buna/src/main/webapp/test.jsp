<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%= request.getParameter("p_title") %><br>
<%= request.getParameter("p_firstdate") %><br>
<%= request.getParameter("p_lastdate") %><br>
<%= request.getParameter("t_taglist") %>
</body>
</html>