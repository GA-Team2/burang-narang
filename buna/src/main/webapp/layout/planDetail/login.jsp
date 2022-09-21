<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.getAttribute("nick_s");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.loginId == null || sessionScope.loginId eq 'guest'}">
		<img src="/resources/img/좋아요전.png" id="likeimg" width="60px" height="60px"
			class="rounded-circle mt-2">
			${b.like_count} <br><br>
		추천 기능은 <a href="/member/login" type="button" id="newLogin"
				  class="btn btn-outline-success">로그인</a> 후 사용 가능합니다.
	</c:if>
	<c:if test="${sessionScope.loginId != null}">
		<div>
			<input type="hidden" id="like_check" value="${like.like_check}">
			<img class="rounded-circle likeimg" id="likeimg" src="/resources/img/좋아요전.png"
				 width="60px" height="60px"> ${b.like_count}
		</div>
	</c:if>
</body>
</html>