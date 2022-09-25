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
<titl>스팟 목록 | 부랑나랑</title>
</head>
<body>
<%
	// 후에 이미지 수정
	// 쿼리 스트링으로 어떤 스팟 목록 출력할지 결정 
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
	
	
	if(spot.equals("tf")){ // 교통
%>
		<div class="spot_list">
        <%
        	tfList = tfDAO.getTfList();
         	for(int i=0; i<tfList.size(); i++){
         		String sNum = tfList.get(i).getS_serialnum();
         		String tfType = tfList.get(i).getTf_type();
         		String tfName = tfList.get(i).getTf_name();
         		String tfPnum = tfList.get(i).getTf_pnumber();
         		String tfLoc = tfList.get(i).getTf_location();
         		String tfPho = tfList.get(i).getTf_photo();
        %>
            <div class="spot_con" onclick="setSpot(this)">
            	<div class="spot_img"><%= tfPho %></div>
                <div class="spot_name">
                	<input type="text" name="s_serialnum" value="<%= sNum %>" hidden>
                    <p class="s_name"><%= tfName %></p>
                    <p class="s_type"><%= tfType %></p>
                    <p class="s_pnumber"><%= tfPnum %></p>
                    <p class="s_loc"><%= tfLoc %></p>
                </div>
            </div>
            <%
            }
            %>
      	</div>
	<%
	}else if(spot.equals("ac")){ // 숙소
		%>
		<div class="spot_list">
        <%
        	acList = acDAO.getAcList();
         	for(int i=0; i<acList.size(); i++){
         		String sNum = acList.get(i).getS_serialnum();
         		String acType = acList.get(i).getA_type();
         		String acName = acList.get(i).getA_name();
         		String acPnum = acList.get(i).getA_pnumber();
         		String acLoc = acList.get(i).getA_location();
         		String acPho = acList.get(i).getA_photo();
         		String acIn = acList.get(i).getA_checkin();
         		String acOut = acList.get(i).getA_checkout();
        %>
            <div class="spot_con" onclick="setSpot(this)">
            	<div class="spot_img"><%= acPho %></div>
                <div class="spot_name">
                	<input type="text" name="s_serialnum" value="<%= sNum %>" hidden>
                    <p class="s_name"><%= acName %></p>
                    <p class="s_type"><%= acType %></p>
                    <p class="s_pnumber"><%= acPnum %></p>
                    <p class="s_loc"><%= acLoc %></p>
                    <p><%= acIn %>~<%= acOut %></p>
                </div>
            </div>
            <%
            }
            %>
      	</div>
	<%
	}else if(spot.equals("re")){ // 레스토랑
		%>
		<div class="spot_list">
        <%
			reList = reDAO.getReList();
         	for(int i=0; i<reList.size(); i++){
         		String sNum = reList.get(i).getS_serialnum();
         		String reName = reList.get(i).getR_name();
         		String rePnum = reList.get(i).getR_pnumber();
         		String reType = reList.get(i).getR_type();
         		String reLoc = reList.get(i).getR_location();
         		String rePho = reList.get(i).getR_photo();
         		String reOpen = reList.get(i).getR_opentime();
         		String reClose = reList.get(i).getR_closetime();
        %>
            <div class="spot_con" onclick="setSpot(this)">
            	<div class="spot_img"><%= rePho %></div>
                <div class="spot_name">
                	<input type="text" name="s_serialnum" value="<%= sNum %>" hidden>
                    <p class="s_name"><%= reName %></p>
                    <p class="s_type"><%= reType %></p>
                    <p class="s_pnumber"><%= rePnum %></p>
                    <p class="s_loc"><%= reLoc %></p>
                    <p><%= reOpen %>~<%= reClose %></p>
                </div>
            </div>
            <%
            }
            %>
      	</div>
	<%
	}else{ // 관광지
		%>
		<div class="spot_list">
        <%
        	evList = evDAO.getEvList();
         	for(int i=0; i<evList.size(); i++){
         		String sNum = evList.get(i).getS_serialnum();
         		String evName = evList.get(i).getE_name();
         		String evPnum = evList.get(i).getE_pnumber();
         		String evVenue = evList.get(i).getE_venue();
         		String evLoc = evList.get(i).getE_location();
         		String evPho = evList.get(i).getE_photo();
         		
         		// 타임 스탬프 변환 
         		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         		String evStart = sdf.format(evList.get(i).getE_startdate());
         		String evEnd = sdf.format(evList.get(i).getE_enddate());
        %>
            <div class="spot_con" onclick="setSpot(this)">
            	<div class="spot_img"><%= evPho %></div>
                <div class="spot_name">
                	<input type="text" name="s_serialnum" value="<%= sNum %>" hidden>
                    <p class="s_name"><%= evName %></p>
                    <p class="s_type"><%= evVenue %></p>
                    <p class="s_pnumber"><%= evPnum %></p>
                    <p class="s_loc"><%= evLoc %></p>
                    <p><%= evStart %>~<%= evEnd %></p>
                </div>
            </div>
            <%
            }
            %>
      	</div>
	<%
	}
	
%>
</body>
</html>