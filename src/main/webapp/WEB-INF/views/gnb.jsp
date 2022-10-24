<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String nickSession = (String) session.getAttribute("nick_s");
    String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
%>

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
            position: relative;
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

        .logo .gnb {
            display: flex;
        }
        /*-----------user_side-----------*/

        .logo .gnb .user_side {
            position: absolute;
            right: 50px;
        }

        .logo .gnb .user_side li {
            margin: 0 10px;
        }

        .logo .gnb .user_side li:last-of-type a {
            background-color: #0090F9;
            color: #fff;
        }

        .logo .gnb .user_side li:last-of-type a:hover {
            background-color: #0B7FD3;
        }

        .logo .gnb .user_side li a {
            font-size: 12px;
            border: 1px solid #0090F9;
            border-radius: 20px;
            padding: 10px 20px;
            color: #0090f9;
        }

        .logo .gnb .user_side li a:hover {
            background-color: #E5E7EB;
        }

        /*-------------------------------*/
        .logo .gnb ul {
            display: flex;
            line-height: 100px;
        }

        .logo .gnb ul li {
            display: inline-block;
        }

        .logo .gnb ul li a {
            font-weight: bold;
            border-right: 1px solid #000;
            padding: 0 35px;
            color: #111827;
        }

        .logo .gnb ul li a:hover {
            color: #0090f9;
        }

        .logo .gnb ul li:last-of-type a {
            border-right: 0;
        }
    </style>
</head>
<body>
<div class="logo">
    <div>
        <div class="logo_img">
            <img alt="logo_img" src="images/logo.png" onclick="javascript:location='/'">
        </div>
        <div class="gnb">
            <ul class="top_menu">
                <li><a href="/Festival">이벤트/축제</a></li>
                <li><a href="/PopularityPlan">인기 플랜</a></li>
                <li><a href="/new">플랜작성</a></li>

            </ul>
            <ul class="user_side">
                <% if (nick != null) {%>
                    <li><a href="">마이페이지</a></li>
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