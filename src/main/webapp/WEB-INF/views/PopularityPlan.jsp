<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String nickSession = (String) session.getAttribute("nick_s");
	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
%>

<%--<%
	//게시판. 값이 없으면 1페이지부터 시작
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null) {
		pageNum = "1";
	}

	PopDAO dao = PopDAO.getInstance();

	//게시판 목록, pageNum -> 페이징, like -> 추천순 정렬, searchTag -> 해시태그 서치
	ArrayList<PopDTO> popboard = dao.popBoard(pageNum, request.getParameter("like"), request.getParameter("searchTag"));
	request.setAttribute("popBoard", popboard);

	//태그 서치 리스트
	ArrayList<PopDTO> poptag = dao.popTag();
	request.setAttribute("popTag", poptag);

	//전체 인기순
	ArrayList<PopDTO> poptopall = dao.popTop(1);
 	request.setAttribute("popTopAll", poptopall);

	//남자 인기순
	ArrayList<PopDTO> poptopman = dao.popTop(2);
 	request.setAttribute("popTopMan", poptopman);

	//여자 인기순
	ArrayList<PopDTO> poptopwoman = dao.popTop(3);
 	request.setAttribute("popTopWoman", poptopwoman);

	//20대 인기순
	ArrayList<PopDTO> poptop20 = dao.popTop(4);
 	request.setAttribute("popTop20", poptop20);

	//30대 인기순
	ArrayList<PopDTO> poptop30 = dao.popTop(5);
 	request.setAttribute("popTop30", poptop30);

	//40대 인기순
	ArrayList<PopDTO> poptop40 = dao.popTop(6);
 	request.setAttribute("popTop40", poptop40);

	//50대 인기순
	ArrayList<PopDTO> poptop50 = dao.popTop(7);
 	request.setAttribute("popTop50", poptop50);

	//DTO에 넘길 변수 페이지처리
	String like = request.getParameter("like");
	String searchTag = request.getParameter("searchTag");
%> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<!-- popularityPlan style -->
	<link rel="stylesheet" href="styles/normalize.css">
	<link rel="stylesheet" href="styles/popularity_style.css">
	
	<!-- TOP3 따봉아이콘(font-awesome) -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
	
	<!-- TOP3 slick slide -->
	<link rel="stylesheet" type="text/css"
		href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
	
	<!-- google font -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link
		href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
		rel="stylesheet">
	
	<!-- js -->
	<script type="text/javascript"
		src="http://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
	
	<!-- slick slide -->
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	
	<!-- slick slide custom -->
	<script src="scripts/PopularityPlan.js" charset="utf-8"></script>
	
	<!-- 쿼리스트링 숨기기 -->
	<!--<script>
		history.replaceState({}, null, location.pathname);
	</script>-->
	
	<title>인기 여행 플랜 | 부랑나랑</title>
</head>
<body>
	<!-- gnb 구현 준비중 -->
	 <jsp:include page="gnb.jsp"/>

	<div id="pop_wrap">
		<input type="hidden" id="nickCheck" value="<%=nick%>">
		<!-- 상단 로고 부분 -->
<%--		<div class="logo">--%>
<%--			<div>--%>
<%--				<div class="logo_img">--%>
<%--					<img alt="logo_img" src="images/logo.png"--%>
<%--						onclick="javascript:location='/'">--%>
<%--				</div>--%>
<%--			</div>--%>
<%--		</div>--%>
		<!-- 상단 로고 부분 끝-->

		<div class="inner">
			<!-- 타이틀 -->
			<h1 class="Pp_title">인기 여행 플랜</h1>
			<div class="indicaotr">
				<span class="prevArrow">이전</span> <span class="nextArrow">다음</span>
			</div>
			<!-- 타이틀 끝 -->

			<!-- TOP3 부분 분류별 반복 -->
			<div class="Pp_rankBox">
				<!-- TOP3 전체 목록 -->
				<c:forEach var="i" items="${popTopAll}" varStatus="status">
					<div class="rk_box" id="box1">
						<div class="rk_img">
							<p>전체 인기 ${status.count}위</p>
							<a href="PlanDetail.jsp?rownum=${i.planRownum}&pop=true"
								onclick="return click_on();"> <img
								src="images/top${status.count}.jpg" alt="">
							</a>
						</div>
						<div class="rk_content">
							<div>
								<p>
									<i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
								</p>
								<p>${i.tagNamelist}</p>
								<p>${i.planTitle}</p>
							</div>
						</div>
					</div>
				</c:forEach>

				<!-- TOP3 남자 목록 -->
				<c:forEach var="i" items="${popTopMan}" varStatus="status">
					<div class="rk_box" id="box1">
						<div class="rk_img">
							<p>남자 인기 ${status.count}위</p>
							<a href="PlanDetail.jsp?rownum=${i.planRownum}&pop=true"
								onclick="return click_on();"> <img
								src="images/mtop${status.count}.jpg" alt="">
							</a>
						</div>
						<div class="rk_content">
							<div>
								<p>
									<i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
								</p>
								<p>${i.tagNamelist}</p>
								<p>${i.planTitle}</p>
							</div>
						</div>
					</div>
				</c:forEach>

				<!-- TOP3 여자 목록 -->
				<c:forEach var="i" items="${popTopWoman}" varStatus="status">
					<div class="rk_box" id="box1">
						<div class="rk_img">
							<p>여자 인기 ${status.count}위</p>
							<a href="PlanDetail.jsp?rownum=${i.planRownum}&pop=true"
								onclick="return click_on();"> <img
								src="images/wtop${status.count}.jpg" alt="">
							</a>
						</div>
						<div class="rk_content">
							<div>
								<p>
									<i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
								</p>
								<p>${i.tagNamelist}</p>
								<p>${i.planTitle}</p>
							</div>
						</div>
					</div>
				</c:forEach>

				<!-- TOP3 20대 목록 -->
				<c:forEach var="i" items="${popTop20}" varStatus="status">
					<div class="rk_box" id="box1">
						<div class="rk_img">
							<p>20대 인기 ${status.count}위</p>
							<a href="PlanDetail.jsp?rownum=${i.planRownum}&pop=true"
								onclick="return click_on();"> <img
								src="images/2top${status.count}.jpg" alt="">
							</a>
						</div>
						<div class="rk_content">
							<div>
								<p>
									<i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
								</p>
								<p>${i.tagNamelist}</p>
								<p>${i.planTitle}</p>
							</div>
						</div>
					</div>
				</c:forEach>

				<!-- TOP3 30대 목록 -->
				<c:forEach var="i" items="${popTop30}" varStatus="status">
					<div class="rk_box" id="box1">
						<div class="rk_img">
							<p>30대 인기 ${status.count}위</p>
							<a href="PlanDetail.jsp?rownum=${i.planRownum}&pop=true"
								onclick="return click_on();"> <img
								src="images/3top${status.count}.jpg" alt="">
							</a>
						</div>
						<div class="rk_content">
							<div>
								<p>
									<i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
								</p>
								<p>${i.tagNamelist}</p>
								<p>${i.planTitle}</p>
							</div>
						</div>
					</div>
				</c:forEach>

				<!-- TOP3 40대 목록 -->
				<c:forEach var="i" items="${popTop40}" varStatus="status">
					<div class="rk_box" id="box1">
						<div class="rk_img">
							<p>40대 인기 ${status.count}위</p>
							<a href="PlanDetail.jsp?rownum=${i.planRownum}&pop=true"
								onclick="return click_on();"> <img
								src="images/4top${status.count}.jpg" alt="">
							</a>
						</div>
						<div class="rk_content">
							<div>
								<p>
									<i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
								</p>
								<p>${i.tagNamelist}</p>
								<p>${i.planTitle}</p>
							</div>
						</div>
					</div>
				</c:forEach>

				<!-- TOP3 50대 목록 -->
				<c:forEach var="i" items="${popTop50}" varStatus="status">
					<div class="rk_box" id="box1">
						<div class="rk_img">
							<p>50대 인기 ${status.count}위</p>
							<a href="PlanDetail.jsp?rownum=${i.planRownum}&pop=true"
								onclick="return click_on();"> <img
								src="images/5top${status.count}.jpg" alt="">
							</a>
						</div>
						<div class="rk_content">	
							<div>
								<p>
									<i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
								</p>
								<p>${i.tagNamelist}</p>
								<p>${i.planTitle}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- TOP3 부분 분류별 반복 끝-->

			<!-- 인기 해시태그 목록 -->
			<div class="Pp_search">
				<div>
					<ul class="hashTag_list">
						<li><a href="?">전체</a></li>
						<c:forEach var="i" items="${popTag}" varStatus="status">
<%--						<%
							for (int i = 0; i < popTag.size(); i++) {
							PopDTO taglist = popTag.get(i);
						%>--%>
						<li><a href="?searchTag=searchTag${status.count} ">
<%--							href="?pageNum=1&searchTag=<%=URLEncoder.encode(taglist.getTagName(), "utf-8")%>">--%>
<%--								<%=taglist.getTagName()%>--%>
							${i.tagName}
						</a></li>
<%--						<%
							}
						%>--%>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!-- 인기 해시태그 목록 끝 -->

			<!-- 게시판 목록 -->
			<div class="Pp_board">
				<div class="inner">
					<div class="boardBox">
						<table id="gcTable" class="Pp_table tablesorter">
							<thead>
								<tr class="Pp_table_title">
									<td><a href="?pageNum=1">글번호</a></td>
									<td>글제목</td>
									<td>해시태그</td>
									<td>작성일</td>
									<td><a href="?like=true">추천</a></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="i" items="${popBoard}">
									<fmt:formatDate value="${i.planRegdate}" pattern="yyyy-MM-dd"
										var="planRegdate" />
									<tr class="Pp_table_content">
										<td>${i.planRownum}</td>
										<td><a
											href="PlanDetail.jsp?rownum=${i.planRownum}&pop=true"
											onclick="return click_on()">${i.planTitle}</a></td>
										<td><div class="etc">${i.tagNamelist}</div></td>
										<td>${planRegdate}</td>
										<td>${i.planLike}</td>
									</tr>
								</c:forEach>
							<tbody>
						</table>
					</div>
					<!-- 게시판 목록 끝 -->

					<!-- 페이징처리 -->
					<div class="Pp_page">
<%--						<a href="?startNum=0">1</a>&nbsp;&nbsp;--%>
<%--						<a href="?startNum=1">2</a>--%>
						 ${pagingBoard}
<%--						<p><%=PopDTO.pageNumber(4, like, searchTag)%></p>--%>
					</div>
					<!-- 페이징처리 끝-->
				</div>
			</div>
		</div>
	</div>
	<script>


	</script>

	<!-- 로그인여부 확인 -->
<%--	<script type="text/javascript">--%>
<%--		/* TOP 이미지, 게시판 제목 클릭 시*/--%>
<%--		function click_on() {--%>
<%--			/* 세션값(아이디) 여부 체크 */--%>
<%--			var check = '${nick_s}';--%>
<%--			if (check == 'null' || check == "") {--%>
<%--				alert("로그인을 하셔야합니다")--%>
<%--				/* 세션값(아이디)이 없을경우 로그인 페이지로 보냄 */--%>
<%--				location.href = "Login.jsp";--%>
<%--				/* a태그에 false를 반환하여 a태그에 있는 페이지로는 이동 안함 */--%>
<%--				return false;--%>
<%--			}--%>
<%--			/* 세션값(아이디)이 존재하면 a태그로 true반환 planDetail 페이지로 이동*/--%>
<%--			return true;--%>
<%--		}--%>
<%--	</script>--%>
</body>
</html>