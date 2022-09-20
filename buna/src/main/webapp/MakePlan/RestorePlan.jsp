<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String p_title = request.getParameter("p_title");
		String p_firstdate = request.getParameter("p_firstdate");
		String p_lastdate = request.getParameter("p_lastdate");
		
		int i = 0;
		while(true){
			if(request.getParameterValues("p_no"+(i+1)) != null) i++;
			else break;
		}
	%>
	<h1><%= p_title %></h1>
	<p>
		<%= p_firstdate %> ~ <%= p_lastdate %>
	</p>
	
	<table border="1">
		<%
		for(int j=1; j<=i; j++){
			String[] p_no = request.getParameterValues("p_no"+j);
			String[] s_name = request.getParameterValues("s_name"+j);
			String[] s_type = request.getParameterValues("s_type"+j);
			String[] s_loc = request.getParameterValues("s_loc"+j);
			
			for(int x=0; x<p_no.length; x++){
				%>
				<tr>
					<td colspan="4">day<%= j %></td>
				</tr>
				<tr>
					
					<td><%= p_no[x] %></td>
					<td><%= s_name[x] %></td>
					<td><%= s_type[x] %></td>
					<td><%= s_loc[x] %></td>
				</tr>
				
				<%
			}
		}
		%>
	</table>
</body>
</html>