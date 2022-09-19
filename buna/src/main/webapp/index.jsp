<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index | 부랑나랑</title>

	<link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/style_index.css" />

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/script_index.js"></script>
</head>
<body>
	<input type="button" name="radio_unchecked" id="radio_unchecked" />
    <label for="radio_unchecked">
      <div class="wrap inner">
        <div class="main_title">
          <h1>부랑나랑</h1>
          <p>부산을 git하다</p>
        </div>
        <div class="main_menu">
          <input
            type="button"
            name="login"
            id="login"
            onclick="location.href='../login/login.html'"
          />
          <input
            type="button"
            name="signUp"
            id="signUp"
            onclick="location.href='../signUp/signUp.html'"
          />

          <label for="login"> 로그인 </label>
          <label for="signUp"> 회원가입 </label>
        </div>
        <input type="radio" name="gnb" id="gnb_hotP" />
        <input type="radio" name="gnb" id="gnb_event" />
        <input type="radio" name="gnb" id="gnb_traffic" />
        <label for="gnb_hotP">
          <h2>인기 플랜</h2>
          <div class="hotP_content">
            <ul>
              <li>hot1</li>
              <li>hot2</li>
              <li>hot3</li>
            </ul>
          </div>
        </label>
        <label for="gnb_event">
          <h2>이벤트</h2>
          <div class="event_content">
            <ul>
              <li>event1</li>
              <li>event2</li>
              <li>event3</li>
            </ul>
          </div>
        </label>
        <label for="gnb_traffic">
          <h2>일정 혼잡도</h2>
          <div class="traffic_content"></div>
        </label>
        <div class="main_planner">
          <input type="button" name="plan" id="plan" onclick="" />
          <label for="plan"> 플랜작성 </label>
        </div>
      </div>
    </label>
</body>
</html>