<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 
	spot list 띄우고 css 설정하는 container
 -->
<title>스팟 목록 | 부랑나랑</title>
<!--css-->
<link rel="stylesheet" href="styles/normalize.css">
<link rel="stylesheet" href="styles/style_spotList.css">
</head>
<body>
	<div class="spot_area hidden" id="spot_area">
        <div class="spot_modal_container">
        	<!-- 검색 창 -->
            <div class="spot_search_wrap">
                <input type="search" placeholder="검색어를 입력해주세요." id="spot_search_bar">
               	<input type="button" value="검색" onclick="searchSpot()" class="spot_btn">
                <input type="button" onclick="toggleSpotArea()" value="나가기" class="spot_btn">
            </div>
            <!-- spot 탭 -->
            <ul class="spot_tab_container">
               	<li class="spot_tab_active" onclick="getSpotList('traffic')" id="tf_tab">교통</li>
                <li onclick="getSpotList('accommodation')" id="ac_tab">숙소</li>
                <li onclick="getSpotList('restaurant')" id="re_tab">맛집</li>
                <li onclick="getSpotList('event')" id="ev_tab">관광지</li>
            </ul>
            <div class="spot_list_container" id="spot_list">
            	<!-- spot 데이터가  load되는 공간 -->
            </div>
    	</div>
    </div>

   <script src="scripts/spot.js"></script>
</body>
</html>