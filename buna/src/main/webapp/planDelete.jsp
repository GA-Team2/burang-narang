<%@page import="org.ga2.buna.dao.PlanDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int p_rownum = Integer.parseInt(request.getParameter("p_rownum"));
	PlanDAO dao = PlanDAO.getInstance();
	
	int result = dao.deleteInfo(p_rownum);
%>
<html>
<head>
<title>Document</title>
</head>
<body>
	<c:set var="result" value="<%= result %>"></c:set>
	<c:choose>
		<c:when test="${result==1}">
			<script>
				alert("플랜이 삭제 되었습니다.");
				location.href="myPage.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("플랜이 삭제되지 않았습니다.");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>