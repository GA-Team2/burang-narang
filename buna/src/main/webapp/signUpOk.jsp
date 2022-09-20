<%@page import="signUpPackage.SignUpDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="sb" class="signUpPackage.SignUpBean"></jsp:useBean>
<jsp:setProperty property="*" name="sb"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpOk | 부랑나랑</title>
</head>
<body>
	<%
		SignUpDBBean sdb = SignUpDBBean.getInstance();
	
		if(sdb.confirmID(sb.getM_nickname()) == 1){
			response.sendRedirect("signUp.jsp?nickname=" + sb.getM_nickname());
		} else {
			int re = sdb.insertMember(sb);
			if(re == 1){
	%>
				<script>
					alert("회원가입이 완료되었습니다.");
					location.href("login.jsp");
				</script>
	<%
			} else {
	%>
				<script>
					alert("회원가입에 실패했습니다.");
					location.href("signUp.jsp");
				</script>
	<%				
			}
		}
	%>
</body>
</html>