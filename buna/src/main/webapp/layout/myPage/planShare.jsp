<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="plan.PlanDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int rownum = Integer.parseInt(request.getParameter("p_rownum"));
	int shared = Integer.parseInt(request.getParameter("shared"));
	PlanDAO dao = PlanDAO.getInstance();
	int re = dao.publicUpdateInfo(rownum, shared);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="result" value="<%= re %>"></c:set>
	<c:choose>
		<c:when test="${result==1}">
			<script>
				alert("플랜이 공유 되었습니다.");
				location.href="planDetail.jsp?rownum="+<%=rownum%>;
			</script>
		</c:when>
		<c:when test="${result==2}">
			<script>
				alert("비공개 되었습니다.");
				location.href="myPage.jsp";
			</script>
		</c:when>
	</c:choose>
</body>
</html>