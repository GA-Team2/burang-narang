<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    String[] arr = request.getParameterValues("spot");
		
		for(int i=0; i<arr.length; i++){
			%>
			<%= arr[i] %> <br>
			<%
		}
	%>
	
</body>
</html>