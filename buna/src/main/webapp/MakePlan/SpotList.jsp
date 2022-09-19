<%@page import="org.ga2.buna.dto.Restaurant"%>
<%@page import="org.ga2.buna.dao.RestaurantDAO"%>
<%@page import="org.ga2.buna.dto.SpotDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.ga2.buna.dao.SpotDetailDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spot List | 부랑나랑</title>
<style type="text/css">
	.spot_con {
            cursor: pointer;
            border: 1px black solid;
            border-radius: 30px;
            width: 350px;
            height: 150px;
            overflow: hidden;
            display: flex;
            margin: 10px 0;
        }

        .spot_img {
            width: 150px;
            height: 150px;
            background-color: gray;
            text-align: center;
            line-height: 150px;
            margin-right: 20px;
        }

        .spot_name {
            margin: 20px 0;
        }
</style>
</head>
<body>
	<%
		SpotDetailDAO sdDAO = SpotDetailDAO.getInstance();
		ArrayList<SpotDetail> spotlist = new ArrayList<SpotDetail>();
		spotlist = sdDAO.getSpot();
		
		for(int i=0; i<spotlist.size(); i++){
			String type = spotlist.get(i).getS_serialnum().substring(0, 2);
			
			if(type.equals("re")) {
				RestaurantDAO resDAO = RestaurantDAO.getInstance();
				Restaurant res = resDAO.getRes(spotlist.get(i).getS_serialnum());
				%>
				<div class="spot_con" onclick="setSpot(this)">
	        		<div class="spot_img"><%= res.getR_photo() %></div>
	        		<div class="spot_name">
	        			<p class="s_name"><%= res.getR_name() %></p>
	       				<p class="s_type"><%= res.getR_type() %></p>
	        			<p class="s_loc"><%= res.getR_location() %></p>
	       			</div>
	    		</div>	
				<%	
			}
		}
	%>
</body>
</html>