<%@page import="org.ga2.buna.dao.PlanDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int rownum = Integer.parseInt(request.getParameter("p_rownum"));
	int shared = Integer.parseInt(request.getParameter("shared"));
	PlanDAO dao = PlanDAO.getInstance();
	
	/**
	 * 플랜번호와 공유여부를 파라미터로 받아서 publicUpdateInfo() 호출
	 * shared==1이면 공유상태 shared==0이면 비공유상태
	 */
	int re = dao.publicUpdateInfo(rownum, shared);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="result" value="<%=re%>"></c:set>
	<c:choose>
		<c:when test="${result==1}">
			<script>
				alert("플랜이 공유 되었습니다.");
				location.href = "PlanDetail.jsp?rownum=" + <%=rownum%> ;
			</script>
		</c:when>
		<c:when test="${result==2}">
			<script>
				alert("비공개 되었습니다.");
				location.href = "MyPage.jsp";
			</script>
		</c:when>
	</c:choose>
</body>
</html>