<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make Plan</title>
 <!-- css -->
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- js -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <!-- map_area 임의 배경 구성 -->
    <div class="map_area"></div>
    <div class="side_bar">
        <!-- 여행 제목을 적게 할지
            여행 제목을 표시하면 수정 버튼도 넣을지 -->
        <div class="plan_sub">
            여행 일정
        </div>
        <!-- class active 유무로 탭 전환 -->
        <div class="tab_detail">
            <div class="day_plan_con">
                <!-- 날짜 입력 시 입력 개수 만큼 day plan tab 생성 -->
                <ul class="day_plan_tab">
                    <li class="active_day">day1</li>
                    <li>day2</li>
                    <li>day3</li>
                </ul>
                <!-- 여행 날자 수에 따라 day_plan 길어짐 -->
               <div class="day_plan_scroll">
               		<div class="day_plan">
                    	<div class="plan_day">day1</div>
                    	<button class="plan_btn" onclick="getSpotList(this)">+</button>
                     <!-- 데이터 넘길 input hidden tag 추가하기 -->
                     <!-- 플랜 삭제 버튼 만들기 -->
                    <!-- <div class="plan_list">
                        	<div class="up_down">
                            	<div class="up">&#9650;</div>
                            	<div class="plan_no">1</div>
                            	<div class="down">&#9660;</div>
                        	</div>
                        	<div class="plan_main">
                        		<p>plan1</p>
                        		<p>spotName</p>
                        		<p>spotType</p>
                        		<p>spotLoc</p>
                        	</div>
                    	</div> -->
                	</div>
		             <div class="blank"></div>
               </div>
            </div>
        </div>
        <div class="btn_con">
        	<div class="plan_submit">저장하기</div>
        	<div class="plan_cancle">취소하기</div>
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
    <script src="js/side.js"></script>
</body>
</html>