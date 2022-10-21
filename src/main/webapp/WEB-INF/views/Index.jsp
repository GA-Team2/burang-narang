<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>나의 부산 여행 플래너 | 부랑나랑</title>

    <link rel="stylesheet" href="/styles/normalize.css" />
    <link rel="stylesheet" href="/styles/style_index.css" />
    <!-- css를 브라우저에 즉각적으로 적용시키는 css -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />

    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/scripts/script_index.js"></script>

    <!-- 쿼리스트링을 숨겨주는 스크립트 -->
    <script>
      history.replaceState({}, null, location.pathname);
    </script>
  </head>
  <body>
<%--    <c:set var="nick" value="${nick}" />--%>
    <input type="hidden" id="session_nick" value="${nick}" />
    <!--
     	전체 프레임
      -->
    <div class="wrap inner" id="wrap">
      <!-- 
	     	홈페이지 중앙 타이틀 
	     -->
      <div id="main_title" class="main_title_ani">
        <img id="logo_whole" src="/images/logo_whole.png" />
        <div id="title_blind" class="title_blind_ani"></div>
      </div>
      <img id="flight" class="flight_ani" src="images/flight.png" />
      <!-- 
	     	컨텐츠 
	     -->
      <div id="content">
        <img id="lion" class="lion" src="/images/walking_lion.gif" />
        <img id="think_left" src="/images/think.png" />
        <img id="think_left3" src="/images/think.png" />
        <img id="think_right" src="/images/think2.png" />
        <p id="lion_click">click!</p>
        <!-- 
	       	유저 정보 인터페이스 
	       -->
        <div id="main_menu">
        <!-- 
            로그인 전/후 의 유저정보 인터페이스 전환 
        -->
          <c:choose>
            <%--
            비 로그인 시 구성
            --%>
            <c:when test="${nick == null}">
              <%--로그인 input--%>
              <input
                      type="button"
                      name="login"
                      id="login"
                      onclick="location.href = 'login'"
              />
              <%--회원가입 input--%>
              <input
                      type="button"
                      name="signUp"
                      id="signUp"
                      onclick="location.href='SignUp.jsp'"
              />
              <%--실질적으로 보여지는 로그인버튼(label)--%>
              <label for="login" class="login"> 로그인 </label>
              <%--실질적으로 보여지는 회원가입 버튼(label)--%>
              <label for="signUp" class="signUp"> 회원가입 </label>
            </c:when>
            <%--
              로그인 시 구성
            --%>
            <c:when test="${nick != null}">
              <%--D-day--%>
              <p class="d-day">${str}</p>
              <%--나의 정보 input--%>
              <input
                      type="button"
                      name="myInfo"
                      id="myInfo"
                      onclick="location.href='/myPage'"
              />
              <%--로그아웃 input--%>
              <input
                      type="button"
                      name="logOut"
                      id="logOut"
                      onclick="location.href='logout'"
              />
              <%--실질적으로 보여지는 나의 정보 버튼(label)--%>
              <label for="myInfo" class="myInfo"> 나의 정보 </label>
              <%--실질적으로 보여지는 로그아웃 버튼(label)--%>
              <label for="logOut" class="logOut"> 로그아웃 </label>
            </c:when>
          </c:choose>
        </div>
        <!-- 
	       	gnb 구성
	        -->
        <!-- 플랜 인기 순위 gnb input -->
        <input
          type="button"
          name="hotP"
          id="gnb_hotP"
          onclick="location.href='/PopularityPlan'"
        />
        <!-- 행사/이벤트 gnb input -->
        <input
          type="button"
          name="event"
          id="gnb_event"
          onclick="location.href='/Festival'"
        />

        <!-- 실질적으로 보여지는 인기 순위 gnb label -->
        <label for="gnb_hotP">
          <h2>인기 플랜</h2>
        </label>
        <!-- 실질적으로 보여지는 행사/이벤트 gnb label -->
        <label for="gnb_event">
          <h2>이벤트</h2>
        </label>
        <!-- 날짜 혼잡도 gnb -->
        <div id="gnb_traffic">
          <h2>일정<br />혼잡도</h2>
          <div id="calendar"></div>
        </div>
        <!-- 플랜작성 input -->
        <input
          type="button"
          name="plan"
          id="plan"
          onclick="location.href='/new'"
        />
        <!-- 실질적으로 보여지는 플랜작성 label -->
        <label for="plan">
          <h2>플랜 작성</h2>
        </label>
      </div>
    </div>
  </body>
</html>
