<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="pop.popDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pop.popDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum ="1";
	}
		popDAO dao = popDAO.getInstance();
		ArrayList<popDTO> popList = dao.listpop(pageNum);
				
		int b_rownum;
		String b_title;
		String b_hashname;
		int b_hashhit;
		Timestamp b_regdate;
		int b_like;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/popularity_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <title>[인기 공유 플랜] | 부랑나랑</title>
</head>
<body>
    <div id="pop_wrap">
        <div class="inner">
            <h1 class="Pp_title">인기 여행 플랜</h1>
            <div class="Pp_rankBox">
                <div class="rk_box" id="box1">
                    <div class="rk_img">rank1<img src="" alt=""></div>
                    <div class="rk_content">
                        <p><i class="fa-regular fa-thumbs-up"> 1245</i></p>
                        <p>#맛집 #바다</p>
                        <p>해운대, 광안리 바다 뷰</p>
                    </div>
                </div>
                <div class="rk_box" id="box2">
                    <div class="rk_img">rank2<img src="" alt=""></div>
                    <div class="rk_content">
                        <p><i class="fa-regular fa-thumbs-up"> 667</i></p>
                        <p>#카페 #핫플</p>
                        <p>전포 카페거리, 카페 투어</p>
                    </div>
                </div>
                <div class="rk_box" id="box2">
                    <div class="rk_img">rank3<img src="" alt=""></div>
                    <div class="rk_content">
                        <p><i class="fa-regular fa-thumbs-up"> 475</i></p>
                        <p>#맛집</p>
                        <p>국밥투어</p>
                    </div>
                </div>
            </div>
        </div>
    
    <div class="Pp_search">
        <div class="inner">
            <ul class="hashTag_list">
                <li><a href="#">#바다</a></li>
                <li><a href="#">#맛집</a></li>
                <li><a href="#">#카페</a></li>
                <li><a href="#">#핫플</a></li>
                <li><a href="#">#바다뷰</a></li>
            </ul>
        </div>
    </div>
    <div class="Pp_board">
        <div class="inner">
                <table class="Pp_table">
                    <tr class="Pp_table_title">
                        <td>글번호</td>
                        <td>글제목</td>
                        <td>해시태그</td>
                        <td>좋아요</td>
                        <td>작성일</td>
                    </tr>
				<% for(int i =0; i<popList.size(); i++) {
					popDTO pop = popList.get(i);
					
					b_rownum = pop.getB_ROWNUM();
					b_title = pop.getB_TITLE();
					b_hashname = pop.getB_HASHNAME();
					b_hashhit = pop.getB_LIKE();
					b_regdate = pop.getB_REGDATE();
					b_like = pop.getB_LIKE();
				%>
                    <tr>
                        <td><%= b_rownum %></td>
                        <td><a href="#"><%= b_title %></a></td>
                        <td><%= b_hashname %></td>
                        <td><%= b_like %></td>
                        <td><%= b_regdate %></td>
                    </tr>
                 <% } %>
                </table>
            <div class="Pp_page">
                <%= popDTO.pageNumber(4) %>
            </div>
        </div>
    </div>
</div>
</body>
</html>