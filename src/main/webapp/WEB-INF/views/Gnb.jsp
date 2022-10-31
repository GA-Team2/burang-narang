<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- festival style -->
    <link rel="stylesheet" href="/styles/style_gnb.css">

    <!-- XEIcon -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

    <title>Insert title here</title>
</head>
<body>
    <div class="logo">
        <div>
            <div class="logo_img">
                <img alt="logo_img" src="/images/logo.png" onclick="javascript:location='/'">
            </div>
            <div class="gnb">
                <ul class="top_menu">
                    <c:set var="nick" value="${sessionScope.nick_s}"></c:set>
                    <li><a href="/festival">축제/이벤트</a></li>
                    <li><a href="/popularity">인기 여행 플랜</a></li>
                    <li><a href="/new">플랜작성</a></li>
                    <c:choose>
                        <c:when test="${nick ne null}">
                            <li><a href="/mypage">마이페이지</a></li>
                        </c:when>
                    </c:choose>
                </ul>
                <ul class="user_side">
                    <c:choose>
                        <c:when test="${nick ne null}">
                            <li class="side_menu_user"><a href="/mypage"><i class="xi-profile"></i><span
                                    class="user">${nick}</span><span class="nim">님</span></a></li>
                            <li class="side_menu"><a href="/logout">로그아웃</a></li>
                        </c:when>
                        <c:when test="${nuck eq null}">
                            <li class="side_menu"><a href="/login">로그인</a></li>
                            <li class="side_menu"><a href="/signup">회원가입</a></li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>