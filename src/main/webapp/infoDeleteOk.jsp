<%@page import="java.net.URLDecoder"%>
<%@page import="org.ga2.buna.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setContentType("text/html;charset=UTF-8");
request.setCharacterEncoding("UTF-8");

String nickSession = (String) session.getAttribute("nick_s");
String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;

//탈퇴 폼에서 받아온 password
String password = request.getParameter("password");

MemberDAO dao = MemberDAO.getInstance();
//탈퇴 메서드 호출
int re = dao.deleteMember(nick, password);
%>
<!DOCTYPE html>
<html>
<head>
<title>Document</title>
</head>
<body>
	<c:set var="re" value="<%=re%>"></c:set>
	<c:choose>
		<c:when test="${re==1}">
			<script>
				alert("탈퇴처리 되었습니다.");
				location.href = "index.jsp";
			</script>
			<!-- 탈퇴한 후 세션 무효화 처리 -->
			<%
				session.invalidate();
			%>
		</c:when>
		<c:when test="${re==0 }">
			<script type="text/javascript">
				alert("비밀번호가 일치하지 않습니다.");
				location.href = "signOut.jsp";
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