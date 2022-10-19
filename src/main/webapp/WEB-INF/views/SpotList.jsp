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
<link rel="stylesheet" href="styles/style_spotContainer.css">
</head>
<body>
	<div class="spot_black hidden" id="spot_container">
        <div class="con">
        	<!-- 검색 창 -->
            <div class="search_bar">
                <input type="search" placeholder="검색어를 입력해주세요." id="searchSpot">
               	<input type="button" value="검색" onclick="searchSpot()" class="spot_btn">
                <input type="button" onclick="cancelSpot()" value="나가기" class="spot_btn">
            </div>
            <!-- spot 탭 -->
            <ul class="search_tab">
               	<li class="spotTab_active" onclick="getSpotList('traffic')" id="tfTap">교통</li>
                <li onclick="getSpotList('accommodation')" id="acTap">숙소</li>
                <li onclick="getSpotList('restaurant')" id="reTap">맛집</li>
                <li onclick="getSpotList('event')" id="evTap">관광지</li>
            </ul>
            <div id="list_load">
            	<!-- spot list 및 search spot이 load되는 공간 -->
                <div class="spot_list">
                        <c:forEach var="trafficList" items="${trafficList}">
                           <div class="spot_con" onclick="setSpot(this)">
                               <img src="${trafficList.trafficPhoto}" class="spot_img">
                               <div>
                                   <input type="text" name="spotSerialNum" value="${trafficList.spotSerialNum}" hidden>
                                   <p class="s_name">${trafficList.trafficName}</p>
                                   <p class="s_type">${trafficList.trafficType}</p>
                                   <p class="s_pnumber">${trafficList.trafficPnumber}</p>
                                   <p class="s_loc">${trafficList.trafficLocation}</p>
                               </div>
                           </div>
                        </c:forEach>
                    <div class="blank"></div>
                </div>
            </div>
    	</div>
    </div>

   <script src="scripts/spot.js"></script>
</body>
</html>