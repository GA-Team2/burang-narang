<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>플랜 저장(임시) | 부랑나랑</title>
</head>
<body>
	<%
		String p_title = request.getParameter("p_title");
		String p_firstdate = request.getParameter("p_firstdate");
		String p_lastdate = request.getParameter("p_lastdate");
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date fd = fm.parse(p_firstdate);
		Date ld = fm.parse(p_lastdate);
		Timestamp firstdate = new Timestamp(fd.getTime());
		Timestamp lastdate = new Timestamp(ld.getTime());
		
		
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
		<tr>
			<td>플랜 번호</td>
			<td>장소 넘버</td>
			<td>장소 이름</td>
			<td>장소 타입</td>
			<td>장소 위치</td>
		</tr>
		<%
		for(int j=1; j<=i; j++){
			String[] p_no = request.getParameterValues("p_no"+j);
			String[] s_snum = request.getParameterValues("s_snum"+j);
			String[] s_name = request.getParameterValues("s_name"+j);
			String[] s_type = request.getParameterValues("s_type"+j);
			String[] s_loc = request.getParameterValues("s_loc"+j);
			%>
				<tr>
					<td colspan="2">여행 날짜 : day<%= j %></td>
					<td colspan="3">
						<%
							int sec = 600;		          
		                  	Calendar cal = Calendar.getInstance();
		                  	cal.setTime(firstdate);
		                  	
							Timestamp tripdate = firstdate;
							if(j==1) tripdate = firstdate;
							if(j>1 && j<i) {
								cal.add(Calendar.DATE, (j-1));
		              			tripdate = new Timestamp(cal.getTime().getTime());								
							}
							if(j==i) tripdate = lastdate;
						%>
						<%= tripdate %>
					</td>
				</tr>
			<%
			for(int x=0; x<p_no.length; x++){
				%>
				<tr>					
					<td><%= p_no[x] %></td>
					<td><%= s_snum[x] %></td>
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