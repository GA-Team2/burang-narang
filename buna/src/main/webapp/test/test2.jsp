<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		Connection conn = null;
		DataSource ds = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	%>
	
	<%
	try{
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		conn = ds.getConnection();
		System.out.println("DBCP ���� �����߽��ϴ�!");
		
		String sql = "select * from planinfo";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			%>
				<%= rs.getInt(1) %> <br>
				<%= rs.getString(2) %> <br>
				<%= rs.getString(3) %> <br>
				<%= rs.getTimestamp(4) %> <br>
				<%= rs.getTimestamp(5) %> <br>
				<%= rs.getString(6) %> <br>
				<%= rs.getTimestamp(7) %> <br>				
				<%= rs.getInt(8) %> <br>
			<%
		}
	//chatch �ΰ��� ����
	}catch(NamingException ne){
		ne.printStackTrace();
	}catch(SQLException ex){
		out.print("�����ͺ��̽� ������ �����߽��ϴ�.<br>");
		out.print("SQLException: "+ex.getMessage());
	}finally{
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(conn != null) conn.close();
	}
	%>

</body>
</html>