<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.ga2.buna.dao.PlanInfoDAO"%>
<%@page import="org.ga2.buna.dto.PlanInfo"%>
<%@page import="org.ga2.buna.dao.RestaurantDAO"%>
<%@page import="org.ga2.buna.dto.Restaurant"%>
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
<title>플랜 수정 | 부랑나랑</title>
<!-- css -->
<link rel="stylesheet" href="styles/normalize.css">
<link rel="stylesheet" href="styles/style.css">
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<%
	// rownum 임의 지정
	int p_rownum = 9;

	PlanDetailDAO pd_DAO = PlanDetailDAO.getInstance();
	ArrayList<PlanDetail> plan = pd_DAO.getPlanDetail(p_rownum);
	
	PlanInfo pi = null;
	PlanInfoDAO piDAO = PlanInfoDAO.getInstance();
	pi = piDAO.getPlanInfo(p_rownum);
	
	// spot restaurant로만 임의 구성
	Restaurant res = null;
	RestaurantDAO resDAO = RestaurantDAO.getInstance();
	
	// day 개수 
	int day=plan.get(plan.size()-1).getP_tripday();
	
	// timestamp -> string yyyy-mm-dd
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String firstdate = df.format(pi.getP_firstdate());
	String lastdate = df.format(pi.getP_lastdate());
%>
<!-- rownum 받아오기 -->
  	<!-- map_area 임의 배경 구성 -->
    <div class="map_area"></div>
    <div class="side_bar">
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
            								String snum = plan.get(j).getS_serialnum();
            								String sname = plan.get(j).getP_spotname();
            								res = resDAO.getRes(snum);
            								String stype = res.getR_type();
            								String sloc = res.getR_location();
            								%>
            									<div class="plan_list" id="p_list<%= i %>_<%= seq %>">
            										<div class="up_down">
            											<div class="up" onclick="goUp(this)">&#9650;</div>
            											<div class="plan_no"><%= seq %></div>
            											<div class="down" onclick="goDown(this)">&#9660;</div>
            										</div>
            										<div class="plan_main">
            											<div>img 넣을 예정</div>
            											<p>일정 <%= seq %></p>
            											<input type="text" value="<%= seq %>" name="p_seq<%= i %>" hidden>
            											<p><%= sname %></p>
            											<input type="text" value="<%= snum %>" name="s_snum<%= i %>" hidden>
            											<input type="text" value="<%= sname %>" name="s_name<%= i %>" hidden>
            											<p><%= stype %></p>
            											<input type="text" value="<%= stype %>" name="s_type<%= i %>" hidden>
            											<p><%= sloc %></p>
            											<input type="text" value="<%= sloc %>" name="s_loc<%= i %>" hidden>
            											<div class="remove_plan" onclick="removePlan(this)">X</div>
            										</div>
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
        			<input type="button" value="수정하기" class="plan_submit" onclick="editPlan('<%= p_rownum %>')">
        			<input type="button" value="취소하기" onclick="history.go(-1)" class="plan_cancle">
        		</div>
        	</form>   
        	</div>
        <div class="side_button">&#9654;</div>
    </div>
	
	
	<!-- modal -->
    <div class="black hidden">
    	<div class="modal">
    		<div class="modal_detail"></div>
        	<div class="back" onclick="cancle()">x</div>
        </div>
    </div>
    
    <jsp:include page="writeSimplePlan.jsp"></jsp:include>
    
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
</body>
</html>