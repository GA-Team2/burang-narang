<%@page import="org.ga2.buna.dao.SignUpDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		한글 깨짐 방지 
	*/
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>

<!-- 
	액션태그로 signUpBean객체 선언
 -->
<jsp:useBean id="sb" class="org.ga2.buna.dto.SignUpBean"></jsp:useBean>
<!-- 액션태그로 signUp.jsp로부터 받아온 파라미터를 signUpBean.java의 이름이 같은 필드와 모두 연결 -->
<jsp:setProperty property="*" name="sb"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpOk | 부랑나랑</title>
</head>
<body>
	<%
		/* 데이터 베이스 객체 선언 */
		SignUpDBBean sdb = SignUpDBBean.getInstance();
	
		/* 회원 추가 메소드 선언 */
		int re = sdb.insertMember(sb);
		
		/* 
			회원가입 성패 여부 조건문 
		*/
		if(re == 1){  /* 회원가입에 성공했을 경우 */
	%>
			<script>
				alert("회원가입이 완료되었습니다.");
				location.href="Login.jsp";
			</script>
	<%
		} else {  /* 회원가입에 실패했을 경우 */
	%>
			<script>
				alert("회원가입에 실패했습니다.");
				location.href="SignUp.jsp";
			</script>
	<%				
		}
	%>
</body>
</html>