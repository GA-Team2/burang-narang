<%@page import="signUpPackage.SignUpDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="sb" class="signUpPackage.SignUpBean"></jsp:useBean>
<jsp:setProperty property="*" name="sb"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>signUpOk | �ζ�����</title>
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
					alert("ȸ�������� �Ϸ�Ǿ����ϴ�.");
					location.href("login.jsp");
				</script>
	<%
			} else {
	%>
				<script>
					alert("ȸ�����Կ� �����߽��ϴ�.");
					location.href("signUp.jsp");
				</script>
	<%				
			}
		}
	%>
</body>
</html>