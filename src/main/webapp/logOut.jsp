<%
	/* 세션값 삭제 */
	session.invalidate();
	/* 메인 페이지로 리다이렉트 */
	response.sendRedirect("index.jsp");
%>