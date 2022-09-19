<%@page import="signUpPackage.SignUpBean"%>
<%@page import="signUpPackage.SignUpDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginOk | 부랑나랑</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String nick = request.getParameter("nick");
		String pwd = request.getParameter("pwd");
		SignUpDBBean sdb = SignUpDBBean.getInstance();
		int check = sdb.userCheck(nick, pwd);
		SignUpBean sb = sdb.getMember(nick);
		
		if(sb == null){
	%>
			<script>
				alert("존재하지 않는 회원");
				/* location.href("login.jsp"); */
				history.go(-1);
			</script>
	<%
		} else {
			String nickname = sb.getM_nickname();
			if(check == 0){
	%>
				<script>
					alert("비밀번호가 맞지 않습니다.");
					/* location.href("login.jsp"); */
					history.go(-1);
				</script>
	<%
			} else if(check == 1) {
				/* 세션값 전달 */
				session.setAttribute("nick", nick);
				session.setAttribute("Member", "yes");
				response.sendRedirect("index.jsp?nick=" + nick);
			} else {
	%>
				<script>
					alert("아이디가 맞지 않습니다.");
					/* location.href("login.jsp"); */
					history.go(-1);
				</script>
	<%
			}
		}
	%>
</body>
</html>