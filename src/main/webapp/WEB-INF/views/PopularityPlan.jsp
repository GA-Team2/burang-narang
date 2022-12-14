<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- popularityPlan style -->
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/style_popularity.css">

    <!-- TOP3 따봉아이콘(font-awesome) -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

    <!-- TOP3 slick slide -->
    <link rel="stylesheet" type="text/css"
          href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <!-- google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
            rel="stylesheet">

    <!-- js -->
    <script type="text/javascript"
            src="http://code.jquery.com/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>

    <!-- slick slide -->
    <script type="text/javascript"
            src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

    <!-- slick slide custom -->
    <script src="scripts/popularityPlan.js" charset="utf-8"></script>

    <!-- 쿼리스트링 숨기기 -->
    <script>
        history.replaceState({}, null, location.pathname);
    </script>

    <title>인기 여행 플랜 | 부랑나랑</title>
</head>
<body>
    <!-- gnb  -->
    <jsp:include page="Gnb.jsp">
        <jsp:param name="popularityPage" value="on"/>
    </jsp:include>

    <div id="pop_wrap">
        <!-- js로 nick 넘겨서 로그인 여부 체크 -->
        <c:set var="nick" value="${sessionScope.nick_s}"/>
        <input type="hidden" id="nickCheck" value="${nick}">

        <div class="inner">
            <!-- 타이틀 -->
            <h1 class="Pp_title">인기 여행 플랜</h1>
            <div class="indicaotr">
                <span class="prevArrow">이전</span> <span class="nextArrow">다음</span>
            </div>
            <!-- 타이틀 끝 -->

            <!-- TOP3 부분 분류별 반복 -->
            <div class="Pp_rankBox">
                <!-- TOP3 전체 목록 -->
                <c:forEach var="i" items="${popTopAll}" varStatus="status">
                    <div class="rk_box" id="box1">
                        <div class="rk_img">
                            <p>전체 인기 ${status.count}위</p>
                            <a href="/detail?rownum=${i.planRowNumber}&pop=true"
                               onclick="return click_on();"> <img
                                    src="images/top${status.count}.jpg" alt="">
                            </a>
                        </div>
                        <div class="rk_content">
                            <div>
                                <p>
                                    <i class="fa-regular fa-user"> ${i.memberNickName}</i>
                                    <i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
                                </p>
                                <p>${i.tagNameList}</p>
                                <p>${i.planTitle}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <!-- TOP3 남자 목록 -->
                <c:forEach var="i" items="${popTopMan}" varStatus="status">
                    <div class="rk_box" id="box1">
                        <div class="rk_img">
                            <p>남자 인기 ${status.count}위</p>
                            <a href="/detail?rownum=${i.planRowNumber}&pop=true"
                               onclick="return click_on();"> <img
                                    src="images/mtop${status.count}.jpg" alt="">
                            </a>
                        </div>
                        <div class="rk_content">
                            <div>
                                <p>
                                    <i class="fa-regular fa-user"> ${i.memberNickName}</i>
                                    <i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
                                </p>
                                <p>${i.tagNameList}</p>
                                <p>${i.planTitle}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <!-- TOP3 여자 목록 -->
                <c:forEach var="i" items="${popTopWoman}" varStatus="status">
                    <div class="rk_box" id="box1">
                        <div class="rk_img">
                            <p>여자 인기 ${status.count}위</p>
                            <a href="/detail?rownum=${i.planRowNumber}&pop=true"
                               onclick="return click_on();"> <img
                                    src="images/wtop${status.count}.jpg" alt="">
                            </a>
                        </div>
                        <div class="rk_content">
                            <div>
                                <p>
                                    <i class="fa-regular fa-user"> ${i.memberNickName}</i>
                                    <i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
                                </p>
                                <p>${i.tagNameList}</p>
                                <p>${i.planTitle}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <!-- TOP3 20대 목록 -->
                <c:forEach var="i" items="${popTop20}" varStatus="status">
                    <div class="rk_box" id="box1">
                        <div class="rk_img">
                            <p>20대 인기 ${status.count}위</p>
                            <a href="/detail?rownum=${i.planRowNumber}&pop=true"
                               onclick="return click_on();"> <img
                                    src="images/2top${status.count}.jpg" alt="">
                            </a>
                        </div>
                        <div class="rk_content">
                            <div>
                                <p>
                                    <i class="fa-regular fa-user"> ${i.memberNickName}</i>
                                    <i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
                                </p>
                                <p>${i.tagNameList}</p>
                                <p>${i.planTitle}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <!-- TOP3 30대 목록 -->
                <c:forEach var="i" items="${popTop30}" varStatus="status">
                    <div class="rk_box" id="box1">
                        <div class="rk_img">
                            <p>30대 인기 ${status.count}위</p>
                            <a href="/detail?rownum=${i.planRowNumber}&pop=true"
                               onclick="return click_on();"> <img
                                    src="images/3top${status.count}.jpg" alt="">
                            </a>
                        </div>
                        <div class="rk_content">
                            <div>
                                <p>
                                    <i class="fa-regular fa-user"> ${i.memberNickName}</i>
                                    <i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
                                </p>
                                <p>${i.tagNameList}</p>
                                <p>${i.planTitle}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <!-- TOP3 40대 목록 -->
                <c:forEach var="i" items="${popTop40}" varStatus="status">
                    <div class="rk_box" id="box1">
                        <div class="rk_img">
                            <p>40대 인기 ${status.count}위</p>
                            <a href="/detail?rownum=${i.planRowNumber}&pop=true"
                               onclick="return click_on();"> <img
                                    src="images/4top${status.count}.jpg" alt="">
                            </a>
                        </div>
                        <div class="rk_content">
                            <div>
                                <p>
                                    <i class="fa-regular fa-user"> ${i.memberNickName}</i>
                                    <i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
                                </p>
                                <p>${i.tagNameList}</p>
                                <p>${i.planTitle}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <!-- TOP3 50대 목록 -->
                <c:forEach var="i" items="${popTop50}" varStatus="status">
                    <div class="rk_box" id="box1">
                        <div class="rk_img">
                            <p>50대 인기 ${status.count}위</p>
                            <a href="/detail?rownum=${i.planRowNumber}&pop=true"
                               onclick="return click_on();"> <img
                                    src="images/5top${status.count}.jpg" alt="">
                            </a>
                        </div>
                        <div class="rk_content">
                            <div>
                                <p>
                                    <i class="fa-regular fa-user"> ${i.memberNickName}</i>
                                    <i class="fa-regular fa-thumbs-up"> ${i.planLike}</i>
                                </p>
                                <p>${i.tagNameList}</p>
                                <p>${i.planTitle}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- TOP3 부분 분류별 반복 끝-->

            <!-- 인기 해시태그 목록 -->
            <div class="Pp_search">
                <p>#인기 태그</p>
                <div>
                    <ul class="hashTag_list">
                        <li><a href="/popularity">전체</a></li>
                        <c:forEach var="i" items="${popTag}" varStatus="status">
                            <li><a onclick="searchAjax(${status.count})">
                                    ${i.tagName}
                            </a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!-- 인기 해시태그 목록 끝 -->

            <!-- 게시판 목록 -->
            <div class="Pp_board">
                <div class="inner">
                    <div class="boardBox">
                        <table id="gcTable" class="Pp_table tablesorter">
                            <thead>
                            <tr class="Pp_table_title" id="title_board">
                                <td><a href="/popularity">글번호</a></td>
                                <td>글제목</td>
                                <td>해시태그</td>
                                <td>작성자</td>
                                <td>작성일</td>
                                <td><a href="?like=true">추천</a></td>
                            </tr>
                            </thead>
                            <tbody id="searchBody">
                            <c:forEach var="i" items="${popBoard}">
                                <fmt:formatDate value="${i.planRegisterDate}" pattern="yyyy-MM-dd"
                                                var="planRegisterDate"/>
                            <tr class="Pp_table_content">
                                <td>${i.planRowNumber}</td>
                                <td><a
                                        href="/detail?rownum=${i.planRowNumber}&pop=true"
                                        onclick="return click_on()">${i.planTitle}</a></td>
                                <td>
                                    <div class="etc">${i.tagNameList}</div>
                                </td>
                                <td>${i.memberNickName}</td>
                                <td>${planRegisterDate}</td>
                                <td>${i.planLike}</td>
                            </tr>
                            </c:forEach>
                            <tbody>
                        </table>
                    </div>
                    <!-- 게시판 목록 끝 -->


                    <!-- 페이징 -->
                    <div class="Pp_page" id="Pp_page">
                        ${pagingBoard}
                    </div>
                    <!-- 페이징 끝-->

                    <!-- 내 게시글 보기 버튼 -->
                    <div class="myboard">
                        <c:choose>
                            <c:when test="${nick ne null}">
                                <input type="button" value="내 게시글 보기" onclick="nickAjax('${nick}')">
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>