<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>[플랜 상세보기] | 부랑나랑</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/myPlan_style.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/myplan.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
    <div class="aside">
        <h2>부산여행 <span>n</span>일차</h2>

        <ul class="date">
            <li class="active">DAY1</li>
            <li>DAY2</li>
            <li>DAY3</li>
        </ul>

        <div class="schedule">
            <div class="active">
                <p>9월 15일 목요일</p>
                <ul>
                    <li>일정1</li>
                    <li>위치</li>
                </ul>
                <p class="time"><i class="xi-timer-sand-o xi-x"></i> 소요시간</p>
                <ul>
                    <li>일정1</li>
                    <li>위치</li>
                </ul>
                <p class="time"><i class="xi-timer-sand-o xi-x"></i> 소요시간</p>
                <ul>
                    <li>일정1</li>
                    <li>위치</li>
                </ul>
            </div>
            <div>
                <p>9월 16일 금요일</p>
                <ul>
                    <li>일정2</li>
                    <li>위치</li>
                </ul>
                <p class="time"><i class="xi-timer-sand-o xi-x"></i> 소요시간</p>
            </div>
            <div>
                <p>9월 17일 토요일</p>
                <ul>
                    <li>일정3</li>
                    <li>위치</li>
                </ul>
                <p class="time"><i class="xi-timer-sand-o xi-x"></i> 소요시간</p>
            </div>
        </div>

        <div class="management">
        
            <!-- 인기 페이지에서 넘어왔을 때 -->
            <input type="button" name="planedit" value="플랜 가져오기">
            <input type="button" name="recommend" value="좋아요">
            <input type="button" name="recommend" value="목록" onclick=""><br>
            <!-- 마이페이지에서 넘어왔을 때 -->
            <input type="button" name="edit" value="수정">
            <input type="button" name="cancle" value= "취소" onclick="location.href='../myPage/myPage.jsp'">
        </div>
    </div> <!--aside 끝-->

</body>
</html>