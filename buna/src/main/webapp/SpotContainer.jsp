<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스팟 목록 | 부랑나랑</title>
<style type="text/css">
	body, html {height: 100%;}
        .con {
            background-color: white;
            width: 800px;
            height: 800px;
            overflow-y: auto;
            position: fixed;
            top: 100px;
            left: 50%;
            transform: translateX(-50%);
            z-index: 999;
        }
        .spot_black {
        	width: 100%;
            height: 100%;
            position: fixed;
            top: 0;
            z-index: 100;
            background-color: rgba(0, 0, 0, 0.8);
            display: block;
        }
        .search_bar {
            width: 90%;
            height: 50px;
            margin: 20px auto;
            position: relative;
        }
       
        input[type="search"] {
            width: 80%;
            height: 50px;
            font-size: 20px;
            font-family: 'Noto Sans KR', sans-serif;
            outline: 0;
            border: 0;
            background-color: rgb(219, 219, 219);
            border-radius: 10px;
        }
        ul, li {list-style: none;}
        ul.search_tab {
            width: 80%;
            display: flex;
            justify-content: space-between;
            margin: 0 auto;
        }
        ul.search_tab li {
            width: 22%;
            height: 50px;
            line-height: 50px;
            text-align: center;
            border: 1px solid white;
            background-color: black;
            color: white;
            border-radius: 10px;
            cursor: pointer;
        }
        ul.search_tab li.spotTab_active {
            background-color: white;
            border: 1px solid black;
            color: black;
        }
	 	
	 	/* 스크롤 */
	 	#list_load {
            max-height: 100%;
            overflow-y: scroll;
        }
        
	 	
        .spot_list {
            width: 90%;
            margin: 30px auto 0;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .spot_con {
            cursor: pointer;
            border: 1px black solid;
            border-radius: 30px;
            width: 45%;
            height: 150px;
            overflow: hidden;
            display: flex;
            margin-bottom: 20px;
        }
        .spot_img {
            width: 150px;
            height: 100%;
            background-color: gray;
            text-align: center;
            line-height: 150px;
            margin-right: 20px;
        }
        
        .hidden{
        	display: none;
        }
        
        ::-webkit-scrollbar {
  			display: none;
		}
        
        input[value="나가기"] {
            position: absolute;
            top: -15px;
            right: -35px;
           
        }
        input[type="button"] {
            height: 50px;
        }
</style>
</head>
<body>
	<div class="spot_black hidden">
        <div class="con">
            <div class="search_bar">
                <input type="search" placeholder="검색어를 입력해주세요." id="searchSpot">
               	<input type="button" value="검색" onclick="searchSpot()">
                <input type="button" onclick="cancelSpot()" value="나가기">
            </div>
            <ul class="search_tab">
               	<li class="spotTab_active" onclick="getSpotLoad('tf')" id="tfTap">교통</li>
                <li onclick="getSpotLoad('ac')" id="acTap">숙소</li>
                <li onclick="getSpotLoad('re')" id="reTap">맛집</li>
                <li onclick="getSpotLoad('ev')" id="evTap">관광지</li>
            </ul>
            <div id="list_load">
            	<!-- spot list가 load되는 공간 -->	
            </div>
    	</div>
    </div>

   <script src="scripts/spot.js"></script>  
</body>
</html>