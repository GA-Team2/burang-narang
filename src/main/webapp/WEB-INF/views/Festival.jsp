<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">

    <!-- festival style -->
    <link rel="stylesheet" href="/styles/normalize.css">
    <link rel="stylesheet" href="/styles/style_festival.css">

    <!-- js -->
    <script src="/scripts/festival.js" charset="utf-8"></script>

    <!-- 쿼리스트링 숨기기 -->
    <script>
        history.replaceState({}, null, location.pathname);
    </script>

    <title>축제 / 이벤트 | 부랑나랑</title>
</head>
<body id="body">
    <!-- gnb -->
    <jsp:include page="Gnb.jsp">
        <jsp:param name="festivalPage" value="on"/>
    </jsp:include>

    <section id="fest_wrap">
        <!-- js로 nick 넘겨서 로그인 여부 체크 -->
        <c:set var="nick" value="${sessionScope.nick_s}"/>
        <input type="hidden" id="nickCheck" value="${nick}">

        <div class="inner">
            <!-- 타이틀 -->
            <h1 class="fest_title">축제 / 이벤트</h1>

            <!-- 탭메뉴 -->
            <div class="fest_month">
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <!-- 탭메뉴 전체 -->
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="pills-allmonth-tab"
                                data-bs-toggle="pill" data-bs-target="#pills-allmonth"
                                type="button" role="tab" aria-controls="pills-allmonth"
                                aria-selected="true">전체
                        </button>
                    </li>
                    <!-- 탭메뉴 1월 ~ 12월 -->
                    <c:forEach var="i" begin="1" end="12">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="pills-${i}month-tab"
                                    data-bs-toggle="pill" data-bs-target="#pills-${i}month"
                                    type="button" role="tab" aria-controls="pills-${i}month"
                                    aria-selected="false">${i}월
                            </button>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <!-- 탭메뉴 끝 -->

            <!-- 이벤트 리스트. 시작날짜(월)를 분기처리 해당 월마다 출력 -->
            <div class="fest_list">
                <div class="tab-content" id="pills-tabContent">

                    <!-- 전체 리스트  -->
                    <div class="tab-pane fade show active fest_hotList"
                         id="pills-allmonth" role="tabpanel"
                         aria-labelledby="pills-allmonth-tab">
                        <c:forEach var="i" items="${list}">
                            <div class="fest_box" id="box1">
                                <div class="fest_img">
                                    <a href="${i.eventUrl}" target="_blank"> <img
                                            src="${i.eventPhoto}" alt="">
                                    </a>
                                </div>
                                <div class="fest_content">
                                    <p>${i.eventName}</p>
                                </div>
                                <div class="planAdd">
                                    <!-- 플랜 작성 페이지로 이동 -->
                                    <a href="/new"
                                       onclick="return click_on()">내 플랜에 추가</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                    <!-- 1월 ~ 12월 행사 리스트 -->
                    <c:forEach var="j" begin="1" end="12">
                        <div class="tab-pane fade fest_hotList" id="pills-${j}month"
                             role="tabpanel" aria-labelledby="pills-${j}month-tab">
                            <c:forEach var="i" items="${list}">
                                <!-- startdate에서 날짜형식으로 M만 뽑음 -->
                                <fmt:formatDate var="startdate" value="${i.eventStartDate}"
                                                pattern="M"/>
                                <!-- M(월) = 1~12(월) -->
                                <c:if test="${startdate == j}">
                                    <div class="fest_box" id="box1">
                                        <div class="fest_img">
                                            <a href="${i.eventUrl}" target="_blank"> <img
                                                    src="${i.eventPhoto}" alt="">
                                            </a>
                                        </div>
                                        <div class="fest_content">
                                            <p>${i.eventName}</p>
                                        </div>
                                        <div class="planAdd">
                                            <a href="/new"
                                               onclick="return click_on()">내 플랜에 추가</a>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!-- 이벤트 리스트 끝 -->

        </div>
    </section>

    <!-- Bootstrap -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</body>
</html>