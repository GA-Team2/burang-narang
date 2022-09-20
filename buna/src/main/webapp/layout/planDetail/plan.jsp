<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int rownum = 1;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/planstyle.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/myplan.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
    <!--일정 -->
    <div class="aside">
        <h2>부산 <span>n</span>일 여행</h2>
        
        <div class="like">
        	<input type="button" id="recommend" value="추천" onclick="like(rownum)">
        </div>

        <ul class="date">
            <li>DAY1</li>
            <li>DAY2</li>
            <li>DAY3</li>
        </ul>

        <div class="schedule">
        
        </div>



        <div class="management">
            <!-- 인기 플랜에서 넘어왔을 경우에만 표시 -->
            <input type="button" name="planedit" value="플랜가져오기"> <!--플랜 수정 페이지 이동-->
            <input type="button" name="recommend" value="목록" onclick=""><br> <!--인기플랜이동-->
            <!-- 나의 플랜 목록에서 넘어왔을 경우에만 표시 -->
            <input type="button" name="edit" value="수정">
            <input type="button" name="cancle" value="취소" onclick="location.href='myPage.html'">
        </div>
    </div> <!--aside 끝-->

</body>
</html>