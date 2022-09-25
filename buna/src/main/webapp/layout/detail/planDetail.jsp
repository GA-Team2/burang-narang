<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="plan.PlanInfoDTO"%>
<%@page import="plan.PlanJoinDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="plan.PlanDAO"%>
<%@page import="like.LikeDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	int rownum = Integer.parseInt(request.getParameter("rownum"));
	//세션값 받아오기
	String nickSession = (String)session.getAttribute("nick_s");
	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;

	//좋아요 수 받아오기
	LikeDAO ldao = LikeDAO.getInstance();
	int likeNum = ldao.getLikeNum(rownum);
	
	//마이페이지에서 넘어 왔을 경우 true
	String pop = request.getParameter("pop");
	
	//디테일 리스트 출력
	PlanDAO pdao = PlanDAO.getInstance();
	ArrayList<PlanJoinDTO> list = pdao.getPlanDetail(nick, rownum);
	request.setAttribute("list", list);
	
	int tripday = list.size()-1;

	//좋아요 여부 체크
	int checkLike = ldao.checkLike(rownum, nick);
	
%>
<html>
<head>
<title>[플랜 상세] | 부랑나랑</title>
<link rel="stylesheet" href="styles/normalize.css">
<link rel="stylesheet" href="styles/planstyle.css?v=3">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="scripts/myplan.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">
    
    <div class="aside">
	    <h2><%=nick %>님의 여행 일정표</h2>
	    <div class="title">
	    	<p><%=list.get(tripday).getP_title() %></p>
	   		<p><%=list.get(tripday).getT_namelist() %></p>
		</div><!--title끝-->
		<!-- 좋아요 -->
        <div class="like">
<%--          	<a href="likeUpdate.jsp?rownum=<%=rownum%>"> --%>
<!--          		<i class="xi-heart-o xi-2x" id="like"></i> -->
<!--          	</a> -->
		<!-- pop에서 넘어왔을 때 분기처리 -->
			<c:choose>
				<c:when test="${param.pop eq 'true'}">
		         	<a href="likeUpdate.jsp?rownum=<%=rownum%>&pop=true">
			        	<i class="xi-heart-o xi-2x" id="like"></i>
			        </a>
				</c:when>
				<c:otherwise>
		         	<a href="likeUpdate.jsp?rownum=<%=rownum%>&pop=false">
			        	<i class="xi-heart-o xi-2x" id="like"></i>
		        	</a>
				</c:otherwise>
			</c:choose>
        	<b><%=likeNum %></b>
        	<input type="hidden" id="likecheck" value="<%=checkLike%>">
        </div><!--like끝-->
        
	    <!--일정 -->
		<div class="day">
			<!-- tripday 값이 0이 아니고 tripdate의 값이 null이 아닐 때 날짜와 day 출력 -->
			<c:forEach var="detailList" items="${list}">
				<c:choose>
					<c:when test="${detailList.p_tripday != 0
								&& detailList.p_tripdate != null}">
						<ul class="date">
							<li class="tripday">
								DAY ${detailList.p_tripday }
							</li>
							<li class="tripday">
								${fn:substring(detailList.p_tripdate, 0, 10)}
							</li>
						</ul>
						<div class="schedule">
							<p>${detailList.p_spotname }</p>
							<div class="edge"><div class="circle"></div></div>
							<!-- <div class="circle"><div class="edge"></div></div> -->
							<p>${detailList.s_location }</p>
						</div>
					</c:when>
					<c:otherwise>
						<div class="schedule">
							<p>${detailList.p_spotname }</p>
							<div class="edge"><div class="circle"></div></div>
							<!-- <div class="circle"><div class="edge"></div></div> -->
							<p>${detailList.s_location }</p>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
        </div><!--day끝-->

		<!--이동 버튼-->
        <div class="management">
            <c:choose>
            	<c:when test="${param.pop eq 'true'}"><!-- 인기플랜에서 넘어왔을 때 -->
		            <input type="button" name="planedit" value="플랜가져오기" onclick="location.href='EditPlan.jsp?rownum=<%=rownum%>'"> <!--플랜 수정 페이지 이동-->
		            <input type="button" name="recommend" value="목록" onclick="location.href='popularityPlan.jsp'"><br> <!--인기플랜이동-->
            	</c:when>
            	<c:otherwise>
		            <input type="button" name="edit" value="수정" onclick="location.href='EditPlan.jsp?rownum=<%=rownum%>'">
<!-- 		            <input type="button" name="cancle" value="취소" onclick="location.href='myPage.jsp'"> -->
		            <input type="button" name="cancle" value="취소" onclick="location.href='../myPage/myPage.jsp'">
				</c:otherwise>
            </c:choose>
        </div><!--management 끝-->
    </div> <!--aside 끝-->

</body>
</html>