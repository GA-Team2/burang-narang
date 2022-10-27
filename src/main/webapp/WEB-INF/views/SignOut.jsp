<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- css 초기화 -->
    <link rel="stylesheet" href="/styles/normalize.css">
    <!-- 탈퇴페이지 적용 css -->
    <link rel="stylesheet" href="/styles/style_signOut.css">
    <!--쿼리스트링 숨겨주는 스크립트-->
    <script>
        history.replaceState({}, null, location.pathname);
    </script>
    <title>회원 탈퇴 | 부랑나랑</title>
</head>
<body>
	<div class="signOut_wrap">
		<h1>회원 탈퇴</h1>
		<!-- 탈퇴폼에서 비밀번호를 파라미터로 넘김 -->
		<form action="/mypage/checkpw" method="post">
			<div>
				비밀번호 입력<input type="password" name="memberPw" id="pw">
			</div>
			<input type="button" class="button" value="탈퇴" onclick="delete_member_ajax()">
			<input type="button" class="button" value="취소" onclick="history.back()">
		</form>
	</div>

<!--js-->
<script type="text/javascript" src="/scripts/signOut.js"></script>
</body>
</html>