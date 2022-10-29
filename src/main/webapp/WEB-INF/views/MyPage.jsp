<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>마이페이지 | 부랑나랑</title>
    <!-- css초기화 -->
    <link rel="stylesheet" href="/styles/normalize.css">
    <!-- myPage CSS 적용 -->
    <link rel="stylesheet" href="/styles/style_myPage.css">
</head>
<body>

    <jsp:include page="Gnb.jsp"/>

    <input type="hidden" value="${sessionScope.nick_s}" id="nick_s">
    <div class="inner">
        <h1>MY PAGE</h1>
        <!--nav 영역-->
        <div class="mypage_wrap">
            <ul id="mypage_nav">
                <li class="active"><a href="/mypage">나의 플랜목록</a></li>
                <li><a href="/mypage/info">회원정보수정</a></li>
            </ul>

            <!-- mypage_content 시작 -->
            <div id="mypage_content">
                <!-- 나의 플랜목록 -->
                <div id="mypage_plan">
                    <h2>나의 플랜 목록</h2>
                    <!-- 작성한 플랜이 없을 때 플랜 작성 페이지 이동 문구 -->
                    <c:if test="${infolist.size() == 0}">
                        <div class="none">
                            <p>아직 작성한 플랜이 없습니다.</p>
                            <a href="/new">새 플랜 작성하러가기</a>
                        </div>
                    </c:if>
                    <!-- 작성한 플랜이 있을 때만 플랜 정보를 출력 -->
                    <c:if test="${infolist.size() != 0 }">
                        <c:forEach var="i" begin="0" end="${infolist.size() - 1}">
                            <div class="myplan_wrap" id="plan${i}">
                                <div class="myplan_content">
                                    <div class="con">
                                        <p class="image">
                                            <img src="/images/mtop${i+1}.jpg">
                                        </p>
                                        <div class="plan_con">
                                            <div class="plantitle">
                                                <p>
                                                    <span class="bold">여행 이름 </span> ${infolist[i].planTitle}
                                                </p>
                                                <p>
                                                    <span class="bold">여행 일정</span>
                                                    ${firstDate[i]}
                                                    <!--여행 일정이 하루 이상일 때만 lastDate 출력-->
                                                    <c:if test="${firstDate[i] != lastDate[i]}">
                                                        ~ ${lastDate[i]}
                                                    </c:if>
                                                </p>
                                            </div>
                                            <div class="tag">
                                                <span class="bold">태그 </span> <b>${infolist[i].tagNameList}</b>
                                            </div>
                                            <div class="myplan_management">
                                                <!-- 버튼 -->
                                                <input type="button" class="detail" value="자세히 보기"
                                                       onclick="location.href='/detail?mypage=true&rownum=${infolist[i].planRowNumber}'">
                                                <input type="hidden" value="${infolist[i].planPublic}" class="publicCheck" id="plan${i}publiccheck">
                                                <input type="button" name="plan_share" value="일정 비공개" id="plan${i}share"
                                                       class="share"
                                                       onclick="sharecheck(${infolist[i].planRowNumber}, ${i})">
<%--                                                       onclick="sharecheck(${infolist[i].planPublic}, ${infolist[i].planRowNumber}, ${i})">--%>
                                                <input type="button" name="plan_delete" class="p_delete"
                                                       value="일정 삭제" onclick="delete_ok(${infolist[i].planRowNumber}, ${i})"><br>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
                <!--플랜 목록 끝-->
            </div>
            <!-- mypage_content끝 -->
        </div>
        <!--mypage_wrap끝-->
    </div>


<%--	<script>
        //쿼리스트링 숨겨주는 스크립트
        history.replaceState({}, null, location.pathname);
    </script>--%>
<!-- js -->
<script type="text/javascript" src="/scripts/mypage_plan.js"></script>
</body>
</html>