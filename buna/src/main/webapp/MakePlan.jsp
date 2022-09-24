<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String nickSession = (String)session.getAttribute("nick_s");
String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>플랜 작성 | 부랑나랑</title>
    <!-- css -->
    <link rel="stylesheet" href="styles/normalize.css" />
    <link rel="stylesheet" href="styles/style.css" />
    <!-- js -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  </head>
  <body>
    <!-- 아이디 있는지 없는 지 확인 -->
    <!-- map_area 임의 배경 구성 -->
    <!-- 수정 : class를 id로 변경 (김규빈) -->
    <div id="map_area" style="width: 70%; height: 100%"></div>
    <!-- 수정 : class를 id로 변경 (김규빈) -->
    <div id="side_bar">
      <!-- 여행 제목을 적게 할지
            여행 제목을 표시하면 수정 버튼도 넣을지 -->
      <div class="plan_sub">
        <p>여행 일정</p>
        <div class="edit_sub" onclick="editInfo()">수정</div>
      </div>
      <!-- class active 유무로 탭 전환 -->
      <div class="tab_detail">
        <ul class="day_plan_tab">
          <!-- <li class="active_day">day1</li> -->
        </ul>
        <form action="RestorePlan.jsp" method="post" name="makePlanForm">
          <input type="text" name="p_title" hidden />
          <input type="text" name="p_firstdate" hidden />
          <input type="text" name="p_lastdate" hidden />
          <input type="text" name="t_namelist" hidden />
          <input type="text" name="m_nickname" value="${nick}" hidden />

          <div class="day_plan_con">
            <!-- 날짜 입력 시 날짜 입력 수만큼 day plan tab 생성 -->
            <!-- 여행 날자 수에 따라 day_plan 생성 -->
          </div>
          <div class="btn_con">
            <!-- 아이디 세션 확인 후 아이디가 있을 경우 restore, 없을 경우 로그인 모달 -->
            <input
              type="button"
              value="저장하기"
              class="plan_submit"
              onclick="restore_plan()"
            />
            <input
              type="button"
              value="취소하기"
              onclick="history.go(-1)"
              class="plan_cancle"
            />
          </div>
        </form>
      </div>
      <div id="side_button">&#9654;</div>
    </div>

    <!-- modal -->
    <div class="black hidden">
      <div class="modal">
        <div class="modal_detail"></div>
        <div class="back" onclick="cancle()">x</div>
      </div>
    </div>

    <!-- planInfo -->
    <jsp:include page="writeSimplePlan.jsp"></jsp:include>
    <!-- spotList -->
    <jsp:include page="SpotContainer.jsp"></jsp:include>

    <!-- js -->
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df278366797b59b90c8d2797fb62bc3f&libraries=services"
    ></script>
    <script src="scripts/side.js"></script>
    <!-- change plan -->
    <script src="scripts/modify.js"></script>
    <!-- cancle plan -->
    <script src="scripts/cancle.js"></script>
    <!-- make plan info -->
    <script src="scripts/makePlanInfo.js"></script>
    <!-- make plan detail -->
    <script src="scripts/makePlanDetail.js"></script>
    <script src="scripts/restore.js"></script>
    <!-- js -->
    <script src="scripts/map.js"></script>
  </body>
</html>
