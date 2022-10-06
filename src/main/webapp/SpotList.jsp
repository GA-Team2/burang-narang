<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.ga2.buna.dao.TrafficDAO"%>
<%@page import="org.ga2.buna.dto.TrafficDTO"%>
<%@page import="org.ga2.buna.dao.AccommodationDAO"%>
<%@page import="org.ga2.buna.dto.AccommodationDTO"%>
<%@page import="org.ga2.buna.dao.EventDAO"%>
<%@page import="org.ga2.buna.dto.EventDTO"%>
<%@page import="org.ga2.buna.dto.RestaurantDTO"%>
<%@page import="org.ga2.buna.dao.RestaurantDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	/* 쿼리 스트링으로 어떤 스팟 목록 출력할지 결정 */ 
	String spot = "tf";
	if(request.getParameter("spot") != null) spot = request.getParameter("spot");
	
	ArrayList<RestaurantDTO> reList = new ArrayList<>();
	RestaurantDAO reDAO = RestaurantDAO.getInstance();
	
	ArrayList<EventDTO> evList = new ArrayList<EventDTO>();
	EventDAO evDAO = EventDAO.getInstance();
	
	ArrayList<AccommodationDTO> acList = new ArrayList<AccommodationDTO>();
	AccommodationDAO acDAO = AccommodationDAO.getInstance();
	
	ArrayList<TrafficDTO> tfList = new ArrayList<TrafficDTO>();
	TrafficDAO tfDAO = TrafficDAO.getInstance();
	tfList = tfDAO.getTfList();
	
	String sNum = "";
	String sName = "";
	String sType = "";
	String sPnum = "";
	String sLoc = "";
	String sPho = "";
	String sStart = "";
	String sEnd = "";
	
%>
	<!-- spot list 안에 spot_con 나열 -->
	<div class="spot_list">
		<%
			if(spot.equals("tf")){ // 교통
				tfList = tfDAO.getTfList();
	         	for(int i = 0; i < tfList.size(); i++){
	         		sNum = tfList.get(i).getS_serialnum();
	         		sType = tfList.get(i).getTf_type();
	         		sName = tfList.get(i).getTf_name();
	         		sPnum = tfList.get(i).getTf_pnumber();
	         		sLoc = tfList.get(i).getTf_location();
	         		sPho = tfList.get(i).getTf_photo();
	         		%>
	         		<div class="spot_con" onclick="setSpot(this)">
            			<img src="<%= sPho %>" class="spot_img">
                		<div class="spot_name">
                			<input type="text" name="s_serialnum" value="<%= sNum %>" hidden>
                    		<p class="s_name"><%= sName %></p>
                    		<p class="s_type"><%= sType %></p>
                   	 		<p class="s_pnumber"><%= sPnum %></p>
                   	 		<p class="s_loc"><%= sLoc %></p>
                		</div>
            		</div>
	         		<%
	         	}
			}else if(spot.equals("ac")){ // 숙소
				acList = acDAO.getAcList();
	         	for(int i = 0; i < acList.size(); i++){
	         		sNum = acList.get(i).getS_serialnum();
	         		sType = acList.get(i).getA_type();
	         		sName = acList.get(i).getA_name();
	         		sPnum = acList.get(i).getA_pnumber();
	         		sLoc = acList.get(i).getA_location();
	         		sPho = acList.get(i).getA_photo();
	         		sStart = acList.get(i).getA_checkin();
	         		sEnd = acList.get(i).getA_checkout();
	         		 %>
	                 <div class="spot_con" onclick="setSpot(this)">
	                 	<img src="<%= sPho %>" class="spot_img">
	                    <div class="spot_name">
	                     	<input type="text" name="s_serialnum" value="<%= sNum %>" hidden>
	                     	<p class="s_name replace_font"><%= sName %></p>
	                        <p class="s_type"><%= sType %></p>
	                        <p class="s_pnumber"><%= sPnum %></p>
	                        <p class="s_loc"><%= sLoc %></p>
	                        <p><%= sStart %>~<%= sEnd %></p>
	                    </div>
	                </div>
	                <%
	         	}
			}else if(spot.equals("re")){ // 레스토랑
				reList = reDAO.getReList();
		        for(int i = 0; i < reList.size(); i++){
		         	sNum = reList.get(i).getS_serialnum();
		         	sName = reList.get(i).getR_name();
		         	sPnum = reList.get(i).getR_pnumber();
		         	sType = reList.get(i).getR_type();
		         	sLoc = reList.get(i).getR_location();
		         	sPho = reList.get(i).getR_photo();
		         	sStart = reList.get(i).getR_opentime();
		         	sEnd = reList.get(i).getR_closetime();
		       		%>
		            <div class="spot_con" onclick="setSpot(this)">
		            	<img src="<%= sPho %>" class="spot_img">
		                <div class="spot_name">
		                	<input type="text" name="s_serialnum" value="<%= sNum %>" hidden>
		                  	<p class="s_name replace_font"><%= sName %></p>
		           	        <p class="s_type"><%= sType %></p>
		         	        <p class="s_pnumber"><%= sPnum %></p>
		                    <p class="s_loc"><%= sLoc %></p>
		                    <p><%= sStart %>~<%= sEnd %></p>
		                </div>
		            </div>
		            <%
		          }
			}else{ // 관광지
		        	evList = evDAO.getEvList();
		         	for(int i = 0; i < evList.size(); i++){
		         		sNum = evList.get(i).getS_serialnum();
		         		sName = evList.get(i).getE_name();
		         		sPnum = evList.get(i).getE_pnumber();
		         		sType = evList.get(i).getE_venue();
		         		sLoc = evList.get(i).getE_location();
		         		sPho = evList.get(i).getE_photo();
		         		
		         		// 타임 스탬프 변환 
		         		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		         		String evStart = sdf.format(evList.get(i).getE_startdate());
		         		String evEnd = sdf.format(evList.get(i).getE_enddate());
		        %>
		            <div class="spot_con" onclick="setSpot(this)">
		            	<img src="<%= sPho %>" class="spot_img">
		                <div class="spot_name">
		                	<input type="text" name="s_serialnum" value="<%= sNum %>" hidden>
		                    <p class="s_name replace_font"><%= sType %></p>
		                    <p class="s_type"><%= sName %></p>
		                    <p class="s_pnumber"><%= sPnum %></p>
		                    <p class="s_loc"><%= sLoc %></p>
		                    <p><%= sStart %>~<%= sEnd %></p>
		                </div>
		            </div>
		         <%
		         	}
			}
		         %>
		<div class="blank"></div>
	</div>
</body>
</html>