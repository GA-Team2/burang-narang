<%@page import="org.ga2.buna.dto.SignUpBean"%>
<%@page import="org.ga2.buna.dao.SignUpDBBean"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	String nick = request.getParameter("nick");
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
			alert("존재하지 않는 회원입니다.");
			/* 이전 페이지로 이동 */
			$('.login_form').load('makePlanLoginForm.jsp');
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
				$('.login_form').load('makePlanLoginForm.jsp');
			</script>
	<%
		} else if(check == 1) {  /* 비밀번호가 일치할 경우 */
			/* 한글 닉네임 깨짐 방지 인코딩 후 변수에 저장 */
			String str = URLEncoder.encode(nick,"UTF-8");
			/* 세션에 닉네임 저장 */
			session.setAttribute("nick_s", str);
			/* 메인 페이지로 이동 */
			%>
			<script>
			/* 모달 종료 후 저장 버튼 갱신 */
				document.getElementById('login').classList.add("hidden");
				document.getElementById(".plan_submit").setAttribute("onclick","restorePlan()");
			</script>
			<%
		} else {  /* DB에 오류가 일어난 경우 */
	%>
			<script>
				alert("접속할 수 없습니다.");
				$('.login_form').load('makePlanLoginForm.jsp');
			</script>
	<%
		}
	}
	%>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
</body>
</html>