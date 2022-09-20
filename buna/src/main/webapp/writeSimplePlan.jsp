<%@ page import="org.ga2.buna.dto.TagDto"%>
<%@ page import="org.ga2.buna.dao.TagDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	TagDao tDao = new TagDao();
	ArrayList<TagDto> tagList = tDao.listTag();
	request.setAttribute("tagList", tagList);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>새 플랜 작성 | 부랑나랑</title>
<link rel="stylesheet" href="styles/normalize.css" />
<link rel="stylesheet" href="styles/style.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.css" />
	
</head>
<body>
	<!-- 새 플랜 작성 Modal -->
	<section id="modal_area" class="modal_zone">
		<div id="modal" class="modal_overlay">
			<div class="modal_bg"></div>
			<form action="test.jsp" method="get" name="scheduleForm">
				<div class="modal_context">
					<h1>새 플랜 작성</h1>
					<!-- 입력 영역 -->
					<div class="modal_input_area">
						<ul>
							<li>
								<label for="title">여행제목</label>
								<input type="text"
								name="p_title" id="title" placeholder="제목을 입력해주세요." />
								<span id="notitle" class="hidden">제목을 입력해주세요.</span>
							</li>
							<li>
								<label for="schedule">여행기간</label>
								<input type="text"
								name="p_firstdate" id="start_schedule" size="10" readonly />
								<span>&nbsp;~&nbsp;</span>
								<input type="text" name="p_lastdate" id="end_schedule" size="10"
								readonly />
								<span id="noschedule" class="hidden">여행기간을 입력해주세요.</span>
							</li>
							<li id="tag_input_area">
								<label for="tag">태그</label>
								<input type="text" name="tag" id="tag" size="15" value="#">
								<input type="button" id="tag_insert" value="태그 추가">
								<span id="overlap" class="hidden">이미 추가한 태그입니다.</span>
								<span id="manytag" class="hidden">태그는 10개까지만 추가할 수 있습니다.</span>
								<span id="longtag" class="hidden">태그는 10자까지 쓸 수 있습니다.</span>
								<span id="notag" class="hidden">빈 태그를 추가할 수 없습니다.</span>
							</li>							
							<li>
							 	<input type="hidden" id="tag_value" name="t_taglist" value="" >
							 	<div id="tag_area"></div>
							</li>
						</ul>
						<div id="tag_recommend_area">
							<p>추천 태그</p>
							<div id="tag_recommend_list">
								<c:forEach var="list" items="${tagList}" begin="0" end="9" varStatus="vs">
									<span id="${list.tagName}" class="highlight" onclick="getValue(event)">${list.tagName}</span>
									<c:if test="${vs.index == 4}"><br></c:if>
								</c:forEach>
							</div>
						</div>
					</div>
					<!-- 캘린더 영역 -->
					<div class="modal_calendar_area">
						<div id="calendar"></div>
					</div>

					<!-- 버튼 영역 -->
					<div class="modal_button_area">
						<input type="button" class="modal_add" value="추가" onclick="writeCheck()" />
						<input type="button" class="modal_cancel" value="취소" />
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script src="scripts/modal.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/moment@2.27.0/min/moment.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@fullcalendar/moment@5.5.0/main.global.min.js"></script>
</html>
