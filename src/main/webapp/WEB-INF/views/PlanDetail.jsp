<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
	<title>여행 일정표 | 부랑나랑</title>
	<link rel="stylesheet" href="styles/normalize.css">
	<link rel="stylesheet" href="styles/style_myPlanDetail.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!--쿼리 스트링 숨겨주는 스크립트-->
<%--	<script>
		history.replaceState({}, null, location.pathname);
	</script>--%>
	<!-- 추천 기능 xeicon 사용 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>

	<div class="detail_container">
		<div id="map" style="width: 40%; height: 100%"></div>

		<div class="aside">
			<h2>
				<span>${list.get(0).memberNickname}</span>님의 여행 일정표
			</h2>

			<div class="intro_wrap">
				<!--타이틀 시작-->
				<div class="intro">
					<h3>${list.get(0).planTitle}</h3>
					<p>
						<c:if test="${list.get(0).tagNamelist != null}">
							${list.get(0).tagNamelist}
						</c:if>
					</p>
				</div>
				<!--타이틀 끝-->

				<!-- 좋아요 -->
				<div class="like">
					<a onclick="likeAjax(${rownum})">
						<i class="xi-heart-o xi-2x" id="like"></i>
					</a>
					<b id="likeNum">${likeNum}</b>
					<input type="hidden" id="likecheck" value="${checkLike}">
				</div>
				<!--좋아요 끝-->
			</div>
			<!--introwrap 끝-->


			<div class="day_wrap">
				<!--누적합산을 위한 변수 sum 선언-->
				<c:set var="sum" value="0" />
				<!--총 여행 일자수만큼 반복-->
				<c:forEach var="i" begin="0" end="${totalTripDay-1}">
					<!-- i일차에 해당하는 일정 수를 누적합산 -->
					<c:set var="sum" value="${sum + seqNumber[i]}"/>
					<div class="container">
						<!-- (일자별 일정 누적합-해당 일자의 일정)부터 누적합까지 반복하면서 일자별 일정 출력 -->
						<c:forEach var="j" items="${list}" begin="${sum - seqNumber[i]}" end="${sum-1}">
							<!-- tripday와 tripdate 일자별로 한번만 출력하기 위한 조건문 -->
							<c:if test="${j.planTripday != 0 && j.planTripdate != null}">
								<div class="tripday">
									DAY <span>${j.planTripday}</span><br>
									${fn:substring(j.planTripdate, 2, 10)}
								</div>
							</c:if>
							<div class="schedule">
								<p class="spotname">${j.planSpotname}</p>
								<div class="circle f_circle">
									<div class="edge f_edge"></div>
								</div>
								<p class="location">${j.spotLocation}</p>
							</div>
						</c:forEach>
					</div> <!--container끝-->
				</c:forEach>

				<!--이동 버튼 영역-->
				<div class="management">
					<c:choose>
						<c:when test="${pop == 'true'}">
							<input type="button" name="planedit" value="플랜가져오기"
								   onclick="location.href='popularCopyPlan.jsp?rownum=${rownum}&pop=true'">
							<input type="button" name="recommend" value="목록"
								   onclick="location.href='/popularity'">
							<br>
						</c:when>
						<c:otherwise>
							<input type="button" name="edit" value="수정"
								   onclick="location.href='EditPlan.jsp?rownum=${rownum}'">
							<input type="button" name="cancle" value="취소"
								   onclick="cancle_location('${mypage}')">
						</c:otherwise>
					</c:choose>
				</div>
				<!--management 끝-->
			</div>
			<!--day_wrap 끝-->
		</div>
		<!--aside 끝-->
	</div>
	<!--detail_container 끝-->
<!-- js -->
<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df278366797b59b90c8d2797fb62bc3f&libraries=services"></script>
<!-- js -->
<script src="scripts/map.js"></script>
<script src="scripts/myplan.js"></script>

</body>
</html>