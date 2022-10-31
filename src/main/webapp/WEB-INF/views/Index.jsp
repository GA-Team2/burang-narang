<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>나의 부산 여행 플래너 | 부랑나랑</title>

    <link rel="stylesheet" href="/styles/normalize.css" />
    <link rel="stylesheet" href="/styles/style_index.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />

    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/scripts/script_index.js"></script>

  </head>
  <body>

    <%--
      전체 프레임
    --%>

    <div class="wrap inner" id="wrap">
      <%--
        컨텐츠
      --%>
      <div id="content">
        <div id="logo">
          <img src="/images/logo_whole.png">
        </div>
        <%--
          유저 정보 인터페이스
        --%>
        <div id="main_menu">
          <%--
            로그인 전/후 의 유저정보 인터페이스 전환
          --%>
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
                      onclick="location.href='signup'"
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
                      onclick="location.href='/mypage'"
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
        <%--
          gnb 구성
        --%>
        <%--
          플랜 인기 순위 gnb input
        --%>
        <input
          type="button"
          name="hotP"
          id="gnb_hotP"
          onclick="location.href='/popularity'"
        />
        <%--
          행사/이벤트 gnb input
        --%>
        <input
          type="button"
          name="event"
          id="gnb_event"
          onclick="location.href='/festival'"
        />

        <%--
          실질적으로 보여지는 인기 순위 gnb label
        --%>
        <label for="gnb_hotP">
          <h2>인기 플랜</h2>
        </label>
        <%--
          실질적으로 보여지는 행사/이벤트 gnb label
        --%>
        <label for="gnb_event">
          <h2>이벤트</h2>
        </label>
        <%--
          날짜 혼잡도 gnb
        --%>
        <div id="gnb_traffic">
          <h2>일정 혼잡도</h2>
          <div id="calendar"></div>
        </div>
        <%--
          플랜작성 input
        --%>
        <input
          type="button"
          name="plan"
          id="plan"
          onclick="location.href='/new'"
        />
        <%--
          실질적으로 보여지는 플랜작성 label
        --%>
        <label for="plan" id="planMake">
          <h2>플랜 작성</h2>
        </label>
      </div>
    </div>
  </body>
</html>
