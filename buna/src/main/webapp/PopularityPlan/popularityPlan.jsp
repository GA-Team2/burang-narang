<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="pop.PopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pop.PopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum ="1";
	}
		pop.PopDAO dao = PopDAO.getInstance();
		ArrayList<PopDTO> popList = dao.listPop(pageNum, request.getParameter("like"));
		ArrayList<PopDTO> popList2 = dao.listPop();
		ArrayList<PopDTO> tagList = dao.listTag();
		
		String like = request.getParameter("like");
		
		int p_rownum;
		String p_title;
		String t_namelist;
		Timestamp p_regdate;
		int p_like;
		
		String t_name;
		int t_hit;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/popularity_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
    <title>[인기 공유 플랜] | 부랑나랑</title>
</head>
<body>
<%= like %>
    <div id="pop_wrap">
        <div class="inner">
            <h1 class="Pp_title">인기 여행 플랜</h1>
            <div class="Pp_rankBox">
            <% for(int i=0; i<popList2.size();i++){ 
            	PopDTO pop = popList2.get(i);
            	p_rownum = pop.getP_rownum();
            	p_title = pop.getP_title();
            	t_namelist = pop.getT_namelist();
            	p_regdate = pop.getP_regdate();
            	p_like = pop.getP_like();
            %>
                <div class="rk_box" id="box1">
                    <div class="rk_img">rank<%= i+1 %><a href="?p_rownum=<%= p_rownum %>"><img src="" alt=""></a></div>
                    <div class="rk_content">
                        <p><i class="fa-regular fa-thumbs-up"><%= p_like %></i></p>
                        <p><%= t_namelist %></p>
                        <p><%= p_title %></p>
                    </div>
                </div>
             <%} %>
            </div>
        </div>
    
    <div class="Pp_search">
        <div class="inner">
            <ul class="hashTag_list">
            <% for(int i=0; i<tagList.size();i++){
            	PopDTO tag = tagList.get(i);
            	t_name = tag.getT_name();
            	%>
                <li><a href="#"><%= t_name %></a></li>
           <%} %> 
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
                        <td><a href="?like=true">좋아요</a></td> <!-- get방식 쿼리스트링  현재url(분기 처리) 디폴트값 페이지넘버까지, 메인에서 넘어올때  -->
                    </tr>
                </thead>
                <tbody>
					<%
						for(int i =0; i<popList.size(); i++) {
								PopDTO pop = popList.get(i);
								p_rownum = pop.getP_rownum();
				            	p_title = pop.getP_title();
				            	t_namelist = pop.getT_namelist();
				            	p_regdate = pop.getP_regdate();
				            	p_like = pop.getP_like();
					%>
                    <tr class="Pp_table_content">
                        <td><%=p_rownum%></td>
                        <td><a href="?p_rownum=<%= p_rownum %>"><%=p_title%></a></td>
                        <td><%=t_namelist%></td>
                        <td><%= sdf.format(p_regdate) %></td>
                        <td><%=p_like%></td>
                    </tr>
                 <%
                 	}
                 %>
                 <tbody>
                </table>
            </div>
            <div class="Pp_page">
                <%=PopDTO.pageNumber(4)%>
            </div>
        </div>
    </div>
</div>
<!-- <script type="text/javascript">
	$(document).ready(function(){
	      $("#gcTable").tablesorter();
	   });
</script> -->
</body>
</html>