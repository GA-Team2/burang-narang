<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
/* 
loginOk로부터 nick세션을 값을 넘겨받아 문자열 변수에 저장 후 ui전환에 사용
*/
	/* loginOk로부터 session에 object로 저장된 nick값을 session.getAttribute();로 받아오는 코드 */
	/* 수정 : 김규빈 */
	String nickQs = (String) session.getAttribute("nick_s");
	/* obj_nick을 String으로 캐스팅 후 문자열 변수 nick에 저장 */
	/* 수정 : 김규빈 */
	String nick = nickQs != null ? URLDecoder.decode(nickQs, "UTF-8") : null;
	System.out.println("nickname : " + nick);
	/* 캘린더 DTO */
	/* String year_forI = request.getParameter("year");
	int month_forI = Integer.parseInt(request.getParameter("month"));
	MonthCheckBean mcb = new MonthCheckBean();
	DateCheckDBBean dcdb = DateCheckDBBean.getInstance();
	DateCheckBean dcb = dcdb.getDate(year_forI, month_forI); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index | 부랑나랑</title>

	<link rel="stylesheet" href="styles/normalize.css" />
    <link rel="stylesheet" href="styles/style_index.css" />
    <!-- css를 브라우저에 즉각적으로 적용시키는 css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css">
    
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="scripts/script_index.js"></script>
    
    <!-- 쿼리스트링을 숨겨주는 스크립트 -->
    <script>history.replaceState({}, null, location.pathname);</script>
	<!-- <script type="text/javascript">
		function justSubmit(){
			document.getElementById("MY").submit();
		}
	</script> -->
    
</head>
<body>
	<form id="MY" name="MY" method="post" action="monthAndYearCheck.jsp">
		<!-- 캘린더의 월을 가져오는 input -->
		<input type="text" id="month" name="month">
		<!-- 캘린더의 년도를 가져오는 input -->
		<input type="text" id="year" name="year">
		<!-- hidden input 생성 -->
	</form>
	<%-- <%
		for(int i=0; i<31; i++){
	%>
			<input type="hidden" id="date<%= i %>" value="<%= dcb.getDate()[i] %>">
	<%
		}
	%> --%>
	<!-- gnb의 radio checked를 해제하는 input -->
	<input type="button" name="radio_unchecked" id="radio_unchecked" />
	<!-- 위 input의 기능을 화면 전체 적용하는 label -->
    <label for="radio_unchecked">
      <!-- 
      	전체 프레임
       -->
      <div class="wrap inner">
      	<!-- 
      		홈페이지 중앙 타이틀 
      	-->
        <div class="main_title">
          <h1>부랑나랑</h1>
          <p>부산을 git하다</p>
        </div>
        <!-- 
        	유저 정보 인터페이스 
        -->
        <div class="main_menu">
        
		<!-- 로그인 전/후 의 유저정보 인터페이스 전환 -->
        <%
        	/*비 로그인 시 구성 */
        	if(nick == null){
        %>
        		<!-- 로그인 input -->
	        	<input
		            type="button"
		            name="login"
		            id="login"
		            onclick="location.href='login.jsp'"
		        />
		        <!-- 회원가입 input -->
		        <input
		            type="button"
		            name="signUp"
		            id="signUp"
		            onclick="location.href='signUp.jsp'"
		        />
				<!-- 실질적으로 보여지는 로그인버튼(label) -->
		        <label for="login" class="login"> 로그인 </label>
				<!-- 실질적으로 보여지는 회원가입 버튼(label) -->
		        <label for="signUp" class="signUp"> 회원가입 </label>
        <%
        	/* 로그인 시 구성 */
        	} else {
        %>
        		<!-- 나의 플랜 input -->
        		<input
		            type="button"
		            name="myPlan"
		            id="myPlan"
		            onclick="location.href=''"
	          	/>
	          	<!-- 나의 정보 input -->
	          	<input
	            	type="button"
	            	name="myInfo"
	            	id="myInfo"
	            	onclick="location.href='myPage.jsp'"
	          	/>
	          	<!-- 로그아웃 input -->
	          	<input
	            	type="button"
	            	name="logOut"
	            	id="logOut"
	            	onclick="location.href='logOut.jsp'"
	          	/>
				<!-- 실질적으로 보여지는 나의 플랜 버튼(label) -->
	          	<label for="myPlan" class="myPlan"> 나의 플랜 </label>
				<!-- 실질적으로 보여지는 나의 정보 버튼(label) -->
	          	<label for="myInfo" class="myInfo"> 나의 정보 </label>
				<!-- 실질적으로 보여지는 로그아웃 버튼(label) -->
	          	<label for="logOut" class="logOut"> 로그아웃 </label>
        <%		
        	}
        %>
        </div>
        <!-- 
        	gnb 구성
         -->
         <!-- 플랜 인기 순위 gnb input -->
        <input type="radio" name="gnb" id="gnb_hotP" />
        <!-- 행사/이벤트 gnb input -->
        <input type="radio" name="gnb" id="gnb_event" />
        <!-- 날짜 혼잡도 gnb input -->
        <input type="radio" name="gnb" id="gnb_traffic" />
        
        <!-- 실질적으로 보여지는 인기 순위 gnb label -->
        <label for="gnb_hotP">
          <h2>인기 플랜</h2>
          <!-- 인기 순위 gnb안의 컨텐츠  -->
          <div class="hotP_content">
            <ul>
              <li>hot1</li>
              <li>hot2</li>
              <li>hot3</li>
            </ul>
          </div>
            <a href="popularityPlan.jsp">더보기</a>
        </label>
        <!-- 실질적으로 보여지는 행사/이벤트 gnb label -->
        <label for="gnb_event">
          <h2>이벤트</h2>
          <!-- 행사/이벤트 gnb안의 컨텐츠  -->
          <div class="event_content">
            <ul>
              <li>event1</li>
              <li>event2</li>
              <li>event3</li>
            </ul>
          </div>
          <a href="festival.jsp">더보기</a>
        </label>
        <!-- 실질적으로 보여지는 날짜 혼잡도 gnb label -->
        <label for="gnb_traffic">
          <h2>일정 혼잡도</h2>
          <!-- 날짜 혼잡도 gnb안의 컨텐츠  -->
		  <div id="calendar"></div>
        </label>
        <!-- 플랜작성 버튼  -->
        <div class="main_planner">
          <!-- 플랜작성 input -->
          <input type="button" name="plan" id="plan" onclick="location.href='MakePlan.jsp'" />
          <!-- 실질적으로 보여지는 플랜작성 label -->
          <label for="plan"> 플랜작성 </label>
        </div>
      </div>
    </label>
</body>
</html>