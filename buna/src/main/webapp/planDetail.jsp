<%@page import="java.util.Arrays"%>
<%@page import="org.ga2.buna.dto.PlanJoinDTO"%>
<%@page import="org.ga2.buna.dao.PlanDAO"%>
<%@page import="org.ga2.buna.dao.LikeDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
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

//디테일 리스트 출력
PlanDAO pdao = PlanDAO.getInstance();
ArrayList<PlanJoinDTO> list = pdao.getPlanDetail(rownum);
request.setAttribute("list", list);

System.out.println(list.toString());

int tripday = list.size() - 1;

//좋아요 여부 체크
int checkLike = ldao.checkLike(rownum, nick);

//총 여행일자 구하는 메서드 (ex.3일)
int planDay = pdao.getPlanDay(rownum);
System.out.println("planDay : " + planDay);
//각 여행일 별 일정개수 배열로 받아오기
int[] seqNumber = pdao.getTripDaySequence(planDay, rownum);
System.out.println("seqNumber : "+ Arrays.toString(seqNumber));
	
%>
<html>
<head>
<title>[플랜 상세] | 부랑나랑</title>
<link rel="stylesheet" href="styles/normalize.css">
<link rel="stylesheet" href="styles/planstyle.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">

	<input type="hidden" id="ajaxrownum" value="<%=rownum%>">
<div class="detail_container">
	<div id="map_area" style="width: 40%; height: 100%"></div>
    <div class="aside">
<h2><%=list.get(tripday).getM_nickname()%>님의 여행 일정표</h2>
		<div class="intro_wrap">
			<div class="intro">
				<h3><%=list.get(tripday).getP_title()%></h3>
				<p>
					<%
						if (list.get(tripday).getT_namelist() != null) {
					%>
					<%=list.get(tripday).getT_namelist()%>
					<%
						}
					%>
				</p>
			</div>
			<!--title끝-->

			<!-- 좋아요 -->
			<div class="like">
				<c:choose>
					<c:when test="${param.pop == 'true'}">
						<a href="likeUpdate.jsp?rownum=<%=rownum%>&pop=true"> <i
							class="xi-heart-o xi-2x" id="like"></i>
						</a>
					</c:when>
					<c:otherwise>
						<a href="likeUpdate.jsp?rownum=<%=rownum%>&pop=false"> <i
							class="xi-heart-o xi-2x" id="like"></i>
						</a>
					</c:otherwise>
				</c:choose>
				<b><%=likeNum%></b> <input type="hidden" id="likecheck"
					value="<%=checkLike%>">
			</div>
			<!--like끝-->
		</div>
		<div class="day_wrap">
		<%
			int sum=0;
			for(int i=0; i<planDay; i++) {
				sum+=seqNumber[i];
				System.out.println(i+"="+sum);
		%>
				<div class="container">
		<%
				for(int j=sum-seqNumber[i]; j<sum; j++) {
					if(list.get(j).getP_tripday()!=0 && list.get(j).getP_tripdate()!=null) {
		%>
						<div class="tripday">
							DAY <%=list.get(j).getP_tripday() %> <br>
							<%=list.get(j).getP_tripdate() %>
						</div>
						<div class="schedule">
		<%
						if(list.get(j).getS_serialnum().startsWith("E")) {
		%>
								<p class="fsname"><%=list.get(j).getE_name() %></p>
		<%
						} // event if끝
		%>
							<p><%=list.get(j).getP_spotname() %></p>
<!-- 							<div class="circle"><div class="edge"></div></div> -->
							<p class="location"><%=list.get(j).getS_location() %></p>
						</div>
		<%
					} else {
		%>
						<div class="schedule">
		<%
						if(list.get(j).getS_serialnum().startsWith("E")) {
		%>							<p class="fsname"><%=list.get(j).getE_name() %></p>
		<%
						} // event if끝
		%>
							<p><%=list.get(j).getP_spotname() %></p>
<!-- 							<div class="circle"><div class="edge"></div></div> -->
							<p class="location"><%=list.get(j).getS_location() %></p>
						</div>
		<%	
					} // tripday if끝
		%>
		<%
				} //for int j 끝
		%>
				</div> <!-- container 끝 -->
		<%
			} //for int i 끝
		%>
		</div>


		<!--이동 버튼-->
		<div class="management">
			<c:choose>
				<c:when test="${param.pop eq 'true'}">
					<!-- 인기플랜에서 넘어왔을 때 -->
					<input type="button" name="planedit" value="플랜가져오기"
						onclick="location.href='EditPlan.jsp?rownum=<%=rownum%>'">
					<!--플랜 수정 페이지 이동-->
					<input type="button" name="recommend" value="목록"
						onclick="location.href='popularityPlan.jsp'">
					<br>
					<!--인기플랜이동-->
				</c:when>
				<c:otherwise>
					<input type="button" name="edit" value="수정"
						onclick="location.href='EditPlan.jsp?rownum=<%=rownum%>'">
					<!-- 		            <input type="button" name="cancle" value="취소" onclick="location.href='myPage.jsp'"> -->
					<input type="button" name="cancle" value="취소"
						onclick="location.href='myPage.jsp'">
				</c:otherwise>
			</c:choose>
		</div>
		<!--management 끝-->
	</div>
	<!--aside 끝-->
     <!-- js -->
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df278366797b59b90c8d2797fb62bc3f&libraries=services"
    ></script>
    <!-- js -->
    <script src="scripts/map.js"></script>
    <script src="scripts/myplan.js"></script>

</body>
</html>