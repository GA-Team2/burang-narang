<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>restore plan</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");	
	
		String[] p_no = request.getParameterValues("p_no");
		String[] s_name = request.getParameterValues("s_name");
		String[] s_type = request.getParameterValues("s_type");
		String[] s_loc = request.getParameterValues("s_loc");
		
		for(int i=0; i<p_no.length; i++){
			%>
			<div>
				<%= p_no[i] %>
				<%= s_name[i] %>
				<%= s_type[i] %>
				<%= s_loc[i] %>
			</div>
			<%
		}
	%>
	
	
</body>
</html>