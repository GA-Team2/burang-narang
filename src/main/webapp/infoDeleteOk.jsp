<%@page import="java.net.URLDecoder"%>
<%@page import="org.ga2.buna.dao.MemberDAO"%>
<%
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String nickSession = (String)session.getAttribute("nick_s");
String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
	String password = request.getParameter("password");
	
	System.out.println(nick);

	MemberDAO dao = MemberDAO.getInstance();
	int re = dao.deleteMember(nick, password);
%>
<!DOCTYPE html>
<html>
<head>
<title>Document</title>
</head>
<body>
	<c:set var="re" value="<%= re %>"></c:set>
	<c:choose>
		<c:when test="${re==1}">
			<script>
				alert("탈퇴처리 되었습니다.");
				location.href="index.jsp";
			</script>
			<% session.invalidate(); %>
		</c:when>
		<c:when test="${re==0 }">
			<script type="text/javascript">
				alert("비밀번호가 일치하지 않습니다.");
				location.href="signOut.jsp?nick=<%=nick%>"; 
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("삭제 실패");
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>