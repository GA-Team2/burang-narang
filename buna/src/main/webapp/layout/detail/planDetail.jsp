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
	String nick = (String) session.getAttribute("nick_s");

	//좋아요 수 받아오기
	LikeDAO ldao = LikeDAO.getInstance();
	int likeNum = ldao.getLikeNum(rownum);
	
	//마이페이지에서 넘어 왔을 경우 true
	String mypage = request.getParameter("mypage");
	System.out.println(mypage);
	
	//디테일 리스트 출력
	PlanDAO pdao = PlanDAO.getInstance();
	ArrayList<PlanJoinDTO> list = pdao.getPlanDetail(nick, rownum);
	request.setAttribute("detailList", list);
	
	int tripday = list.size()-1;

	//좋아요 여부 체크
	int checkLike = ldao.checkLike(rownum, nick);
	
%>
<html>
<head>
<title>[플랜 상세] | 부랑나랑</title>
<link rel="stylesheet" href="styles/normalize.css">
<link rel="stylesheet" href="styles/planstyle.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="scripts/myplan.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

</head>
<body>

    <div class="aside">
	    <h2><%=nick %>님의 여행 일정표</h2>
	    <div class="title">
	    	<p><%=list.get(tripday).getP_title() %></p>
	   		<p><%=list.get(tripday).getT_namelist() %></p>
		</div>
		<!-- 좋아요 -->
        <div class="like">
         	<a href="likeUpdate.jsp?rownum=<%=rownum%>&mypage=<%=mypage%>">
<!--         	<a onclick="like('rownum', 'nick')"> -->
	        	<i class="xi-heart-o xi-2x" id="like"></i>
        	</a>
        	<b><%=likeNum %></b>
        	<input type="hidden" id="likecheck" value="<%=checkLike%>">
        </div>
        
	    <!--일정 -->
		<c:forEach var="i" begin="0" end="<%=list.size()-1%>">
			<div class="day">
		        <ul id="date">
		        	<!-- tripday 값이 0이 아니고 tripdate의 값이 null이 아닐 때 날짜와 day 출력 -->
	            	<c:if test="${detailList[i].p_tripday ne 0
	            			   && detailList[i].p_tripdate ne null}">
			            <li class="p_tripday">
			            	DAY ${detailList[i].p_tripday }
			            </li>
			            <li class="p_tripday">
			            	${fn:substring(detailList[i].p_tripdate, 0, 10)}
			            </li>
	            	</c:if>
		        </ul>
		        <div class="schedule">
		        	<p>${detailList[i].p_spotname }</p>
		        	<p>${detailList[i].s_location }</p>
		        </div>
	        </div>
		</c:forEach>

        <div class="management">
            <c:choose>
            	<c:when test="${param.mypage eq 'true'}"><!-- 마이페이지에서 넘어왔을 때 -->
		            <input type="button" name="edit" value="수정" onclick="location.href='EditPlan.jsp?rownum=<%=rownum%>'">
		            <input type="button" name="cancle" value="취소" onclick="history.go(-1)">
            	</c:when>
            	<c:otherwise>
<%-- 	            <c:when test="${param.pop eq 'true'}"> --%>
		            <input type="button" name="planedit" value="플랜가져오기" onclick="location.href='EditPlan.jsp?rownum=<%=rownum%>'"> <!--플랜 수정 페이지 이동-->
		            <input type="button" name="recommend" value="목록" onclick="locatioin.href=''"><br> <!--인기플랜이동-->
<%-- 				</c:when> --%>
				</c:otherwise>
            </c:choose>
        </div>
    </div> <!--aside 끝-->

</body>
</html>