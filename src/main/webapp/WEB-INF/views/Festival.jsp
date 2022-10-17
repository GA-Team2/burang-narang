<%@page import="org.ga2.buna.dto.EventlistDTO"%>
<%@page import="org.ga2.buna.dao.EventlistDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	//이벤트,축제 리스트 가져오기
	EventlistDAO dao = EventlistDAO.getInstance();
	ArrayList<EventlistDTO> eventList = dao.listEvent();
	
	request.setAttribute("eventList", eventList);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<!-- festival style -->
	<link rel="stylesheet" href="styles/normalize.css">
	<link rel="stylesheet" href="styles/festival_style.css">
	
	<!-- google font -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link
		href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
		rel="stylesheet">
	
	<!-- Bootstrap -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous">
	
	<!-- js -->
	<script language="JavaScript" src="scripts/festivalAdd.js"
		charset="utf-8"></script>
	
	<!-- 쿼리스트링 숨기기 -->
	<script>
		history.replaceState({}, null, location.pathname);
	</script>
	
	<title>축제 / 이벤트 | 부랑나랑</title>
</head>
<body>
	<!-- gnb 구현 준비중 -->
	<%-- <jsp:include page="../popularityPlan/gnb.jsp"/> --%>

	<section id="fest_wrap">
		<!-- 상단 로고 부분 -->
		<div class="logo">
			<div>
				<div class="logo_img">
					<img alt="logo_img" src="images/logo.png"
						onclick="javascript:location='IIndex.jsp'">
				</div>
			</div>
		</div>
		<!-- 상단 로고 부분 끝-->

		<div class="inner">
			<!-- 타이틀 -->
			<h1 class="fest_title">축제 / 이벤트</h1>

			<!-- 탭메뉴 -->
			<div class="fest_month">
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					<!-- 탭메뉴 전체 -->
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="pills-allmonth-tab"
							data-bs-toggle="pill" data-bs-target="#pills-allmonth"
							type="button" role="tab" aria-controls="pills-allmonth"
							aria-selected="true">전체</button>
					</li>
					<!-- 탭메뉴 1월 ~ 12월 -->
					<c:forEach var="i" begin="1" end="12">
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-${i}month-tab"
								data-bs-toggle="pill" data-bs-target="#pills-${i}month"
								type="button" role="tab" aria-controls="pills-${i}month"
								aria-selected="false">${i}월</button>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!-- 탭메뉴 끝 -->

			<!-- 이벤트 리스트. 시작날짜(월)를 분기처리 해당 월마다 출력 -->
			<div class="fest_list">
				<div class="tab-content" id="pills-tabContent">

					<!-- 전체 리스트  -->
					<div class="tab-pane fade show active fest_hotList"
						id="pills-allmonth" role="tabpanel"
						aria-labelledby="pills-allmonth-tab">
						<c:forEach var="i" items="${eventList}">
							<div class="fest_box" id="box1">
								<div class="fest_img">
									<a href="${i.eventUrl}" target="_blank"> <img
										src="${i.eventPhoto}" alt="">
									</a>
								</div>
								<div class="fest_content">
									<p>${i.eventName}</p>
								</div>
								<div class="planAdd">
									<!-- 플랜 작성 페이지로 이동 -->
									<a href="MakePlan.jsp?s_serialnum=${i.spotSerialnum}"
										onclick="return click_on()">내 플랜에 추가</a>
								</div>
							</div>
						</c:forEach>
					</div>

					<!-- 1월 ~ 12월 행사 리스트 -->
					<c:forEach var="j" begin="1" end="12">
						<div class="tab-pane fade fest_hotList" id="pills-${j}month"
							role="tabpanel" aria-labelledby="pills-${j}month-tab">
							<c:forEach var="i" items="${eventList}">
								<!-- startdate에서 날짜형식으로 M만 뽑음  -->
								<fmt:formatDate var="startdate" value="${i.eventStartdate}"
									pattern="M" />
								<!-- M(월) = 1~12(월) -->
								<c:if test="${startdate == j}">
									<div class="fest_box" id="box1">
										<div class="fest_img">
											<a href="${i.eventUrl}" target="_blank"> <img
												src="${i.eventPhoto}" alt="">
											</a>
										</div>
										<div class="fest_content">
											<p>${i.eventName}</p>
										</div>
										<div class="planAdd">
											<a href="MakePlan.jsp?s_serialnum=${i.spotSerialnum}"
												onclick="return click_on()">내 플랜에 추가</a>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- 이벤트 리스트 끝 -->

		</div>
	</section>

	<!-- 로그인 여부 -->
	<script type="text/javascript">
		/* 내 플랜에 추가 버튼을 누르면  */
		function click_on() {
			/* 세션값(아이디) 여부 체크 */
			var check = '${nick_s}';
			if (check == 'null' || check == "") {
				alert("로그인을 하셔야합니다")
				/* 세션값(아이디)이 없을경우 로그인 페이지로 보냄 */
				location.href = "Login.jsp";
				/* a태그에 false를 반환하여 a태그에 있는 페이지로는 이동 안함 */
				return false;
			}
			/* 세션값(아이디)이 존재하면 a태그로 true반환 MakePlan 페이지로 이동*/
			return confirm("플랜 작성페이지로 이동하시겠습니까?");
		}
	</script>
<script src="scripts/aaa.js"></script>
	<!-- Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>