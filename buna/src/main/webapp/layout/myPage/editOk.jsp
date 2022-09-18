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
	String nickname = request.getParameter("current_nickname");

	MemberDAO dao = MemberDAO.getInstance();
	int re = dao.updateMember(member, nickname);
	
	if (re==1) {
%>
		<script type="text/javascript">
			alert("수정 성공");
			location.href="../planDetail/myPlan.jsp";
		</script>
<%
	} else {
%>
		<script type="text/javascript">
			alert("수정 실패");
			history.back();
		</script>
<%
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>