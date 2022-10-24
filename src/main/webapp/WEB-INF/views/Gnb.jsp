<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String nickSession = (String) session.getAttribute("nick_s");
    String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;

    String eventPage = request.getParameter("festivalPage");
    String popularityPage = request.getParameter("popularityPage");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- festival style -->
    <link rel="stylesheet" href="/styles/gnb_style.css">

    <title>Insert title here</title>
</head>
<body>
<div class="logo">
    <div>
        <div class="logo_img">
            <img alt="logo_img" src="images/logo.png" onclick="javascript:location='/'">
        </div>
        <div class="gnb">
            <ul class="top_menu">
                <c:set var="event" value="<%=eventPage%>"/>
                <c:set var="popularity" value="<%=popularityPage%>"/>
                <c:choose>
                    <c:when test="${popularity eq 'on'}">
                        <li><a href="/Festival">이벤트/축제</a></li>
                    </c:when>
                    <c:when test="${event eq 'on'}">
                        <li><a href="/PopularityPlan">인기 플랜</a></li>
                    </c:when>
                </c:choose>
                <li><a href="/new">플랜작성</a></li>

            </ul>
            <ul class="user_side">
                <c:set var="nick" value="<%=nick%>"/>
                <c:choose>
                    <c:when test="${nick ne null}">
                        <li><a href="">마이페이지</a></li>
                        <li><a href="/logout">로그아웃</a></li>
                    </c:when>
                    <c:when test="${nick eq null}">
                        <li><a href="/login">로그인</a></li>
                        <li><a href="/signup">회원가입</a></li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</div>
</body>
</html>