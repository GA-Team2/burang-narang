<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="festiver.EventDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="festiver.EventDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    	EventDAO dao = EventDAO.getInstance();
       	ArrayList<EventDTO> ftlist = dao.listEvent();
       	
       	SimpleDateFormat sdf = new SimpleDateFormat("M");
       	
       	String e_serialnum;
       	String e_name;
       	String e_location;
       	String e_photo;
       	String e_url;
       	Timestamp e_startdate, e_enddate;
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/festival_style.css">
    <title>[축제 / 이벤트] | 부랑나랑</title>
</head>
<body>
	<section id="fest_wrap">
        <div class="inner">
            <h1 class="fest_title">축제 / 이벤트</h1>
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
                    
            <%
            	for(int i=0; i < ftlist.size(); i++) { 
  	               		EventDTO event = ftlist.get(i);
  	            		e_serialnum = event.getE_SERIALNUM();
  	            		e_name = event.getE_NAME();
  	            		e_location = event.getE_PHOTO();
  	            		e_startdate = event.getE_STARTDATE();
  	            		e_enddate = event.getE_ENDDATE();
  	            		e_photo = event.getE_PHOTO();
  	            		e_url = event.getE_URL();
            %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
           		   <%
           		   	}
           		   %>
                    </div>
                    
                    <div class="tab-pane fade fest_hotList" id="pills-1month" role="tabpanel" aria-labelledby="pills-1month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("1")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-2month" role="tabpanel" aria-labelledby="pills-2month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
      	               		EventDTO event = ftlist.get(i);
      	            		e_serialnum = event.getE_SERIALNUM();
      	            		e_name = event.getE_NAME();
      	            		e_location = event.getE_PHOTO();
      	            		e_startdate = event.getE_STARTDATE();
      	            		e_enddate = event.getE_ENDDATE();
      	            		e_photo = event.getE_PHOTO();
      	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("2")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-3month" role="tabpanel" aria-labelledby="pills-3month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("3")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-4month" role="tabpanel" aria-labelledby="pills-4month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("4")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-5month" role="tabpanel" aria-labelledby="pills-5month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
      	               		EventDTO event = ftlist.get(i);
      	            		e_serialnum = event.getE_SERIALNUM();
      	            		e_name = event.getE_NAME();
      	            		e_location = event.getE_PHOTO();
      	            		e_startdate = event.getE_STARTDATE();
      	            		e_enddate = event.getE_ENDDATE();
      	            		e_photo = event.getE_PHOTO();
      	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("5")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-6month" role="tabpanel" aria-labelledby="pills-6month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("6")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-7month" role="tabpanel" aria-labelledby="pills-7month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
      	               		EventDTO event = ftlist.get(i);
      	            		e_serialnum = event.getE_SERIALNUM();
      	            		e_name = event.getE_NAME();
      	            		e_location = event.getE_PHOTO();
      	            		e_startdate = event.getE_STARTDATE();
      	            		e_enddate = event.getE_ENDDATE();
      	            		e_photo = event.getE_PHOTO();
      	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("7")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-8month" role="tabpanel" aria-labelledby="pills-8month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("8")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-9month" role="tabpanel" aria-labelledby="pills-9month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("9")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-10month" role="tabpanel" aria-labelledby="pills-10month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("10")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-11month" role="tabpanel" aria-labelledby="pills-11month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <%
                        	if( sdf.format(e_startdate).equals("11")){
                        %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%=e_url%>" target="_blank">
                                <img src="<%=e_photo%>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%=e_name%></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <%
                            	}
                            %>
           		   <%
           		   	}
           		   %>
                    </div>
                    <div class="tab-pane fade fest_hotList" id="pills-12month" role="tabpanel" aria-labelledby="pills-12month-tab">
                    <%
                    	for(int i=0; i < ftlist.size(); i++) { 
       	               		EventDTO event = ftlist.get(i);
       	            		e_serialnum = event.getE_SERIALNUM();
       	            		e_name = event.getE_NAME();
       	            		e_location = event.getE_PHOTO();
       	            		e_startdate = event.getE_STARTDATE();
       	            		e_enddate = event.getE_ENDDATE();
       	            		e_photo = event.getE_PHOTO();
       	            		e_url = event.getE_URL();
                    %>
                        <% if( sdf.format(e_startdate).equals("12")){ %>
                        <div class="fest_box" id="box1">
                            <div class="fest_img"><a href="<%= e_url %>" target="_blank">
                                <img src="<%= e_photo %>" alt=""></a></div>
                            <div class="fest_content">
                                <p><%= e_name %></p>
                            </div>
                            <div class="planAdd">
                            	<a href="#">내 플랜에 추가</a>
                            </div>
                        </div>
                            <% } %>
           		   <% } %>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>