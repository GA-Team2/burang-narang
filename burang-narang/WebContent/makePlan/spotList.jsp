<%@page import="buna.spotDetail.SpotDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="buna.spotDetail.SpotDetailDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/style.css">
<!-- js -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<%
		SpotDetailDB sp = new SpotDetailDB();
		ArrayList<SpotDetail> spot = new ArrayList<SpotDetail>();
		
		spot = sp.getSpot();
	%>
	
	 <!-- modal 내에서 페이지 이동이 가능한지 모르겠음 -->
    <!-- div에 onclick 메소드로 구성 -->
    <!-- serial number 값으로 spotDetail 페이지에서 spot의 데이터 불러올 수 있음 -->
    <%
    	for(int i=0; i<spot.size(); i++){
    		%>
    		<!-- onclick시 sn 넘기는 식으로? -->
    		<div class="spot_con" onclick="setSpot(this)">
        		<div class="spot_img">img</div>
        		<div class="spot_name">
        			<p class="s_name"><%= spot.get(i).getS_name() %> </p>
        			<p class="s_type">spotType</p>
        			<p class="s_loc">spotLocation</p>
       			 </div>
    		</div>
    		<%
    	}
    %>
     <!-- js -->
    <script src="js/side.js"></script>
</body>
</html>