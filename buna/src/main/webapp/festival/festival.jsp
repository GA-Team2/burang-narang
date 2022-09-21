<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="festiver.EventDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="festiver.EventDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
		request.setCharacterEncoding("UTF-8");
%>

<%		
//		로그인 여부 테스트
// 		String nick_s = "okkk";
// 		session.setAttribute("nick_s", nick_s);
		String nick = (String)session.getAttribute("nick_s");		
		session.invalidate();
		
    	EventDAO dao = EventDAO.getInstance();
       	ArrayList<EventDTO> eventList = dao.listEvent();
       	
       	request.setAttribute("eventList", eventList);
       	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/festival_style.css">
    <script language="JavaScript" src="scripts/festivalAdd.js" charset="utf-8"></script>
    <script>history.replaceState({}, null, location.pathname);</script>
    <title>[축제 / 이벤트] | 부랑나랑</title>
</head>
<body>
${nick}
	<section id="fest_wrap">
        <div class="inner">
            <h1 class="fest_title">축제 / 이벤트</h1>
            <p class="back"><input type="button" value="메인페이지 이동" onclick="main_go()"></p>
            <div class="fest_month">
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item" role="presentation">
                      <button class="nav-link active" id="pills-allmonth-tab" data-bs-toggle="pill" data-bs-target="#pills-allmonth" type="button" role="tab" aria-controls="pills-allmonth" aria-selected="true">전체</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-1month-tab" data-bs-toggle="pill" data-bs-target="#pills-1month" type="button" role="tab" aria-controls="pills-1month" aria-selected="false">1월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-2month-tab" data-bs-toggle="pill" data-bs-target="#pills-2month" type="button" role="tab" aria-controls="pills-2month" aria-selected="false">2월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-3month-tab" data-bs-toggle="pill" data-bs-target="#pills-3month" type="button" role="tab" aria-controls="pills-3month" aria-selected="false">3월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-4month-tab" data-bs-toggle="pill" data-bs-target="#pills-4month" type="button" role="tab" aria-controls="pills-4month" aria-selected="false">4월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-5month-tab" data-bs-toggle="pill" data-bs-target="#pills-5month" type="button" role="tab" aria-controls="pills-5month" aria-selected="false">5월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-6month-tab" data-bs-toggle="pill" data-bs-target="#pills-6month" type="button" role="tab" aria-controls="pills-6month" aria-selected="false">6월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-7month-tab" data-bs-toggle="pill" data-bs-target="#pills-7month" type="button" role="tab" aria-controls="pills-7month" aria-selected="false">7월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-8month-tab" data-bs-toggle="pill" data-bs-target="#pills-8month" type="button" role="tab" aria-controls="pills-8month" aria-selected="false">8월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-9month-tab" data-bs-toggle="pill" data-bs-target="#pills-9month" type="button" role="tab" aria-controls="pills-9month" aria-selected="false">9월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-10month-tab" data-bs-toggle="pill" data-bs-target="#pills-10month" type="button" role="tab" aria-controls="pills-10month" aria-selected="false">10월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-13month-tab" data-bs-toggle="pill" data-bs-target="#pills-11month" type="button" role="tab" aria-controls="pills-11month" aria-selected="false">11월</button>
                    </li>
                    <li class="nav-item" role="presentation">
                      <button class="nav-link" id="pills-12month-tab" data-bs-toggle="pill" data-bs-target="#pills-12month" type="button" role="tab" aria-controls="pills-12month" aria-selected="false">12월</button>
                    </li>
                </ul>
            </div>            
            <div class="fest_list"> 
                <div class="tab-content" id="pills-tabContent">
                    <div class="tab-pane fade show active fest_hotList" id="pills-allmonth" role="tabpanel" aria-labelledby="pills-allmonth-tab">
	                    <c:forEach var="i" items="${eventList}">
	                        <div class="fest_box" id="box1">
	                            <div class="fest_img">
	                            	<a href="${i.e_url}" target="_blank">
	                                	<img src="${i.e_photo}" alt="">
	                                </a>
	                            </div>
	                            <div class="fest_content">
	                                <p>${i.e_name}</p>
	                            </div>
	                            <div class="planAdd">
	                            	 <a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a>
	                            </div>
	                        </div>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-1month" role="tabpanel" aria-labelledby="pills-1month-tab">
                    	<c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '1'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-2month" role="tabpanel" aria-labelledby="pills-2month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '2'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-3month" role="tabpanel" aria-labelledby="pills-3month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '3'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-4month" role="tabpanel" aria-labelledby="pills-4month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '4'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-5month" role="tabpanel" aria-labelledby="pills-5month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '5'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-6month" role="tabpanel" aria-labelledby="pills-6month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '6'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-7month" role="tabpanel" aria-labelledby="pills-7month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '7'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-8month" role="tabpanel" aria-labelledby="pills-8month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '8'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-9month" role="tabpanel" aria-labelledby="pills-9month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '9'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-10month" role="tabpanel" aria-labelledby="pills-10month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '10'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-11month" role="tabpanel" aria-labelledby="pills-11month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '11'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-12month" role="tabpanel" aria-labelledby="pills-12month-tab">
                    <c:forEach var="i" items="${eventList}">
                    	<fmt:formatDate var="startdate" value="${i.e_startdate}" pattern="M" />
                    		<c:if test="${startdate == '12'}">
		                        <div class="fest_box" id="box1">
		                            <div class="fest_img">
		                            	<a href="${i.e_url}" target="_blank">
		                                	<img src="${i.e_photo}" alt="">
		                                </a>
		                            </div>
		                            <div class="fest_content">
		                                <p>${i.e_name}</p>
		                            </div>
		                            <div class="planAdd">
		                            	<a href="?${i.s_serialnum}" onclick="click_on()">내 플랜에 추가</a> 
		                            </div>
		                        </div>
	                        </c:if>
	                    </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script type="text/javascript">
	function click_on(){
		var check = "<%= nick %>";
			if(check == "null"){
				alert("로그인이 필요합니다");
				location.href="";	
			} else {
				alert("내 일정에 추가했습니다");
				location.href="";
			}
		}
	</script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>