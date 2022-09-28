<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스팟 목록 | 부랑나랑</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');
	* {font-family: 'Noto Sans KR', sans-serif;}
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
            background-color: #d3d3d3;
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
            border: 1px solid #d3d3d3;
            background-color: #d3d3d3;
            color: white;
            border-radius: 10px;
            cursor: pointer;
            font-size: 1.3em;
            font-weight: 600;
        }
		ul.search_tab li:active {background-color: #4073c8; }
        ul.search_tab li.spotTab_active {
            background-color: white;
            border: 1px solid #4073c8;
            color: #4073c8;
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
            border: 2px #4073c8 solid;
            border-radius: 30px;
            width: 45%;
            height: 150px;
            overflow: hidden;
            display: flex;
            margin-bottom: 20px;
        }        
        .spot_con:hover {border: 3px solid #4073c8; }
        .spot_con:active {border: 3px solid #4bbcf4; }

        .spot_img {
            width: 150px;
            height: 100%;
            background-color: #3574a1;
            text-align: center;
            line-height: 150px;
            margin-right: 10px;
        }
        .hidden{display: none;}
        ::-webkit-scrollbar {display: none;}
        input[value="나가기"] {
            position: absolute;
            top: -15px;
            right: -35px;
        }
        input::-webkit-search-decoration,
		input::-webkit-search-cancel-button,
		input::-webkit-search-results-button,
		input::-webkit-search-results-decoration{
    	-webkit-appearance: none;
		}
        .spot_btn {height: 50px; border-radius: 5px; border: 1px solid black; background-color: white; cursor: pointer;}
        .spot_btn:active {background: #4073c8; color: white;}
        .s_type {color: #4073c8; font-weight: 600; font-size: 1.1em; margin-bottom: 15px;}
        .s_name {font-size: 1.6em; font-weight: 600; margin: 20px 0 10px;}
        .s_pnumber {font-size: 0.9em; color: #edd792; margin: 6px 0;}
        .s_loc {font-size: 0.9em; width: 160px; text-overflow: ellipsis; white-space: nowrap; overflow: hidden; margin: 6px 0; color: #c0c0c0;}
        .replace_font {font-size: 1.4em; width: 160px; text-overflow: ellipsis; white-space: nowrap; overflow: hidden;}
        .spot_con p:last-child {font-size: 0.9em; color: #c0c0c0;}
</style>
</head>
<body>
	<div class="spot_black hidden">
        <div class="con">
            <div class="search_bar">
                <input type="search" placeholder="검색어를 입력해주세요." id="searchSpot">
               	<input type="button" value="검색" onclick="searchSpot()" class="spot_btn">
                <input type="button" onclick="cancelSpot()" value="나가기" class="spot_btn">
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