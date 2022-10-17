<%@page import="org.ga2.buna.dto.EventDTO"%>
<%@page import="org.ga2.buna.dao.EventDAO"%>
<%@page import="org.ga2.buna.dao.AccommodationDAO"%>
<%@page import="org.ga2.buna.dto.AccommodationDTO"%>
<%@page import="org.ga2.buna.dao.TrafficDAO"%>
<%@page import="org.ga2.buna.dto.TrafficDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.ga2.buna.dao.PlanInfoDAO"%>
<%@page import="org.ga2.buna.dto.PlanInfo"%>
<%@page import="org.ga2.buna.dao.RestaurantDAO"%>
<%@page import="org.ga2.buna.dto.RestaurantDTO"%>
<%@page import="java.util.jar.Attributes.Name"%>
<%@page import="org.ga2.buna.dto.PlanDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.ga2.buna.dao.PlanDetailDAO"%>
<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String nickSession = (String) session.getAttribute("nick_s");
	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
	/* rownum 받아와 필요한 데이터 반환 */
	int p_rownum = Integer.parseInt(request.getParameter("rownum"));

	PlanDetailDAO planDetailDAO = PlanDetailDAO.getInstance();
	ArrayList<PlanDetail> planDetail = planDetailDAO.getPlanDetail(p_rownum);

	PlanInfo planInfo = null;
	PlanInfoDAO planInfoDAO = PlanInfoDAO.getInstance();
	planInfo = planInfoDAO.getPlanInfo(p_rownum);

	/* max-tripday 계산 */
	int maxTripDay = planDetail.get(planDetail.size() - 1).getP_tripday();

	/* timestamp -> string yyyy-mm-dd 변환 */
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String firstDate = dateFormat.format(planInfo.getP_firstdate());
	String lastDate = dateFormat.format(planInfo.getP_lastdate());

	/* spot list 객체 생성 */
	TrafficDTO trafficDTO = new TrafficDTO();
	TrafficDAO trafficDAO = TrafficDAO.getInstance();
	RestaurantDTO restaurantDTO = new RestaurantDTO();
	RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
	AccommodationDTO accommodationDTO = new AccommodationDTO();
	AccommodationDAO accommodationDAO = AccommodationDAO.getInstance();
	EventDTO eventDTO = new EventDTO();
	EventDAO eventDAO = EventDAO.getInstance();

	/* plan detail에 세팅 할 spot 정보 받아올 리스트 */
	ArrayList<String> sName = new ArrayList<>();
	ArrayList<String> sPhoto = new ArrayList<>();
	ArrayList<String> sType = new ArrayList<>();
	ArrayList<String> sLoc = new ArrayList<>();
	ArrayList<String> sPnum = new ArrayList<>();

	for (int i = 0; i < planDetail.size(); i++) {
		String sNum = planDetail.get(i).getS_serialnum();
		char sCode = sNum.charAt(0);

		if (sCode == 'T') {
			trafficDTO = trafficDAO.getTraffic(sNum);
			sName.add(trafficDTO.getTf_name());
			sPhoto.add(trafficDTO.getTf_photo());
			sType.add(trafficDTO.getTf_type());
			sLoc.add(trafficDTO.getTf_location());
			sPnum.add(trafficDTO.getTf_pnumber());
		} else if (sCode == 'R') {
			restaurantDTO = restaurantDAO.getRestaurant(sNum);
			sName.add(restaurantDTO.getR_name());
			sPhoto.add(restaurantDTO.getR_photo());
			sType.add(restaurantDTO.getR_type());
			sLoc.add(restaurantDTO.getR_location());
			sPnum.add(restaurantDTO.getR_pnumber());
		} else if (sCode == 'A') {
			accommodationDTO = accommodationDAO.getAccommodation(sNum);
			sName.add(accommodationDTO.getA_name());
			sPhoto.add(accommodationDTO.getA_photo());
			sType.add(accommodationDTO.getA_type());
			sLoc.add(accommodationDTO.getA_location());
			sPnum.add(accommodationDTO.getA_pnumber());
		} else if (sCode == 'E') {
			eventDTO = eventDAO.getEvent(sNum);
			/* event는 name에 venue 사용 */
			sName.add(eventDTO.getE_venue());
			sPhoto.add(eventDTO.getE_photo());
			sType.add(eventDTO.getE_name());
			sLoc.add(eventDTO.getE_location());
			sPnum.add(eventDTO.getE_pnumber());
		}
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>내 플랜 수정 | 부랑나랑</title>
<!-- css -->
<link rel="stylesheet" href="../../styles/normalize.css">
<link rel="stylesheet" href="../../styles/style.css">
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	<!-- 메인 지도  -->
	<div id="map"></div>

	<!-- 사이드바  -->
	<div id="side_bar">
		<!-- plan 제목 -->
		<div class="plan_title" id="plan_title">
			<p><%= planInfo.getP_title() %></p>
			<div class="edit_title" onclick="getPlanInfo()">수정</div>
		</div>
		<!-- plan_detail container -->
		<div class="plan_detail_container">
			<!-- 상단의 day tab-->
			<ul class="day_tab_container" id="day_tab_con">
				<!-- day_tab 생성 -->
				<%
					for (int i = 1; i <= maxTripDay; i++) {
						if (i == 1) {
				%>
					<li class="active_day" onclick="tabScroll(this)" id="day<%=i%>">Day<%=i%></li>
				<%
						} else {
				%>
					<li onclick="tabScroll(this)" id="day<%=i%>">Day<%=i%></li>
				<%
						}
					}
				%>
			</ul>

			<form action="EditPlanOk.jsp" method="post" name="makePlanForm">
				<!-- 반환한  planInfo 정보 저장 -->
				<input type="text" name="p_title" hidden value="<%=planInfo.getP_title()%>">
				<input type="text" name="p_firstdate" hidden value="<%=firstDate%>">
				<input type="text" name="p_lastdate" hidden value="<%=lastDate%>">
				<input type="text" name="t_namelist" hidden value="<%=planInfo.getT_namelist()%>">
				<input type="text" name="m_nickname" value="${nick}" hidden />

				<div class="plan_lists_container" id="plan_lists_container">
				<%
					int pSeq = 0;
					for (int day = 1; day <= maxTripDay; day++){
				%>
					<!-- tripday 수 만큼 day_plan 생성  -->
					<div id="day_plan<%=day%>">
						<div class="plan_day_title">Day<%=day%></div>
						<input type="text" name="day<%=day%>" value="<%=day%>" hidden>
					<%

						/* tripday의 planSequence 만큼 plan_list 생성 */
						for (int j = pSeq; j < planDetail.size(); j++) {
							if (planDetail.get(j).getP_tripday() != day) {
								pSeq = j;
								break;
							}

							int seq = planDetail.get(j).getP_sequence();
							String sNum = planDetail.get(j).getS_serialnum();
						%>
						<div class="plan_list" id="plan_list<%=day%>_<%=seq%>">
							<div class="change_plan_container">
								<div class="change_up_button" onclick="changeUpPlan(this)">&#9650;</div>
								<div class="plan_seq"><%=seq%></div>
								<div class="change_down_button" onclick="changeDownPlan(this)">&#9660;</div>
							</div>
						<%
						%>
							<!-- spot 정보를 기반으로 plan_main 생성 -->
							<div class="plan_detail">
								<img src="<%=sPhoto.get(j)%>">
								<p>일정<%=seq%></p>
								<input type="text" value="<%=seq%>" name="p_seq<%=day%>" id="p_seq<%=day%>_<%=seq%>" hidden>
								<p><%=sName.get(j)%></p>
								<input type="text" value="<%=sNum%>" name="s_snum<%=day%>" hidden>
								<input type="text" value="<%=sName.get(j)%>" name="s_name<%=day%>"id="s_name<%=day%>_<%=seq%>" hidden>
								<p><%=sType.get(j)%></p>
								<input type="text" value="<%=sType.get(j)%>" name="s_type<%=day%>" hidden>
								<p><%=sLoc.get(j)%></p>
								<input type="text" value="<%=sLoc.get(j)%>" name="s_loc<%=day%>" id="s_loc<%=day%>_<%=seq%>" hidden>
								<input type="text" value="<%=sPnum.get(j)%>" name="s_pnum<%=day%>" id="s_pnum<%=day%>_<%=seq%>" hidden>
								<div class="remove_plan_button" onclick="removePlan(this)">X</div>
							</div>
						</div>
						<%
						}
						%>
						<input type='button' onclick='getSpotContainer(this)' class='add_plan_button' id="add_plan<%=day%>" value='+'>
					</div>
				<%
					}
				%>
					<div class="blank"></div>
				</div>
				<div class="button_container">
					<input type="button" value="수정하기" class="plan_submit" onclick="planCheck()">
					<input type="button" value="취소하기" onclick="location.href='PlanDetail.jsp?rownum=<%=p_rownum%>'" class="plan_cancel">
				</div>
			</form>
		</div>
		<div id="side_button">&#9654;</div>
	</div>

	<!-- planInfo -->
	<jsp:include page="MakePlanModal.jsp"></jsp:include>
	<!-- spotList -->
	<jsp:include page="SpotContainer.jsp"></jsp:include>

	<!-- kakao map api -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df278366797b59b90c8d2797fb62bc3f&libraries=services"></script>
	<!-- map -->
	<script src="../../scripts/map.js"></script>
	<!-- js -->
	<script src="../../scripts/side.js"></script>
	<!-- change plan -->
	<script src="../../scripts/changePlanDetail.js"></script>
	<!-- make plan info -->
	<script src="../../scripts/makePlanInfo.js"></script>
	<script src="../../scripts/editPlanInfo.js"></script>
	
	<!-- edit plan -->
	<script src="../../scripts/dayCookie.js"></script>
	<!-- 페이지 초기화 -->
	<script src="../../scripts/planOnload.js"></script>
	<script src="../../scripts/makePlanDetail.js"></script>
	<script src="../../scripts/restorePlan.js"></script>

</body>
</html>