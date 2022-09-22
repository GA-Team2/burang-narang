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
	int p_rownum = 1;

	PlanDetailDAO pd_DAO = PlanDetailDAO.getInstance();
	ArrayList<PlanDetail> plan = pd_DAO.getPlanDetail(p_rownum);
	
	// day 개수 
	int no=0;
	for(int i=0; i<plan.size(); i++){
		if(plan.get(i).getP_tripday()>no) no++;
	}
%>
<!-- rownum 받아오기 -->
  	<!-- map_area 임의 배경 구성 -->
    <div class="map_area"></div>
    <div class="side_bar">
        <div class="plan_sub">여행 일정</div>
        <div class="tab_detail">
            <ul class="day_plan_tab">
            	<%
            		for(int i=1; i<=no; i++){
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
             <form action="RestorePlan.jsp" method="post" name="makePlanForm">
             	<input type="text" name="p_title" hidden
             		value="<%= %>">
             	<input type="text" name="p_firstdate" hidden>
             	<input type="text" name="p_lastdate" hidden>
             	<input type="text" name="t_namelist" hidden>
             	
             	<div class="day_plan_con">
             		<%
             			for(int i=1; i<=no; i++){
            				%>
            					<div class="day_plan day_plan<%= i %>">
            						<div class="plan_day">Day<%= i %></div>
            						<input type="text" name="day<%= i %>" value="<%= i %>">
            						<%
            							for(int j=0; j<plan.size(); j++){
            								if(plan.get(j).getP_tripday() != i) break;
            							}
            						%>
            						<input type='button' onclick='getSpotList(this)' class='plan_btn btn_day<%= i %>' value='+'>
             					</div>
            				<%
            			}
             		%>
            	</div>
        		<div class="btn_con">
        			<input type="button" value="저장하기" class="plan_submit" onclick="restore_plan()">
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
    
    <!-- js -->
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
</body>
</html>