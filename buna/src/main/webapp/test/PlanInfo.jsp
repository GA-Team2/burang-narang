<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="buna";
	String password="1234";
	
	String sql = "select * from planinfo";

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.print("yes");
		conn = DriverManager.getConnection(url, user, password);
		System.out.print("yes");
		
		stmt = conn.createStatement();
		System.out.print("yes");
		rs = stmt.executeQuery(sql);
		System.out.print("yes");
		
		if(rs.next()) {
			System.out.print("yes");
			%>
			<%= rs.getInt("p_rownum") %>
			<%
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${1+1}
	<%= application.getMajorVersion() %>.<%= application.getMajorVersion() %>
	
</body>
</html>