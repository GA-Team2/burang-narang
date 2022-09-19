<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
/* loginOk로부터 nick세션을 값을 넘겨받아 문자열 변수에 저장 후 ui전환에 사용 */
	String nick = request.getParameter("nick");
	/* if(session.getAttribute("member") == null){
		response.sendRedirect("index.jsp");
	} */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index | 부랑나랑</title>

	<link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/style_index.css" />
    <link rel="stylesheet" href="template.css?ver=1.3">

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/script_index.js"></script>
    <!-- 로그아웃 후 뒤로가기 방지 -->
    <script type="text/javascript">
		 window.history.forward();
		 function noBack(){window.history.forward();}
	</script>
    
</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">   <!-- 로그아웃 후 뒤로가기 방지 -->
	<input type="button" name="radio_unchecked" id="radio_unchecked" />
    <label for="radio_unchecked">
      <div class="wrap inner">
        <div class="main_title">
          <h1>부랑나랑</h1>
          <p>부산을 git하다</p>
        </div>
        <div class="main_menu">
<!-- 로그인 전/후 의 유저정보 인터페이스 전환 -->
        <%
        	if(nick == null){
        %>
	        	<input
		            type="button"
		            name="login"
		            id="login"
		            onclick="location.href='login.jsp'"
		        />
		        <input
		            type="button"
		            name="signUp"
		            id="signUp"
		            onclick="location.href='signUp.jsp'"
		        />
		
		        <label for="login" class="login"> 로그인 </label>
		        <label for="signUp" class="signUp"> 회원가입 </label>
        <%
        	} else {
        %>
        		<input
		            type="button"
		            name="myPlan"
		            id="myPlan"
		            onclick="location.href=''"
	          	/>
	          	<input
	            	type="button"
	            	name="myInfo"
	            	id="myInfo"
	            	onclick="location.href=''"
	          	/>
	          	<input
	            	type="button"
	            	name="logOut"
	            	id="logOut"
	            	onclick="location.href='logOut.jsp'"
	          	/>
	
	          	<label for="myPlan" class="myPlan"> 나의 플랜 </label>
	          	<label for="myInfo" class="myInfo"> 나의 정보 </label>
	          	<label for="logOut" class="logOut"> 로그아웃 </label>
        <%		
        	}
        %>
        	<%-- <c:if test="${empty nick}">
	          <input
	            type="button"
	            name="login"
	            id="login"
	            onclick="location.href='login.jsp'"
	          />
	          <input
	            type="button"
	            name="signUp"
	            id="signUp"
	            onclick="location.href='signUp.jsp'"
	          />
	
	          <label for="login" class="login"> 로그인 </label>
	          <label for="signUp" class="signUp"> 회원가입 </label>
        	</c:if>
        	
        	<c:if test="${not empty nick}">
        		<input
		            type="button"
		            name="myPlan"
		            id="myPlan"
		            onclick="location.href=''"
	          	/>
	          	<input
	            	type="button"
	            	name="myInfo"
	            	id="myInfo"
	            	onclick="location.href=''"
	          	/>
	          	<input
	            	type="button"
	            	name="logOut"
	            	id="logOut"
	            	onclick="location.href='logOut.jsp'"
	          	/>
	
	          	<label for="myPlan" class="myPlan"> 나의 플랜 </label>
	          	<label for="myInfo" class="myInfo"> 나의 정보 </label>
	          	<label for="logOut" class="logOut"> 로그아웃 </label>
        	</c:if> --%>
        	
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