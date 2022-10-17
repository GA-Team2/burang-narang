<%@page import="org.ga2.buna.dao.PlanDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	int p_rownum = Integer.parseInt(request.getParameter("p_rownum"));
	PlanDAO dao = PlanDAO.getInstance();
	
	//파라미터로 플랜번호 받아서 deleteInfo메서드 호출
	int result = dao.deleteInfo(p_rownum);
%>
<html>
<head>
	<title>Document</title>
</head>
<body>
	<c:set var="result" value="<%=result%>"></c:set>
	<c:choose>
		<c:when test="${result==1}">
			<script>
				alert("플랜이 삭제되었습니다.");
				location.href = "MyPage.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("플랜이 삭제되지 않았습니다.");
				location.href = "MyPage.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>