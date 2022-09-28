<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="pop.PopDTO"%>
<%@page import="pop.PopDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
		request.setCharacterEncoding("UTF-8"); 
%>

<%
		//로그인 여부 테스트
// 		String gu = "okkk";
// 		session.setAttribute("nick_s", gu);
// 		String nick = (String)session.getAttribute("nick_s");		
// 		session.invalidate();
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum ="1";
		}
	
		PopDAO dao = PopDAO.getInstance();
				
		//게시판 목록 부분
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
		
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/popularity_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script language="JavaScript" src="scripts/popAdd.js" charset="utf-8"></script>
	<script>history.replaceState({}, null, location.pathname);</script>
 
    <title>[인기 공유 플랜] | 부랑나랑</title>
</head>
<body>
<%-- <jsp:include page="gnb.jsp"/> --%>
    <div id="pop_wrap">
        <div class="logo">
        	<div>
	        	<div class="logo_img">
	        		<img alt="logo_img" src="images/logo.png" onclick="javascript:location='index.jsp'">
	        	</div>
	        	<!-- <div class="gnb">
	        		<ul>
	        			<li><a href="../festival/festival.jsp">이벤트/축제</a></li>
	        			<li><a href="popularityPlan.jsp">인기 플랜</a></li>
	        			<li><a>플랜작성</a></li>
	        			<li><a>마이페이지</a></li>
	        		</ul>
	        	</div> -->
        	</div>
        </div>
        <div class="inner">
            <h1 class="Pp_title">인기 여행 플랜</h1>
             <div class="indicaotr">
			    <span class="prevArrow">이전</span>
			    <span class="nextArrow">다음</span>          
			</div>

            <div class="Pp_rankBox">
             
				<!-- TOP3 전체 목록 -->            
            	<c:forEach var="i" items="${popTopAll}" varStatus="status">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
	                    	<p>전체 인기 ${status.count}위</p>
		                    <a href="planDetail.jsp?rownum=${i.p_rownum}&pop=true" onclick="return click_on();">
		                    	<img src="images/top${status.count}.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                    	<div>
		                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
		                        <p>${i.t_namelist}</p>
		                        <p>${i.p_title}</p>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
				
				<!-- TOP3 남자 목록 -->
            	<c:forEach var="i" items="${popTopMan}" varStatus="status">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
	                    	<p>남자 인기 ${status.count}위</p>
		                    <a href="planDetail.jsp?rownum=${i.p_rownum}&pop=true" onclick="return click_on();">
		                    	<img src="images/mtop${status.count}.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                    	<div>
		                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
		                        <p>${i.t_namelist}</p>
		                        <p>${i.p_title}</p>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
				
				<!-- TOP3 여자 목록 -->
            	<c:forEach var="i" items="${popTopWoman}" varStatus="status">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
	                    	<p>여자 인기 ${status.count}위</p>
		                    <a href="planDetail.jsp?rownum=${i.p_rownum}&pop=true" onclick="return click_on();">
		                    	<img src="images/wtop${status.count}.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                    	<div>
		                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
		                        <p>${i.t_namelist}</p>
		                        <p>${i.p_title}</p>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
                
                <!-- TOP3 20대 목록 -->
            	<c:forEach var="i" items="${popTop20}" varStatus="status">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
	                    	<p>20대 인기 ${status.count}위</p>
		                    <a href="planDetail.jsp?rownum=${i.p_rownum}&pop=true" onclick="return click_on();">
		                    	<img src="images/2top${status.count}.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                    	<div>
		                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
		                        <p>${i.t_namelist}</p>
		                        <p>${i.p_title}</p>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
                
                 <!-- TOP3 30대 목록 -->
            	<c:forEach var="i" items="${popTop30}" varStatus="status">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
	                    	<p>30대 인기 ${status.count}위</p>
		                    <a href="planDetail.jsp?rownum=${i.p_rownum}&pop=true" onclick="return click_on();">
		                    	<img src="images/3top${status.count}.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                    	<div>
		                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
		                        <p>${i.t_namelist}</p>
		                        <p>${i.p_title}</p>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
                
                 <!-- TOP3 40대 목록 -->
            	<c:forEach var="i" items="${popTop40}" varStatus="status">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
	                    	<p>40대 인기 ${status.count}위</p>
		                    <a href="planDetail.jsp?rownum=${i.p_rownum}&pop=true" onclick="return click_on();">
		                    	<img src="images/4top${status.count}.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                    	<div>
		                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
		                        <p>${i.t_namelist}</p>
		                        <p>${i.p_title}</p>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
                
                 <!-- TOP3 50대 목록 -->
            	<c:forEach var="i" items="${popTop50}" varStatus="status">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
	                    	<p>50대 인기 ${status.count}위</p>
		                    <a href="planDetail.jsp?rownum=${i.p_rownum}&pop=true" onclick="return click_on();">
		                    	<img src="images/5top${status.count}.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                    	<div>
		                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
		                        <p>${i.t_namelist}</p>
		                        <p>${i.p_title}</p>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
            </div>

            <!-- 인기 해시태그 목록 -->
	    	<div class="Pp_search">
		        <div>
		            <ul class="hashTag_list">
		            			<li><a href="?">전체</a></li>
			            <% for(int i = 0; i<poptag.size(); i++){ 
			            	PopDTO taglist = poptag.get(i);
			            %>
				                <li>
				                	<a href="?pageNum=1&searchTag=<%=URLEncoder.encode(taglist.getT_name(), "utf-8")%>">
				                		<%= taglist.getT_name() %>
				                	</a>
				                </li>
				        <% } %>
		            </ul>
		        </div>
	    	</div>
	    	
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
	                       		<fmt:formatDate value="${i.p_regdate}" pattern="yyyy-MM-dd" var="regdate" />
				                    <tr class="Pp_table_content">
				                        <td> ${i.p_rownum} </td>
				                        <td> <a href="planDetail.jsp?rownum=${i.p_rownum}&pop=true" onclick="return click_on()">${i.p_title}</a> </td>
				                        <td><div class="etc"> ${i.t_namelist} </div></td>
				                        <td> ${regdate} </td>
				                        <td> ${i.p_like} </td>
				                    </tr>
			                    </c:forEach>
			                 <tbody>
		                </table>
		            </div>
		            
					<!-- 페이징처리 -->		            
		            <div class="Pp_page">
						<%-- ${PopDTO.pageNumber(4)} --%>
						<p><%= PopDTO.pageNumber(4, like, searchTag)%></p>
		            </div>
		        </div>
		    </div>
	    </div>
	</div>
	
	<!-- 로그인여부 확인 -->
	<script type="text/javascript">
		function click_on(){
			var check = '${nick_s}';
			if(check == 'null' || check == ""){
				alert("로그인을 하셔야합니다")
				location.href="login.jsp";
				return false;
			} 
				return true;
		}
	</script>
</body>
</html>