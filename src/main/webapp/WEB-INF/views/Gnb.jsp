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
    <link rel="stylesheet" href="/styles/style_gnb.css">

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
                <c:set var="event" value="<%=eventPage%>"/>
                <c:set var="popularity" value="<%=popularityPage%>"/>
<%--                <c:choose>--%>
<%--                    <c:when test="${popularity eq 'on'}">--%>
                        <li><a href="/festival">이벤트/축제</a></li>
<%--                    </c:when>--%>
<%--                    <c:when test="${event eq 'on'}">--%>
                        <li><a href="/popularity">인기 플랜</a></li>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <li><a href="/festival">이벤트/축제</a></li>--%>
<%--                        <li><a href="/popularity">인기 플랜</a></li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
                <li><a href="/new">플랜작성</a></li>

            </ul>
            <ul class="user_side">
                <% if (nick != null) {%>
                <li><a href="/mypage">마이페이지</a></li>
                <li><a href="/logout">로그아웃</a></li>
                <% } else if (nick == null) {%>
                <li><a href="/login">로그인</a></li>
                <li><a href="/SignUp">회원가입</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</div>
</body>
</html>