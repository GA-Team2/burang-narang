<%@page import="org.ga2.buna.dto.PopDTO"%>
<%@page import="org.ga2.buna.dao.PopDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
// 		String nick_s = "okkk";
// 		session.setAttribute("nick_s", nick_s);
// 		String nick = (String)session.getAttribute("nick_s");		
// 		session.invalidate();
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum ="1";
		}
	
		PopDAO dao = PopDAO.getInstance();
				
		//게시판 목록 부분
		ArrayList<PopDTO> popList = dao.listPop(pageNum, request.getParameter("like"), request.getParameter("searchTag"));
		request.setAttribute("popList", popList);
		
		//태그 서치 리스트
		ArrayList<PopDTO> tagList = dao.listTag();
		request.setAttribute("tagList", tagList);

		//전체 인기순 
		ArrayList<PopDTO> popList2 = dao.listPop2(1);
		request.setAttribute("popList2", popList2);
		
		//남자 인기순
		ArrayList<PopDTO> popList3 = dao.listPop2(2);
		request.setAttribute("popList3", popList3);
		
		//여자 인기순
		ArrayList<PopDTO> popList4 = dao.listPop2(3);
		request.setAttribute("popList4", popList4);
		
		//페이지 DTO에 넘길 변수
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
   <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script language="JavaScript" src="scripts/popAdd.js" charset="utf-8"></script>
	<script>history.replaceState({}, null, location.pathname);</script>
 
    <title>[인기 공유 플랜] | 부랑나랑</title>
</head>
<body>
    <div id="pop_wrap">
        <div class="inner">
            <h1 class="Pp_title">인기 여행 플랜</h1>
             <div class="indicaotr">
			    <span class="prevArrow">이전</span>
			    <span class="nextArrow">다음</span>          
			</div>

            <div class="Pp_rankBox">
             
				<!-- TOP3 전체 목록 -->            
            	<c:forEach var="i" items="${popList2}">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
		                    <a href="hello.html?p_rownum=${i.p_rownum}" onclick="return click_on();">
		                    	<img src="images/3.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
	                        <p>${i.t_namelist}</p>
	                        <p>${i.p_title}</p>
	                    </div>
	                </div>
                </c:forEach>
				
				<!-- TOP3 남자 목록 -->
            	<c:forEach var="i" items="${popList3}">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
		                    <a href="hello.html?p_rownum=${i.p_rownum}" onclick="return click_on();">
		                    	<img src="images/4.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
	                        <p>${i.t_namelist}</p>
	                        <p>${i.p_title}</p>
	                    </div>
	                </div>
                </c:forEach>
				
				<!-- TOP3 여자 목록 -->
            	<c:forEach var="i" items="${popList4}">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
		                    <a href="hello.html?p_rownum=${i.p_rownum}" onclick="return click_on();">
		                    	<img src="images/5.jpg" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
	                        <p>${i.t_namelist}</p>
	                        <p>${i.p_title}</p>
	                    </div>
	                </div>
                </c:forEach>
            </div>
            
            <!-- 인기 해시태그 목록 -->
	    	<div class="Pp_search">
		        <div class="inner">
		            <ul class="hashTag_list">
		            			<li><a href="?">전체</a></li>
			            <% for(int i = 0; i<tagList.size(); i++){ 
			            	PopDTO taglist = tagList.get(i);
			            %>
				                <li>
				                	<a href="?searchTag=<%=URLEncoder.encode(taglist.getT_name(), "utf-8")%>">
				                		<%= taglist.getT_name() %>
				                	</a>
				                </li>
				        <% } %>
		            </ul>
		        </div>
	    	</div>
	    	
	    	<!-- 하단부 게시판 목록 -->
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
			                	<c:forEach var="i" items="${popList}">
	                       		<fmt:formatDate value="${i.p_regdate}" pattern="yyyy-MM-dd" var="regdate" />
				                    <tr class="Pp_table_content">
				                        <td> ${i.p_rownum} </td>
				                        <c:choose>
				                        	<c:when test="${!empty nick_s }">
				                        		<td> <a href="hello.html?p_rownum=${i.p_rownum}">${i.p_title}</a> </td>
				                        	</c:when>
				                        	<c:otherwise>
				                        		<td> <a href="login.html">${i.p_title}</a> </td>
				                        	</c:otherwise>
				                        </c:choose>
				                        <td> ${i.t_namelist} </td>
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
				location.href="login.html";
				return false;
			} 
				return true;
		}
	</script>
</body>
</html>