<%@page import="java.net.URLDecoder"%>
<%@page import="org.ga2.buna.dao.MemberDAO"%>
<%
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="member" class="org.ga2.buna.dto.MemberDTO"/>
<jsp:setProperty property="*" name="member"/>
<%
String nickSession = (String)session.getAttribute("nick_s");
String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;

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
				location.href="myPage.jsp";
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