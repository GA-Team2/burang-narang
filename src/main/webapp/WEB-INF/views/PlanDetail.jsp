<%@page import="java.util.Arrays"%>
<%@page import="org.ga2.buna.dto.plandetail.PlanJoinDTO"%>
<%@page import="org.ga2.buna.dao.PlanDAO"%>
<%@page import="org.ga2.buna.dao.like.LikeDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
	request.setCharacterEncoding("UTF-8");

	int rownum = Integer.parseInt(request.getParameter("rownum"));
	//세션값 받아오기
	String nickSession = (String) session.getAttribute("nick_s");
	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;

	//좋아요 수 받아오기
	LikeDAO ldao = LikeDAO.getInstance();
	int likeNum = ldao.getLikeNum(rownum);

	//마이페이지에서 넘어 왔을 경우 true
	String pop = request.getParameter("pop");
	String mypage = request.getParameter("mypage");

	//디테일 리스트 출력
	PlanDAO pdao = PlanDAO.getInstance();
	ArrayList<PlanJoinDTO> list = pdao.getPlanDetail(rownum);
	request.setAttribute("list", list);

	//닉네임, 여행 제목, 태그 for문 돌리지 않고 가져오기 위해 tripday 변수 설정
	int tripday = list.size() - 1;

	//좋아요 여부 체크
	int checkLike = ldao.checkLike(rownum, nick);

	//총 여행일자 구하는 메서드 (ex.3일)
	int planDay = pdao.getPlanDay(rownum);

	//각 여행일별 일정개수 배열로 받아오기
	int[] seqNumber = pdao.getTripDaySequence(planDay, rownum);
--%>

<html>
<head>
	<title>여행 일정표 | 부랑나랑</title>
	<link rel="stylesheet" href="styles/normalize.css">
	<link rel="stylesheet" href="styles/planstyle.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!--쿼리 스트링 숨겨주는 스크립트-->
	<script>
		history.replaceState({}, null, location.pathname);
	</script>
	<!-- 추천 기능 xeicon 사용 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>

<input type="hidden" id="ajaxrownum" value="<%=rownum%>">

<div class="detail_container">
	<div id="map" style="width: 40%; height: 100%"></div>

	<div class="aside">
		<h2>
			<span><%=list.get(tripday).getMemberNickname()%></span>님의 여행 일정표
		</h2>
		<div class="intro_wrap">
			<div class="intro">
				<h3><%=list.get(tripday).getPlanTitle()%></h3>
				<p>
					<%
						//태그 있을 때만 태그리스트를 출력
						if (list.get(tripday).getTagNamelist() != null) {
					%>
					<%=list.get(tripday).getTagNamelist()%>
					<%
						}
					%>
				</p>
			</div>
			<!--title끝-->

			<!-- 좋아요 -->
			<div class="like">
				<c:choose>
					<%--
                         인기플랜에서 넘어왔을 경우와 아닐 경우를 분기처리
                         분기처리 없이 인기플랜에서 넘어왔을 때 좋아요 클릭하면 이동 버튼이 수정/취소로 바뀜
                    --%>
					<c:when test="${param.pop == 'true'}">
						<a href="LikeUpdate.jsp?rownum=<%=rownum%>&pop=true">
							<i class="xi-heart-o xi-2x" id="like"></i>
						</a>
					</c:when>
					<c:otherwise>
						<a href="LikeUpdate.jsp?rownum=<%=rownum%>&pop=false">
							<i class="xi-heart-o xi-2x" id="like"></i>
						</a>
					</c:otherwise>
				</c:choose>
				<b><%=likeNum%></b>
				<input type="hidden" id="likecheck" value="<%=checkLike%>">
			</div>
			<!--like끝-->
		</div>

		<div class="day_wrap">
			<%
				int sum = 0;
				//i일차에 해당하는 일정수를 누적합산
				for (int i = 0; i < planDay; i++) {
					sum += seqNumber[i];
			%>
			<div class="container">
				<%
					/**
					 * (누적합산-i일차 일정)=전체 list에서 i일차에 해당하는 날짜의 첫번째 일정부터 시작해서
					 * 누적합산값까지 반복하면 i일차의 일정 수만큼만 반복 가능
					 */
					for (int j = sum - seqNumber[i]; j < sum; j++) {
						/**
						 * 여행날짜와 n일차 중복되는 값 제외하기 위해 분기처리
						 * db에서 null처리 후 데이터 들고왔기 때문에 null이 아닌 경우에 tripday와 tripdate 출력
						 */
						if (list.get(j).getPlanTripday() != 0 && list.get(j).getPlanTripdate() != null) {
				%>
				<div class="tripday">
					DAY <span><%=list.get(j).getPlanTripday()%></span> <br>
					<%=list.get(j).getPlanTripdate()%>
				</div>
				<div class="schedule">
					<%
						//이벤트의 경우 spotname 대신 축제명이 출력되게 하기 위해 분기처리
						if (list.get(j).getSpotSerialnum().startsWith("E")) {
					%>
					<p class="fsname"><%=list.get(j).getEventName()%></p>
					<%
					} else {
					%>
					<!-- 이벤트가 아니면 spotname 출력되게 -->
					<p class="spotname"><%=list.get(j).getPlanSpotname()%></p>
					<%
						}
					%>
					<div class="circle f_circle">
						<div class="edge f_edge"></div>
					</div>
					<p class="location"><%=list.get(j).getSpotLocation()%></p>
				</div>
				<%
					//tripday와 tripdate가 null일 때 위와 같은 형식으로 반복
				} else {
				%>
				<div class="schedule">
					<%
						if (list.get(j).getSpotSerialnum().startsWith("E")) {
					%>
					<p class="fsname"><%=list.get(j).getEventName()%></p>
					<%
					} else {
					%>
					<p class="spotname"><%=list.get(j).getPlanSpotname()%></p>
					<%
						}
					%>
					<div class="circle f_circle">
						<div class="edge f_edge"></div>
					</div>
					<p class="location"><%=list.get(j).getSpotLocation()%></p>
				</div>
				<%
					} // tripday if끝
				%>
				<%
					} //for int j 끝
				%>
			</div>
			<!-- container 끝 -->
			<%
				} //for int i 끝
			%>
			<!--이동 버튼-->
			<div class="management">
				<c:choose>
					<%-- 인기플랜에서 넘어왔을 때 플랜가져오기 / 목록 버튼 활성화 --%>
					<c:when test="${param.pop eq 'true'}">
						<%-- 플랜 가져오기 버튼 : 플랜 수정 페이지 이동 --%>
						<input type="button" name="planedit" value="플랜가져오기"
							   onclick="location.href='popularCopyPlan.jsp?rownum=<%=rownum%>&pop=true'">
						<%-- 목록 버튼 : 인기플랜이동--%>
						<input type="button" name="recommend" value="목록"
							   onclick="location.href='PopularityPlan.jsp'">
						<br>
					</c:when>
					<%-- 인기플랜 외의 페이지에서 넘어왔을 때 수정/취소 버튼 활성화 --%>
					<c:otherwise>
						<input type="button" name="edit" value="수정"
							   onclick="location.href='EditPlan.jsp?rownum=<%=rownum%>'">
						<input type="button" name="cancle" value="취소"
							   onclick="cancle_location('${param.mypage}')">
					</c:otherwise>
				</c:choose>
			</div>
			<!--management 끝-->
		</div>
	</div>


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