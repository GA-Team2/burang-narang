<%@page import="org.ga2.buna.dao.RestaurantDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.ga2.buna.dto.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String spot = "tf";
	if(request.getParameter("spot") != null) spot = request.getParameter("spot");
	
	
	if(spot.equals("tf")){ // 교통
		%>
		<div class="spot_list">
        <%
         	for(int i=0; i<5; i++){
        %>
            <div class="spot_con" onclick="setSpot(this)">
            	<div class="spot_img"><%= spot %>img</div>
                <div class="spot_name">
                	<!-- 
                	
                			snum value
                	
                	 -->
                	<input type="text" name="s_serialnum" hidden>
                    <p class="s_name"><%= spot %>+sname</p>
                    <p class="s_type"><%= spot %>+stype</p>
                    <p class="s_loc"><%= spot %>+sloc</p>
                    <p class="s_pnumber"><%= spot %>+pnumber</p>
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
         	for(int i=0; i<5; i++){
        %>
            <div class="spot_con" onclick="setSpot(this)">
            	<div class="spot_img"><%= spot %>img</div>
                <div class="spot_name">
                	<input type="text" name="s_serialnum" hidden>
                    <p class="s_name"><%= spot %>+sname</p>
                    <p class="s_type"><%= spot %>+stype</p>
                    <p class="s_loc"><%= spot %>+sloc</p>
                    <p class="s_pnumber"><%= spot %>+pnumber</p>
                </div>
            </div>
            <%
            }
            %>
      	</div>
	<%
	}else if(spot.equals("re")){ // 레스토랑
		RestaurantDAO reDAO = RestaurantDAO.getInstance();
		ArrayList<Restaurant> reList = new ArrayList<>();
		reList = reDAO.getResList();
		%>
		<div class="spot_list">
        <%
         	for(int i=0; i<reList.size(); i++){
         		String snum = reList.get(i).getS_serialnum();
         		String sname = reList.get(i).getR_name();
         		String pnumber = reList.get(i).getR_pnumber();
         		String stype = reList.get(i).getR_type();
         		String sloc = reList.get(i).getR_location();
         		String photo = reList.get(i).getR_photo();
        %>
            <div class="spot_con" onclick="setSpot(this)">
            	<div class="spot_img"><%= photo %></div>
                <div class="spot_name">
                	<input type="text" name="s_serialnum" value="<%= snum %>" hidden>
                    <p class="s_name"><%= sname %></p>
                    <p class="s_pnumber"><%= pnumber %></p>
                    <p class="s_type"><%= stype %></p>
                    <p class="s_loc"><%= sloc %></p>
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
         	for(int i=0; i<5; i++){
        %>
            <div class="spot_con" onclick="setSpot(this)">
            	<div class="spot_img"><%= spot %>img</div>
                <div class="spot_name">
                	<input type="text" name="s_serialnum" hidden>
                    <p class="s_name"><%= spot %>+sname</p>
                    <p class="s_type"><%= spot %>+stype</p>
                    <p class="s_loc"><%= spot %>+sloc</p>
                    <p class="s_pnumber"><%= spot %>+pnumber</p>
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