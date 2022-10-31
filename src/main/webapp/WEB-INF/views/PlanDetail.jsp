<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>여행 일정표 | 부랑나랑</title>
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/style_myPlanDetail.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <!-- 추천 아이콘 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>

<div class="detail_container">
    <div id="map" style="width: 40%; height: 100%"></div>

    <input type="hidden" value="${sessionScope.nick_s}" id="nick_s">
    <div class="aside">
        <h2>
            <span>${list.get(0).memberNickname}</span>님의 여행 일정표
        </h2>

        <!--intro_wrap 시장-->
        <div class="intro_wrap">
            <!--타이틀 시작-->
            <div class="intro">
                <h3>${list.get(0).planTitle}</h3>
                <p>
                    <c:if test="${list.get(0).tagNamelist != null}">
                        ${list.get(0).tagNamelist}
                    </c:if>
                </p>
            </div>
            <!--타이틀 끝-->

            <!-- 좋아요 -->
            <div class="like">
                <a onclick="likeAjax(${rownum})">
                    <i class="xi-heart-o xi-2x" id="like"></i>
                </a>
                <b id="likeNum">${likeNum}</b>
                <input type="hidden" id="likecheck" value="${checkLike}">
            </div>
            <!--좋아요 끝-->
        </div>
        <!--introwrap 끝-->

        <!--일정-->
        <div class="day_wrap">
            <!--일자별 일정-->
            <c:forEach var="detail" items="${list}" varStatus="conS">
                <div class="container" id="container${conS.index}">
                    <div class="tripday">
                        DAY <span>${detail.planTripday}</span><br>
                            ${fn:substring(detail.planTripdate, 2, 10)}
                    </div>
                    <c:forEach var="schedule" items="${detail.planScheduleDTO}" varStatus="scheS">
                        <div class="schedule">
                            <p class="spotname">${schedule.planSpotname}</p>
                            <div class="circle"></div>
                            <div class="edge"></div>
                            <p class="location">${schedule.spotLocation}</p>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>
            <!--일자별 일정 끝-->

            <!--버튼-->
            <div class="management">
                <c:choose>
                    <c:when test="${pop == 'true'}">
                        <input type="button" name="planedit" value="플랜가져오기"
                               onclick="location.href='edit?rownum=${rownum}&pop=true'">
                        <input type="button" name="recommend" value="목록"
                               onclick="location.href='/popularity'">
                        <br>
                    </c:when>
                    <c:otherwise>
                        <input type="button" name="edit" value="수정"
                               onclick="location.href='edit?mypage=true&rownum=${rownum}'">
                        <input type="button" name="cancle" value="돌아가기"
                               onclick="cancle_location('${mypage}')">
                    </c:otherwise>
                </c:choose>
            </div>
            <!--버튼 끝-->
        </div>
        <!--일정 끝-->
    </div>
    <!--aside 끝-->
</div>
<!--detail_container 끝-->

<!-- js -->
<script type="text/javascript"
        src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=39s5mj7qep&submodules=geocoder"></script>

<!-- js -->
<script src="scripts/map.js"></script>
<script src="scripts/myplan.js"></script>

</body>
</html>