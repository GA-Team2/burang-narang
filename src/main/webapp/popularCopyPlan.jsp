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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 플랜 수정 | 부랑나랑</title>
<!-- css -->
<link rel="stylesheet" href="styles/normalize.css">
<link rel="stylesheet" href="styles/style.css">
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
<%
	int p_rownum = Integer.parseInt(request.getParameter("rownum"));
	String pop = request.getParameter("pop");

	PlanDetailDAO pd_DAO = PlanDetailDAO.getInstance();
	ArrayList<PlanDetail> plan = pd_DAO.getPlanDetail(p_rownum);
	
	PlanInfo pi = null;
	PlanInfoDAO piDAO = PlanInfoDAO.getInstance();
	pi = piDAO.getPlanInfo(p_rownum);
	
	// day 개수 
	int day=plan.get(plan.size()-1).getP_tripday();
	
	// timestamp -> string yyyy-mm-dd
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String firstdate = df.format(pi.getP_firstdate());
		String lastdate = df.format(pi.getP_lastdate());
	
	/* spot list */
	TrafficDTO traffic = new TrafficDTO();
	TrafficDAO tfDAO = TrafficDAO.getInstance();
	RestaurantDTO restaurant = new RestaurantDTO();
	RestaurantDAO reDAO = RestaurantDAO.getInstance();
	AccommodationDTO accommodation = new AccommodationDTO();
	AccommodationDAO acDAO = AccommodationDAO.getInstance();
	EventDTO event = new EventDTO();
	EventDAO evDAO = EventDAO.getInstance();
%>

<!-- rownum 받아오기 -->
  	<!-- map_area 임의 배경 구성 -->
    <div id="map_area" style="width: 70%; height: 100%"></div>
    <div id="side_bar">
    <div class="plan_sub">
        	<p><%= pi.getP_title() %></p>
        	<div class="edit_sub" onclick="editInfo()">수정</div>
        </div>
        <div class="tab_detail">
            <ul class="day_plan_tab">
            	<%
            		for(int i=1; i<=day; i++){
            			if(i==1){
            				%>
            					<li class="active_day">Day<%= i %></li>
            				<%
            			}else{
            				%>
        					<li>Day<%= i %></li>
        					<%
            			}
            		}
            	%>
             </ul>
             <form action="EditPlanOk.jsp" method="post" name="editPlanForm">
             	<input type="text" name="p_title" hidden value="<%= pi.getP_title() %>">
             	<input type="text" name="p_firstdate" hidden value="<%= firstdate %>">
             	<input type="text" name="p_lastdate" hidden value="<%= lastdate %>">
             	<input type="text" name="t_namelist" hidden value="<%= pi.getT_namelist() %>">
             	<div class="day_plan_con">
             		<%
             		for(int i=1; i<=day; i++){
        				%>
        					<div class="day_plan day_plan<%= i %>">
        						<div class="plan_day">Day<%= i %></div>
        						<input type="text" name="day<%= i %>" value="<%= i %>" hidden>
        						<%
        							for(int j=0; j<plan.size(); j++){
        								if(plan.get(j).getP_tripday() != i) continue;
        								
        								int seq = plan.get(j).getP_sequence();
        								String sNum = plan.get(j).getS_serialnum();
        								String sName = plan.get(j).getP_spotname();
        								%>
        								<div class="plan_list" id="p_list<%= i %>_<%= seq %>">
        									<div class="up_down">
        										<div class="up" onclick="goUp(this)">&#9650;</div>
        										<div class="plan_no"><%= seq %></div>
        										<div class="down" onclick="goDown(this)">&#9660;</div>
        									</div>
        								<%
										char sCode = sNum.charAt(0);
        								
        								
        								// 시리얼 넘버에 따라 출력할 스팟의 데이터 설정
        								if(sCode == 'T') {
        									traffic = tfDAO.getTraffic(sNum);
        									String sType = traffic.getTf_type();
        									String pNum = traffic.getTf_pnumber();
        									String sLoc = traffic.getTf_location();
        									String sPhoto = traffic.getTf_photo();
        									%>
        										<div class="plan_main">
        												<img src="<%= sPhoto %>" class="spot_img">
        											<p>일정 <%= seq %></p>
        											<input type="text" value="<%= seq %>" name="p_seq<%= i %>" id="p_seq<%= i %>_<%= seq %>" hidden>
            											<p><%= sName %></p>
            											<input type="text" value="<%= sNum %>" name="s_snum<%= i %>" id="s_snum<%= i %>_<%= seq %>" hidden>
            											<input type="text" value="<%= sName %>" name="s_name<%= i %>" id="s_name<%= i %>_<%= seq %>" hidden>
            											<p><%= sType %></p>
            											<input type="text" value="<%= sType %>" name="s_type<%= i %>" id="s_type<%= i %>_<%= seq %>" hidden>
            											<p><%= sLoc %></p>
            											<input type="text" value="<%= sLoc %>" name="s_loc<%= i %>" id="s_loc<%= i %>_<%= seq %>" hidden>
            											<input type="text" value="<%= pNum %>" name="s_pnum<%= i %>" id="s_pnum<%= i %>_<%= seq %>" hidden>
            											<div class="remove_plan" onclick="removePlan(this)">X</div>
        										</div>
        									
        					
        									<%
        								}else if(sCode == 'R') {
        									restaurant = reDAO.getRestaurant(sNum);
        									String sType = restaurant.getR_type();
        									String pNum = restaurant.getR_pnumber();
        									String sLoc = restaurant.getR_location();
        									String sPhoto = restaurant.getR_photo();
        									%>
        										<div class="plan_main">
        										<img src="<%= sPhoto %>" class="spot_img">
        											<p>일정 <%= seq %></p>
        											<input type="text" value="<%= seq %>" name="p_seq<%= i %>" id="p_seq<%= i %>_<%= seq %>" hidden>
            											<p><%= sName %></p>
            											<input type="text" value="<%= sNum %>" name="s_snum<%= i %>" id="s_snum<%= i %>_<%= seq %>" hidden>
            											<input type="text" value="<%= sName %>" name="s_name<%= i %>" id="s_name<%= i %>_<%= seq %>" hidden>
            											<p><%= sType %></p>
            											<input type="text" value="<%= sType %>" name="s_type<%= i %>" id="s_type<%= i %>_<%= seq %>" hidden>
            											<p><%= sLoc %></p>
            											<input type="text" value="<%= sLoc %>" name="s_loc<%= i %>" id="s_loc<%= i %>_<%= seq %>" hidden>
            											<input type="text" value="<%= pNum %>" name="s_pnum<%= i %>" id="s_pnum<%= i %>_<%= seq %>" hidden>
            											<div class="remove_plan" onclick="removePlan(this)">X</div>
        										</div>
        					
        									<%
        								}else if(sCode == 'A') {
        									accommodation = acDAO.getAccommodation(sNum);
        									String sType = accommodation.getA_type();
        									String pNum = accommodation.getA_pnumber();
        									String sLoc = accommodation.getA_location();
        									String sPhoto = accommodation.getA_photo();
        									%>
        										<div class="plan_main">
        											<img src="<%= sPhoto %>" class="spot_img">
        											<p>일정 <%= seq %></p>
        											<input type="text" value="<%= seq %>" name="p_seq<%= i %>" id="p_seq<%= i %>_<%= seq %>" hidden>
            											<p><%= sName %></p>
            											<input type="text" value="<%= sNum %>" name="s_snum<%= i %>" id="s_snum<%= i %>_<%= seq %>" hidden>
            											<input type="text" value="<%= sName %>" name="s_name<%= i %>" id="s_name<%= i %>_<%= seq %>" hidden>
            											<p><%= sType %></p>
            											<input type="text" value="<%= sType %>" name="s_type<%= i %>" id="s_type<%= i %>_<%= seq %>" hidden>
            											<p><%= sLoc %></p>
            											<input type="text" value="<%= sLoc %>" name="s_loc<%= i %>" id="s_loc<%= i %>_<%= seq %>" hidden>
            											<input type="text" value="<%= pNum %>" name="s_pnum<%= i %>" id="s_pnum<%= i %>_<%= seq %>" hidden>
            											<div class="remove_plan" onclick="removePlan(this)">X</div>
        										</div>
        					
        									<%
        								}else if(sCode == 'E') {
        									event = evDAO.getEvent(sNum);
        									sName = event.getE_venue();
        									String sType = event.getE_name();
        									String pNum = event.getE_pnumber();
        									String sLoc = event.getE_location();
        									String sPhoto = event.getE_photo();
        									%>
        										<div class="plan_main">
        										<img src="<%= sPhoto %>" class="spot_img">
        											<p>일정 <%= seq %></p>
        											<input type="text" value="<%= seq %>" name="p_seq<%= i %>" id="p_seq<%= i %>_<%= seq %>" hidden>
            											<p><%= sName %></p>
            											<input type="text" value="<%= sNum %>" name="s_snum<%= i %>" id="s_snum<%= i %>_<%= seq %>" hidden>
            											<input type="text" value="<%= sName %>" name="s_name<%= i %>" id="s_name<%= i %>_<%= seq %>" hidden>
            											<p><%= sType %></p>
            											<input type="text" value="<%= sType %>" name="s_type<%= i %>" id="s_type<%= i %>_<%= seq %>" hidden>
            											<p><%= sLoc %></p>
            											<input type="text" value="<%= sLoc %>" name="s_loc<%= i %>" id="s_loc<%= i %>_<%= seq %>" hidden>
            											<input type="text" value="<%= pNum %>" name="s_pnum<%= i %>" id="s_pnum<%= i %>_<%= seq %>" hidden>
            											<div class="remove_plan" onclick="removePlan(this)">X</div>
        										</div>
        										
        									<%
        								}
        								%>
        								</div>
        								<%
        							}
        						%>
        						<input type='button' onclick='getSpotList(this)' class='plan_btn btn_day<%= i %>' value='+'>
         					</div>
        				<%
        			}
         		%>
         		<div class="blank"></div>
        	</div>
    		<div class="btn_con">
    			<input type="button" value="저장하기" class="plan_submit" onclick="restore_plan()">
    			<input type="button" value="취소하기" onclick="location.href='planDetail.jsp?rownum=<%= p_rownum %>&pop=<%= pop %>'" class="plan_cancle">
    		</div>
    	</form>   
    	</div>
    <div class="side_button">&#9654;</div>
   
</div>
<!-- planInfo -->
<jsp:include page="writeSimplePlan.jsp"></jsp:include>
<!-- spotList -->
<jsp:include page="SpotContainer.jsp"></jsp:include>

<!-- kakao map api -->
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df278366797b59b90c8d2797fb62bc3f&libraries=services"
    ></script>
    <script src="scripts/map.js"></script>
<!-- js -->
<script src="scripts/side.js"></script>
<!-- change plan -->
<script src="scripts/modify.js"></script>
<!-- cancle plan -->
<script src="scripts/cancle.js"></script>
<!-- make plan info -->
<script src="scripts/makePlanInfo.js"></script>
<!-- make plan detail -->
<script src="scripts/editPlan.js"></script>   
<script src="scripts/restore.js"></script>
    <!-- map -->
        

</body>
</html>