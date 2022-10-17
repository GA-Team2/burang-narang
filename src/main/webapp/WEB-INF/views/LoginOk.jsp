<%@page import="org.ga2.buna.dto.SignUpBean"%>
<%@page import="org.ga2.buna.dao.SignUpDBBean"%>
<%@page import="java.net.URLEncoder"%>
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
		/* 파라미터가 한글일 경우 깨짐 방지 인코딩 */
		request.setCharacterEncoding("UTF-8");
		/* login.jsp로부터 받아온 닉네임 파라미터 변수 선언 */
		String nick = request.getParameter("nick");
		/* login.jsp로부터 받아온 패스워드 파라미터 변수 선언 */
		String pwd = request.getParameter("pwd");
		/* 데이터 베이스 객체 선언 */
		SignUpDBBean sdb = SignUpDBBean.getInstance();
		/* 회원 조회 메소드 변수 선언 */
		int check = sdb.userCheck(nick, pwd);
		/* 받아온 닉네임의 정보를 가져오는 메소드 bean 객체에 참조 */
		SignUpBean sb = sdb.getMember(nick);
		
		/*
			회원 여부 조건문
		*/
		if(sb == null){  /* 데이터 베이스에 닉네임이 존재하지않아 sb값이 null인 경우 */
	%>
			<script>
				/* 경고창 */
				alert("존재하지 않는 회원");
				/* 이전 페이지로 이동 */
				history.go(-1);
			</script>
	<%
		} else {  /* 데이터 베이스에 닉네임이 존재할 경우 */
			/*
				비밀번호 체크 조건문
			*/
			if(check == 0){  /* 비밀번호가 일치하지 않을 경우 */
	%>
				<script>
					alert("비밀번호가 맞지 않습니다.");
					history.go(-1);
				</script>
	<%
			} else if(check == 1) {  /* 비밀번호가 일치할 경우 */
				/* 한글 닉네임 깨짐 방지 인코딩 후 변수에 저장 */
				String str = URLEncoder.encode(nick,"UTF-8");
				/* 세션에 닉네임 저장 */
				session.setAttribute("nick_s", str);
				/* 메인 페이지로 이동 */
				response.sendRedirect("IIndex.jsp");
			} else {  /* DB에 오류가 일어난 경우 */
	%>
				<script>
					alert("접속할 수 없습니다.");
					history.go(-1);
				</script>
	<%
			}
		}
	%>
</body>
</html>