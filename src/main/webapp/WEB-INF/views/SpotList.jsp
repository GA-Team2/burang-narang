<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.ga2.buna.dao.TrafficDAO"%>
<%@page import="org.ga2.buna.dto.TrafficDTO"%>
<%@page import="org.ga2.buna.dao.AccommodationDAO"%>
<%@page import="org.ga2.buna.dto.AccommodationDTO"%>
<%@page import="org.ga2.buna.dao.EventDAO"%>
<%@page import="org.ga2.buna.dto.RestaurantDTO"%>
<%@page import="org.ga2.buna.dao.RestaurantDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="org.ga2.buna.dto.EventlistDTO" %>
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
	if (request.getParameter("spot") != null)
		spot = request.getParameter("spot");
	%>
	<!-- spot list 안에 spot_con 나열 -->
	<div class="spot_list">

<%--		<c:if test="${spot == 'tf'}">
			<c:forEach var="trafficList" items="${trafficList}">
				<div class="spot_con" onclick="setSpot(this)">
					<img src="${trafficList.trafficPhoto}" class="spot_img">
					<div class="spot_name">
						<input type="text" name="spotSerialNum" value="${trafficList.trafficPhoto}" hidden>
						<p class="s_name">${trafficList.trafficName}</p>
						<p class="s_type">${trafficList.trafficType}</p>
						<p class="s_pnumber">${trafficList.trafficPnumber}</p>
						<p class="s_loc">${trafficList.trafficLocation}</p>
					</div>
				</div>
			</c:forEach>
		</c:if>--%>

		<div class="blank"></div>
	</div>
</body>
</html>