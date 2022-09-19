<%
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String nickname = request.getParameter("nickname");
	String password = request.getParameter("password");
	
	System.out.println(nickname);

	MemberDAO dao = MemberDAO.getInstance();
	int re = dao.deleteMember(nickname, password);
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
				location.href="../planDetail/myPlan.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("비밀번호가 일치하지 않습니다.");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>