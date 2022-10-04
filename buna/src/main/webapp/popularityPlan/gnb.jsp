<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
}

.logo {
	width: 100%;
	height: 100px;
	background-color: #fff;
	border-bottom: 1px solid #e2e2e2;
	z-index: 9999;
}
.logo > div {
	width: 1200px;
	display: flex;
	justify-content: space-between;
	margin: 0 auto;
}
.logo .logo_img {
	width: 300px;
}

.logo img {
	width: 250px;
	height: 87px;
	cursor: pointer;
}

.logo .gnb ul	{
	display: flex;
	line-height: 100px;
}

.logo .gnb ul li {
	display: inline-block;
}

.logo .gnb ul li a{
	font-weight: bold;
	border-right: 1px solid #000;
	padding: 0 35px;
	color: #111827;
}

.logo .gnb ul li:last-of-type a{
	border-right: 0;
}
</style>
</head>
<body>
	<div class="logo">
        	<div>
	        	<div class="logo_img">
	        		<img alt="logo_img" src="images/logo.png" onclick="javascript:location='index.jsp'">
	        	</div>
	        	<div class="gnb">
	        		<ul>
	        			<li><a href="../festival/festival.jsp">이벤트/축제</a></li>
	        			<li><a href="popularityPlan.jsp">인기 플랜</a></li>
	        			<li><a>플랜작성</a></li>
	        			<li><a>마이페이지</a></li>
	        		</ul>
	        	</div>
        	</div>
        </div>
</body>
</html>