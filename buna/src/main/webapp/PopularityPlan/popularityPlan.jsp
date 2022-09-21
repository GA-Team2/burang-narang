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
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum ="1";
		}
	
		pop.PopDAO dao = PopDAO.getInstance();
		
		ArrayList<PopDTO> popList = dao.listPop(pageNum, request.getParameter("like"));
		ArrayList<PopDTO> tagList = dao.listTag();
		request.setAttribute("popList", popList);
		request.setAttribute("tagList", tagList);

		ArrayList<PopDTO> popList2 = dao.listPop2(1);
		request.setAttribute("popList2", popList2);

		ArrayList<PopDTO> popList3 = dao.listPop2(2);
		request.setAttribute("popList3", popList3);
		
		ArrayList<PopDTO> popList4 = dao.listPop2(3);
		request.setAttribute("popList4", popList4);
		
		
		
		
		

		String like = request.getParameter("like");
		
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/popularity_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script>history.replaceState({}, null, location.pathname);</script>
    <title>[인기 공유 플랜] | 부랑나랑</title>
</head>
<body>
<%= like %>
    <div id="pop_wrap">
        <div class="inner">
            <h1 class="Pp_title">인기 여행 플랜</h1>
             <div class="indicaotr">
			    <span class="prevArrow">이전</span>
			    <span class="nextArrow">다음</span>          
			</div>
            <div class="Pp_rankBox">
            
            
            	<c:forEach var="i" items="${popList2}">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
		                    <a href="?p_rownum=${i.p_rownum}">
		                    	전체인기순<img src="" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
	                        <p>${i.t_namelist}</p>
	                        <p>${i.p_title}</p>
	                    </div>
	                </div>
                </c:forEach>

            	<c:forEach var="i" items="${popList3}">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
		                    <a href="?p_rownum=${i.p_rownum}">
		                    	남자인기순<img src="" alt="">
		                    </a>
	                	</div>
	                    <div class="rk_content">
	                        <p><i class="fa-regular fa-thumbs-up"> ${i.p_like}</i></p>
	                        <p>${i.t_namelist}</p>
	                        <p>${i.p_title}</p>
	                    </div>
	                </div>
                </c:forEach>

            	<c:forEach var="i" items="${popList4}">
	                <div class="rk_box" id="box1">
	                    <div class="rk_img">
		                    <a href="?p_rownum=${i.p_rownum}">
		                    	여자인기순<img src="" alt="">
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
	    	<div class="Pp_search">
		        <div class="inner">
		            <ul class="hashTag_list">
			            <c:forEach var="i" items="${tagList}">
			                <li><a href="#">${i.t_name}</a></li>
			             </c:forEach>
		            </ul>
		        </div>
	    	</div>
		    <div class="Pp_board">
		        <div class="inner">
		        	<div class="boardBox">
		                <table id="gcTable" class="Pp_table tablesorter">
			                <thead>
			                    <tr class="Pp_table_title">
			                        <td>글번호</td>
			                        <td>글제목</td>
			                        <td>해시태그</td>
			                        <td>작성일</td>
			                        <td><a href="?pageNum=1&like=true">좋아요</a></td> <!-- get방식 쿼리스트링  현재url(분기 처리) 디폴트값 페이지넘버까지, 메인에서 넘어올때  -->
			                    </tr>
			                </thead>
			                <tbody>
			                	<c:forEach var="i" items="${popList}">
	                       		<fmt:formatDate value="${i.p_regdate}" pattern="yyyy-MM-dd" var="regdate" />
				                    <tr class="Pp_table_content">
				                        <td> ${i.p_rownum} </td>
				                        <td> <a href="?p_rownum=${i.p_rownum}">${i.p_title}</a> </td>
				                        <td> ${i.t_namelist} </td>
				                        <td> ${regdate} </td>
				                        <td> ${i.p_like} </td>
				                    </tr>
			                    </c:forEach>
			                 <tbody>
		                </table>
		            </div>
		            <div class="Pp_page">
		                ${PopDTO.pageNumber(4)}
		            </div>
		        </div>
		    </div>
	    </div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
		  $('.Pp_rankBox').slick({
			  slidesToShow: 3,
			  slidesToScroll: 3,
			  autoplay: false,
			  autoplaySpeed: 2000,
			  prevArrow: $('.prevArrow'), 
			  nextArrow: $('.nextArrow'), 
		  });
		});
	</script>
</body>
</html>