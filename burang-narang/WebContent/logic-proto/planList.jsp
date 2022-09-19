
<%@page import="java.util.ArrayList"%>
<%@page import="bn.spot.SpotDB"%>
<%@page import="bn.spot.Spot"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	String s_name = request.getParameter("s_name");
	Spot s = (new SpotDB()).getSpot(s_name);
	
	ArrayList<Spot> s_list = new ArrayList<Spot>();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	html, body {width: 100%; height: 100%;}
        .black {
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.7);
            position: fixed;
            z-index: 10;
        }
        .modal {
            width: 500px;
            height: 500px;
            position: absolute;
            left: 50%; top: 50%; transform: translate(-50%, -50%); background-color: white;}
        .modal_detail {
        	overflow: scroll;
        	width: 100%;
        	height: 100%;
        }
        .back {
            width: 50px; height: 50px;
            position: absolute;
            right: -25px; top: -25px;
            cursor: pointer;
            border-radius: 50px; background-color: black; color: white; font-size: 30px; text-align: center;}
        .hidden {display: none;}

        .insert {cursor: pointer;}
        
        .test {color: red; cursor: pointer;}
</style>
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	 
    <!-- modal -->
    <div class="black hidden">
    	<div class="modal">
    		<div class="modal_detail"></div>
        	<div class="back" onclick="cancle()">x</div>
        </div>
    </div>
    
    <ul class="hi">
    	<li>쿠키 추가</li>
    </ul>
    <div id="hi"></div>
    <div onclick="callModal()" class="insert">추가하기</div>
    
    <script>
    function callModal() {
        var url = "modalSpot.jsp";
        $('.modal_detail').load(url, function(){
            $('.black').removeClass('hidden');
        });

    }

    function cancle() {
    	// 쿠키가 저장 되면서 modal 종료가 되면 
    	// 쿠키가 있는지 없는지 확인 한 후
    	// list 갱신
        $('.black').addClass('hidden');
    }
    </script>
</body>
</html>