<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String nickSession = (String) session.getAttribute("nick_s");
String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>플랜 작성 | 부랑나랑</title>

<!-- css -->
<link rel="stylesheet" href="styles/normalize.css" />
<link rel="stylesheet" href="styles/style.css" />

<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<!-- 메인 지도  -->
	<div id="map_area" style="width: 70%; height: 100%"></div>

	<!-- 메인 플랜 작성하는 사이드바 -->
	<div id="side_bar">
		<div class="plan_sub">
			<!-- 여행 일정은 writeSimplePlan에서 제목 입력 시 변경 -->
			<p>여행 일정</p>
			<!-- editInfo() 클릭 시  writeSimplePlan에서 플랜 info 변경 가능 -->
			<div class="edit_sub" onclick="editInfo()">수정</div>
		</div>

		<!-- plan detail container -->
		<div class="tab_detail">
			<!-- 상단의 day tab-->
			<ul class="day_plan_tab">
				<!-- writeSimplePlan에서 입력한 날짜 만큼 day list 생성 -->
				<!-- makePlanInfo.js 참고 -->
				<!-- tab 클릭 시 해당 날짜로 스크롤 이동  side.js 참고 -->
			</ul>
			<!-- restorePlan 페이지로 넘어가는 form -->
			<form action="RestorePlan.jsp" method="post" name="makePlanForm">
				<!-- writeSimplePlan에서 작성한 planInfo -->
				<input type="text" name="p_title" hidden />
				<input type="text" name="p_firstdate" hidden />
				<input type="text" name="p_lastdate" hidden />
				<input type="text" name="t_namelist" hidden />
				<input type="text" name="m_nickname" value="${nick}" hidden />

				<!-- 각 tripday의 plan이 작성되는 컨테이너 -->
				<div class="day_plan_con">
					<!-- 날짜 입력 시 날짜 입력 수만큼 day plan tab 생성 -->
					<!-- 여행 날자 수에 따라 day_plan 생성 => makePlanInfo.js 참고 -->
					<!-- day_plan 안에 plan_list 생성 makePlanDetail.js setspot() 참고 -->
				</div>

				<!-- 저장, 취소 버튼 -->
				<div class="btn_con">
					<!-- 아이디 세션 확인 후 아이디가 있을 경우 restore, 없을 경우 로그인 모달 -->
					<%
						if (nick != null) {
					%>
					<input type="button" value="저장하기" class="plan_submit" onclick="restore_plan()">
					<%
						} else {
					%>
					<input type="button" value="저장하기" class="plan_submit" onclick="login_alert()">
					<%
						}
					%>
					<input type="button" value="취소하기" onclick="location.href='index.jsp'" class="plan_cancle" />
				</div>
			</form>
		</div>

		<!-- 사이드 움직이는 버튼 side.js -->
		<div id="side_button">&#9654;</div>
	</div>

	<!-- planInfo -->
	<jsp:include page="writeSimplePlan.jsp"></jsp:include>
	<!-- spotList -->
	<jsp:include page="SpotContainer.jsp"></jsp:include>
	<!-- login modal -->
	<jsp:include page="makePlanLoginModal.jsp"></jsp:include>

	<!-- kakao map api -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df278366797b59b90c8d2797fb62bc3f&libraries=services"></script>
	<!-- map -->
	<script src="scripts/map.js"></script>
	
	<!-- side bar -->
	<script src="scripts/side.js"></script>
	<!-- change plan -->
	<script src="scripts/modify.js"></script>
	<!-- cancle plan -->
	<script src="scripts/cancle.js"></script>
	<!-- make plan info -->
	<script src="scripts/makePlanInfo.js"></script>

	<!-- make plan detail -->
	<script src="scripts/cookie.js"></script>
	<!-- 페이지 초기화 -->
	<script src="scripts/makePlanOnload.js"></script>	
	<script src="scripts/makePlanDetail.js"></script>
	<script src="scripts/restore.js"></script>

</body>
</html>
