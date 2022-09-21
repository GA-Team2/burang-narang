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
	
	int rownum=Integer.parseInt(request.getParameter("rownum"));
	//세션값 받아오기
	String nick = (String)session.getAttribute("nick_s");

	//좋아요 수 받아오기
	LikeDAO ldao = LikeDAO.getinstance();
	int likeNum = ldao.getLikeNum(rownum);
	
	//마이페이지에서 넘어 왔을 경우 true
	String myPage = request.getParameter("myPage");
	
	//좋아요 여부 체크
	int checkRs = ldao.checkLike(rownum, nick);
	
	//디테일 리스트 출력
	PlanDAO pdao = PlanDAO.getInstance();
	ArrayList<PlanJoinDTO> list = pdao.getPlanDetail(nick, rownum);
	
	request.setAttribute("detailList", list);
	
	int tripday = list.size()-1;
%>
<html>
<head>
<title>[플랜 상세] | 부랑나랑</title>
<link rel="stylesheet" href="styles/normalize.css">
<link rel="stylesheet" href="styles/planstyle.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="scripts/myplan.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script>
	var nick = "<%=nick%>";
</script>
</head>
<body>

    <div class="aside">
	    <h2><%=nick %>님의 부산 <span><%=list.get(tripday).getP_tripday() %></span>일 여행</h2>
	    <div class="title">
	    	<p><%=list.get(tripday).getP_title() %></p>
	   		<p><%=list.get(tripday).getT_namelist() %></p>
		</div>
		<!-- 좋아요 -->
        <div class="like">
        	<a onclick="like(<%=rownum%>)">
	        	<i class="xi-heart-o xi-2x" id="like"></i>
        	</a>
        	<b><%=likeNum %></b>
        	<input type="hidden" id="likecheck" value="<%=checkRs%>">
        </div>
        
	    <!--일정 -->
		<c:forEach var="i" begin="0" end="<%=list.size()-1%>">
			<div class="day">
		        <ul id="date">
		            <li class="p_tripday">DAY ${detailList[i].p_tripday }</li>
		            <li class="p_tripday">${fn:substring(detailList[i].p_tripdate, 0, 10)}</li>
		        </ul>
		        <div class="schedule">
		        	<p>${detailList[i].p_spotname }</p>
		        	<p>${detailList[i].s_location }</p>
		        </div>
	        </div>
		</c:forEach>

        <div class="management">
            <c:choose>
            	<c:when test="${param.myPage eq 'true'}"><!-- 마이페이지에서 넘어왔을 때 -->
		            <input type="button" name="edit" value="수정" onclick="location.href='edit.jsp?rownum=<%=rownum%>'">
		            <input type="button" name="cancle" value="취소" onclick="history.back()">
            	</c:when>
            	<c:otherwise>
<%-- 	            <c:when test="${param.pop eq 'true'}"> --%>
		            <input type="button" name="planedit" value="플랜가져오기"> <!--플랜 수정 페이지 이동-->
		            <input type="button" name="recommend" value="목록" onclick="history.back()"><br> <!--인기플랜이동-->
<%-- 				</c:when> --%>
				</c:otherwise>
            </c:choose>
        </div>
    </div> <!--aside 끝-->

</body>
</html>