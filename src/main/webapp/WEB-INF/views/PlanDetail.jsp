<%@page import="java.util.Arrays"%>
<%@page import="org.ga2.buna.dto.plandetail.PlanJoinDTO"%>
<%@page import="org.ga2.buna.dao.PlanDAO"%>
<%@page import="org.ga2.buna.dao.like.LikeDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
	<title>여행 일정표 | 부랑나랑</title>
	<link rel="stylesheet" href="styles/normalize.css">
	<link rel="stylesheet" href="styles/planstyle.css">
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
			<!--
                         인기플랜에서 넘어왔을 경우와 아닐 경우를 분기처리
                         분기처리 없이 인기플랜에서 넘어왔을 때 좋아요 클릭하면 이동 버튼이 수정/취소로 바뀜
            -->
			<div class="like">
				<c:choose>
					<c:when test="${param.pop == 'true'}">
						<a onclick="likeAjax(${rownum}, '${pop}', '${mypage}')">
							<i class="xi-heart-o xi-2x" id="like"></i>
						</a>
					</c:when>
					<c:otherwise>
						<a onclick="likeAjax(${rownum}, '${pop}', '${mypage}')">
							<i class="xi-heart-o xi-2x" id="like"></i>
						</a>
					</c:otherwise>
				</c:choose>
				<b id="likeNum">${likeNum}</b>
				<input type="hidden" id="likecheck" value="${checkLike}">
			</div>
			<!--좋아요 끝-->
		</div>
		<!--introwrap 끝-->


		<!--누적합산을 위한 변수 sum 선언-->
		<c:set var="sum" value="0" />
		<!--총 여행 일자수만큼 반복-->
		<c:forEach var="i" begin="0" end="${totalTripDay-1}">
			<!-- i일차에 해당하는 일정 수를 누적합산 -->
			<c:set var="sum" value="${sum + seqNumber[i]}"/>
			<div class="container">
				<c:forEach var="j" items="${list}" begin="${sum - seqNumber[i]}" end="${sum-1}">
					<c:if test="${j.planTripday != 0 && j.planTripdate != null}">
						<div class="tripday">
							DAY <span>${j.planTripday}</span> <br>
							${j.planTripdate}
						</div>
						<div class="schedule">
							<p class="spotname">${j.planSpotname}</p>
							<div class="circle f_circle">
								<div class="edge f_edge"></div>
							</div>
							<p class="location">${j.spotLocation}</p>
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
						   onclick="location.href='/PopularityPlan'">
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
	<!--aside 끝-->

<!-- js -->
<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df278366797b59b90c8d2797fb62bc3f&libraries=services"></script>
<!-- js -->
<script src="scripts/map.js"></script>
<script src="scripts/myplan.js"></script>

</body>
</html>