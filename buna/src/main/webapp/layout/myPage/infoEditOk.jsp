<%
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="member" class="member.MemberDTO"/>
<jsp:setProperty property="*" name="member"/>
<%
	String nick = request.getParameter("nick");

	MemberDAO dao = MemberDAO.getInstance();
	int re = dao.updateMember(member, nick);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 변수 세팅 -->
	<c:set var="re" value="<%= re %>"/>
	
	<!-- 출력 조건문 -->
	<c:choose>
		<c:when test="${re==1}">
			<script>
				alert("수정 성공");
				location.href="../detail/planDetail.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("수정 실패");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>

</body>
</html>