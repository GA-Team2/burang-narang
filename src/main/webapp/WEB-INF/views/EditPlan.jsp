<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 플랜 수정 | 부랑나랑</title>
<!-- css -->
<link rel="stylesheet" href="../../styles/normalize.css">
<link rel="stylesheet" href="../../styles/style_makePlan.css">
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- 메인 지도  -->
	<div id="map"></div>

	<!-- 사이드바  -->
	<div id="side_bar">
		<!-- plan 제목 -->
		<div class="plan_title" id="plan_title">
			<p>${planInfo.planTitle}</p>
			<div class="edit_title" onclick="getPlanInfo()">수정</div>
		</div>
		<!-- plan_detail container -->
		<div class="plan_detail_container">
			<!-- 상단의 day tab-->
			<ul class="day_tab_container" id="day_tab_con">
				<!-- day_tab 생성 -->
				<c:forEach var="i" begin="1" end="${totalTripDay}">
					<c:choose>
						<c:when test="${i eq 1}">
							<li class="active_day" onclick="tabScroll(this)" id="day${i}">Day${i}</li>
						</c:when>
						<c:otherwise>
							<li onclick="tabScroll(this)" id="day${i}">Day${i}</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>

			<form method="post" name="makePlanForm">
				<!-- 반환한  planInfo 정보 저장 -->
				<input type="text" name="p_title" hidden value="${planInfo.planTitle}">
				<input type="text" name="p_firstdate" hidden value="${planInfo.planFirstDate}">
				<input type="text" name="p_lastdate" hidden value="${planInfo.planLastDate}">
				<input type="text" name="t_namelist" hidden value="${planInfo.tagNameList}">
				<input type="text" name="m_nickname" value="${nick}" hidden />

				<div class="plan_lists_container" id="plan_lists_container">
					<c:forEach var="i" begin="1" end="${totalTripDay}">
						<div id="day_plan${i}">
							<div class="plan_day_title">Day${i}</div>
							<input type="text" name="day${i}" value="${i}" hidden>
							<c:forEach var="detail" items="${detailList}">
								<c:choose>
									<c:when test="${i eq detail.planTripDay}">
										<div class="plan_list" id="plan_list${i}_${detail.planSequence}">
											<div class="change_plan_container">
												<div class="change_up_button" onclick="changeUpPlan(this)">&#9650;</div>
												<div class="plan_seq">${detail.planSequence}</div>
												<div class="change_down_button" onclick="changeDownPlan(this)">&#9660;</div>
											</div>
											<!-- spot 정보를 기반으로 plan_main 생성 -->
											<div class="plan_detail">
												<img src="${detail.spotPhoto}">
												<p>일정${detail.planSequence}</p>
												<input type="text" value="${detail.planSequence}" id="p_seq${i}_${detail.planSequence}" hidden>
												<p>${detail.spotName}</p>
												<input type="text" value="${detail.spotSerialNumber}" id="s_snum${i}_${detail.planSequence}" hidden>
												<input type="text" value="${detail.spotName}" id="s_name${i}_${detail.planSequence}" hidden>
												<p>${detail.spotType}</p>
												<input type="text" value="${detail.spotType}" hidden>
												<p>${detail.spotLocation}</p>
												<input type="text" value="${detail.spotLocation}" id="s_loc${i}_${detail.planSequence}" hidden>
												<div class="remove_plan_button" onclick="removePlan(this)">X</div>
											</div>
										</div>
									</c:when>
								</c:choose>
							</c:forEach>
							<input type='button' onclick='getSpotContainer(this)' class='add_plan_button' id="add_plan${i}" value='+'>
						</div>
					</c:forEach>
					<div class="blank"></div>
				</div>
				<div class="button_container">
					<c:choose>
						<c:when test="${not empty mypage}">
							<input type="button" value="수정하기" class="plan_submit" onclick="planCheck()">
							<input type="button" value="취소하기" onclick="location.href='/detail?mypage=true&rownum=${rownum}'" class="plan_cancel">
						</c:when>
						<c:otherwise>
							<input type="button" value="저장하기" class="plan_submit" onclick="planCheck()">
							<input type="button" value="취소하기" onclick="location.href='/detail?rownum=${rownum}&pop=true'" class="plan_cancel">
						</c:otherwise>
					</c:choose>
				</div>
			</form>
		</div>
		<div id="side_button">&#9654;</div>
	</div>

	<!-- planInfo -->
	<jsp:include page="MakePlanModal.jsp"></jsp:include>
	<!-- spotList -->
	<jsp:include page="SpotList.jsp"></jsp:include>

	<!-- Naver map api -->
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=&submodules=geocoder"></script>
	<!-- map -->
	<script src="scripts/map.js"></script>

	<!-- js -->
	<script src="../../scripts/side.js"></script>
	<!-- change plan -->
	<script src="../../scripts/changePlanDetail.js"></script>
	<!-- make plan info -->
	<script src="../../scripts/makePlanInfo.js"></script>
	<script src="../../scripts/editPlanInfo.js"></script>
	
	<!-- edit plan -->
	<script src="../../scripts/dayCookie.js"></script>
	<!-- 페이지 초기화 -->
	<script src="../../scripts/planOnload.js"></script>
	<script src="../../scripts/makePlanDetail.js"></script>
	<script src="../../scripts/savePlan.js"></script>

</body>
</html>